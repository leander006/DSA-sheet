import java.util.*;
class Activity {
    public static void main(String args[]){
      int start[] ={1,3,0,5,8,5};
      int end[] ={2,4,6,7,9,9};

      int activities[][] = new int[end.length][3];
      for(int i =0;i<end.length;i++){
            activities[i][0]=i;
            activities[i][1]= start[i];
            activities[i][2]= end[i];
      }
      Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

      // For sorted array
      int maxAct =1;
      int lastEnd =end[0];
      ArrayList<Integer>Arr = new ArrayList<>();
      Arr.add(0);
      for(int i=1;i<end.length;i++){
            if(start[i] >= lastEnd){
                  maxAct++;
                  Arr.add(i);
                  lastEnd=end[i];
            }
      }

      // For non sorted array 

      int maxActs =1;
      int lastEnds =activities[0][2];
      ArrayList<Integer>Arrs = new ArrayList<>();
      Arrs.add(0);
      for(int i=1;i<end.length;i++){
            if(activities[i][1] >= lastEnds){
                  maxActs++;
                  Arrs.add(activities[i][0]);
                  lastEnds=activities[i][2];
            }
      }
      System.out.println("Activity performed are "+maxAct);
      for(int i=0;i<Arr.size();i++){
            System.out.print("A"+Arr.get(i)+" ");
      }
    }
}