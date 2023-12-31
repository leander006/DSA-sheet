

import java.util.*;

class Prims {
    
              static class Edge{
                  int src;
                  int des;
                  int wt;

                  public Edge(int s ,int d,int wt){
                        this.src =s;
                        this.des =d;
                        this.wt=wt;
                  }

      }

    
      public static void createGraph(ArrayList<Edge> graph[]){

            for(int i=0;i<graph.length;i++){
                  graph[i] = new ArrayList<>();
            }

            // 0 vertex
            graph[0].add(new Edge(0,1,2));
            graph[0].add(new Edge(0,2,4));
            // graph[0].add(new Edge(0,3));
            // 1 vertex
            graph[1].add(new Edge(1,3,7));
            graph[1].add(new Edge(1,2,1));

            // 2 vertex
            // graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,4,3));

            // 3 vertex
            graph[3].add(new Edge(3,5,1));
            // graph[3].add(new Edge(3,4));

            // 4 vertex
            graph[4].add(new Edge(4,3,2)); 
            graph[4].add(new Edge(4,5,5)); 

            // 5 vertex

            // graph[5].add(new Edge(5,0)); 
            // graph[5].add(new Edge(5,2)); 

      }

     static class Pair implements Comparable<Pair>{
            int n;
            int cost;

            public Pair(int n,int cost){
                  this.n = n;
                  this.cost=cost;
            }

            @Override
            public int compareTo(Pair p2){
                  return this.cost - p2.cost; // path based logic
            }

      }

      public static int prims(ArrayList<Edge> graph[],int V){
            PriorityQueue<Pair> pq = new PriorityQueue<>(); // E log(E)
            boolean vis[] = new boolean[V];
            pq.add(new Pair(0,0));
            int cost =0;
            while(!pq.isEmpty()){
                  Pair curr = pq.remove();
                  if(!vis[curr.n]){
                        vis[curr.n] = true;
                        cost += curr.cost;
                  }
                  
                  for(int i=0;i<graph[curr.n].size();i++){
                        Edge e = graph[curr.n].get(i);
                        
                        if(!vis[e.des]){
                              pq.add(new Pair(e.des,e.wt));
                        }
                        
                  }
                  
            }

            return cost;
      }

      public static void main(String args[]){
           int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            System.out.print(prims(graph,V));
      }
}