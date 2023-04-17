import java.util.*;
class IndianCoin {
    public static void main(String args[]){
      Integer coin[] ={1,2,5,10,20,50,100,500,2000};

      Arrays.sort(coin,Comparator.reverseOrder());
      int amount =901;
      int maxCoin = 0;
      ArrayList<Integer> arr= new ArrayList<>();
      for(int i=0;i<coin.length;i++){
            if(coin[i] <= amount){
                  while(coin[i] <=amount){
                        maxCoin++;
                        arr.add(coin[i]);
                        amount -= coin[i];
                  }
            }
      }
      System.out.println("Min coins are "+ maxCoin);
      for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
      }
      
    }
}