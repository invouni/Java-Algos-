# Dijkstra's Algorithm in Java - Code Explanation and Dry Run

## Introduction

This Java program implements Dijkstra's algorithm to find the shortest path from a source vertex to all other vertices in a weighted graph. The program uses an adjacency list representation of the graph and a priority queue to efficiently determine the shortest path distances.

## Code Explanation

### Import Statements

```java
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;
```

These import statements bring in the necessary Java classes for working with lists, priority queues, and arrays.

### Shortest Distance Function

```java
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
```

#### Function Breakdown

- **Input Parameters:**
  - `adj`: Adjacency list representation of the graph.
  - `V`: Number of vertices.
  - `start`: Starting vertex for Dijkstra's algorithm.

- **Priority Queue Initialization:**
  - A priority queue `pq` is used to always process the vertex with the smallest known distance.

- **Distance Array Initialization:**
  - `dist`: An array to store the shortest distance from the `start` vertex to each vertex. Initially, all distances are set to `Integer.MAX_VALUE` except for the starting vertex which is set to 0.

- **Main Loop:**
  - While the priority queue is not empty, the vertex with the smallest distance is processed.
  - For each neighbor of the current vertex, calculate the potential new distance.
  - If the new distance is smaller than the known distance, update the distance and add the neighbor to the priority queue.

- **Return:**
  - The array `dist` which contains the shortest distances from the `start` vertex to all other vertices.

### Main Method

```java
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
```

#### Main Method Breakdown

- **Graph Initialization:**
  - `V`: Number of vertices.
  - `edges`: Array of edges where each edge is represented as `{source, destination, weight}`.

- **Adjacency List Construction:**
  - An array of lists `adj` is created to store the adjacency list of the graph.
  - Each edge is added to the adjacency list of both vertices (since the graph is undirected).

- **Shortest Distance Calculation:**
  - The `shortestDistance` function is called with the adjacency list, number of vertices, and the starting vertex `0`.
  - The result is printed as an array of shortest distances.

### Pair Class

```java
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
```

#### Pair Class Breakdown

- **Fields:**
  - `u`: Vertex number.
  - `w`: Weight (distance from the source vertex).

- **Constructor:**
  - Initializes the vertex number and weight.

- **Comparable Interface:**
  - Implements `compareTo` to allow the priority queue to order pairs by weight.

## Dry Run

Let's dry run the program with the given input graph and starting vertex `0`.

### Graph Representation

```
Vertices: 7
Edges:
(0)---4---(1)
 |         |
 1         4
 |         |
(5)---8---(6)
  |
 67
  |
(4)---2---(3)---5---(2)
```

### Initialization

- `dist` array: `[0, ∞, ∞, ∞, ∞, ∞, ∞]`
- Priority queue: `[(0, 0)]`

### Steps

1. **Pop (0, 0)**:
   - Process neighbors of vertex 0: `(1, 4)` and `(5, 1)`
   - Update `dist` array: `[0, 4, ∞, ∞, ∞, 1, ∞]`
   - Priority queue: `[(1, 4), (5, 1)]`

2. **Pop (5, 1)**:
   - Process neighbors of vertex 5: `(0, 1)`, `(6, 8)`, `(4, 67)`
   - Update `dist` array: `[0, 4, ∞, ∞, 68, 1, 9]`
   - Priority queue: `[(1, 4), (6, 9), (4, 68)]`

3. **Pop (1, 4)**:
   - Process neighbors of vertex 1: `(0, 4)`, `(2, 4)`
   - Update `dist` array: `[0, 4, 8, ∞, 68, 1, 9]`
   - Priority queue: `[(2, 8), (6, 9), (4, 68)]`

4. **Pop (2, 8)**:
   - Process neighbors of vertex 2: `(3, 5)`, `(1, 4)`
   - Update `dist` array: `[0, 4, 8, 13, 68, 1, 9]`
   - Priority queue: `[(6, 9), (4, 68), (3, 13)]`

5. **Pop (6, 9)**:
   - Process neighbors of vertex 6: `(5, 8)`
   - No update needed (already shorter path known)
   - Priority queue: `[(3, 13), (4, 68)]`

6. **Pop (3, 13)**:
   - Process neighbors of vertex 3: `(2, 5)`, `(4, 2)`
   - Update `dist` array: `[0, 4, 8, 13, 15, 1, 9]`
   - Priority queue: `[(4, 15), (4, 68)]`

7. **Pop (4, 15)**:
   - Process neighbors of vertex 4: `(3, 2)`, `(5, 67)`
   - No update needed (already shorter path known)
   - Priority queue: `[(4, 68)]`

8. **Pop (4, 68)**:
   - Skip as current distance is greater than known shortest distance
   - Priority queue: `[]`

### Final `dist` Array

```
[0, 4, 8, 13, 15, 1, 9]
```

This array represents the shortest distances from vertex `0` to all other vertices in the graph.

## Conclusion

The program correctly implements Dijkstra's algorithm to find the shortest paths from a given source vertex to all other vertices in a weighted graph. The provided dry run demonstrates the step-by-step execution of the algorithm on the given input graph.
