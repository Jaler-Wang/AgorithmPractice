package structs;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    Graph graph = null;

    @Before
    public void init() {
        graph = new Graph(10);
        graph.addAdj(0, 1);
        graph.addAdj(0, 3);
        graph.addAdj(1, 2);
        graph.addAdj(1, 4);
        graph.addAdj(2, 5);
        graph.addAdj(3, 4);
        graph.addAdj(4, 5);
        graph.addAdj(4, 6);
        graph.addAdj(5, 7);
        graph.addAdj(6, 7);
    }

    @Test
    public void bfsTest(){
        graph.bfs(0, 6);
    }

    @Test
    public void dfsTest(){
        graph.dfs(0, 3);
    }
}
