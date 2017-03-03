import java.math.BigInteger;
import java.util.*;

/**
 * Created by jvillegas on 1/11/17.
 */
public class AlgorithmsMixed {

    public static void main(String[] args) throws Exception {
        String num = "" + (((long) Integer.MAX_VALUE) + 1);
        System.out.println("Parsing \"" + num + "\" : " + parseInt(num));
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
        for (int i = 0; i < clouds; i++)
            a[i] = in.nextInt();

        int jumps = 0;
        int j = 0;
        while (j < clouds - 2) {
            j += a[j + 2] == 0 ? 2 : 1;
            jumps += 1;
        }

        System.out.print(j == clouds - 1 ? jumps : jumps + 1);
    }

    private static void viralAdvertising() {
        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        int lastLiked = 2;
        int likeAggregate = 2;
        while (--days > 0) {
            lastLiked = (lastLiked * 3) / 2;
            likeAggregate += lastLiked;
        }
        System.out.print(likeAggregate);
    }

    private static void beatifulDayAtMovies() {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();

        int days = 0;
        while (i <= j) {
            if ((i - beautifulHelper(i)) % k == 0)
                days++;
            i++;
        }
        System.out.print(days);
    }

    private static int beautifulHelper(int in) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (in > 0) {
            arr.add(in % 10);
            in /= 10;
        }

        int rev = 0;
        int i = 1;
        while (!arr.isEmpty()) {
            rev += arr.remove(arr.size() - 1) * i;
            i *= 10;
        }

