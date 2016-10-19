import java.math.BigInteger;
import java.security.SecureRandom;

public class main
{
    public static void main(String [] args) {
        runOverrideTest(10000);
    }

    private static void simpleAdditionRemovalTest(){
        MyHashtable<String, Integer> woah = new MyHashtable<>();
        woah.put("shiet", 123);
        System.out.println(woah.get("shiet"));
        System.out.println(woah.remove("shiet"));
        System.out.println(woah.get("shiet"));
    }

    private static void runOverrideTest(int length){
        MyHashtable<Integer, Integer> woah = createIntTable(length);
        for(int i = 0; i < length; i++)
            System.out.println("old value: " + woah.put(i, length - i));
        for(int i = 0; i < length; i++)
            System.out.println(String.format("%d: %d", i, woah.get(i)));
    }

    private static MyHashtable<Integer, Integer> createIntTable(int length){
        MyHashtable<Integer, Integer> woah = new MyHashtable<>();
        for(int i = 0; i < length; i++)
            woah.put(i, i);
        return woah;
    }

    private static void runIntTest(int length){
        MyHashtable<Integer, Integer> woah = createIntTable(length);
        for(int i = 0; i < length; i++)
            System.out.println(String.format("%d: %d", i, woah.get(i)));
    }

    private static void runHashTest(){
        SecureRandom random = new SecureRandom();
        int[] results = new int[MyHashtable.maxArraySize];
        int cuantos = 100000;
        for(int i = 0; i < cuantos; i++){
            Long longo = System.currentTimeMillis();
            String yoluondo = new BigInteger(130, random).toString(32);
            //System.out.println(MyHashtable.getHash(longo));
            //System.out.println(MyHashtable.getHash(yoluondo));
            //int hash = MyHashtable.getHash(longo);
            int hash = MyHashtable.getHash(yoluondo);
            //System.out.println(hash);
            results[hash] = results[hash] + 1;
        }

        for(int i = 0; i < results.length; i++)
            System.out.println(String.format("%d : %d", i, results[i]));
    }

}