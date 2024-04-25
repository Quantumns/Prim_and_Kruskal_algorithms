import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<Edge>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adj[src].add(edge);
        // For undirected graph, add reverse edge too
        edge = new Edge(dest, src, weight);
        adj[dest].add(edge);
    }

    public List<Edge>[] getAdjacencyList() {
        return adj;
    }
}
