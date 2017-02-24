/**
 * Created by jvillegas on 2/16/17.
 */
public class CountSay {

    public static void main(String[] args) {
        doCount(15);
    }

    private static void doCount(int count) {
        String initial = "1";
        System.out.println(initial);
        for (int i = 0; i < count; i++) {
            int iter = 0;
            String temp = "";
            int charCount = 0;
            int charIter = 0;
            while (charIter < initial.length()) {
                int num = Integer.parseInt("" + initial.charAt(iter));
                charIter++;
                charCount++;
                while (charIter < initial.length()) {
                    if (num != Integer.parseInt("" + initial.charAt(charIter))) {
                        temp += ("" + charCount) + num;
                        num = Integer.parseInt("" + initial.charAt(charIter));
                        charCount = 1;
                    } else
                        charCount++;
                    charIter++;
                }
                temp += ("" + charCount) + num;
            }
            initial = temp;
            System.out.println(initial);
        }
    }
}
