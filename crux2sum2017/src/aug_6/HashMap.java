package aug_6;

import java.util.ArrayList;

import june_23.arraylist;

public class HashMap<K, V> {

    public class HMNode {
        K key;
        V value;
    }

    private int size = 0;
    private linkedList<HMNode>[] buckets;

    public HashMap() {
        buckets = new linkedList[5];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new linkedList<>();
        }
        this.size = 0;
    }

    public void put(K key, V value) throws Exception {
        int bi = hashFunction(key);
        linkedList<HMNode> a = buckets[bi];
        int nodefound = findInBucket(a, key);
        if (nodefound == -1) {
            HMNode nodeadd = new HMNode();
            nodeadd.key = key;
            nodeadd.value = value;
            this.size++;
            a.addLast(nodeadd);
        } else {
            HMNode nodeup = a.getAt(bi);
            nodeup.value = value;
        }

        double lambda = (this.size * 1.0) / this.buckets.length;
        if (lambda > 2.0) {
            rehash();
        }

    }

    private int hashFunction(K key) {
        int hc = key.hashCode();

        int a = Math.abs(hc);
        return a % buckets.length;

    }

    private int findInBucket(linkedList<HMNode> bucket, K key) throws Exception {
        for (int i = 0; i < bucket.size; i++) {

            HMNode n = bucket.getAt(i);
            if (n.key.equals(key)) {
                return i;
            }

        }

        return -1;
    }

    public boolean containsKey(K key) throws Exception {
        int bi = hashFunction(key);
        linkedList<HMNode> a = buckets[bi];
        int nodefound = findInBucket(a, key);

        if (nodefound == -1) {
            return false;
        } else {
            return true;
        }
    }

    public V get(K key) throws Exception {
        int bi = hashFunction(key);
        linkedList<HMNode> a = buckets[bi];
        int nodefound = findInBucket(a, key);

        if (nodefound == -1) {
            return null;
        } else {
            HMNode nodetr = a.getAt(nodefound);
            return nodetr.value;
        }
    }

    public V removeAt(K key) throws Exception {
        int bi = hashFunction(key);
        linkedList<HMNode> a = buckets[bi];
        int nodefound = findInBucket(a, key);

        if (nodefound == -1) {
            return null;
        } else {
            HMNode nodetr = a.removeAt(nodefound);
            this.size--;
            return nodetr.value;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void display() throws Exception {
        System.out.println("-------------------------------------------------------------------------------");
        String s = "";
        for (int i = 0; i < buckets.length; i++) {
            s += "bucket" + i + " => ";
            for (int j = 0; j < buckets[i].size; j++) {
                HMNode n = buckets[i].getAt(j);
                s += "{ " + n.key + "_" + n.value + " },";
            }

        }
        System.out.println(s + ".");
        System.out.println("-------------------------------------------------------------------------------");

    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size; j++) {
                HMNode n = buckets[i].getAt(j);
                keys.add(n.key);
            }
        }

        return keys;
    }

    private void rehash() throws Exception {
        linkedList<HMNode>[] obs = this.buckets;
        this.buckets = new linkedList[obs.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new linkedList<>();
        }
        this.size = 0;

        for (int i = 0; i < obs.length; i++) {
            for (int j = 0; j < obs[i].size; j++) {
                HMNode n = obs[i].getAt(j);
                this.put(n.key, n.value);
            }
        }

    }

}
