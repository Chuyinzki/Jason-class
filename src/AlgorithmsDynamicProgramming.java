import java.util.*;

/**
 * Created by jvillegas on 12/28/16.
 */
public class AlgorithmsDynamicProgramming {

    //I know retreating to a global variable is ugly, but I'm doing it anyways
    static HashMap<AbstractMap.SimpleImmutableEntry<Integer, Integer>, Long> map = new HashMap<>();

    public static void main(String[] args) {
        coinProblem();
    }

    private static void coinProblem() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (m == 0) {
            System.out.print(0);
            return;
        }
        int[] ms = new int[m];
        for (int i = 0; i < m; i++)
            ms[i] = in.nextInt();
        Arrays.sort(ms);
        System.out.print(coinProblemHelper(n, ms, 0));
    }

    private static Long coinProblemHelper(int n, int[] ms, int curIter) {
        if (n < 0)
            return 0L;
        if (0 == n)
            return 1L;
        Long innerMatches = 0L;
        for (Integer i = curIter; i < ms.length; i++) {
            AbstractMap.SimpleImmutableEntry<Integer, Integer> entry =
                    new AbstractMap.SimpleImmutableEntry<>(i, n);
            Long count = map.get(entry);
            if (count == null) {
                Long reted = coinProblemHelper(n - ms[i], ms, i);
                innerMatches += reted;
                map.put(entry, reted);
            } else
                innerMatches += count;
        }
        return innerMatches;
    }
}
