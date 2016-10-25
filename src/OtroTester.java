/**
 * Created by jvillegas on 10/25/16.
 */
public class OtroTester {

    int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    public static void main(String[] args) {
        int[] cube = Otro.generateCube(3);
        Otro.printCube(cube);
        Otro.printCube(Otro.getSum(cube));
    }

}
