import java.util.Scanner;

/**
 * Created by jvillegas on 12/23/16.
 */
public class AlgorithmsSorting {

    public static void main(String[] args) {
        intro();
    }

    private static void intro() {
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        int arrSize = in.nextInt();
        int i = 0;
        while(arrSize-- > 0) {
            if(in.nextInt() == val) {
                System.out.print(i);
                break;
            }
            i++;
        }
        /*int[] arr = new int[arrSize];
        for(int i = 0; i < arr.length; i++)
            arr[i] = in.nextInt();*/

       /* int min = 0;
        int max = arr.length - 1;
        int index = (max - min)/2;
        while(true) {
            int iNum = arr[index];
            if(iNum == val) {
                System.out.print(index);
                break;
            } else if (iNum < val)
                index = (max - (min = index))/2;
            else
                index = ((max = index) - min)/2;

        }*/
    }
}
