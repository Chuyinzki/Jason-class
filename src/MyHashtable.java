import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by jvillegas on 10/18/16.
 */
public class MyHashtable<K,V> {
    private V[] array;
    public static int maxArraySize = 100;

    public MyHashtable() {
        array = (V[]) new Object[maxArraySize];
    }

    public static int getHash(Object object) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        int num = 69;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            for(byte yo : yourBytes) {
                num += ((int) yo);
                num ^= 3;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
            } catch (IOException ex) {
                System.out.println("shit, couldn't close");
                // ignore close exception
            }
        }
        return Math.abs(num % maxArraySize);
    }

    public V put(K key, V val) {
        int hash = getHash(key);
        V retVal = array[hash];
        array[hash] = val;
        return retVal;
    }

    public V get(K key) {
        return array[getHash(key)];
    }

    public V remove(K key) {
        int hash = getHash(key);
        V retVal = array[hash];
        array[hash] = null;
        return retVal;
    }
}
