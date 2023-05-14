import java.util.*;
class FamousQuestions {
      
      static class Point implements Comparable<Point>{
            int x;
            int y;
            int idx;
            int diff;

            public Point(int x,int y ,int diff,int idx){
                  this.diff = diff;
                  this.x=x;
                  this.y =y;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Point p2){
                  return this.diff - p2.diff;
            }
      }
      
      static class Window implements Comparable<Window>{
            int idx;
            int val;

            public Window(int val,int idx){
                  this.val = val;
                  this.idx = idx;
            }

            @Override
            public int compareTo(Window w2){
                  return w2.val - this.val ;
            }
      }
      static class Row implements Comparable<Row>{
            int soliders;
            int idx;

            public Row(int soliders,int idx){
                  this.soliders = soliders;

                  this.idx = idx;
            }

            @Override
            public int compareTo(Row r2){
                  if(this.soliders == r2.soliders){
                        return this.idx-r2.idx;
                  }else{
                        return this.soliders-r2.soliders;
                  }
            }
      }

      public static void nearestCar(int arr[][],int k){
            PriorityQueue<Point> pq = new PriorityQueue<>();
            for(int i = 0 ;i<arr.length;i++){
                  int d = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
                  pq.add(new Point(arr[i][0],arr[i][1],d,i));
            }

            for(int i =0 ;i<k;i++){
                  System.out.print("C"+pq.remove().idx +" ");

            }
      }

      public static int smallestRopes(int arr[]){
            int sum=0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<arr.length;i++){
                  pq.add(arr[i]);
            }
            while(pq.size() >1){
                  int i = pq.remove();
                  int j = pq.remove();
                  sum += i+j;
                  pq.add(i+j);
            }

            return sum;
      }

      public static void slidingWindow(int arr[],int k){
                  PriorityQueue<Window> pq = new PriorityQueue<>();
                  int a[] = new int[arr.length - k +1];
                  for(int i=0;i<k;i++){
                        pq.add(new Window(arr[i],i));
                  }
                  a[0]= pq.peek().val;
                  for(int i=k;i<arr.length;i++){
                        while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                              pq.remove();
                        }
                        pq.add(new Window(arr[i],i));
                        a[i-k+1]= pq.peek().val;
                  }
                  for(int i=0;i<a.length;i++){
                        System.out.print(a[i] +" ");
                  }                  
      }
      public static void weakestSol(int arr[][],int k){
            PriorityQueue<Row> pq = new PriorityQueue<>();            
            for(int i=0;i<arr.length;i++){
                 int count=0;
                 for(int j=0;j<arr[0].length;j++){
                        count+=arr[i][j] == 1 ? 1:0;
                 }
                 pq.add(new Row(count,i));
            }
            for(int i=0;i<k;i++){
                        System.out.print("R"+pq.remove().idx+" ");
            }


      }
      public static void main(String args[]){
            int a[][] ={{3,3},{5,-1},{-2,4}};
            int k=2;
            int ropes[]={2,3,3,4,6};
            int arr[][]= {
                  {1,0,0,0},
                  {1,1,1,1},
                  {1,0,1,1},
                  {1,0,1,1}
            };
            // int ropes[]={4,2,5,6};
            // nearestCar(a,k);
            // System.out.print(smallestRopes(ropes));
            int arrr[] ={1,3,-1,-3,5,3,6,7};
            // weakestSol(arr,2);
            slidingWindow(arrr,3);

      }
}