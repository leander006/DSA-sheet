import java.util.*;

class Kosaraju {
        
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
            graph[0].add(new Edge(0,2,2));
            graph[0].add(new Edge(0,3,4));

            // 1 vertex
            graph[1].add(new Edge(1,0,7));


            // 2 vertex
            graph[2].add(new Edge(2,1,3));

            // 3 vertex
            graph[3].add(new Edge(3,4,1));
      }
      public static void topoSort(ArrayList<Edge> graph[],int curr,boolean vis[] , Stack<Integer> s){
            vis[curr] = true;

            for(int i=0;i<graph[curr].size();i++){
                  Edge e = graph[curr].get(i);

                  if(!vis[e.des]){
                        topoSort(graph,e.des,vis,s);
                  }
            }

            s.push(curr);
      }

      public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
            vis[curr] = true;
            System.out.print(curr+" ");

            for(int i=0;i<graph[curr].size();i++){
                  Edge e = graph[curr].get(i);

                  if(!vis[e.des]){
                        dfs(graph,e.des,vis);
                  }
            }
      }
      public static void kosaraju(ArrayList<Edge> graph[], int V){
            // Step 1
            Stack<Integer> s = new Stack<>();
            boolean vis[] = new boolean[V];

            for(int i=0;i<V;i++){
                  if(!vis[i]){
                        topoSort(graph,i,vis,s);
                  }
            }

            // Step 2
            ArrayList<Edge> transpose[] = new ArrayList[V];           
            for(int i=0;i<graph.length;i++){
                  vis[i]= false;
                  transpose[i] = new ArrayList<>();
            }

            for(int i=0;i<V;i++){
                  for(int j=0;j<graph[i].size();i++){
                        Edge e = graph[i].get(j);
                        transpose[e.des].add(new Edge(e.des,e.src,e.wt));
                  }
            }

            // Step 3

            while(!s.isEmpty()){
                  int curr = s.pop();
                  if(!vis[curr]){
                        dfs(transpose,curr,vis);
                        System.out.println("");
                  }
            }
            
      }

      public static void main(String args[]){
           int V= 5;

            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
           
            kosaraju(graph,V);
      }


}