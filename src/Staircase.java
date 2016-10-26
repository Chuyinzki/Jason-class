import java.util.StringTokenizer;

/**
 * Created by jvillegas on 10/25/16.
 */
public class Staircase {
    public static void printStaircase(String in) {
        if (in == null) return;
        int preSpace = 0;
        int tokenCount = 1;
        char lastCharacter = ' ';
        StringTokenizer tokenizer = new StringTokenizer(in);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (tokenCount % 2 != 0) {
                if(token.charAt(0) == lastCharacter) {
                    preSpace--;
                    for(int i = 1; i < token.length(); i++) {
                        System.out.print(token.charAt(i));
                        preSpace++;
                    }
                    preSpace++;
                    System.out.println();
                } else {
                    System.out.println();
                    for (int i = 0; i < preSpace; i++)
                        System.out.print(" ");
                    System.out.println(token);
                    preSpace += token.length();
                }
                lastCharacter = token.charAt(token.length() - 1);
            } else {
                boolean flag = false;
                if(token.charAt(0) == lastCharacter) {
                    preSpace--;
                    flag = true;
                }

                for(int i = 0; i < token.length(); i++) {
                    if(flag) {
                        flag = false;
                        continue;
                    }
                    for(int j = 0; j < preSpace; j++)
                        System.out.print(" ");
                    System.out.print(token.charAt(i));
                    if(i < token.length() - 1)
                        System.out.println();
                }
                preSpace++;
                lastCharacter = token.charAt(token.length() - 1);
            }
            tokenCount++;
        }
    }
}
