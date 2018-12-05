package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        return getPaths(graph, 0);
    }

    private List<List<Integer>> getPaths(int[][] graph, int startIndex) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(startIndex == graph.length - 1){
            List path = new ArrayList();
            path.add(startIndex);
            ans.add(path);
            return ans;
        }
        for(int node: graph[startIndex]){
            for(List<Integer> path: getPaths(graph, node)){
                path.add(0, startIndex);
                ans.add(path);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[][] graph = new int[][]{{1,2}, {3}, {3}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}
