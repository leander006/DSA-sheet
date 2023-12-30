import java.util.*;
class Pq {
    
      public static PriorityQueue<Integer> kthMin(int arr[],int k){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0;i<k;i++){
                  pq.add(arr[i]);
            }

            for(int i=k;i<arr.length;i++){
                  if(arr[i]<pq.peek()){
                        pq.poll();
                        pq.add(arr[i]);
                  }
            }
            return pq;
      }

      // Hard level where we use two pq
      public static int[] median(int arr[]){
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            
            int res[] = new int[arr.length];

            for(int i=0;i<arr.length;i++){
                  if(left.size() == right.size()){
                        right.add(arr[i]);
                        left.add(right.poll()) ;
                  }else{
                        left.add(arr[i]);
                        right.add(left.poll());
                  }

                  if(left.size() == right.size()){
                       int mid = (left.peek()+right.peek())/2;
                       res[i]=mid;
                  }
                  else{
                       int mid = left.peek(); 
                       res[i]=mid;
                  }
                  
            }
            

            return res;
      }
      public static void main(String args[]){
            int arr[] = {12,4,3,7,1,10,6,2,9};
            // int arr[] = {1,2,3,4,6,7,9,10,12};
            // PriorityQueue<Integer> pq = kthMin(arr,6);
            // while(!pq.isEmpty()){
            //       System.out.print(pq.poll()+" ");
            // }
            int res[] = median(arr);
            for(int i=0;i<res.length;i++){
                  System.out.print(res[i]+" ");
            }
            // System.out.print(median(arr));
      }
}