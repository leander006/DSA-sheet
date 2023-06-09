import java.util.*;
class Intersection {
    public static void main(String args[]){
            int arr1[]={1,4,7};
            int arr2[] ={4,6,7,8,9,7};
            HashSet<Integer>set = new HashSet<>();
            for (int each : arr1) {
                  set.add(each);
            }
            for (int each : arr2) {
                  set.add(each);
            }     
            
            System.out.println("Union is "+ set.size()+" "+set);
            set.clear();

            for (int each : arr1) {
                  set.add(each);
            }
            int count =0;
            for(int i=0;i<arr2.length;i++){
                  if(set.contains(arr2[i])){
                        set.remove(arr2[i]);
                        count++;
                  }
            }
            System.out.println("Intersection is "+ count);


    }
}