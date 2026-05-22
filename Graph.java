import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private Map<Integer, Vertex> vertices;
    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }
    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to, int weight) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            adjList.get(from).add(new Edge(vertices.get(from), vertices.get(to), weight));
        }
    }

    public void dijkstra(int startId) {
        int n = vertices.size();
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer id : vertices.keySet()) {
            distances.put(id, Integer.MAX_VALUE);
        }
        distances.put(startId, 0);
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (Integer id : vertices.keySet()) {
                if (!visited.contains(id) && (u == -1 || distances.get(id) < distances.get(u))) {
                    u = id;
                }
            }
            if (distances.get(u) == Integer.MAX_VALUE) break;
            visited.add(u);
            for (Edge edge : adjList.get(u)) {
                int v = edge.getDestination().getId();
                int weight = edge.getWeight();
                if (distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }
        System.out.println("\nDijkstra Shortest Paths from vertex " + startId + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            String dist = entry.getValue() == Integer.MAX_VALUE ? "Infinity" : String.valueOf(entry.getValue());
            System.out.println("To " + entry.getKey() + ": " + dist);
        }
    }
    public void bfs(int start) {}
    public void dfs(int start) {}
}