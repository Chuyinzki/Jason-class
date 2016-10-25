/**
 * Created by jvillegas on 10/25/16.
 */
public class Otro {

    public static int[] generateCube(int side) {
        int[] ret = new int[side*side];
        int toPut = 1;
        for(int i = 0; i < ret.length; i++)
            ret[i] = toPut++;
        return ret;
    }

    public static void printCube(int[] cube) {
        int side = (int) Math.sqrt(cube.length);
        for(int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(String.format("%4d", cube[side * i + j]));
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    public static int[] getSum(int[] toSum) {
        int side = (int) Math.sqrt(toSum.length);
        int[] toRet= new int[toSum.length];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                int total = 0;
                //add top left
                int topLeft = side * (i - 1) + (j - 1);
                if(topLeft >= 0)
                    total += toRet[topLeft];

                //add all up
                for (int p = i - 1; p >= 0; p--) {
                    total += toSum[side * p + j];
                }

                //add all left
                for (int k = j - 1; k >= 0; k--) {
                    total += toSum[side * i + k];
                }

                toRet[side * i + j] = total + toSum[side * i + j];
            }
        }
        return toRet;
    }
}
