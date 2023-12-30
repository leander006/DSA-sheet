import java.util.*;
class BellmanFord {
    
      static class Edge{
                  int src;
                  int des;
                  int wt;

                  public Edge(int s ,int d,int w){
                        this.src =s;
                        this.des =d;
                        this.wt = w;
                  }

      }

    
      public static void createGraph(ArrayList<Edge> graph[]){

            for(int i=0;i<graph.length;i++){
                  graph[i] = new ArrayList<>();
            }

            // 0 vertex
            graph[0].add(new Edge(0,1,5));
            graph[0].add(new Edge(0,2,5));
            // 1 vertex
            graph[1].add(new Edge(1,0,5));
            graph[1].add(new Edge(1,3,1));

            // 2 vertex
            graph[2].add(new Edge(2,0,1));
            graph[2].add(new Edge(2,4,4));

            // 3 vertex
            graph[3].add(new Edge(3,1,3));
            graph[3].add(new Edge(3,4,1));
            graph[3].add(new Edge(3,5,1));

            // 4 vertex
            graph[4].add(new Edge(4,2,2));
            graph[4].add(new Edge(4,3,2));
            graph[4].add(new Edge(4,5,2));

            // 5 vertex
            graph[5].add(new Edge(5,3,2));
            graph[5].add(new Edge(5,4,2));
            graph[5].add(new Edge(5,6,2));

            // 6 vertex
            graph[6].add(new Edge(6,5,2));

      }

      public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
            int dist[] = new int[V];

            for(int i=0;i<V;i++){
                  if(i != src){
                        dist[i] = Integer.MAX_VALUE;
                  }
            }

            for(int k=0;k<V-1;k++){
                  for(int i=0;i<V;i++){
                        for(int j=0;j<graph[i].size();j++){
                              Edge e = graph[i].get(j);
                              int u = e.src;
                              int v = e.des;

                              if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]){
                                    dist[v] = dist[u] + e.wt;
                              }
                        }
                  }
            }

            for(int i=0;i<V;i++){
                  System.out.print(dist[i] +" ");
            }
      }

      public static void main(String args[]){
            int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            bellmanFord(graph,2,V);

      }
}