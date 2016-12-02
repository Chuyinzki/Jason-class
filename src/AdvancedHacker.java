import java.util.Scanner;

/**
 * Created by jvillegas on 12/1/16.
 */
public class AdvancedHacker {

    public static void main(String[] args) {
        advanced1();
    }

    public static void advanced1() {
        Scanner in = new Scanner(System.in);
        int scraperCount = in.nextInt();
        int[] scrapers = new int[scraperCount];

        for(int i = 0; i < scraperCount; i++)
            scrapers[i] = in.nextInt();

        int totalPaths = 0;
        for(int i = 0; i < scrapers.length - 1; i++) {
            int iScraper = scrapers[i];
            for(int j = i + 1; j < scrapers.length; j++){
                int jScraper = scrapers[j];
                if(iScraper == jScraper)
                    totalPaths++;
                else if (iScraper < jScraper)
                    break;
            }
        }
        System.out.print(totalPaths * 2);
    }

}
