import java.net.URI;
import java.util.Arrays;

/**
 * Created by jvillegas on 10/24/16.
 */
public class SortTester {
    private static Integer[] arrInt = {7,4,5,3,8,7,4,1,2,4,5,4,9,8,6};
    private static String[] strings = {"cSuch", "aWhy", "fYo?", "eBitch", "bYou", "dA"};
    private static URI[] uris = new URI[strings.length];

    public static void main(String [] args) throws Exception {
        for(int i = 0; i < strings.length; i++)
            uris[i] = new URI(strings[i]);

        testSorting(arrInt);
        testSorting(strings);
        testSorting(uris);
    }

    private static <T extends Comparable<T>> void testSorting(T[] toSort){
        QuickSorter<T> yolo = new QuickSorter<>();
        System.out.println("Before sorting: " + Arrays.toString(toSort));
        yolo.sort(toSort);
        System.out.println("After sorting: " + Arrays.toString(toSort));
        System.out.println();
    }
}
