import java.io.*;
import java.util.*;

public class temp {

    public static void main(String[] args) throws IOException {
        String path = "D:\\src.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        HashMap<String, ArrayList<Integer>> keyword = new HashMap<>();
        HashMap<String, ArrayList<Integer>> identifier = new HashMap<>();
        HashSet<String> words = new HashSet<>();
        words.add("int");
        words.add("float");
        words.add("String");
        words.add("char");
        String st;
        int lno = 0;
        while ((st = br.readLine()) != null) {
            String[] arr = st.split(" ");
            String[] handlefor = st.split("\\(");
            if (handlefor.length > 1) {
                for (int k = 1; k < handlefor.length; k += 2) {
                    String[] temp = handlefor[k].split(" ");
                    helper(temp, identifier, keyword, words, lno);
                }
            }
            helper(arr, identifier, keyword, words, lno);
            lno++;
        }

        System.out.println("Keywords");
        for (String s : keyword.keySet()) {
            System.out.println(s + " " + keyword.get(s));
        }

        System.out.println("Identifier");
        for (String s : identifier.keySet()) {
            identifier.get(s).remove(0);
            System.out.println(s + " " + identifier.get(s));
        }
    }


    private static void helper(String arr[], HashMap<String, ArrayList<Integer>> identifier, HashMap<String, ArrayList<Integer>> keyword, HashSet<String> words, int lno) {
        for (int i = 0; i < arr.length; i++) {
            if (words.contains(arr[i])) {
                ArrayList<Integer> list = new ArrayList<>();
                if (keyword.containsKey(arr[i])) list = keyword.get(arr[i]);
                list.add(lno);
                keyword.put(arr[i], list);

                if (i + 1 < arr.length) {
                    String str = arr[i + 1];
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == ';' || str.charAt(j) == '=' || str.charAt(j) == ')') {
                            arr[i + 1] = arr[i + 1].substring(0, j);
                            break;
                        }
                    }
                    ArrayList<Integer> list2 = new ArrayList<>();
                    if (identifier.containsKey(arr[i + 1])) list2 = identifier.get(arr[i + 1]);
                    list2.add(lno);
                    identifier.put(arr[i + 1], list2);
                }
            }

            if (identifier.containsKey(arr[i])) {
                identifier.get(arr[i]).add(lno);
            }

        }
    }
}