        return rev;
    }

    private static void minDistance() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int A_i = 0; A_i < n; A_i++) {
            a[A_i] = in.nextInt();
        }

        Integer ret = null;
        for (int i = 0; i < a.length - 1; i++) {
            int temp1 = a[i];
            int dist = 0;
            for (int j = i + 1; j < a.length; j++) {
                dist++;
                if (temp1 == a[j])
                    ret = ret == null ? dist : (ret < dist ? ret : dist);
            }
        }
        System.out.print(ret == null ? -1 : ret);
    }

    private static void kangaroo() {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        int v = v1 - v2;
        int x = x2 - x1;

        System.out.print(v == 0 || x % v != 0 || x / v < 0 ? "NO" : "YES");
    }

    private static void pdfViewer() {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for (int h_i = 0; h_i < n; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int largest = -1;
        for (int i = 0; i < word.length(); i++)
            largest = h[word.charAt(i) - 97] > largest ? h[word.charAt(i) - 97] : largest;
        System.out.print(word.length() * largest);
    }

    /*private static void sherlockAnagrams() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        while(count-- > 0) {
            String s = in.next();
            for(int i = 0; i < s.length() - 1; i++) {
                for(int j = )
            }
        }
    }*/

    private static void applesAndOranges() {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int appleCount = 0;
        for (int apple_i = 0; apple_i < m; apple_i++) {
            int applePos = in.nextInt() + a;
            if (applePos >= s && applePos <= t)
                appleCount++;
        }
        int orangeCount = 0;
        for (int orange_i = 0; orange_i < n; orange_i++) {
            int orangePos = in.nextInt() + b;
            if (orangePos >= s && orangePos <= t)
                orangeCount++;
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    private static void savePrisoner() {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            long n = in.nextInt();
            long m = in.nextInt();
            long s = in.nextInt();
            boolean opt = (s - 1 + m) % n == 0;
            System.out.println(opt ? n : (s - 1 + m) % n);
        }
    }

    private static void beautifulTriplets() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int beauty = in.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++)
            nums[i] = in.nextInt();

        int ret = 0;
        for (int i = 0; i < count - 2; i++)
            for (int j = i + 1; j < count - 1; j++) {
                if (nums[j] - nums[i] != beauty) continue;
                for (int k = j + 1; k < count; k++)
                    if (nums[k] - nums[j] == beauty)
                        ret++;
            }
        System.out.print(ret);
    }

    private static void manasaStones() {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            PriorityQueue<Integer> queue = manasaStonesHelper(n, a, b);
            while (!queue.isEmpty())
                System.out.print(queue.poll() + " ");
            System.out.println();
        }
    }

    private static PriorityQueue<Integer> manasaStonesHelper(int n, int a, int b) {
        PriorityQueue<Integer> ret = new PriorityQueue<>();
        n--;
        for (int i = 0; i <= n; i++) {
            int calc = (a * i) + (b * (n - i));
            if (!ret.contains(calc))
                ret.add(calc);
        }
        return ret;
    }

    private static void strangeCounter() {
        Scanner in = new Scanner(System.in);
        long t = Long.parseLong(in.next());
        long mult = 3;
        while (mult - 2 < t) {
            mult *= 2;
        }
        if (mult - 2 == t)
            System.out.print(mult);
        else {
            mult /= 2;
            System.out.print(mult - (t - (mult - 2)));
        }
    }

    private static void luckBalance() {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        int losable = in.nextInt();
        int ret = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (lines-- > 0) {
            int L = in.nextInt();
            if (in.nextInt() == 0)
                ret += L;
            else
                queue.add(L);
        }

        int win = 0;
        while (queue.size() > losable)
            win += queue.poll();
        while (!queue.isEmpty())
            ret += queue.poll();
        System.out.print(ret - win);
    }

    /*private static void abbreviation() { fml
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0) {
            String a = in.next();
            String b = in.next();

            int iter = 0;
            int matched = 0;
            boolean hitUpper = false;
            char lastMatched = '%';
            for(int i = 0; i < b.length(); i++) {
                char toFind = b.charAt(i);
                for(int j = iter; j < a.length(); j++, iter++) {
                    char c = a.charAt(j);

                    if(Character.isUpperCase(c) && c != toFind) {
                        if(hitUpper) {
                            i = b.length();
                            break;
                        } else {
                            hitUpper = true;
                            i = -1;
                            break;
                        }
                    }
                    if(Character.isUpperCase(c))
                        hitUpper = true;

                    if (Character.toUpperCase(c) == toFind) {
                        matched++;
                        iter++;
                        break;
                    }
                }
            }

            boolean noMoreUppers = true;
            for(int k = iter; k < a.length(); k++)
                if(Character.isUpperCase(a.charAt(k))) {
                    noMoreUppers = false;
                    break;
                }
            System.out.println(noMoreUppers && matched == b.length() ? "YES" : "NO");
        }
    }*/

    private static void utopianTree() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while (q-- > 0) {
            int cycles = in.nextInt();
            int height = 1;

            boolean spring = true;
            while (cycles-- > 0) {
                if (spring) {
                    height *= 2;
                    spring = false;
                } else {
                    height += 1;
                    spring = true;
                }
            }
            System.out.println(height);
        }
    }

    private static void classCancellation() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while (q-- > 0) {
            int students = in.nextInt();
            int thresh = in.nextInt();

            int onTime = 0;
            while (students-- > 0)
                onTime += in.nextInt() > 0 ? 0 : 1;
            System.out.println(onTime >= thresh ? "NO" : "YES");
        }
    }

    private static void factorial() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        BigInteger cur = BigInteger.valueOf((long) q);
        while (q-- > 1)
            cur = cur.multiply(BigInteger.valueOf((long) q));
        System.out.print(cur);
    }

    private static void insertionSortPart2() {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++)
            ar[i] = in.nextInt();

        for (int j = 1; j < ar.length; j++) {
            int iter = j;
            int k = iter - 1;
            while (k >= 0) {
                int jth = ar[iter];
                int kth = ar[k];
                if (kth > jth) {
                    ar[k] = jth;
                    ar[iter] = kth;
                    k--;
                    iter--;
                } else
                    break;
            }
            printArray(ar);
        }

    }

    private static void printArray(int[] ar) {
        for (int n : ar)
            System.out.print(n + " ");
        System.out.println("");
    }

    private static void hackerlandRadioTransmitters() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextInt();
        }
    }

    private static int parseInt(String string) throws Exception {
        int ret = 0;
        boolean isNeg = false;
        if (string.charAt(0) == '-')
            isNeg = true;
        for (int i = !isNeg ? 0 : 1; i < string.length(); i++) {
            double multer = Math.pow(10.0, (double) string.length() - i - 1);
            try {
                ret = !isNeg ? Math.addExact(ret, Math.multiplyExact((int) multer, (string.charAt(i) - '0')))
                        : Math.subtractExact(ret, Math.multiplyExact((int) multer, (string.charAt(i) - '0')));
            } catch (ArithmeticException e) {
                throw new Exception("Yo, that number is not in the integer range.");
            }
        }
        return ret;
    }

}
