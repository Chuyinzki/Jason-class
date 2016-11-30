/**
 * Created by jvillegas on 11/30/16.
 */
public class BadBreadthFirstSearch {
    /*Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.


    Do a level wise traversal of a binary tree and maintain the order of the levels in the output


                       5
                    /    \
                    4     3
                 /  \    /  \
                 1   7  6   10
                           /
                          52


                    5
                    4 3
                    1 7 6 10
                    52*/


    public static class Node {
        Integer value;
        Node left;
        Node right;
        public Node(int i){
            value = i;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);

        Node temp = root.left;
        temp.left = new Node(1);
        temp.right = new Node(7);

        temp = root.right;
        temp.left = new Node(6);
        temp.right = new Node(10);

        root.right.right.left = new Node(52);
        traverse(root);
    }

    public static void traverse(Node root) {
        int treeHeight = getTreeHeight(root, 0) + 1;
        for(int i = 0; i < treeHeight; i++){
            levelTraversal(root, 0, i);
            System.out.println();
        }
    }


    private static int getTreeHeight(Node root, int currentLevel) {
        if(root == null)
            return currentLevel - 1;
        return Math.max(getTreeHeight(root.left, currentLevel + 1), getTreeHeight(root.right, currentLevel + 1));
    }


    public static void levelTraversal(Node root, int level, int levelToPrint) {
        if(root == null)
            return;
        if(levelToPrint > level) {
            levelTraversal(root.left, level + 1, levelToPrint);
            levelTraversal(root.right, level + 1, levelToPrint);
        }
        else if(levelToPrint == level)
            System.out.print(root.value + " ");


    }
    /*System.out =  5
            4 3
            1 7 6 10
            52

    i			0 -> 1 -> 2
    level			0 -> 1 -> 0 -> 1 -> 2
    levelToPrint		0 -> 1 -> 2
    l


    Run time: n^2*/



}
