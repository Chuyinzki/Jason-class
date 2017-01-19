import java.math.BigInteger;
import java.util.*;

/**
 * Created by jvillegas on 12/28/16.
 */
public class AlgorithmsDynamicProgramming {

    //I know retreating to a global variable is ugly, but I'm doing it anyways
    static HashMap<AbstractMap.SimpleImmutableEntry<Integer, Integer>, Long> map = new HashMap<>();

    public static void main(String[] args) {
        modifiedFib();
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

    private static void modifiedFib() {
        Scanner in = new Scanner(System.in);
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.valueOf((long)in.nextInt()));
        list.add(BigInteger.valueOf((long)in.nextInt()));
        System.out.print(modifiedFibHelper(in.nextInt(), list));
    }

    private static BigInteger modifiedFibHelper(int desired, ArrayList<BigInteger> list) {
        if (list.size() >= desired)
            return list.get(desired - 1);
        else {
            BigInteger prev = list.get(list.size() - 1);
            BigInteger prev2 = list.get(list.size() - 2);
            list.add(prev.multiply(prev).add(prev2));
            return modifiedFibHelper(desired, list);
        }
    }
}
