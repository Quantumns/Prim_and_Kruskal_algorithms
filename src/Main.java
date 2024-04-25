public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 6, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(5, 6, 4);
        graph.addEdge(6, 7, 7);

        PrimMST mst = new PrimMST(8);
        mst.primMST(graph);
    }
}
