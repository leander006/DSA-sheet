
import java.util.*;

class Articulation {

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

      public static void dfs(ArrayList<Edge> graph[],int curr, int par, boolean vis[],int dt[],int low[],boolean pt[],int time){
            vis[curr] = true;
            dt[curr] = low[curr] = ++time;
            int child=0;

            for(int i=0;i<graph[curr].size();i++){
                  Edge e = graph[curr].get(i);
                  
                  if(par == e.des){
                        continue;
                  }else if(vis[e.des]){
                        low[curr] = Math.min(low[curr],dt[e.des]);
                  }
                  else{
                        dfs(graph,e.des,curr,vis,dt,low,pt,time);
                        low[curr] = Math.min(low[curr],low[e.des]);
                        if(dt[curr]< low[e.des] && par != -1){
                              pt[curr] = true;
                        }
                        child++;
                  }     
            }

            if(par == -1 && child >1){
                  pt[curr] = true;
            }
      
      }
      public static void pt(ArrayList<Edge> graph[],int V){

            int dt[] = new int[V];
            int low[] = new int[V];
            boolean pt[]= new boolean[V];
            int time=0;
            boolean vis[] = new boolean[V];

            for(int i=0;i<V;i++){
                  if(!vis[i]){
                        dfs(graph,i,-1,vis,dt,low,pt,time);
                  }
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

      public static void main(String args[]){
            int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
 

      }
}