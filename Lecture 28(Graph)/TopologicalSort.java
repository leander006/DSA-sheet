import java.util.*;

class TopologicalSort{

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
            // graph[0].add(new Edge(0,3));
            // 1 vertex
            // graph[1].add(new Edge(1,0));
            graph[1].add(new Edge(1,3));

            // 2 vertex
            // graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,3));

            // 3 vertex
            // graph[3].add(new Edge(3,0));
            // graph[3].add(new Edge(3,4));

            // 4 vertex
            // graph[4].add(new Edge(4,3)); 


      }

      public static void topologySort(ArrayList<Edge> graph[]){
            boolean vis[] = new boolean[graph.length];
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<graph.length;i++){
                  if(!vis[i]){
                        topoUtil(graph,vis,i,s);
                  }
            }
            while(!s.isEmpty()){
                  System.out.print(s.pop()+" ");
            }
      }

      public static void topoUtil(ArrayList<Edge> graph[],boolean vis[],int curr,Stack<Integer> stack){
            vis[curr] =true;
            for(int i=0;i<graph[curr].size();i++){
                  Edge e = graph[curr].get(i);
                 if(!vis[e.des]){
                        topoUtil(graph,vis,e.des,stack);
                  }      
            }
            stack.push(curr);
      }

      public static void main(String args[]){
            int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            // dfs(graph);
            topologySort(graph);
            

      }
}