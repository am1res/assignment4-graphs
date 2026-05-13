import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("Warning: Vertex " + from + " or " + to + " does not exist");
            return;
        }
        adjacencyList.get(from).add(to);
    }

    public void printGraph() {
        System.out.println("\n\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        System.out.println("  GRAPH STRUCTURE (Adjacency List)");
        System.out.println("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print("V" + entry.getKey() + " -> ");
            List<Integer> neighbors = entry.getValue();
            if (neighbors.isEmpty()) {
                System.out.println("(no edges)");
            } else {
                for (int i = 0; i < neighbors.size(); i++) {
                    System.out.print("V" + neighbors.get(i));
                    if (i < neighbors.size() - 1) System.out.print(", ");
                }
                System.out.println();
            }
        }
        System.out.println("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\n");
    }

    // Breadth-First Search (BFS)
    // Uses a Queue (FIFO) - explores all neighbors at current depth before going deeper
    public void bfs(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex " + start + " does not exist");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> traversalOrder = new ArrayList<>();

        // Step 1: Enqueue start vertex and mark visited
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            // Step 2: Dequeue front vertex
            int current = queue.poll();
            traversalOrder.add(current);

            // Step 3: Enqueue all unvisited neighbors
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("BFS Traversal from V" + start + ":");
        for (int i = 0; i < traversalOrder.size(); i++) {
            System.out.print("V" + traversalOrder.get(i));
            if (i < traversalOrder.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\n");
    }

    // Depth-First Search (DFS)
    // Uses recursion (call stack / LIFO) - explores as deep as possible before backtracking
    public void dfs(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex " + start + " does not exist");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> traversalOrder = new ArrayList<>();

        System.out.println("DFS Traversal from V" + start + ":");
        dfsRecursive(start, visited, traversalOrder);

        for (int i = 0; i < traversalOrder.size(); i++) {
            System.out.print("V" + traversalOrder.get(i));
            if (i < traversalOrder.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\n");
    }

    // Recursive helper for DFS
    private void dfsRecursive(int current, Set<Integer> visited, List<Integer> order) {
        // Mark current as visited and record
        visited.add(current);
        order.add(current);

        // Recurse on every unvisited neighbor
        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, order);
            }
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count;
    }
}
