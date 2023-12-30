
import java.util.*;
public class Dijkstra 
{
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
            int path;

            public Pair(int n,int path){
                  this.n = n;
                  this.path=path;
            }

            @Override
            public int compareTo(Pair p2){
                  return this.path - p2.path; // path based logic
            }

      }


      public static void dijkstra(ArrayList<Edge> graph[],int src){
            int dis[] = new int[graph.length];
            for(int i=0;i<dis.length;i++){
                  if(i!=src){
                        dis[i] = Integer.MAX_VALUE;
                  }
            }
            
            boolean vis[] = new boolean[graph.length];
            PriorityQueue<Pair>pq = new PriorityQueue<>();
            pq.add(new Pair(src,0));
            
            while(!pq.isEmpty()){
                Pair curr = pq.remove();
                if(!vis[curr.n]){
                        vis[curr.n] = true;
                        for(int i=0;i<graph[curr.n].size();i++){
                                Edge e = graph[curr.n].get(i);
                                int u = e.src;
                                int v = e.des;
                                int wt = e.wt;
                                
                                if(dis[u]+wt <dis[v]){
                                        dis[v] = dis[u]+wt;
                                        pq.add(new Pair(v,dis[v]));
                                }
                        }
                }
            }
            
            for(int i=0;i<dis.length;i++){
                    System.out.print(dis[i] +" ");
            }
            System.out.println("");
      }

      public static void main(String args[]){
            int V= 6;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            // dfs(graph);
            // printAllPath(graph,5,1,"");
            dijkstra(graph,0);
            
            

      }
}
