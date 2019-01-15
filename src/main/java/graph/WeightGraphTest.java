package graph;

import org.junit.Test;

public class WeightGraphTest {

    @Test
    public void test(){
        WeightGraph weightGraph = new WeightGraph(4);
        weightGraph.addEdge(0, 1, 1);
        weightGraph.addEdge(0, 2, 4);
        weightGraph.addEdge(0, 3, 3);
        weightGraph.addEdge(1, 2, 2);
        weightGraph.addEdge(3, 2, 2);
        weightGraph.dijkstra(0, 2);
    }
}
