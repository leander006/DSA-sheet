import java.util.*;
class FractionalKnapsack {
    public static void main(String args[]){
      int val[]={60,100,120};
      int wieght[]={10,20,30};

      int W=50;
      double ratio[][] = new double[val.length][2];

      for(int i=0;i<wieght.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)wieght[i];
      }

      Arrays.sort(ratio,Comparator.comparingDouble( o -> o[1]));

      int capacity = W;
      int profit =0;
      for(int i=ratio.length-1;i>=0 ;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= wieght[idx]){
                  profit+= val[idx];
                  capacity -= wieght[idx];
            }
            else{
                  profit += (ratio[i][1] * capacity);
                  capacity=0;
                  break;
            }
      }

      System.out.print("Maximum profit is "+ profit);
    }
}