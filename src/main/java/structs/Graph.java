package structs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addAdj(int s, int j){
        adj[s].add(j);
        adj[j].add(s);
    }

    public void bfs(int start, int end){
        if(start == end) return;
        boolean[] visited = new boolean[v];
        visited[start] = true;
        int[] prev = new int[v];
        for(int i = 0; i < v; i++){
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i = 0; i < adj[current].size(); i++){
                int next = adj[current].get(i);
                if(visited[next] == true){
                    continue;
                }
                prev[next] = current;
                visited[next] = true;
                if(next == end){
                    print(prev, start, end);
                    return;
                }
                queue.offer(next);
            }
        }
    }
    public void dfs(int start, int end){
        if(start == end) return;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i = 0; i < v; i++){
            prev[i] = -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        visited[start] = true;
        stack.push(start);
        while(!stack.empty()){
            int current = stack.pop();
            for(int i = 0; i < adj[current].size(); i++){
                if(visited[adj[current].get(i)] == true){
                    continue;
                }
                visited[adj[current].get(i)] = true;
                prev[adj[current].get(i)] = current;

                if(adj[current].get(i) == end){
                    print(prev, start, end);
                    return;
                }
                stack.push(adj[current].get(i));
            }
        }
    }
    private void print(int[] prev, int start, int end) {
        int last = prev[end];
        if(last != -1 && end != start){
            print(prev, start, last);
        }
        System.out.print(" " + end);
    }
}
