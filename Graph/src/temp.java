import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class temp {
    public static class Trie {
        public class Node {
            Character data;
            boolean eow;
            HashMap<Character, Node> children = new HashMap<>();
        }

        private Node root = new Node();
        int numWords = 0;
        int numNods = 1;

        public void addWord(String word) {
            addWord(root, word);
        }

        private void addWord(Node node, String word) {
            if (word.length() == 0) {
                node.eow = true;
                numWords++;
                return;
            }
            char ch = word.charAt(0);
            String ros = word.substring(1);

            Node child = node.children.get(ch);

            if (child == null) {
                Node t = new Node();
                numNods++;
                t.data = ch;
                node.children.put(ch, t);
                addWord(t, ros);

            } else {
                addWord(child, ros);
            }
        }

        public boolean searchWord(String word) {
            return searchWord(root, word);
        }

        private boolean searchWord(Node node, String word) {
            if (word.length() == 0) {
                return node.eow;
            }
            char ch = word.charAt(0);
            String ros = word.substring(1);
            Node child = node.children.get(ch);

            if (child == null) {
                return false;
            } else {
                return searchWord(child, ros);
            }

        }

        public void removeWord(String word) {
            removeWord(root, word);
        }

        private void removeWord(Node node, String word) {
            if (word.length() == 0) {
                if (node.eow) {
                    node.eow = false;
                    this.numWords--;
                }
                return;
            }

            char ch = word.charAt(0);
            String ros = word.substring(1);
            Node child = node.children.get(ch);

            if (child == null) {
                System.out.println("word not present");
                return;
            }

            removeWord(child, ros);

            if (child.eow == false && child.children.size() == 0) {
                node.children.remove(ch);
                this.numNods--;
            }

        }

        public void solver(String s, mover m) {
            solver(s, root, m, 0);

        }

        private void solver(String s, Node root, mover m, int idx) {
            if (s.length() == 0) return;
            char ch = s.charAt(0);
            String ros = s.substring(1);
            solver(ros, root.children.get(ch), m, idx + 1);
            if (root.children.get(ch).children.size() > 1 && m.i == 0) m.i = idx + 1;

        }
    }

    public static class mover {
        int i = 0;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("beea");
        list.add("beer");
        System.out.println(prefix(list));
    }
    public static ArrayList<String> prefix(ArrayList<String> A) {
        Trie t = new Trie();
        for (String s : A) {
            t.addWord(s);
        }

        ArrayList<String> rl = new ArrayList<>();
        for (String s : A) {
            mover m = new mover();
            t.solver(s, m);
            rl.add(s.substring(0, m.i + 1));
        }
        return rl;
    }
}
