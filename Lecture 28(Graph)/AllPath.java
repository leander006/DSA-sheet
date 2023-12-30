import java.util.*;
class AllPath {
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
            graph[0].add(new Edge(0,3));
            // graph[0].add(new Edge(0,2));
            // graph[0].add(new Edge(0,3));
            // 1 vertex
            // graph[1].add(new Edge(1,0));
            graph[1].add(new Edge(1,3));

            // 2 vertex
            // graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,3));

            // 3 vertex
            graph[3].add(new Edge(3,1));
            // graph[3].add(new Edge(3,4));

            // 4 vertex
            graph[4].add(new Edge(4,0)); 
            graph[4].add(new Edge(4,1)); 

            // 5 vertex

            graph[5].add(new Edge(5,0)); 
            graph[5].add(new Edge(5,2)); 

      }

      public static void printAllPath(ArrayList<Edge> graph[],int src,int des,String res){
            if(src == des){
                  System.out.println(res+des);
                  return;
            }
            for(int i=0;i<graph[src].size();i++){
                  Edge e = graph[src].get(i);
                  printAllPath(graph,e.des,des,res+src);
            }
            // System.out.println("");
      }


      public static void main(String args[]){
            int V= 7;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            // dfs(graph);
            printAllPath(graph,5,1,"");
            
            

      }
}