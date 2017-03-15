import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jvillegas on 12/1/16.
 */
public class AdvancedHacker {

    public static void main(String[] args) {

        Integer[] values = {7, 8, 3, 1, 4, 2, 1, 7, 8, 10, 9, 4, 2, 4, 7, 10};
        jasonChallenge(values);
    }

    public static void advanced1() {
        Scanner in = new Scanner(System.in);
        int scraperCount = in.nextInt();
        int[] scrapers = new int[scraperCount];

        for (int i = 0; i < scraperCount; i++)
            scrapers[i] = in.nextInt();

        int totalPaths = 0;
        for (int i = 0; i < scrapers.length - 1; i++) {
            int iScraper = scrapers[i];
            for (int j = i + 1; j < scrapers.length; j++) {
                int jScraper = scrapers[j];
                if (iScraper == jScraper)
                    totalPaths++;
                else if (iScraper < jScraper)
                    break;
            }
        }
        System.out.print(totalPaths * 2);
    }

    private static void jasonChallenge(Integer[] values) {
        LinkedList<NumInfo> nums = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            int curNum = values[i];
            NumInfo temp = new NumInfo(curNum, i);
            int index = nums.indexOf(temp);
            if (index == -1)
                nums.add(temp);
            else {
                NumInfo orig = nums.get(index);
                orig.occurrences.add(i);
            }
        }

        System.out.print("Printing original numbers: ");
        for (NumInfo info : nums)
            if (info.occurrences.size() == 1)
                System.out.print(info.num + " ");

        System.out.println();
        for (NumInfo info : nums) {
            if (info.occurrences.size() > 1) {
                System.out.print("Indices of \"" + info.num + "\" (" + info.occurrences.size() + " occurrences): ");
                for (int innerNum : info.occurrences)
                    System.out.print(innerNum + " ");
                System.out.println();
            } else
                System.out.println("\"" + info.num + "\" has only one occurrence");
        }


    }

    public static class NumInfo {
        int num;
        LinkedList<Integer> occurrences;

        NumInfo(int num, int index) {
            this.num = num;
            occurrences = new LinkedList<>();
            occurrences.add(index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NumInfo numInfo = (NumInfo) o;

            return num == numInfo.num;
        }
    }

}
