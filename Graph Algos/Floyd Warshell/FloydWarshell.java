import java.util.Arrays;


public class FloydWarshell {
	public static int[][] minDist(int n, int[][] edges) {
		int[][] dist = new int[n][n];
		for (int[] d : dist) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		for (int[]edge : edges) {
			dist[edge[0]][edge[1]] = edge[2];
			dist[edge[1]][edge[0]] = edge[2];
			dist[edge[0]][edge[0]] = 0;
			dist[edge[1]][edge[1]] = 0;
		}
		for (int k = 0; k < n; k ++) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					if (dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
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
	    int[][] dist = (minDist(V, edges));
	    for(int i = 0;i < V;i ++) {
	        for(int j = 0;j < V;j ++) {
	           System.out.print("{"+i+"->"+j+"="+dist[i][j]+"} ");
	         }
	         System.out.println();
	    }
	}
}
