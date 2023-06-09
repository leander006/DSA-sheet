import java.util.*;
class Itinerary {

      public static String getStart(HashMap<String,String> tickets){
            HashMap<String,String> revtickets = new HashMap<>();

            for(String keys: tickets.keySet()){
                  revtickets.put(tickets.get(keys),keys);
            }

 
            for(String keys:tickets.keySet()){
                  if(!revtickets.containsKey(keys)){
                        return keys;
                  }
            }
            return null;
      }

      public static void main(String args[]){

            HashMap<String,String> tickets = new HashMap<>();

            tickets.put("Chennai","Bengaluru");
            tickets.put("Mumbai","Delhi");
            tickets.put("Goa","Chennai");
            tickets.put("Delhi","Goa");

            String start = getStart(tickets);
            System.out.print(start);

            for(String keys:tickets.keySet()){
                  System.out.print(" -> "+tickets.get(start));
                  start = tickets.get(start);
            }


      }
}