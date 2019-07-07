package june_23;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashSet;

public class arraylist {

    public static void main(String[] args) {
//        System.out.println(getMazePathsMulti(0, 0, 2, 2));
        printKPC("23","");


        System.out.println(permDup("aab"));
    }

    public static ArrayList<Integer> getIntersection(Integer[] one, Integer[] two) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, k = 0;
        while (i < one.length && k < two.length) {
            if (one[i].equals(two[k])) {
                list.add(one[i]);
                k++;
                i++;
            } else if (one[i] > two[k]) {
                k++;
            } else {
                i++;
            }
        }

        return list;
    }

    public static ArrayList<String> subsequencevar(String s) {
        if (s.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);

        ArrayList<String> rr = subsequencevar(ros);
        ArrayList<String> mr = new ArrayList<>();

        for (String rs : rr) {
            mr.add(rs);
            mr.add(ch + rs);
            mr.add((int) ch + rs);
        }

        return mr;
    }

    public static ArrayList<String> getboardpath(int curr, int end) {
        if (curr == end) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        if (curr == 0) {
            ArrayList<String> rr = getboardpath(curr + 1, end);
            for (String rs : rr) {
                mr.add(1 + rs);
            }

            rr = getboardpath(curr + 6, end);
            for (String rs : rr) {
                mr.add(6 + rs);
            }
        } else {

            for (int dice = 1; dice <= 6; dice++) {
                if (curr + dice <= end) {
                    ArrayList<String> rr = getboardpath(curr + dice, end);
                    for (String rs : rr) {
                        mr.add(dice + rs);
                    }
                }
            }
        }

        return mr;
    }

    public static ArrayList<String> getMazePaths(int cr, int cc, int er, int ec) {
        if (cr == er && cc == ec) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (cr > er || cc > ec) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> rrv = getMazePaths(cr + 1, cc, er, ec);
        for (String rs : rrv) {
            mr.add("V" + rs);
        }

        ArrayList<String> rrh = getMazePaths(cr, cc + 1, er, ec);
        for (String rs : rrh) {
            mr.add("H" + rs);
        }

        ArrayList<String> rrd = getMazePaths(cr + 1, cc + 1, er, ec);
        for (String rs : rrd) {
            mr.add("D" + rs);
        }
        return mr;
    }

    public static ArrayList<String> getMazePathsMulti(int cr, int cc, int er, int ec) {

        if (cr == er && cc == ec) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (cr > er || cc > ec) {
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        for (int v = 1; v <= er; v++) {
            if (cr + v <= er) {
                ArrayList<String> rrv = getMazePathsMulti(cr + v, cc, er, ec);
                for (String rs : rrv) {
                    mr.add("V" + v + rs);
                }
            }

        }

        for (int h = 1; h <= ec; h++) {
            if (cc + h <= ec) {
                ArrayList<String> rrh = getMazePathsMulti(cr, cc + h, er, ec);
                for (String rs : rrh) {
                    mr.add("H" + h + rs);
                }
            }
        }
        for (int d = 1; d <= er && d <= ec; d++) {
            if (cr + d <= er && cc + d <= ec) {
                ArrayList<String> rrd = getMazePathsMulti(cr + d, cc + d, er, ec);
                for (String rs : rrd) {
                    mr.add("D" + d + rs);
                }
            }
        }
        return mr;
    }

    public static ArrayList<String> perm(String s) {
        if (s.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);

        ArrayList<String> rr = perm(ros);
        ArrayList<String> mr = new ArrayList<>();

        for (String rs : rr) {
            for (int i = 0; i <= rs.length(); i++) {
                String rv = rs.substring(0, i) + ch + rs.substring(i);
                mr.add(rv);
                // StringBuilder sb = new StringBuilder(rs);
                // sb.insert(i, ch);
                // mr.add(sb.toString());
            }

        }
        return mr;
    }

    public static String getQuote(char ch) {
        if (ch == '1') {
            return "abc";
        } else if (ch == '2') {
            return "def";
        } else if (ch == '3') {
            return "ghi";
        } else if (ch == '4') {
            return "jkl";
        } else if (ch == '5') {
            return "mno";
        } else if (ch == '6') {
            return "pqrs";
        } else if (ch == '7') {
            return "tuv";
        } else if (ch == '8') {
            return "wx";
        } else if (ch == '9') {
            return "yx";
        } else {
            return ".;_";
        }
    }

    public static ArrayList<String> getKPC(String s) {
        if (s.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);

        ArrayList<String> rr = getKPC(ros);
        ArrayList<String> mr = new ArrayList<>();
        for (int i = 0; i < getQuote(ch).length(); i++) {
            char ch2 = getQuote(ch).charAt(i);
            for (String rs : rr) {
                mr.add(rs + ch2);
            }
        }
        return mr;

    }


    public static ArrayList<String> permDup(String s) {
        if (s.length() == 0) {
            ArrayList<String> rl = new ArrayList<>();
            rl.add("");
            return rl;
        }
        ArrayList<String> ml = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            if (set.contains(ch)) continue;
            set.add(ch);
            ArrayList<String> rl = permDup(ros);
            for (String str : rl) ml.add(ch + str);
        }
        return ml;
    }

    // backtracking method ----------------------------------------
    // ------------------------------------------------------------
    // ------------------------------------------------------------

    public static void printSSWAscii(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        printSSWAscii(roq, ans);
        printSSWAscii(roq, ans + ch);
        // printSSWAscii(roq, ans + (int) ch);
    }

    public static void printKPC(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.print(ans + ", ");
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        for (int i = 0; i < getQuote(ch).length(); i++) {
            char ch2 = getQuote(ch).charAt(i);
            printKPC(roq, ans + ch2);
        }
    }

    public static void printPermutation(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        for (int i = 0; i <= ans.length(); i++) {
            printPermutation(roq, ans.substring(0, i) + ch + ans.substring(i));
        }
    }

    public static void printPermutationduplicate(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        boolean[] dupli = new boolean[256];
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i + 1);
            if (dupli[ch] == false) {
                printPermutationduplicate(roq, ans + ch);
                dupli[ch] = true;
            }
        }
    }

}

