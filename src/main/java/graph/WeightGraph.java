package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;


public class WeightGraph {
    private int v;
    private LinkedList<Edge>[] adj;
    public WeightGraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }

    public void addEdge(int from, int to, int weight){
        Edge edge = new Edge(from, to, weight);
        adj[from].add(edge);

    }

    private class Vertex implements Comparable<Vertex>{
        private int id;
        private int dist;
        public Vertex(int dest, int weight){
            this.id = dest;
            this.dist = weight;
        }
        public int compareTo(Vertex vertex) {
            if(this.dist < vertex.dist){
                return -1;
            }
            return 1;
        }
    }

    public void dijkstra(int from, int to){
        int[] predecessor = new int[v];
        Vertex[] dist = new Vertex[v];
        boolean[] visited = new boolean[v];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
            dist[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.add(dist[from]);
        dist[from].dist = 0;
        visited[from] = true;
        while(!queue.isEmpty()){
            Vertex node = queue.poll();
            if(node.id == to) break;

            for(int i = 0; i < adj[node.id].size(); i++){
                Edge edge = adj[node.id].get(i);
                int length = dist[node.id].dist + edge.weight;
                if(dist[edge.to].dist > length){
                    dist[edge.to].dist = length;
                    predecessor[edge.to] = node.id;
                    if(visited[edge.to] == false){
                        visited[edge.to] = true;
                        queue.add(dist[edge.to]);
                    }
                }
            }
        }
        System.out.print(from);
        printPath(from, to, predecessor);
    }

    private void printPath(int from, int to, int[] predecessor) {
        if(from == to) return;
        printPath(from, predecessor[to], predecessor);
        System.out.print(" -> " + to);
    }

    private class Edge{
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
