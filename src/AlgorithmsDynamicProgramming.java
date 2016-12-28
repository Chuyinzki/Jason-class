import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jvillegas on 12/28/16.
 */
public class AlgorithmsDynamicProgramming {
    public static void main(String[] args) {
        coinProblem();
    }

    private static void coinProblem() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(m == 0) {
            System.out.print(0);
            return;
        }
        int[] ms = new int[m];
        for(int i = 0; i < m; i++)
            ms[i] = in.nextInt();
        Arrays.sort(ms);
        System.out.print(coinProblemHelper(0, n, new ArrayList<>(), ms, 0));
    }

    private static int coinProblemHelper(int curCount, int n, ArrayList<Integer> curList, int[] ms, int curIter) {
        if(curCount > n)
            return 0;
        if(curCount == n)
            return 1;
        int innerMatches = 0;
        for(Integer i = curIter; i < ms.length; i++) {
            Integer j = ms[i];
            curList.add(j);
            innerMatches += coinProblemHelper(curCount + j, n, curList, ms, i);
            curList.remove(j);
        }
        return innerMatches;
    }
}
