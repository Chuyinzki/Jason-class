import java.util.Scanner;

/**
 * Created by jvillegas on 12/14/16.
 */
public class AlgorithmsWarmUp {

    public static void main(String[] args) {
        timeConversion();
    }

    private static void bigSum() {
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
        for (int i = 0; i < n; i++)
            primary += cube[i][i];

        int secondary = 0;
        int y = n - 1;
        for (int i = 0; i < n; i++)
            secondary += cube[i][y--];

        System.out.print(Math.abs(primary - secondary));
    }

    private static void plusMinus() {
        Scanner in = new Scanner(System.in);
        int totalCount = in.nextInt();
        int posTotal = 0;
        int negTotal = 0;
        int zeroTotal = 0;
        for (int i = 0; i < totalCount; i++) {
            int num = in.nextInt();
            if (num > 0)
                posTotal++;
            else if (num < 0)
                negTotal++;
            else
                zeroTotal++;
        }

        System.out.printf("%.6f\n", ((float) posTotal) / ((float) totalCount));
        System.out.printf("%.6f\n", ((float) negTotal) / ((float) totalCount));
        System.out.printf("%.6f\n", ((float) zeroTotal) / ((float) totalCount));
    }

    private static void staircase() {
        Scanner in = new Scanner(System.in);
        int stairSize = in.nextInt();
        for (int i = stairSize - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--)
                System.out.print(' ');
            for (int k = stairSize - i; k > 0; k--)
                System.out.print('#');
            System.out.println();
        }
    }

    private static void timeConversion() {
        Scanner in = new Scanner(System.in);
        String timeOrig = in.next();
        int h = Integer.parseInt(timeOrig.substring(0, 2));
        int m = Integer.parseInt(timeOrig.substring(3, 5));
        int s = Integer.parseInt(timeOrig.substring(6, 8));
        if ((timeOrig.charAt(8) == 'P' && h != 12) || (timeOrig.charAt(8) != 'P' && h == 12))
            h += 12;
        System.out.print(String.format("%02d:%02d:%02d", h % 24, m, s));
    }
}
