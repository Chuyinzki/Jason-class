import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by jvillegas on 12/29/16.
 */
public class AlgorithmsGraphTheory {

    public static void main(String[] args) {
        toTheMoon();
    }

    private static void bfs() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
    }

    private static void toTheMoon() {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int i = in.nextInt();
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        while (i-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int status = 1; // 0=foundNowAdd 1=notFoundAdd 2=merge
            PriorityQueue<Integer> queueToAdd = null;
            PriorityQueue<Integer> queueToRemove = null;
            int intToAdd = -1;
            for (int as = 0; as < list.size(); as++) {
                PriorityQueue<Integer> q = list.get(as);
                boolean aCont = q.contains(a);
                boolean bCont = q.contains(b);
                if (aCont || bCont)
                    if (queueToAdd == null) {
                        queueToAdd = q;
                        if (aCont && bCont) {
                            status = -1;
                            break;
                        } else {
                            intToAdd = aCont ? b : a;
                            status = 0;
                        }
                    } else {
                        queueToRemove = q;
                        for (Integer k : q)
                            queueToAdd.add(k);
                        status = 3;
                        break;
                    }

            }
            if (status == 0) {
                queueToAdd.add(intToAdd);
            } else if (status == 1) {
                PriorityQueue<Integer> newQ = new PriorityQueue<>();
                newQ.add(a);
                newQ.add(b);
                list.add(newQ);
            } else if (status == 3) {
                list.remove(queueToRemove);
            }
        }
        long perms = 0L;
        for (PriorityQueue<Integer> q : list) {
            int size = q.size();
            n -= size;
            perms += n * size;
        }
        perms += (n * (n - 1)) / 2;
        System.out.print(perms);
    }

}
