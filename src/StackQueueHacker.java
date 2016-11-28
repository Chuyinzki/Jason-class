import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jvillegas on 11/17/16.
 */
public class StackQueueHacker {

    public static void main(String[] args) {
        queue1();
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
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            System.out.print(0);
            return;
        }
        int s1Size = 0;
        int s2Size = 0;
        int s3Size = 0;
        int largestSize;

        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        int[] temp3 = new int[n3];
        for (int i = 0; i < n1; i++) {
            int temp = in.nextInt();
            s1Size += temp;
            temp1[i] = temp;
        }
        for (int i = 0; i < n2; i++) {
            int temp = in.nextInt();
            s2Size += temp;
            temp2[i] = temp;
        }
        for (int i = 0; i < n3; i++) {
            int temp = in.nextInt();
            s3Size += temp;
            temp3[i] = temp;
        }

        if (s1Size == s2Size && s2Size == s3Size) {
            System.out.print(s1Size);
            return;
        }

        Stack<Integer> s1 = new Stack<Integer>();
        for (int i = temp1.length - 1; i >= 0; i--)
            s1.push(temp1[i]);

        int final2Size = 0;
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = temp2.length - 1; i >= 0; i--) {
            int woink = temp2[i];
            s2.push(woink);
            final2Size += woink;
            if (final2Size >= s1Size)
                break;
        }

        int final3Size = 0;
        Stack<Integer> s3 = new Stack<Integer>();
        for (int i = temp3.length - 1; i >= 0; i--) {
            int woink = temp3[i];
            s3.push(woink);
            final3Size += woink;
            if (final3Size >= s1Size)
                break;
        }


        while (!s1.empty() && !s2.empty() && !s3.empty()) {
            if (s1Size == final2Size && final2Size == final3Size) {
                System.out.print(s1Size);
                return;
            }
            if (s1Size > final2Size && s1Size > final3Size)
                while (s1Size > final2Size && s1Size > final3Size)
                    s1Size -= s1.pop();
            else if (final2Size > s1Size && final2Size > final3Size)
                while (final2Size > s1Size && final2Size > final3Size)
                    final2Size -= s2.pop();
            else if (final3Size > s1Size && final3Size > final2Size)
                while ((final3Size > s1Size && final3Size > final2Size))
                    final3Size -= s3.pop();
        }
        System.out.print(0);
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


}
