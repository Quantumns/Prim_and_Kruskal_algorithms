import java.util.List;

public class PrimMST {
    private final int V;

    public PrimMST(int V) {
        this.V = V;
    }

    public int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    public void printMST(int[] parent, List<Edge>[] adj) {
        System.out.println("Edge \tWeight");
        for (int i = 0; i < V; i++) {
            if (parent[i] != -1 && parent[i] < adj.length && !adj[parent[i]].isEmpty()) {
                Edge edge;
                edge = adj[i].get(parent[i]);
                System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
            }
        }
    }

    public void primMST(Graph graph) {
        List<Edge>[] adj = graph.getAdjacencyList();

        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (Edge e : adj[u]) {
                int v = e.dest;
                if (!mstSet[v] && e.weight < key[v]) {
                    parent[v] = u;
                    key[v] = e.weight;
                }
            }
        }

        printMST(parent, adj);
    }
}
