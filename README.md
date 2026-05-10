Project Overview
This project involves the implementation of a graph data structure and the application of two fundamental traversal algorithms: Breadth-First Search (BFS) and Depth-First Search (DFS). A graph consists of vertices, which represent individual nodes, and edges, which represent the connections between these nodes. In this system, the graph is represented using an adjacency list, which is an efficient way to store connections by maintaining a list of neighbors for each vertex.

Class Descriptions
The system is built using an object-oriented approach with the following classes:

Vertex: Represents a node in the graph with a unique identifier.

Edge: Manages the connection between a source vertex and a destination vertex.

Graph: The core class that stores the adjacency list and implements the logic for adding vertices, edges, and performing traversals.

Experiment: A utility class designed to automate testing, generate random graphs, and measure execution time.

Main: The entry point of the application that orchestrates the experimental flow.

Algorithm Descriptions
Breadth-First Search (BFS)
BFS starts at a selected node and explores all of its neighboring nodes at the present depth level before moving on to the nodes at the next depth level. It uses a queue data structure to track the nodes that need to be visited. This algorithm is particularly useful for finding the shortest path in unweighted graphs. The time complexity for BFS is O(V + E).

Depth-First Search (DFS)
DFS starts at a selected node and explores as far as possible along each branch before backtracking. It is implemented using recursion, which utilizes the call stack. DFS is commonly used for topological sorting and finding connected components. The time complexity for DFS is also O(V + E).

Experimental Results
To ensure the accuracy of the performance measurements, the system includes a warm-up phase. During this phase, several traversal cycles are executed to allow the Java Virtual Machine (JVM) and Just-In-Time (JIT) compiler to optimize the code. Without this warm-up, the first test (small graph) often appears slower than larger graphs due to initial overhead.

Analysis and Observations
The experiments show that as the number of vertices and edges increases, the execution time generally follows the O(V + E) complexity. While both algorithms are efficient, DFS showed faster execution times in these specific tests. This is likely due to the lower overhead of recursive calls compared to the management of a Queue object in BFS. The structure of the graph significantly impacts the traversal order; BFS visits nodes in layers, while DFS follows a single path to its end before switching.

Reflection
Through this assignment, I gained a deeper understanding of how graph representations affect algorithm efficiency. Implementing both BFS and DFS highlighted the importance of choosing the right data structures for specific tasks. One of the primary challenges was obtaining consistent timing results, which was successfully resolved by implementing a warm-up routine to stabilize the JVM performance before recording final data.
![screenshots/1.png]()
