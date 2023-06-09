import java.util.*;
class CountUnique {
    public static void main(String args[]){
           // Brute force O(n*n)

           // Optimize o(n)
           int num[] ={1,3,4,7,5,7,5,3,2};
           HashSet<Integer>set = new HashSet<>();
           for(int i:num){
                  set.add(i);
           }

           System.out.print(set.size());

    }
}