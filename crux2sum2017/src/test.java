
public class test {
	public static void main(String[] args) {
		lexico(0, 1000);
		
	}
	public static void lexico(int ans, int ei) {
		if(ans > ei) {
			return;
		}
		System.out.println(ans);
		if(ans == 0) {
			for(int i = 1; i <= 9; i++) {
				lexico(ans*10 + i, ei);
			}
		} else {
			for(int i = 0; i <= 9; i++) {
				lexico(ans*10 + i, ei);
			}
		}
	}

}
