import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jvillegas on 11/15/16.
 */
public class ArraysHacker {

    public static void main(String[] args) {
        arrays3();
    }

    private static void arrays1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void arrays2() {
        int size = 6;
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        Integer maxCalc = null;
        int tempSum = 0;
        for(int i = 0; i < size - 2; i++){
            for(int j = 0; j < size - 2; j++){
                tempSum += matrix[i][j];
                tempSum += matrix[i][j + 1];
                tempSum += matrix[i][j + 2];
                tempSum += matrix[i + 1][j + 1];
                tempSum += matrix[i + 2][j];
                tempSum += matrix[i + 2][j + 1];
                tempSum += matrix[i + 2][j + 2];
                if(maxCalc == null)
                    maxCalc = tempSum;
                else
                    maxCalc = Math.max(tempSum, maxCalc);
                tempSum = 0;
            }
        }
        System.out.print(maxCalc);
    }

    private static void arrays3() {
        Scanner in = new Scanner(System.in);
        int seqCount = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(seqCount);
        for(int i = 0; i < seqCount; i++) {
            list.add(new ArrayList<>());
        }
        int lineCount = in.nextInt();
        int lastAns = 0;

        for(int i = 0; i < lineCount; i++) {
            int instruction = in.nextInt();
            int x = in.nextInt();
            int y =in.nextInt();
            ArrayList<Integer> seq = list.get((x^lastAns) % seqCount);
            if(instruction == 1) {
                seq.add(y);
            } else {
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
            }
        }
    }

    private static void arrays4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] ret = new int[n];
        int rotations = in.nextInt();
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        for(int i = 0; i < arr.length; i++) {
            int finalRotation = i - rotations;
            if(finalRotation < 0) {
                int normalized = Math.abs(finalRotation) % arr.length;
                finalRotation = arr.length - normalized;
            }
            ret[finalRotation] = arr[i];
        }

        for(int print : ret) {
            System.out.print(print + " ");
        }
    }

    private static void arrays5() {
        Scanner in = new Scanner(System.in);
        int stringsCount = Integer.parseInt(in.nextLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < stringsCount; i++){
            String temp = in.nextLine();
            Integer currentValue = map.get(temp);
            map.put(temp, currentValue == null ? 1 : ++currentValue);
        }
        int compareCount = Integer.parseInt(in.nextLine());

        for(int i = 0; i < compareCount; i++) {
            String temp = in.nextLine();
            Integer count = map.get(temp);
            System.out.println(count == null ? 0 : count);
        }
    }

    private static void print2DArray(int[][] in){
        for(int i = 0; i < in.length; i++) {
            for (int j = 0; j < in.length; j++) {
                System.out.print(String.format("%" + in.length + "d", in[i][j]));
            }
            System.out.println();
        }
    }

}
