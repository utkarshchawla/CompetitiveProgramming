package assignment_7;

import java.util.ArrayList;
import java.util.Scanner;

import june_23.arraylist;

public class assignment_7 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        // System.out.println(sumDigits("12340"));
        //
        // System.out.println(isReverse("1234", "4321"));
        // System.out.println(isPalindrome(a));
        // System.out.println(conschar1("hello"));
        // System.out.println(conschar2("hello"));
        // System.out.println(ques7("abexexdexed"));
        // System.out.println(ques8a("abcdhiefghihijhi"));
        // System.out.println(ques8b("abcdhiefghihijhi"));
        // System.out.println(ques8c("hiihihit"));
        // System.out.println(ques9a("hi"));
        // System.out.println(ques9b("hitabcdhiefghihijhi"));
        // System.out.println(ques9c("abcdhitefghithijhi"));
        // System.out.println(ques10("abacaca"));
        // System.out.println(ques11a("abaaadaaa"));
        // System.out.println(ques11b("aaaaabaaa"));
        // ArrayList<String> list = new ArrayList<>();
        // ques12(a, "", list);
        // System.out.println(list);
        // System.out.println(ques13("abbab"));
        // System.out.println(ques14("xy(rgm)h"));
        // System.out.println(ques15("{a+(c+d)", 0));

    }

    public static int sumDigits(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int val = (int) (s.charAt(0) - '0');
        String rs = s.substring(1);
        int rv = sumDigits(rs);

        return rv + val;
    }

    public static int StrtoInt(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int val = (int) (s.charAt(s.length() - 1) - '0');
        String rs = s.substring(0, s.length() - 1);

        return StrtoInt(rs) * 10 + val;
    }

    public static boolean isReverse(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char ch1 = s1.charAt(0);
        String rs1 = s1.substring(1);
        char ch2 = s2.charAt(s2.length() - 1);
        String rs2 = s2.substring(0, s2.length() - 1);

        if (ch1 != ch2) {
            return false;
        }
        return isReverse(rs1, rs2);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static String conschar1(String s) {
        if (s.length() == 0) {
            return "";
        }
        char ch = s.charAt(s.length() - 1);
        String rs = s.substring(0, s.length() - 1);
        StringBuilder rsb = new StringBuilder(conschar1(rs));
        if (rs.length() > 0 && ch == rs.charAt(rs.length() - 1)) {
            rsb.append("*");
        }
        rsb.append(ch);
        return rsb.toString();
    }

    public static String conschar2(String s) {
        if (s.length() == 0) {
            return "";
        }
        char ch = s.charAt(s.length() - 1);
        String rs = s.substring(0, s.length() - 1);
        StringBuilder rsb = new StringBuilder(conschar2(rs));
        if (rs.length() <= 0) {
            rsb.append(ch);
        } else if (ch != rs.charAt(rs.length() - 1)) {
            rsb.append(ch);
        }

        return rsb.toString();

    }

    public static String ques7(String s) {
        if (s.length() == 0) {
            return "";
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);

        StringBuilder rsb = new StringBuilder(ques7(ros));
        if (ch == 'x') {
            rsb.append(ch);
        } else {
            rsb.insert(0, ch);
        }

        return rsb.toString();
    }

    public static int ques8a(String s) {
        if (s.length() < 2) {
            return 0;
        }

        String ros = s.substring(1);
        int cr = ques8a(ros);

        if (s.substring(0, 2).equals("hi")) {
            return cr + 1;
        }
        return cr;

    }

    public static String ques8b(String s) {
        if (s.length() == 0) {
            return "";
        }

        char h = s.charAt(0);
        String ros = s.substring(1);
        StringBuilder rsb = new StringBuilder(ques8b(ros));

        if (s.length() > 1 && s.substring(0, 2).equals("hi")) {
            rsb.deleteCharAt(0);
        } else {
            rsb.insert(0, h);
        }
        return rsb.toString();
    }

    public static String ques8c(String s) {
        if (s.length() == 0) {
            return "";
        }

        char h = s.charAt(0);
        String ros = s.substring(1);
        StringBuilder rsb = new StringBuilder(ques8c(ros));

        if (s.length() > 1 && s.substring(0, 2).equals("hi")) {
            rsb.deleteCharAt(0);
            rsb.insert(0, "bye");
        } else {
            rsb.insert(0, h);
        }
        return rsb.toString();
    }

    public static int ques9a(String s) {
        if (s.length() < 2) {
            return 0;
        }

        String ros = s.substring(1);
        int cr = ques9a(ros);

        if (s.length() == 2 && s.substring(0, 2).equals("hi")) {
            return cr + 1;
        }

        if (s.substring(0, 2).equals("hi") && s.charAt(2) != 't') {
            return cr + 1;
        }

        return cr;
    }

    public static String ques9b(String s) {
        if (s.length() == 0) {
            return "";
        }

        char h = s.charAt(0);
        String ros = s.substring(1);
        StringBuilder rsb = new StringBuilder(ques9b(ros));

        if (s.length() > 2 && s.substring(0, 2).equals("hi") && s.charAt(2) == 't') {
            rsb.insert(0, h);

        } else if (s.length() > 1 && s.substring(0, 2).equals("hi")) {
            rsb.deleteCharAt(0);

        } else {
            rsb.insert(0, h);
        }
        return rsb.toString();
    }

    public static String ques9c(String s) {
        if (s.length() == 0) {
            return "";
        }

        char h = s.charAt(0);
        String ros = s.substring(1);
        StringBuilder rsb = new StringBuilder(ques9c(ros));

        if (s.length() > 2 && s.substring(0, 2).equals("hi") && s.charAt(2) == 't') {
            rsb.insert(0, h);

        } else if (s.length() > 1 && s.substring(0, 2).equals("hi")) {
            rsb.deleteCharAt(0);
            rsb.insert(0, "bye");
        } else {
            rsb.insert(0, h);
        }
        return rsb.toString();
    }

    public static int ques10(String s) {
        if (s.length() < 3) {
            return 0;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        int cr = ques10(ros);

        if (ch == s.charAt(2)) {
            return cr + 1;
        }
        return cr;
    }

    public static int ques11a(String s) {
        if (s.length() < 3) {
            return 0;
        }

        String ros = s.substring(1);
        int cr = ques11a(ros);

        if (s.substring(0, 3).equals("aaa")) {
            return cr + 1;
        }
        return cr;

    }

    public static int ques11b(String s) {
        if (s.length() < 3) {
            return 0;
        }

        String ros = s.substring(1);
        int cr = ques11b(ros);

        if (s.length() == 3 && s.substring(0, 3).equals("aaa")) {
            return cr + 1;
        } else if (s.substring(0, 3).equals("aaa") && s.charAt(3) != 'a') {
            return cr + 1;
        }

        return cr;

    }

    public static void ques12(String ques, String ans, ArrayList<String> list) {
        if (ques.length() == 0) {
            list.add(ans);
            return;
        }

        for (int i = 0; i <= ques.length() - 1; i++) {
            String s = ques.substring(0, i + 1);
            String roq = ques.substring(i + 1);
            s = getCode(s);
            if (!s.equals("")) {
                ques12(roq, ans + s, list);
            }
        }
    }

    public static String getCode(String ch) {
        if (ch.equals("1")) {
            return "a";
        } else if (ch.equals("2")) {
            return "b";
        } else if (ch.equals("3")) {
            return "c";
        } else if (ch.equals("4")) {
            return "d";
        } else if (ch.equals("5")) {
            return "e";
        } else if (ch.equals("6")) {
            return "f";
        } else if (ch.equals("7")) {
            return "g";
        } else if (ch.equals("8")) {
            return "h";
        } else if (ch.equals("9")) {
            return "i";
        } else if (ch.equals("10")) {
            return "j";
        } else if (ch.equals("11")) {
            return "k";
        } else if (ch.equals("12")) {
            return "l";
        } else if (ch.equals("13")) {
            return "m";
        } else if (ch.equals("14")) {
            return "n";
        } else if (ch.equals("15")) {
            return "o";
        } else if (ch.equals("16")) {
            return "p";
        } else if (ch.equals("17")) {
            return "q";
        } else if (ch.equals("18")) {
            return "r";
        } else if (ch.equals("19")) {
            return "s";
        } else if (ch.equals("20")) {
            return "t";
        } else if (ch.equals("21")) {
            return "u";
        } else if (ch.equals("22")) {
            return "v";
        } else if (ch.equals("23")) {
            return "w";
        } else if (ch.equals("24")) {
            return "x";
        } else if (ch.equals("25")) {
            return "y";
        } else if (ch.equals("26")) {
            return "z";
        } else {
            return "";
        }
    }

    public static boolean ques13(String s) {
        if (s.length() == 0) {
            return true;
        }
        char ch = s.charAt(0);
        if (ch != 'a') {
            return false;
        } else {

            if (s.length() == 1) {
                return true;
            } else if (s.charAt(1) == 'a') {
                return ques13(s.substring(1));
            } else if (s.length() == 2) {
                return false;
            } else if (s.length() == 3 && !(s.substring(1, 3).equals("bb"))) {
                return false;
            } else if (s.substring(1, 3).equals("bb")) {
                // if (s.charAt(3) == 'a') {
                return ques13(s.substring(3));
                // }
            }

        }
        return false;

    }

    public static String ques14(String s) {
        if (s.length() <= 2) {
            return "";
        }

        char cs = s.charAt(0);
        char ce = s.charAt(s.length() - 1);
        String rs = null;
        if (cs == '(' && ce == ')') {
            rs = s.substring(1, s.length() - 1);
            return rs;
        }

        if (cs == '(') {
            rs = s.substring(0, s.length() - 1);
        } else if (ce == ')') {
            rs = s.substring(1, s.length());
        } else {
            rs = s.substring(1, s.length() - 1);
        }

        StringBuilder sb = new StringBuilder(ques14(rs));
        //

        return sb.toString();

    }

    // public static boolean ques15(String s, int count){
    //
    // }
}
