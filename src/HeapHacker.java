import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jvillegas on 11/18/16.
 */
public class HeapHacker {

    public static void main(String[] args) {
        heaps1();
    }

    private static void heaps1() {
        Scanner in = new Scanner(System.in);
        int instructionCount = in.nextInt();
        TreeSet<Integer> set = new TreeSet<Integer>();
        while (instructionCount-- > 0) {
            int instruction = in.nextInt();
            if (instruction == 1 || instruction == 2) {
                int num = in.nextInt();
                if (instruction == 1)
                    set.add(num);
                else
                    set.remove(num);
            } else
                System.out.println(set.first());
        }
    }

    /*private static void heaps2() {
        Scanner in = new Scanner(System.in);
        int numCookies = in.nextInt();
        int minSweetness = in.nextInt();
        TreeMultiset<Integer> list = TreeMultiset.create();
        for(int i = 0; i < numCookies; i++)
            list.add(in.nextInt());

        int computationCount = 0;
        while(list.firstEntry().getElement() < minSweetness) {
            if(list.size() < 2) {
                computationCount = -1;
                break;
            }
            int least = list.pollFirstEntry().getElement();
            int second = list.pollFirstEntry().getElement();
            int newCookie = least + second * 2;
            list.add(newCookie);
            computationCount++;
        }
        System.out.print(computationCount);
    }*/
}
