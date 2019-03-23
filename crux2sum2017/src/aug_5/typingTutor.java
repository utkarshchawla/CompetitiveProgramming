package aug_5;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class typingTutor extends JFrame implements ActionListener {
	private Label lbltimer;
	private Label lblscore;
	private Label lblword;
	private TextField txtword;
	private Button startbtn;
	private Button stopbtn;

	boolean running;
	int score;
	private Timer timer = null;
	int timeremaining;
	private String[] words;

	public typingTutor(String[] args) {

		this.words = args;
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		super.setTitle("Typingtutor");
		super.setVisible(true);
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Font font = new Font("Comic Sans MS", 1, 125);

		lbltimer = new Label("Timer");
		lbltimer.setFont(font);
		super.add(lbltimer);

		lblscore = new Label("Score");
		lblscore.setFont(font);
		super.add(lblscore);

		lblword = new Label();
		lblword.setForeground(Color.BLACK);
		lblword.setBackground(Color.cyan);
		lblword.setFont(font);
		super.add(lblword);

		txtword = new TextField("");
		txtword.setFont(font);
		super.add(txtword);

		startbtn = new Button("Start");
		startbtn.setFont(font);
		startbtn.setForeground(Color.WHITE);
		startbtn.setBackground(Color.green);
		startbtn.addActionListener(this);
		super.add(startbtn);

		stopbtn = new Button("Stop");
		stopbtn.setFont(font);
		stopbtn.setForeground(Color.WHITE);
		stopbtn.setBackground(Color.red);
		stopbtn.addActionListener(this);
		super.add(stopbtn);

		setupthegame();

	}

	private void setupthegame() {
		timer = new Timer(2000, this);

		running = false;
		score = 0;
		String a = JOptionPane.showInputDialog(this, "set the time");
		timeremaining = Integer.parseInt(a);
		lbltimer.setText("Time : " + timeremaining);
		lblscore.setText("Score : " + score);
		lblword.setText("");
		txtword.setText("");
		stopbtn.setEnabled(false);
		txtword.setEnabled(false);
		startbtn.setLabel("Start");
		startbtn.setBackground(Color.GREEN);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startbtn) {
			handlestart();
		} else if (e.getSource() == stopbtn) {
			handlestop();
		} else if (e.getSource() == timer) {
			handletimer();
		}
	}

	private void handlestop() {

		timer.stop();
		int choice = JOptionPane.showConfirmDialog(this, "Your score is :- " + score + ", Replay?");

		if (choice == JOptionPane.YES_OPTION) {
			setupthegame();

		} else if (choice == JOptionPane.NO_OPTION) {
			dispose();
		} else {
			if (timeremaining == -1) {
				setupthegame();
			} else {
				timer.start();
			}
		}
	}

	private void handlestart() {
		if (running == false) {

			txtword.requestFocus();
			timer.start();
			running = true;
			stopbtn.setEnabled(true);
			startbtn.setBackground(Color.ORANGE);
			startbtn.setLabel("pause");
			txtword.setEnabled(true);

		} else {

			timer.stop();
			running = false;
			startbtn.setLabel("resume");
			startbtn.setBackground(Color.GREEN);
			txtword.setEnabled(false);
			stopbtn.setEnabled(false);

		}
	}

	private void handletimer() {

		timeremaining -= 2;
		String actual = txtword.getText();
		String expected = lblword.getText();
		if (expected.length() > 0 && actual.equals(expected)) {
			score++;
		}

		lblscore.setText("Score :" + score);

		if (timeremaining == -2) {
			handlestop();
		} else {
			lbltimer.setText("time :" + timeremaining);

			int a = (int) (Math.random() * words.length);
			lblword.setText(words[a]);
			txtword.setText("");
		}

	}

}
