import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;

public class Dijkstra {
    private static int[] shortestDistance(List<int[]>[] adj, int V, int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currentDist = p.w;
            int u = p.u;
            if (currentDist > dist[u]) continue;  // Skip if we have found a better path already
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                int newDist = currentDist + weight;
                
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new Pair(v, newDist));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = new int[][] {
            {0, 1, 4}, {2, 3, 5}, {0, 5, 1}, {5, 6, 8}, {2, 1, 4}, {3, 4, 2}, {4, 5, 67}
        };
        
        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        System.out.println(Arrays.toString(shortestDistance(adj, V, 0)));
    }
    
    static class Pair implements Comparable<Pair> {
        int u;
        int w;
        
        Pair(int u, int w) {
            this.u = u;
            this.w = w;
        }
        
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.w, p.w);
        }
    }
  }
