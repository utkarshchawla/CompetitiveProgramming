package june_19;

public class stringops {

    public static void main(String[] args) {
//        String s = "abdgasdf";
        // String b = "abcd";
//		 printsubstrings(s);
        // System.out.println(isPalindrome(s));
        // System.out.println(countpalidromicsubstrings(s));
        // removeduplicates(s);
        // compression(s);
//		 System.out.println(removeduplicates(s));
        // System.out.println(compression(s));
        // System.out.println(replace(s));
//        System.out.println(difference(s));
        // System.out.println(maxfreq(s));
         subsequences("abc");
//		printChars(s);
//        System.out.println(subsequences("abc"));
    }

    public static void printChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }

    public static void printsubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));

            }
        }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int countpalidromicsubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String removeduplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
//                sb.append(s.charAt(i));
                // System.out.print(s.substring(i, i + 1));
            } else {
                // System.out.print(s.substring(i, i + 1));
                sb.append(s.charAt(i));

            }

        }
        return sb.toString();
    }

    public static String compression(String s) {
        StringBuilder sb = new StringBuilder();
        int counter;

        for (int i = 0; i < s.length(); i++) {
            counter = 0;
            int m = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    counter++;
                    m++;
                }
            }
            i += m;

            // System.out.print(s.charAt(i));
            sb.append(s.charAt(i));
            if (counter + 1 > 1) {
                // System.out.print(counter + 1);
                sb.append(counter + 1);
            }
        }
        return sb.toString();

    }

    public static String replace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                ch = (char) (ch + 1);
            } else {
                ch = (char) (ch - 1);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String difference(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            int n = s.charAt(i + 1) - s.charAt(i);
            sb.append(n);
            sb.append(s.charAt(i + 1));

        }
        return sb.toString();
    }

    public static char maxfreq(String s) {
        int temp = 0;
        char ch = 'a';
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count > temp) {
                temp = count;
                ch = s.charAt(i);
            }

        }
        return ch;
    }

    public static void subsequences(String s) {
        if (s.length() <= 0) {
            System.out.println();
            return;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length(); i > 0; i--) {
            System.out.print(s.charAt(i - 1));
            System.out.println(s.charAt(s.length() - 1));
        }
        System.out.println(sb);
        sb.deleteCharAt(s.length() - 1);
        s = sb.toString();
        subsequences(s);

    }

}
