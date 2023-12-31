
import java.util.*;

class Tarjan {
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

      public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[],int dt[],int low[],int time,int par){

            vis[curr] = true;
            low[curr] = dt[curr] = ++time;

            for(int i=0;i<graph[curr].size();i++){
                  Edge e = graph[curr].get(i);

                  if(e.des == par){
                        continue;
                  }else if(!vis[e.des]){
                        dfs(graph,e.des,vis,dt,low,time,curr);
                        low[curr] =Math.min(low[curr],low[e.des]);
                        if(dt[curr]<low[e.des]){
                              System.out.print(curr +"--->"+ par);
                        }
                  }
                  else{
                        low[curr] = Math.min(low[curr],dt[e.des]);
                  }
            }
      }
      public static void bridge(ArrayList<Edge> graph[] , int V){
            int dt[] = new int[V];
            int low[] = new int[V];
            int time =0;
            boolean vis[] = new boolean[V];

            for(int i=0;i<V;i++){
                  if(!vis[i]){
                        dfs(graph,i,vis,dt,low,time,-1);
                  }
            }
      }

    
      public static void main(String args[]){
           int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
         
      }
}