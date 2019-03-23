package june_19;

public class test {

	public static void main(String[] args) {
		System.out.println(compression("aabbcc"));

	}
	
	public static String compression(String s) {
		StringBuilder sb = new StringBuilder();

		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
				break;
			} else {
				sb.append(s.charAt(i));

				if (count > 1) {
					sb.append(count);
				}
				count = 1;
			}
		}

		sb.append(s.charAt(s.length() - 1));
		if (count > 1) {
			sb.append(count);
		}
		
		return sb.toString();
	}

}
