import java.math.BigInteger;
import java.security.SecureRandom;

public class main
{
    public static void main(String [] args) throws Exception {
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