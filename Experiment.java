import java.util.Random;

public class Experiment {
    // Метод для "прогрева" JVM (JIT-компилятора)
    public void warmup() {
        Graph warmupGraph = createRandomGraph(50, 200);
        for (int i = 0; i < 100; i++) {
            warmupGraph.bfs(0);
            warmupGraph.dfs(0);
        }
    }

    public void runTraversals(Graph g, int size) {
        System.out.println("\nTesting graph size: " + size);

        // Замер BFS
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();

        // Замер DFS
        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();

        System.out.println("BFS Time: " + (endBfs - startBfs) + " ns");
        System.out.println("DFS Time: " + (endDfs - startDfs) + " ns");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            // Увеличиваем количество ребер до size * 5 для лучшей связности
            Graph g = createRandomGraph(size, size * 5);
            runTraversals(g, size);
        }
    }

    private Graph createRandomGraph(int size, int edgeCount) {
        Graph g = new Graph();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i)); // [cite: 38]
        }

        for (int i = 0; i < edgeCount; i++) {
            int from = r.nextInt(size);
            int to = r.nextInt(size);
            if (from != to) {
                g.addEdge(from, to); // [cite: 39, 63]
            }
        }
        return g;
    }
}