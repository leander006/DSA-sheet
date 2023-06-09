import java.util.*;
class Basic {
    
      public static void main(String args[]){
            HashMap<String,Integer>map = new HashMap<>();
            map.put("India",234);
            map.put("China",243);
            map.put("Nepal",224);
            System.out.println(map);
            // System.out.println(map.get("India"));
            // System.out.println(map.remove("Nepal"));
            // System.out.println(map);


            // Iteration in map //
            Set<String> keys = map.keySet();
            System.out.println(keys);
            for(String s:keys){
                  System.out.println("key "+s + " Values "+map.get(s));
            }


      }
}