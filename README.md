<img width="454" height="293" alt="Screenshot 2026-05-18 at 8 21 25 AM" src="https://github.com/user-attachments/assets/2279673f-5c98-44b8-ae7c-210d32e50d0d" /># Assignment 4: Graph Traversal and Representation System

> **Course**: Algorithm Design and Structures (ADS)  
> **Author**: Amir Saulebekov  
> **Topic**: Graph Representation using Adjacency List + BFS & DFS Traversal

---

## Project Overview

This project implements a **graph traversal and representation system** in Java.  
A graph is a data structure made of **vertices** (nodes) connected by **edges** (links).

Graphs are used to model:
- Social networks (people = vertices, friendships = edges)
- Road maps (cities = vertices, roads = edges)
- Network routing, scheduling, recommendation systems

### BFS (Breadth-First Search)
Explores all neighbors at the current depth level **before** moving deeper.  
Uses a **Queue (FIFO)** to track the next vertex to visit.

### DFS (Depth-First Search)
Explores as **deep as possible** along one branch before backtracking.  
Uses **recursion** (implicit call stack / LIFO) to track the path.

---

## How to Run

```bash
# Compile all files from src/ directory
javac src/*.java -d out/

# Run
java -cp out/ Main
```

---

## Project Structure

```
assignment4-graphs/
├── src/
│   ├── Vertex.java       ← Represents a graph node
│   ├── Edge.java         ← Represents a connection between two vertices
│   ├── Graph.java        ← Adjacency list + BFS + DFS
│   ├── Experiment.java   ← Performance testing and results
│   └── Main.java         ← Entry point, creates 3 graph sizes
├── docs/
│   └── screenshots/      ← Program output screenshots
└── README.md
```

---

## Class Descriptions

### `Vertex`
Represents a single node in the graph.

| Field | Type | Description |
|-------|------|-------------|
| `id`  | `int` | Unique identifier for the vertex |

Methods: `Vertex(int id)`, `getId()`, `toString()` → returns `"V{id}"`

---

### `Edge`
Represents a directed connection between two vertices.

| Field | Type | Description |
|-------|------|-------------|
| `source` | `Vertex` | The starting vertex |
| `destination` | `Vertex` | The ending vertex |

Methods: `Edge(Vertex, Vertex)`, `getSource()`, `getDestination()`, `toString()` → `"V1 -> V2"`

---

### `Graph`
Core class implementing the graph using an **adjacency list**.

**Adjacency List** stores each vertex as a key, and its neighbors as a list:
```
V0 -> [V1, V2]
V1 -> [V3, V4]
V2 -> [V5, V6]
```
This is memory-efficient — only existing edges are stored, unlike an adjacency matrix which always uses O(V²) space.

| Method | Description |
|--------|-------------|
| `addVertex(Vertex v)` | Adds a vertex to the graph |
| `addEdge(int from, int to)` | Adds a directed edge |
| `printGraph()` | Prints the full adjacency list |
| `bfs(int start)` | Runs BFS from given start vertex |
| `dfs(int start)` | Runs DFS from given start vertex |
| `getVertexCount()` | Returns total number of vertices |
| `getEdgeCount()` | Returns total number of edges |

---

### `Experiment`
Handles execution and performance analysis.

| Method | Description |
|--------|-------------|
| `runTraversals(Graph g, String size)` | Runs BFS + DFS on a graph, measures time with `System.nanoTime()` |
| `runMultipleTests()` | Orchestrates testing across all graph sizes |
| `printResults()` | Prints formatted comparison table of all results |

---

### `Main`
Entry point. Creates three graphs and runs experiments:

| Graph | Vertices | Approximate Edges |
|-------|----------|-------------------|
| Small | 10 | 12 |
| Medium | 30 | ~50 |
| Large | 100 | ~160 |

---

## Algorithm Descriptions

### BFS — Breadth-First Search

**Step-by-step:**
1. Enqueue the start vertex; mark it visited
2. While queue is not empty:
   - Dequeue the front vertex
   - Add it to traversal order
   - Enqueue all unvisited neighbors and mark them visited

**Time Complexity:** `O(V + E)` — visits every vertex and every edge once  
**Space Complexity:** `O(V)` — for the visited set and queue

**Use cases:**
- Finding the **shortest path** in an unweighted graph
- Level-order traversal (e.g., social network "degrees of separation")
- Web crawlers (explore pages level by level)

---

### DFS — Depth-First Search

**Step-by-step:**
1. Mark start vertex as visited; add to traversal order
2. For each unvisited neighbor, recursively call DFS
3. Backtrack when no unvisited neighbors remain

**Time Complexity:** `O(V + E)` — visits every vertex and every edge once  
**Space Complexity:** `O(V)` — for the visited set and call stack

**Use cases:**
- Detecting **cycles** in a graph
- **Topological sorting** (task scheduling)
- Solving mazes and puzzle games
- Finding connected components

---

## Experimental Results

### Execution Time Comparison

| Graph Size | Vertices | Edges | BFS Time (ns) | DFS Time (ns) |
|------------|----------|-------|---------------|---------------|
| Small      | 10       | 12    | in docs screenshots | in docs screenshots |
| Medium     | 30       | ~50   | in docs screenshots | in docs screenshots |
| Large      | 100      | ~160  | in docs screenshots | in docs screenshots |


### Observations

- Both BFS and DFS have **O(V + E)** time complexity, confirmed by results
- Execution times grow proportionally as graph size increases
- DFS tends to be slightly faster in practice due to less overhead (no queue operations)
- BFS uses more memory at peak because it stores all neighbors at a given level
- Graph structure (dense vs. sparse) affects traversal order significantly

---

## Analysis Questions

**1. How does graph size affect BFS and DFS performance?**  
Performance scales linearly with V + E. Doubling vertices roughly doubles execution time, confirming O(V + E).

**2. Which traversal is faster in experiments?**  
DFS is slightly faster in most cases because recursion has lower overhead than queue management in BFS.

**3. Do results match O(V + E)?**  
Yes. The jump from 10 → 30 → 100 vertices shows a near-linear increase in execution time, consistent with O(V + E).

**4. How does graph structure affect traversal order?**  
BFS always visits closer vertices first (by hop count). DFS follows one path to its end before backtracking, so order depends on adjacency list ordering.

**5. When is BFS preferred over DFS?**  
BFS is preferred when finding the **shortest path** or when the answer is likely near the source vertex. It guarantees minimum hops to reach any node.

**6. What are the limitations of DFS?**  
DFS can get "trapped" going deep into a long path while a short path to the goal exists nearby. It may also cause **stack overflow** on very large graphs due to deep recursion.

---

## Screenshots

### Graph Structure Output
in docs screenshots

### BFS Traversal Output
in docs screenshots

### DFS Traversal Output
in docs screenshots

### Performance Results Table
in docs screenshots

---

## Reflection

Implementing BFS and DFS from scratch gave a clear understanding of how the **choice of data structure drives algorithm behavior**. BFS uses a Queue, which naturally enforces level-by-level exploration — the first element added is the first explored. DFS relies on the call stack via recursion, which naturally explores one path to completion before unwinding. The key insight is that both algorithms visit the same vertices and edges; the only difference is the *order* in which they do so.

The most challenging part was building a correct adjacency list representation and ensuring that the visited tracking worked properly to avoid infinite loops in cyclic graphs. Testing on three different graph sizes (10, 30, 100 vertices) made the O(V + E) complexity concrete — watching execution times scale linearly with graph size confirmed what the theory predicts. Understanding when to prefer BFS (shortest path) versus DFS (cycle detection, topological sort) is a practical skill that applies directly to real-world system design.
