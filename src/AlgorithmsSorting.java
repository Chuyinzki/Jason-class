import java.util.Scanner;

/**
 * Created by jvillegas on 12/23/16.
 */
public class AlgorithmsSorting {

    public static void main(String[] args) {
        insertionSort1();
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

    private static void insertionSort1() {
        Scanner in = new Scanner(System.in);
        int arrSize = in.nextInt();
        int[] arr = new int[arrSize];
        for(int i = 0; i < arr.length - 1; i++)
            arr[i] = in.nextInt();
        int toInsert = in.nextInt();
        int i = arr.length;
        while(i-- > 1) {
            int leftNum = arr[i - 1];
            if(leftNum < toInsert)
                break;
            arr[i] = leftNum;
            printArr(arr);
        }
        arr[i] = toInsert;
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
