/**
 * Created by jvillegas on 10/25/16.
 */
public class OtroTester {

    public static void main(String[] args) {
        int[] cube = Otro.generateCube(5);
        Otro.printCube(cube);
        Otro.printCube(Otro.getSum(cube));
    }

}
