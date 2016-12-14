import java.util.Scanner;

/**
 * Created by jvillegas on 12/14/16.
 */
public class AlgorithmsWarmUp {

    public static void main(String[] args) {
        diagonalDifference();
    }

    public static void bigSum() {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        long sum = 0L;
        while (lines-- > 0)
            sum += in.nextInt();
        System.out.print(sum);
    }

    private static void diagonalDifference() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] cube = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cube[j][i] = in.nextInt();

        int primary = 0;
        for(int i = 0; i < n; i++)
            primary += cube[i][i];

        int secondary = 0;
        int y = n - 1;
        for(int i = 0; i < n; i++)
            secondary += cube[i][y--];

        System.out.print(Math.abs(primary - secondary));
    }
}
