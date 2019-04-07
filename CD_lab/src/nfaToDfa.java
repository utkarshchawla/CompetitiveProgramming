import java.util.*;

public class nfaToDfa {

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Enter the number of states in the NFA");
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        HashMap<String, ArrayList<String>> nfa = new HashMap<>();
        HashMap<String, ArrayList<String>> dfa = new HashMap<>();
        ArrayList<String> mul = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        System.out.println("Input the NFA");
        while (t-- > 0) {
            String s = scn.nextLine();
            String[] arr = s.split(":");
            String left = arr[0];
            String right1 = arr[1].substring(1).split(" ")[0];
            String right2 = arr[1].substring(1).split(" ")[1];
            nfa.put(left, new ArrayList<>(Arrays.asList(right1, right2)));
            if (t == 2) {
                dfa.put(left, new ArrayList<>(Arrays.asList(right1, right2)));
                set.add(left);
                mul.add(right1);
                mul.add(right2);
            }
        }
        while (mul.size() != 0) {
            String s = mul.remove(mul.size() - 1);
            if (set.contains(s) || s.length() == 0) continue;
            set.add(s);
            ArrayList<String> ans = new ArrayList<>();
            for (int ns = 0; ns < n; ns++) {
                String str = "";
                for (int i = 0; i < s.length(); i++) {
                    str += nfa.get(s.charAt(i) + "").get(ns);
                }
                str = remdup(str);
                ans.add(str);
                mul.add(str);
            }
            dfa.put(s, ans);
        }

        System.out.println("output DFA is:-");
        for (String s : dfa.keySet()) {
            System.out.println(s + "-->" + dfa.get(s));
        }
    }

    public static String remdup(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            sb.append(s.charAt(i));
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
