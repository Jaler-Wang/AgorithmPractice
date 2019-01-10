package graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int v; //vertex number
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public void topoSortByKahn() {
        //calculate all vetex's degree
        int[] inDegree = new int[v];
        for (int i = 0; i < inDegree.length; i++) {
            inDegree[i] = 0;
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int v = adj[i].get(j);
                inDegree[v]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            System.out.print(v + "->");
            for (int i = 0; i < adj[v].size(); i++) {
                inDegree[adj[v].get(i)]--;
                if (inDegree[adj[v].get(i)] == 0) {
                    queue.add(adj[v].get(i));
                }
            }
        }
    }

    public void topoSortByDFS() {
        LinkedList<Integer>[] inverse = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverse[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inverse[adj[i].get(j)].add(i);
            }
        }

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, visited, inverse);
            }
        }
    }

    public void topoSortByBFS(){
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            inverseAdj[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < v; i++){
            for(int j = 0; j < adj[i].size(); j++){
                int index = adj[i].get(j);
                inverseAdj[index].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < v; i++){
            if(visited[i] == false){
                visited[i] = true;
                stack.push(i);
                bfs(visited, inverseAdj, stack);
            }
        }
    }

    private void bfs(boolean[] visited, LinkedList<Integer>[] inverseAdj, Stack<Integer> stack) {
        while (!stack.empty()) {
            int v = stack.pop();
            for(int i = 0; i < inverseAdj[v].size(); i++){
                int child = inverseAdj[v].get(i);
                if(visited[child] == true) continue;
                visited[child] = true;
                stack.push(child);
            }

            System.out.print("->" + v);
        }
    }

    private void dfs(int v, boolean[] visited, LinkedList<Integer>[] inverse) {
        for (int j = 0; j < inverse[v].size(); j++) {
            int next = inverse[v].get(j);
            if (visited[next] == false) {
                visited[next] = true;
                dfs(next, visited, inverse);
            }
        }
        System.out.print(v + "->");
    }


}

