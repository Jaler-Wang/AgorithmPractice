package structs.graph;

import java.util.LinkedList;
import java.util.Queue;


public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int e) {
        adj[s].add(e);
        adj[e].add(s);
    }

    public void bfs(int s, int t){
        if(s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        while (queue.size() != 0) {
            int current = queue.poll();
            for (int i = 0; i < adj[current].size(); i++) {
                int child = adj[current].get(i);
                if(!visited[child]){
                    prev[child] = current;
                    if(t == child){
                        print(prev, s, t);
                        return;
                    }
                    visited[child] = true;
                    queue.add(child);
                }

            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if(prev[t] != -1 && t != s){
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    private boolean found = false;
    public void dfs(int s, int t) {
        if(s == t) return;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        if(found) return;
        visited[s] = true;
        if(s==t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            int w = adj[s].get(i);
            if(!visited[w]){
                prev[w] = s;
                recurDfs(w, t, visited, prev);
            }
        }
    }
}
