/**
 * Created by jvillegas on 10/25/16.
 */
public class UniqueCharacterSpit {

    public static char[] printUniques(char[] arr) {
        MyHashtable<Character, Integer> yoink = new MyHashtable<>();

        for(char c : arr) {
            Integer woah = yoink.get(c);
            yoink.put(c, woah == null ? 1 : ++woah);
        }

        int size = 0;
        for(int i = 0; i < arr.length; i++) {
            if(yoink.get(arr[i]) != 1)
                arr[i] = ' ';
            else
                size++;
        }

        char[] ret = new char[size];
        int iter = 0;
        for(char c : arr)
            if(c != ' ')
                ret[iter++] = c;

        return ret;
    }
}
