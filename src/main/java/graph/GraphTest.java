package graph;

import graph.Graph;
import org.junit.Test;

public class GraphTest {
    @Test
    public void testTopoByKahn(){
        Graph graph = initGraph();
        graph.topoSortByDFS();
        System.out.println();
        graph.topoSortByKahn();
        System.out.println();
        graph.topoSortByBFS();
    }

    private Graph initGraph() {
        Graph graph = new Graph(4);
        graph.addEdge(1,0);
        graph.addEdge(2,1);
        graph.addEdge(1,3);
        return graph;
    }
}
