// BFS algorithm in Java

import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS algorithm
    void BFS(int s) {

        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new ArrayDeque();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int value = queue.poll();

            for(int i = 0; i < adj[s].size(); ++i) {
                if (!visited[s]) {
                    queue.add(s);
                    visited[s] = true;
                }
            }

        }


    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2);
    }
}