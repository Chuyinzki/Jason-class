import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by jvillegas on 10/18/16.
 */
public class MyHashtable {
    private Object[] array;
    public static int maxArraySize = 100;

    public MyHashtable() {
        array = new Object[maxArraySize];
    }

    public static int getHash(Object object) throws IOException {
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
        } finally {
            try {
                bos.close();
                return Math.abs(num % maxArraySize);
            } catch (IOException ex) {
                System.out.println("shit, couldn't close");
                // ignore close exception
            }
        }
        return -696969;
    }
}
