import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * Created by jvillegas on 12/1/16.
 */
public class TreeTrieHacker {

    public static void main(String[] args) {
        tree1();
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
        System.out.println("This took: " + (endTime - startTime) / 1000 + " seconds");
    }

    private static int countEndings(TrieNode node) {
        if (node.data == '*')
            return 1;
        int retCount = 0;
        for (TrieNode n : node.children)
            retCount += countEndings(n);
        return retCount;
    }

    public static void trie2() {
        Scanner in = new Scanner(System.in);
        int instructions = in.nextInt();
        TrieNode root = new TrieNode(null);

        while (instructions-- > 0) {
            String arg = in.next();
            TrieNode temp = root;
            for (int j = 0; j < arg.length(); j++) {
                char c = arg.charAt(j);
                if(temp.children.indexOf(new TrieNode('*')) != -1) {
                    System.out.println("BAD SET");
                    System.out.print(arg);
                    return;
                }

                int index = temp.children.indexOf(new TrieNode(c));
                if (index != -1) {
                    temp = temp.children.get(index);
                } else {
                    TrieNode node = new TrieNode(c);
                    temp.children.add(node);
                    temp = temp.children.get(temp.children.indexOf(node));
                }
            }
            if(temp.children.size() > 0) {
                System.out.println("BAD SET");
                System.out.print(arg);
                return;
            }
            int endIndex = temp.children.indexOf(new TrieNode('*'));
            if (endIndex == -1)
                temp.children.add(new TrieNode('*'));

        }
        System.out.print("GOOD SET");
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

    public static void tree1() {
        Scanner in = new Scanner(System.in);
        LinkedList<Node> nodesToDefine = new LinkedList<>();
        Node root = new Node(1);
        nodesToDefine.push(root);
        int addCount = in.nextInt();

        while(addCount-- > 0) {
            Node parent = nodesToDefine.pollFirst();
            Node leftChild = null;
            Node rightChild = null;
            int leftInt = in.nextInt();
            int rightInt = in.nextInt();
            if(leftInt != -1) {
                leftChild = new Node(leftInt);
                nodesToDefine.add(leftChild);
            }
            if(rightInt != -1) {
                rightChild = new Node(rightInt);
                nodesToDefine.add(rightChild);
            }
            parent.left = leftChild;
            parent.right = rightChild;
        }

        int iterationCount = in.nextInt();
        while(iterationCount-- > 0) {
            int depthChange = in.nextInt();
            int mult = 1;
            LinkedList<Node> list = getNodesAtLevel(root, depthChange);
            while(!list.isEmpty()) {
                for (Node node : list) {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
                list = getNodesAtLevel(root, depthChange * (++mult));
            }
            preOrderPrint(root);
            System.out.println();
        }
    }

    private static void preOrderPrint(Node root) {
        if(root == null)
            return;
        preOrderPrint(root.left);
        System.out.print(root.data + " ");
        preOrderPrint(root.right);
    }

    private static LinkedList<Node> getNodesAtLevel(Node root, int level) {
        LinkedList<AbstractMap.SimpleImmutableEntry<Node, Integer>> list = new LinkedList<>();
        LinkedList<Node> retList = new LinkedList<>();
        int cur = 1;
        list.add(new AbstractMap.SimpleImmutableEntry<>(root, 1));
        while(!list.isEmpty()) {
            AbstractMap.SimpleImmutableEntry<Node, Integer> current = list.removeFirst();
            if(current.getValue() != cur)
                cur = current.getValue();

            if(cur == level) {
                retList.add(current.getKey());
                continue;
            }
            if(current.getKey().left != null)
                list.add(new AbstractMap.SimpleImmutableEntry<>(current.getKey().left, current.getValue() + 1));
            if(current.getKey().right != null)
                list.add(new AbstractMap.SimpleImmutableEntry<>(current.getKey().right, current.getValue() + 1));
        }
        return retList;
    }

    public static class Node {
        Integer data;
        Node left;
        Node right;
        public Node(int i){
            data = i;
        }
    }
}
