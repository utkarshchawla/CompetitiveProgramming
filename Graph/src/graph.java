import java.util.*;

public class graph {
    public static class IntegerPair implements Comparable<IntegerPair> {
        int idx;
        int weight;

        @Override
        public int compareTo(IntegerPair ip) {
            return this.weight - ip.weight;
        }

        IntegerPair(int nbr, int weight) {
            this.idx = nbr;
            this.weight = weight;
        }
    }

    private static ArrayList<IntegerPair>[] g;
    private static int visited[];
    private static int distance[];
    private static int parent[];

    public static void main(String[] args) {
//        g = new ArrayList[]
        Deque<Integer> d = new ArrayDeque<>();

    }

    private static void dfs(int idx) {
        visited[idx] = 1;
        for (IntegerPair i : g[idx]) {
            if (visited[i.idx] == 0) dfs(i.idx);
        }
    }

    public static void bfs(int i, int n) {
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        distance[i] = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (IntegerPair ip : g[idx]) {
                if (distance[ip.idx] == Integer.MAX_VALUE) {
                    distance[ip.idx] = distance[idx] + 1;
                    q.add(ip.idx);
                }
            }
        }
    }

    private static boolean isCyclic(int i) {
        visited[i] = 1;
        for (IntegerPair ip : g[i]) {
            if (visited[ip.idx] == 0) {
//                tree edge
                parent[ip.idx] = i;
                if (isCyclic(ip.idx)) return true;
            } else if (visited[ip.idx] == 1) {
//                back edge
                if (parent[i] != ip.idx) return true;
            } else if (visited[i] == 2) {
//                cross edge
                System.out.println("cross edge");
            }
        }
        visited[i] = 2;
        return false;
    }

    private static void dijkstra(int s, int n) {
        distance = new int[n];
        Arrays.fill(distance, 100000000);
        distance[s] = 0;
        PriorityQueue<IntegerPair> pq = new PriorityQueue<>();
        pq.add(new IntegerPair(s, 0));
        while (!pq.isEmpty()) {
            IntegerPair rp = pq.poll();
            int d = rp.weight;
            int u = rp.idx;
            if (d > distance[u]) continue;
            for (IntegerPair i : g[u]) {
                if (d + i.weight < distance[i.idx]) {
                    distance[i.idx] = d + i.weight;
                    pq.add(new IntegerPair(i.idx, distance[i.idx]));
                }
            }
        }
    }
}
