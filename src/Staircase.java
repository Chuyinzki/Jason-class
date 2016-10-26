import java.util.StringTokenizer;

/**
 * Created by jvillegas on 10/25/16.
 */
public class Staircase {
    public static void printStaircase(String in) {
        if (in == null) return;
        int preSpace = 0;
        int tokenCount = 1;
        StringTokenizer tokenizer = new StringTokenizer(in);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (tokenCount % 2 != 0) {
                for(int i = 0; i < preSpace; i++)
                    System.out.print(" ");
                System.out.println(token);
                preSpace += token.length();
            } else {
                for(int i = 0; i < token.length(); i++) {
                    for(int j = 0; j < preSpace; j++)
                        System.out.print(" ");
                    System.out.println(token.charAt(i));
                }
                preSpace++;
            }
            tokenCount++;
        }
    }
}
