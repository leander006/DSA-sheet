import java.util.*;
class Assignment {
      static class Edge{
                  int src;
                  int des;

                  public Edge(int s ,int d){
                        this.src =s;
                        this.des =d;
                  }

      }

    
      public static void createGraph(ArrayList<Edge> graph[]){

            for(int i=0;i<graph.length;i++){
                  graph[i] = new ArrayList<>();
            }

            // 0 vertex
            graph[0].add(new Edge(0,1));
            graph[0].add(new Edge(0,2));
            graph[0].add(new Edge(0,3));
            // 1 vertex
            graph[1].add(new Edge(1,0));
            graph[1].add(new Edge(1,2));

            // 2 vertex
            graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,1));

            // 3 vertex
            graph[3].add(new Edge(3,0));
            graph[3].add(new Edge(3,4));

            // 4 vertex
            graph[4].add(new Edge(4,3)); 


      }

      public static boolean isCycle(ArrayList<Edge> graph[]){
            boolean vis[] = new boolean[graph.length];
            for(int i=0;i<graph.length;i++){
                  if(!vis[i]){
                        if(detectCycle(graph,vis,i)){
                              return true;
                        }
                  }
            }
            return false;
      }

      public static boolean detectCycle(ArrayList<Edge> graph[],boolean vis[],int i){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                 int curr = q.remove();
                  
                  if(!vis[curr]){
                        vis[curr] =true;
                        for(int j=0;j<graph[curr].size();j++){
                                    Edge e = graph[curr].get(i);
                                    q.add(e.des);
                        }
                  }

            }
            return false;
      }



      public static void main(String args[]){
            int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            // dfs(graph);
            System.out.print(isCycle(graph));
            

      }

}