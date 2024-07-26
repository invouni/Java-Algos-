# Floyd-Warshall Algorithm in Java

This code implements the Floyd-Warshall algorithm to find the shortest paths between all pairs of vertices in a given weighted graph. Below is a detailed explanation of the code, block by block.

## 1. Class Declaration

```java
public class FloydWarshell {
```
This declares a public class named `FloydWarshell`. 

## 2. Method to Calculate Minimum Distances

```java
public static int[][] minDist(int n, int[][] edges) {
    int[][] dist = new int[n][n];
```
The `minDist` method is declared as `public static`, meaning it can be called without creating an instance of the class. It takes two parameters: `n`, the number of vertices, and `edges`, a 2D array representing the edges and their weights. The method returns a 2D array `dist` containing the shortest distances between all pairs of vertices.

## 3. Initialize Distance Matrix

```java
for (int[] d : dist) {
    Arrays.fill(d, Integer.MAX_VALUE);
}
```
This loop initializes the distance matrix `dist` by filling it with `Integer.MAX_VALUE`, representing infinity. This means initially, all distances are set to a very large value.

## 4. Populate Distance Matrix with Edge Weights

```java
for (int[] edge : edges) {
    dist[edge[0]][edge[1]] = edge[2];
    dist[edge[1]][edge[0]] = edge[2];
    dist[edge[0]][edge[0]] = 0;
    dist[edge[1]][edge[1]] = 0;
}
```
This loop populates the distance matrix `dist` with the given edge weights. For each edge, it sets the distance from the start vertex to the end vertex and vice versa. It also sets the distance from each vertex to itself as 0.

## 5. Floyd-Warshall Algorithm

```java
for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE) {
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
}
```
These nested loops implement the Floyd-Warshall algorithm. The algorithm iteratively updates the distance matrix `dist` by checking if a shorter path exists through an intermediate vertex `k`. If so, it updates the distance between vertices `i` and `j`.

## 6. Return the Distance Matrix

```java
return dist;
```
The method returns the updated distance matrix `dist`, which now contains the shortest distances between all pairs of vertices.

## 7. Main Method to Test the Algorithm

```java
public static void main(String[] args) {
    int V = 7;
    int[][] edges = new int[][] {
        {0, 1, 4}, {2, 3, 5}, {0, 5, 1}, {5, 6, 8}, {2, 1, 4}, {3, 4, 2}, {4, 5, 67}
    };
    int[][] dist = minDist(V, edges);
```
The `main` method initializes a graph with 7 vertices and a set of edges with their weights. It then calls the `minDist` method to calculate the shortest paths and stores the result in `dist`.

## 8. Print the Distance Matrix

```java
    for(int i = 0; i < V; i++) {
        for(int j = 0; j < V; j++) {
           System.out.print("{" + i + "->" + j + "=" + dist[i][j] + "} ");
         }
         System.out.println();
    }
}
```
This nested loop prints the distance matrix `dist` in a readable format, showing the shortest distances between all pairs of vertices.

## Summary

This Java program demonstrates the Floyd-Warshall algorithm to find the shortest paths between all pairs of vertices in a graph. It initializes a distance matrix, populates it with edge weights, applies the algorithm to update the distances, and finally prints the result.
