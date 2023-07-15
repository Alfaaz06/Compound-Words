import java.io.File;
import java.util.*;

public class index {
    static class Trie {

        public HashMap<Character, Trie> children;
        boolean endOfWord;

        public Trie() {
            children = new HashMap<Character, Trie>();
            endOfWord = false;
        }

    }

    static Trie root = new Trie();

    public static void insert(String s) {
        Trie roots = root;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!roots.children.keySet().contains(ch))
                roots.children.put(ch, new Trie());
            roots = roots.children.get(ch);
        }
        roots.endOfWord = true;
    }

    public static List<Integer> prefixes(String s) {
        List<Integer> list = new ArrayList<>();
        Trie roots = root;

        for (int i = 0; i < s.length(); i++) {
            if (!roots.children.keySet().contains(s.charAt(i)))
                return list;
            roots = roots.children.get(s.charAt(i));

            if (roots.endOfWord) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {

        long begin = System.currentTimeMillis();

        File file = new File("C:\\Users\\dell\\Desktop\\Impledge\\Input_02.txt"); //path of the input file.
        List<String> list = new LinkedList<>();
        Scanner sc = new Scanner(file);
        List<Integer> indices = new ArrayList<>();

        while (sc.hasNext()) {
            String word = sc.nextLine();
            indices = prefixes(word);
            for (int index : indices) {
                if (index >= word.length())
                    break;
                list.add(word + " " + word.substring(index));
            }
            insert(word);
        }

        String p;
        int maxLength = 0;
        String first = "";
        String second = "";

        while (!list.isEmpty()) {
            p = list.remove(0);
            String str[] = p.split(" ");
            String s1 = str[0];
            String s2 = str[1];
            indices = prefixes(s2);

            if (indices.isEmpty()) {
                continue;
            }

            for (int i : indices) {
                if (i > s2.length()) {
                    break;
                }

                if (i == s2.length()) {
                    if (s1.length() > maxLength) {
                        second = first;
                        maxLength = s1.length();
                        first = s1;
                    }

                } else {
                    list.add(s1 + " " + s2.substring(i));
                }
            }
        }

        long end = System.currentTimeMillis();
        // print out the results
        System.out.println("Longest Compound Word: " + first);
        System.out.println("Second Longest Compound Word: " + second);
        System.out.println("Time: " + (end - begin));
        sc.close();
    }

}
