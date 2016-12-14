import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jvillegas on 11/17/16.
 */
public class StackQueueHacker {

    public static void main(String[] args) {
        queue2();
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
            if (h1Last >= h2Last && h1Last >= h3Last)
                h1.remove(0);
            else if (h2Last >= h3Last && h2Last >= h1Last)
                h2.remove(0);
            else
                h3.remove(0);

        }
        System.out.println(0);
    }

    private static void stacks4() {
        Scanner in = new Scanner(System.in);
        int instructionCount = in.nextInt();
        Stack<String> stack = new Stack<String>();
        String s = "";

        for (int i = 0; i < instructionCount; i++) {
            int instruction = in.nextInt();
            if (instruction == 1) {
                String temp = in.next();
                s = s + temp;
                stack.push(temp);
                stack.push("" + instruction);
            } else if (instruction == 2) {
                int toDelete = in.nextInt();
                String deleted = s.substring(s.length() - toDelete, s.length());
                s = s.substring(0, s.length() - toDelete);
                stack.push(deleted);
                stack.push("" + instruction);
            } else if (instruction == 3)
                System.out.println(s.charAt(in.nextInt() - 1));
            else if (instruction == 4) {
                int prevInstruction = Integer.parseInt(stack.pop());
                String undoString = stack.pop();
                if (prevInstruction == 1)
                    s = s.substring(0, s.length() - undoString.length());
                else if (prevInstruction == 2)
                    s += undoString;
            }
        }
    }

    private static void stacks5() {
        Scanner in = new Scanner(System.in);
        int plantCount = in.nextInt();
        if (plantCount < 2) return;
        Stack<Integer> stackA = new Stack<Integer>();
        Stack<Integer> stackB = new Stack<Integer>();
        boolean changed = false;
        int dayCount = 0;

        Integer lastPlant = in.nextInt();
        stackA.push(lastPlant);
        Integer nextPlant;
        for (int i = 1; i < plantCount; i++) {
            nextPlant = in.nextInt();
            if (lastPlant < nextPlant) {
                changed = true;
                lastPlant = nextPlant;
            } else {
                stackA.push(nextPlant);
                lastPlant = nextPlant;
            }
        }
        dayCount++;

        while (changed) {
            if (stackA.size() < 2 && stackB.size() < 2) {
                dayCount++;
                break;
            }
            changed = false;
            if (stackA.isEmpty()) {
                lastPlant = stackB.pop();
                stackA.push(lastPlant);
                while (!stackB.isEmpty()) {
                    nextPlant = stackB.pop();
                    if (lastPlant < nextPlant) {
                        changed = true;
                        lastPlant = nextPlant;
                    } else {
                        stackA.push(nextPlant);
                        lastPlant = nextPlant;
                    }
                }
            } else {
                lastPlant = stackA.pop();
                while (!stackA.isEmpty()) {
                    nextPlant = stackA.pop();
                    if (lastPlant > nextPlant) {
                        changed = true;
                        lastPlant = nextPlant;
                    } else {
                        stackB.push(lastPlant);
                        lastPlant = nextPlant;
                    }
                }
                stackB.push(lastPlant);
            }
            dayCount++;
        }

        System.out.print(--dayCount);
    }

    private static void stacks6() {
        Scanner in = new Scanner(System.in);
        int platesCount = in.nextInt();
        int finalIteration = in.nextInt();
        int iteration = 0;
        int[] primes = getFirstNPrimes(finalIteration);
        ArrayList<Stack<Integer>> listOfStacks = new ArrayList<>();

        Stack<Integer> A = new Stack<>();
        Stack<Integer> Atemp = new Stack<>();
        for (int i = 0; i < platesCount; i++)
            A.push(in.nextInt());

        while (iteration < finalIteration) {
            Stack<Integer> b = new Stack<>();
            int prime = primes[iteration];
            if (A.isEmpty()) {
                while (!Atemp.isEmpty()) {
                    int plate = Atemp.pop();
                    if (plate % prime == 0)
                        b.push(plate);
                    else
                        A.push(plate);
                }
            } else {
                while (!A.isEmpty()) {
                    int plate = A.pop();
                    if (plate % prime == 0)
                        b.push(plate);
                    else
                        Atemp.push(plate);
                }
            }
            listOfStacks.add(b);
            iteration++;
        }

        for (Stack<Integer> stack : listOfStacks)
            while (!stack.isEmpty())
                System.out.println(stack.pop());
        if (A.isEmpty())
            while (!Atemp.isEmpty())
                System.out.println(Atemp.pop());
        else
            while (!A.isEmpty())
                System.out.println(A.pop());
    }

    private static int[] getFirstNPrimes(int n) {
        int[] ret = new int[n];
        int count = 0;
        int num = 2;
        while (count != n) {
            boolean prime = true;
            for (int i = 2; i <= Math.sqrt(num); i++)
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            if (prime)
                ret[count++] = num;
            num++;
        }
        return ret;
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

    private static void queue2() {
        Scanner in = new Scanner(System.in);
        int sizeN = in.nextInt();
        char[][] grid = new char[sizeN][sizeN];

        for (int i = 0; i < sizeN; i++) {
            String line = in.next();
            for (int j = 0; j < sizeN; j++)
                grid[j][i] = line.charAt(j);
        }

        int xOrig = in.nextInt();
        int yOrig = in.nextInt();
        int xDest = in.nextInt();
        int yDest = in.nextInt();


    }


}
