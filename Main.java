public class Main {
    public static void main(String[] args) {
         Experiment experiment = new Experiment();
        System.out.println("Warming up JVM...");
        experiment.warmup();
        System.out.println("Starting experiments...");
        experiment.runMultipleTests();
        
        Graph g = new Graph();
        g.addVertex(new Vertex(0));
        g.addVertex(new Vertex(1));
        g.addVertex(new Vertex(2));
        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 5);
        g.addEdge(0, 2, 20);
        g.dijkstra(0);
    }
}