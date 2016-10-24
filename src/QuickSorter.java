/**
 * Created by jvillegas on 10/24/16.
 */
public class QuickSorter<T extends Comparable<T>> {

    private T[] elements;

    public void sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        elements = arr;
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int start, int end) {
        int i = start;
        int j = end;
        // calculate pivot number, I am taking pivot as middle index number
        T pivot = elements[start + (end - start) / 2];
        // Divide into two arrays
        while (i <= j) {
            while (elements[i].compareTo(pivot) < 0) {
                i++;
            }
            while (elements[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swappity(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (start < j)
            quickSort(start, j);
        if (i < end)
            quickSort(i, end);
    }

    private void swappity(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
