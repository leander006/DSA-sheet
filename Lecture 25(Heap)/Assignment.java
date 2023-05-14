import java.util.*;
class Assignment {

      public static PriorityQueue<Integer> min = new PriorityQueue<>();
      static int row=0;
      static int col=0;
      public static ArrayList<Integer> Ass1(int arr[],int k){
            ArrayList<Integer> a = new ArrayList<>();
            for(int val:arr){
                  if(min.size() < k){
                        min.add(val);
                  }
                  else{
                        if(val>min.peek()){
                              min.poll();
                              min.add(val);
                        }
                  }

                  if(min.size() >=k){
                        a.add(min.peek());
                  }
                  else{
                        a.add(-1);
                  }
  
            }
            return a;
      }
      public static void Ass2(int arr[],int k,int N){
            Queue<Integer> q = new LinkedList<>();
            boolean vis[] = new boolean[N+1];
            int time=0;
            for(int i=0;i<arr.length;i++){
                  q.add(arr[i]);
                  vis[arr[i]] =true;
            }

            while(q.size() >0){
                  for(int i=0;i<q.size();i++){
                        int curr = q.poll();
                        if(curr -1 >= 1 && !vis[curr-1]){
                              vis[curr-1]=true;
                              q.add(curr-1);  
                        }

                        if(curr + 1 <= N && !vis[curr+1]){
                              vis[curr+1]=true;
                              q.add(curr+1);        
                        }
                  }
                  time++;   
            }

        
            System.out.print(time-1);
      }

      // public static void getIdx(int arr[][] ,int element){
      //       for (int i = 0; i < arr.length; i++) {
      //             for (int j = 0; j < arr[i].length; j++) {
      //                   if (arr[i][j] == element) {
      //                         row = i;
      //                         col = j;
      //                         break;
      //             }
      //       }
      // }
      // }
      // public static void Ass3(int a[][]){
      //       int sum=0;
      //       PriorityQueue<Integer> q = new PriorityQueue<>();
      //       sum+=a[0][0];
      //             while(row<a.length && col<a[0].length){
      //                   if(row>-1 && col+1 > -1 ){
      //                         q.add(a[row][col+1]);
      //                   }
      //                   if(row+1 >-1 && col >-1 ){
      //                         q.add(a[row+1][col]);
      //                   }
      //                   if(row >-1  && col-1 >-1 ){
      //                         q.add(a[row][col-1]);
      //                   }
      //                   if(row-1 >-1 && col >-1 ){
      //                         q.add(a[row-1][col]);
      //                   }  
      //                   getIdx(a,q.peek());
      //                   sum+=q.poll();
      //                   while(!q.isEmpty()){
      //                         q.poll();
      //                   }
      //       }
      //       System.out.print(sum+" ");
      // }

      public static void Ass4(int arr[]){
            PriorityQueue<Integer>q = new PriorityQueue<>(Comparator.reverseOrder());
            int sum=0;
            int count =0;
            for(int i=0;i<arr.length;i++){
                  sum+=arr[i];
                  q.add(arr[i]);
            }

            double temp=sum;
            while(temp > sum/2){
                  int x = q.peek();
                  q.poll();
                  temp -= Math.ceil(x *1.0/2);
                  q.add(x/2);
                  count++;
            }
            System.out.print(count +" ");
      }

      public static void Ass5(LinkedList<Integer> l1,LinkedList<Integer> l2,LinkedList<Integer> l3){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<l1.size();i++){
                  
                  pq.add(l1.get(i));
            }            
            for(int i=0;i<l2.size();i++){
                  pq.add(l2.get(i));
            }                       
            for(int i=0;i<l3.size();i++){
                  pq.add(l3.get(i));
            }
            while(!l1.isEmpty()){
                  l1.remove();
            }
            while(!pq.isEmpty()){
                  l1.add(pq.poll());
            }
            
      }
      public static void main(String args[]){
            int stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
            // ArrayList<Integer> a = Ass1(stream,3);
            // for(int val:a){
            //       System.out.print(val+" ");
            // }
            // int N = 5, K = 5, arr[] = {1, 2, 3, 4,5}  ;  
            // int  N = 6, K = 2, arr[] = {2, 6};  
            // Ass2(arr,K,N); 
            // int arr[][] ={ { 31, 100, 65, 12, 18 },{ 10, 13, 47, 157, 6 },{ 100, 113, 174, 11, 33 },{ 88, 124, 41, 20, 140 },{ 99, 32, 111, 41, 20 } };
            // // Ass3(arr);
            // int a[] ={1, 5, 8, 19};
            // Ass4(a);
            LinkedList<Integer> l1 = new LinkedList<>();
            l1.add(1);
            l1.add(3);
            l1.add(7);
            LinkedList<Integer> l2 = new LinkedList<>();
            l2.add(2);
            l2.add(4);
            l2.add(8);            
            LinkedList<Integer> l3 = new LinkedList<>();
            l3.add(9);
            l3.add(10);
            l3.add(11);
            Ass5(l1,l2,l3);
            for(int val:l1){
                  System.out.print(val+" ");
            }
      } 
}