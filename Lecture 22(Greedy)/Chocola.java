import java.util.*;
class Chocola {
    public static void main(String args[]){
      int n=4,m=6;
      Integer costVer[]={2,1,3,1,4};
      Integer costHor[] ={4,1,2};

      Arrays.sort(costVer,Collections.reverseOrder());
      Arrays.sort(costHor,Collections.reverseOrder());

      int h=0,v=0;
      int hp=1,vp=1;

      int finalCost =0;
      while(h< costHor.length &&  v< costVer.length){
            if(costVer[v] <= costHor[h]){
                  finalCost += vp * costHor[h];
                  hp++;
                  h++;
            }
            else{
                  finalCost += hp *  costVer[v];
                  vp++;
                  v++;
            }
      }

      while(h < costHor.length){
            finalCost += vp * costHor[h];
            hp++;
            h++;            
      }

      while(v < costVer.length){
            finalCost += hp *  costVer[v];
            vp++;
            v++;
      }    
      
      System.out.print("Final cost is "+ finalCost);
    }
}