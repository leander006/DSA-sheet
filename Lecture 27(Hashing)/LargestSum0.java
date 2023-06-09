import java.util.*;
class LargestSum0 {
    public static void main(String args[]){
            HashMap<Integer,Integer>map = new HashMap<>();
            int arr[] ={15,-2,2,-8,1,7,10,23};

            int sum=0;
            int length =0;

            for(int i=0;i<arr.length;i++){
                  sum+=arr[i];
                  if(map.containsKey(sum)){
                        length =Math.max(length,i-map.get(sum));
                  }
                  else{
                        map.put(sum,i);
                  }
            }

            System.out.print("Largest length with sum zero is "+ length);      
    }
}