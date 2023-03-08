import java.util.*;
class Histogram {
    
      public static int area(int arr[]){
            int maxarea=0;
            int[] nsl = new int[arr.length];
            int[] nsr = new int[arr.length];

            Stack<Integer> s = new Stack <>();
            // Right array
            for(int i = arr.length-1 ;i>=0;i--){
                  while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        nsr[i] = arr.length;
                  }
                  else{
                        nsr[i] =s.peek();
                  }
                  s.push(i);
            }

            //Left array
            for(int i = 0 ;i<arr.length;i++){
                  while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        nsl[i] = arr.length;
                  }
                  else{
                        nsl[i] =s.peek();
                  }
                  s.push(i);
            }            


            // Area 
            for(int i=0;i<arr.length;i++){
                  int heigth = arr[i];
                  int weight = nsr[i] - nsl[i] -1;
                  int currentArea = heigth * weight;
                  maxarea = Math.max(maxarea,currentArea);
            }
            
            return maxarea;
      }

      public static void main(String args[]){

            int ar[]={2,1,5,6,2,3};
            System.out.print(area(ar));
      }
}