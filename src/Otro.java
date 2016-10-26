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
                int topLeftCount = 0;
                int upCount = 0;
                int leftCount = 0;

                //add top left
                int topLeftIndex = side * (i - 1) + (j - 1);
                if(topLeftIndex >= 0 && i - 1 >= 0 && j - 1 >= 0)
                    topLeftCount = toRet[topLeftIndex];

                //add all up
                int upIndex = side * (i - 1) + j;
                if(upIndex >= 0 && i - 1 >= 0 && j >= 0)
                    upCount = toRet[upIndex];

                //add all left
                int leftIndex = side * (i) + j - 1;
                if(leftIndex >= 0 && i >= 0 && j - 1 >= 0)
                    leftCount = toRet[leftIndex];

                toRet[side * i + j] = topLeftCount + (upCount - topLeftCount) + (leftCount - topLeftCount) + toSum[side * i + j];
            }
        }
        return toRet;
    }
}
