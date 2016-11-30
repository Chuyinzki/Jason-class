import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jvillegas on 11/17/16.
 */
public class StackQueueHacker {

    public static void main(String[] args) {
        stacks3();
    }

    private static void stacks1() {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        int instructionCount = in.nextInt();
        for (int i = 0; i < instructionCount; i++) {
            int instruction = in.nextInt();
            if (instruction == 1) {
                int toPush = in.nextInt();
                stack.push(toPush);
                if (maxStack.empty() || maxStack.peek() <= toPush)
                    maxStack.push(toPush);
            } else if (instruction == 2) {
                int popped = stack.pop();
                if (!maxStack.empty() && maxStack.peek() == popped)
                    maxStack.pop();
            } else {
                System.out.println(maxStack.peek());
            }
        }
    }

    private static void stacks2() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++)
            System.out.println(isBalanced(in.next()) ? "YES" : "NO");
    }

    private static boolean isBalanced(String s) {
        Stack<Character> yoink = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '{' || curChar == '[' || curChar == '(')
                yoink.push(curChar);
            else {
                if (yoink.empty())
                    return false;
                char toMatch = yoink.pop();
                if ((toMatch == '{' && curChar != '}') || (toMatch == '[' && curChar != ']') || (toMatch == '(' && curChar != ')'))
                    return false;
            }
        }
        return yoink.empty();
    }

    private static void stacks3() {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        ArrayList<Integer> h1 = new ArrayList<Integer>(n1);
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1.add(in.nextInt());
        }
        ArrayList<Integer> h2 = new ArrayList<Integer>(n2);
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2.add(in.nextInt());
        }
        ArrayList<Integer> h3 = new ArrayList<Integer>(n3);
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3.add(in.nextInt());
        }

        for (int iter = h1.size() - 2; iter >= 0; iter--)
            h1.set(iter, h1.get(iter) + h1.get(iter + 1));

        for (int iter = h2.size() - 2; iter >= 0; iter--)
            h2.set(iter, h2.get(iter) + h2.get(iter + 1));

        for (int iter = h3.size() - 2; iter >= 0; iter--)
            h3.set(iter, h3.get(iter) + h3.get(iter + 1));

        while (h1.size() > 0 && h2.size() > 0 && h3.size() > 0) {
            int h1Last = h1.get(0);
            int h2Last = h2.get(0);
            int h3Last = h3.get(0);
            if (h1Last == h2Last && h2Last == h3Last) {
                System.out.print(h1Last);
                return;
            }
            if(h1Last >= h2Last && h1Last >= h3Last)
                h1.remove(0);
            else if(h2Last >= h3Last && h2Last >= h1Last)
                h2.remove(0);
            else
                h3.remove(0);

        }
        System.out.println(0);
    }

    private static void queue1() {
        Scanner in = new Scanner(System.in);
        int instructionCount = in.nextInt();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (instructionCount-- > 0) {
            int instruction = in.nextInt();
            if (instruction == 1) {
                s1.push(in.nextInt());
            } else if (instruction == 2) {
                if (s2.empty())
                    while (!s1.empty())
                        s2.push(s1.pop());
                s2.pop();
            } else {
                if (s2.empty())
                    while (!s1.empty())
                        s2.push(s1.pop());
                System.out.println(s2.peek());
            }
        }
    }

    /*private static void queue2() {
        Scanner in = new Scanner(System.in);
        int sizeN = in.nextInt();
        while (sizeN-- > 0) {
            int instruction = in.nextInt();
            if (instruction == 1) {
                s1.push(in.nextInt());
            } else if (instruction == 2) {
                if (s2.empty())
                    while (!s1.empty())
                        s2.push(s1.pop());
                s2.pop();
            } else {
                if (s2.empty())
                    while (!s1.empty())
                        s2.push(s1.pop());
                System.out.println(s2.peek());
            }
        }
    }*/


}
