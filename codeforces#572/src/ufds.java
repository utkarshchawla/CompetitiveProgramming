import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class ufds {
    int[] parent;
    int[] rank;
    int numsets;

    ufds(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        rank = new int[n];
    }

    public int findset(int c) {
        return (c == parent[c]) ? c : (parent[c] = findset(parent[c]));
    }

    public boolean issameset(int a, int b) {
        return findset(a) == findset(b);
    }

    public void merge(int a, int b) {
        if (issameset(a, b)) return;
        a = findset(a);
        b = findset(b);
        if (rank[a] < rank[b]) parent[a] = b;
        else {
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }

    public int numsets() {
        return numsets;
    }
}
