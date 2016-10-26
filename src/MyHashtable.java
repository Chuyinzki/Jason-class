import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jvillegas on 10/18/16.
 */
public class MyHashtable<K extends Comparable<K> , V> {
    private ArrayList<LinkedList<NodeObject>> array;
    public static int maxArraySize = 100;

    public MyHashtable() {
        array = new ArrayList<LinkedList<NodeObject>>(maxArraySize);
        for(int i = 0; i < maxArraySize; i++)
            array.add(i, new LinkedList<>());
    }

    public static int getHash(Object object) {
        /*ByteArrayOutputStream bos = new ByteArrayOutputStream();
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
        }*/
        int num = object.hashCode();
        return Math.abs(num % maxArraySize);
    }

    public V put(K key, V val) {
        if(key == null || val == null)
            throw new NullPointerException("Neither key nor value can be null");
        int hash = getHash(key);
        V retVal = null;
        NodeObject toInsert = new NodeObject(key, val);
        LinkedList<NodeObject> ll = array.get(hash);
        Iterator<NodeObject> iter = ll.descendingIterator();
        while(iter.hasNext()){
            NodeObject cur = iter.next();
            if(cur.equals(toInsert)){
                retVal = cur.getValue();
                iter.remove();
                break;
            }
        }
        ll.add(toInsert);
        return retVal;
    }

    public V get(K key) {
        int hash = getHash(key);
        V retVal = null;
        LinkedList<NodeObject> ll = array.get(hash);
        Iterator<NodeObject> iter = ll.descendingIterator();
        while(iter.hasNext()){
            NodeObject cur = iter.next();
            if(cur.getKey().equals(key)){
                retVal = cur.getValue();
                break;
            }
        }
        return retVal;
    }

    public V remove(K key) {
        int hash = getHash(key);
        V retVal = null;
        LinkedList<NodeObject> ll = array.get(hash);
        Iterator<NodeObject> iter = ll.descendingIterator();
        while(iter.hasNext()){
            NodeObject cur = iter.next();
            if(cur.getKey().equals(key)){
                retVal = cur.getValue();
                iter.remove();
                break;
            }
        }
        return retVal;
    }

    public void printTable(){
        int[] sizes = new int[maxArraySize];
        for(int i = 0; i < maxArraySize; i++){
            System.out.println(String.format("-------Printing array node: %d --------", i));
            LinkedList<NodeObject> ll = array.get(i);
            Iterator<NodeObject> iter = ll.descendingIterator();
            while(iter.hasNext()){
                NodeObject cur = iter.next();
                System.out.println("Key: " + cur.getKey() + " Value: "+ cur.getValue());
                sizes[i] = ++sizes[i];
            }
        }
        System.out.println(String.format("-------Printing array index counts --------"));
        for(int i = 0; i < sizes.length; i++)
            System.out.println(String.format("%d : %d", i, sizes[i]));
    }

    private class NodeObject {
        final K key;
        final V value;
        NodeObject(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        public K getKey(){
            return key;
        }

        public boolean equals(NodeObject o){
            return key.equals(o.getKey());
        }
    }
}
