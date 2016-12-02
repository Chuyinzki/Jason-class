import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jvillegas on 12/1/16.
 */
public class TrieHacker {

    public static void main(String[] args) {
        trie1();
    }

    private static void trie1() {
        long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int instCount = in.nextInt();
        TrieNode root = new TrieNode(null);

        for (int i = 0; i < instCount; i++) {
            String inst = in.next();
            String arg = in.next();
            TrieNode temp = root;

            if ("add".equals(inst)) {
                for (int j = 0; j < arg.length(); j++) {
                    char c = arg.charAt(j);
                    int index = temp.children.indexOf(new TrieNode(c));
                    if (index != -1) {
                        temp = temp.children.get(index);
                    } else {
                        TrieNode node = new TrieNode(c);
                        temp.children.add(node);
                        temp = temp.children.get(temp.children.indexOf(node));
                    }
                }
                int endIndex = temp.children.indexOf(new TrieNode('*'));
                if (endIndex == -1)
                    temp.children.add(new TrieNode('*'));
            } else {
                boolean print = true;
                for (int j = 0; j < arg.length(); j++) {
                    char c = arg.charAt(j);
                    int index = temp.children.indexOf(new TrieNode(c));
                    if (index != -1) {
                        temp = temp.children.get(index);
                    } else {
                        print = false;
                        break;
                    }
                }
                System.out.println(print ? countEndings(temp) : 0);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("This took: " + (endTime - startTime)/1000 + " seconds");
    }

    private static int countEndings(TrieNode node) {
        if (node.data == '*')
            return 1;
        int retCount = 0;
        for (TrieNode n : node.children)
            retCount += countEndings(n);
        return retCount;
    }

    public static class TrieNode {
        Character data;
        LinkedList<TrieNode> children;

        public TrieNode(Character data) {
            this.data = data;
            children = new LinkedList<>();
        }

        @Override
        public boolean equals(Object obj) {
            return this.data == ((TrieNode) obj).data;
        }
    }
}
