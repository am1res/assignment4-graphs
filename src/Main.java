public class Main {
    public static void main(String[] args) {
        System.out.println("\n\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        System.out.println("\u2551   ASSIGNMENT 4: GRAPH TRAVERSAL & REPRESENTATION SYSTEM  \u2551");
        System.out.println("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        Experiment experiment = new Experiment();
        experiment.runMultipleTests();

        // ─────────────────────────────────────────────────────────────────
        // SMALL GRAPH (10 vertices)
        // ─────────────────────────────────────────────────────────────────
        Graph smallGraph = createSmallGraph();
        smallGraph.printGraph();
        experiment.runTraversals(smallGraph, "SMALL (10V)");

        // ─────────────────────────────────────────────────────────────────
        // MEDIUM GRAPH (30 vertices)
        // ─────────────────────────────────────────────────────────────────
        Graph mediumGraph = createMediumGraph();
        System.out.println("[Medium graph: 30 vertices - structure hidden for brevity]");
        experiment.runTraversals(mediumGraph, "MEDIUM(30V)");

        // ─────────────────────────────────────────────────────────────────
        // LARGE GRAPH (100 vertices)
        // ─────────────────────────────────────────────────────────────────
        Graph largeGraph = createLargeGraph();
        System.out.println("[Large graph: 100 vertices - structure hidden for brevity]");
        experiment.runTraversals(largeGraph, "LARGE(100V)");

        // Print final comparison table
        experiment.printResults();
    }

    // Small Graph: 10 vertices, 12 directed edges
    private static Graph createSmallGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 10; i++) g.addVertex(new Vertex(i));

        // Tree-like structure with cross edges
        g.addEdge(0, 1); g.addEdge(0, 2);
        g.addEdge(1, 3); g.addEdge(1, 4);
        g.addEdge(2, 5); g.addEdge(2, 6);
        g.addEdge(3, 7); g.addEdge(4, 7);
        g.addEdge(5, 8); g.addEdge(6, 8);
        g.addEdge(7, 9); g.addEdge(8, 9);
        return g;
    }

    // Medium Graph: 30 vertices, chain + cross edges (~50 edges)
    private static Graph createMediumGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 30; i++) g.addVertex(new Vertex(i));

        // Chain
        for (int i = 0; i < 29; i++) g.addEdge(i, i + 1);

        // Cross edges for complexity
        for (int i = 0; i < 30; i += 3) {
            if (i + 5 < 30) g.addEdge(i, i + 5);
            if (i + 7 < 30) g.addEdge(i, i + 7);
        }
        return g;
    }

    // Large Graph: 100 vertices, chain + cross edges (~160 edges)
    private static Graph createLargeGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 100; i++) g.addVertex(new Vertex(i));

        // Chain
        for (int i = 0; i < 99; i++) g.addEdge(i, i + 1);

        // Cross edges every 5 vertices
        for (int i = 0; i < 100; i += 5) {
            if (i + 10 < 100) g.addEdge(i, i + 10);
            if (i + 15 < 100) g.addEdge(i, i + 15);
            if (i + 20 < 100) g.addEdge(i, i + 20);
        }
        return g;
    }
}
