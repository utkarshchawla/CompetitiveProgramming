package july_7;

public class test {

	public static void main(String[] args) {
		String s = "nitin";
		System.out.println(countPalindromSub(s));
	}

	public static int countPalindromSub(String s) {
		if (s.length() <= 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char a = s.charAt(0);
		char b = s.charAt(s.length() - 1);
		String ros = s.substring(1, s.length() - 1);
		int val = 2;
		if (a == b) {
			val++;
		}

		return val + countPalindromSub(ros);
	}

}
