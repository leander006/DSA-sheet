import java.util.*;
class Set {
    public static void main(String args[]){
            HashSet<Integer> set = new HashSet<>();
            set.add(2);
            set.add(4);
            set.add(3);
            set.add(2);
            set.add(3);

            System.out.println(set);
            // set.clear();
            // System.out.println(set);
            Iterator it = set.iterator();
            while(it.hasNext()){
                  System.out.print(it.next()+" ");
            }
            System.out.println();
            for(Integer i :set){
                  System.out.print(i+" ");
            }

            LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
            lhs.add(2);
            lhs.add(4);
            lhs.add(3);
            lhs.add(2);
            lhs.add(3);
            System.out.print(lhs);
    }
}