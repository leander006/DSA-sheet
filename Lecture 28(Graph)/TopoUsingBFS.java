import java.util.*;
class TopoUsingBFS {
    
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
            // graph[0].add(new Edge(0,1));
            // graph[0].add(new Edge(0,2));
            // graph[0].add(new Edge(0,3));
            // 1 vertex
            // graph[1].add(new Edge(1,0));
            // graph[1].add(new Edge(1,3));

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

      public static void countInDeg(ArrayList<Edge> graph[],int indeg[]){
            for(int i=0;i<graph.length;i++){
                  for(int j=0;j<graph[i].size();j++){
                        Edge e = graph[i].get(j);
                        indeg[e.des]++;
                  }
            }
      }

      public static void topologySort(ArrayList<Edge> graph[]){
            int indeg[] = new int[graph.length];
            countInDeg(graph,indeg);
            Queue<Integer> queue = new LinkedList<>();
            
            for(int i=0;i<indeg.length;i++){
                  if(indeg[i] == 0){
                        queue.add(i);
                  }
            }
            
            while(!queue.isEmpty()){
                  int curr = queue.remove();
                  System.out.print(curr +"");

                  for(int i=0;i<graph[curr].size();i++){
                        Edge e = graph[curr].get(i);
                        indeg[e.des]--;
                        if(indeg[e.des] == 0){
                              queue.add(e.des);
                        }
                  }
            }
      }

      public static void main(String args[]){
            int V= 6;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            // dfs(graph);
            topologySort(graph);
            

      }
}