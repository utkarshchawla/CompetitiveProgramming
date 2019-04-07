import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class First {

    public static HashMap<Character, ArrayList<String>> grammar = new HashMap<>();

    public static void main(String[] args) {
        grammar.put('A', new ArrayList<>(Arrays.asList("BC", "$")));
        grammar.put('B', new ArrayList<>(Arrays.asList("dC")));
        grammar.put('C', new ArrayList<>(Arrays.asList("$")));
        HashMap<Character, String> answer = new HashMap<>();
        for (char c : grammar.keySet()) {
            for (String s : grammar.get(c)) {
                if (answer.containsKey(c)) answer.put(c, answer.get(c) + multi(s));
                else answer.put(c, multi(s));
            }
        }
        for (char c : answer.keySet()) {
            System.out.println(c + " --> " + answer.get(c));
        }

    }

    private static String multi(String s) {
        if (s.length() == 1) return single(s.charAt(0));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            sb.append(single(s.charAt(i)));
            if (!hasEpsilon(s.charAt(i))) break;
            i++;
        }
        return sb.toString();
    }

    private static boolean hasEpsilon(Character ch) {
        if ((ch <= 'z' && ch >= 'a') || ch == '$') return false;
        for (String s : grammar.get(ch)) {
            for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '$') return true;
        }
        return false;
    }

    private static String single(Character ch) {
        if ((ch <= 'z' && ch >= 'a') || ch == '$') return ch + "";
        StringBuilder sb = new StringBuilder();
        for (String s : grammar.get(ch)) {
            sb.append(multi(s));
        }
        return sb.toString();
    }

}
