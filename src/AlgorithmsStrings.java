import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jvillegas on 1/11/17.
 */
public class AlgorithmsStrings {

    public static void main(String[] args) {
        clouds();
    }

    public static void camelCase() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 0;
        if (s.length() == 0) {
            System.out.print(count);
            return;
        }
        for (int i = 0; i < s.length(); i++)
            if (Character.isUpperCase(s.charAt(i)))
                count++;
        System.out.print(++count);
    }

    public static void minMax() {
        Scanner in = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long total = 0;
        for (int i = 0; i < 5; i++) {
            int num = in.nextInt();
            total += num;
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        System.out.print((total - max) + " " + (total - min));
    }

    public static void socks() {
        Scanner in = new Scanner(System.in);
        int socks = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        while (socks-- > 0) {
            int sock = in.nextInt();
            if (map.containsKey(sock)) {
                map.remove(sock);
                pairs++;
            } else
                map.put(sock, sock);
        }
        System.out.print(pairs);
    }

    public static void evenlyDivisible() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int finalCount = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int left = a[i];
            for (int j = i + 1; j < a.length; j++) {
                int right = a[j];
                if ((right + left) % k == 0)
                    finalCount++;
            }
        }
        System.out.print(finalCount);
    }

    private static void mars() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int mutated = 0;
        int i = 0;
        for (int j = 0; j < s.length() / 3; j++) {
            if (s.charAt(i++) != 'S')
                mutated++;
            if (s.charAt(i++) != 'O')
                mutated++;
            if (s.charAt(i++) != 'S')
                mutated++;
        }
        System.out.print(mutated);
    }

    private static void equalize() {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int c2 = c;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (c2-- > 0) {
            int i = in.nextInt();
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        int largest = 0;
        for (Integer boi : map.values())
            largest = largest < boi ? boi : largest;
        System.out.print(c - largest);
    }

    private static void howManyA() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long c = in.nextLong();
        long count = 0;
        long fullS = c / s.length();

        //count semis
        int i = 0;
        int semis = 0;
        for (i = 0; i < c % s.length(); i++)
            if (s.charAt(i) == 'a')
                semis++;

        count += semis;

        //add repeated
        if (fullS > 0) {
            for (i = i; i < s.length(); i++)
                if (s.charAt(i) == 'a')
                    semis++;
            count += semis * fullS;
        }
        System.out.print(count);
    }

    private static void friendsShouldSplitEvenly() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int totalSharedBill = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i != k)
                totalSharedBill += num;
        }

        int charged = in.nextInt();
        int split = totalSharedBill / 2;
        System.out.print(split == charged ? "Bon Appetit" : charged - split);
    }

    private static void clouds() {
        Scanner in = new Scanner(System.in);
        int clouds = in.nextInt();
        int[] a = new int[clouds];
        for(int i = 0; i < clouds; i++)
            a[i] = in.nextInt();

        int jumps = 0;
        int j = 0;
        while(j < clouds - 2) {
            j += a[j + 2] == 0 ? 2 : 1;
            jumps += 1;
        }

        System.out.print(j == clouds - 1 ? jumps : jumps + 1);
    }

}
