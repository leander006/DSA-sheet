import java.util.*;
class QueueByStac {
      static class queue{
               static Stack<Integer>s1 = new Stack<>();
      static Stack<Integer>s2 = new Stack<>();
      
      public static boolean isEmpty(){
            return s1.empty();
      }      

      public static void add(int data){
            while(!s1.empty()){
                  s2.push(s1.pop());
            } 
            s1.add(data);
            while(!s2.empty()){
                  s1.push(s2.pop());
            }    
      }

      public static int remove(){
            if(s1.empty()){
                  System.out.println("Queue is empty");
                  return 1;
            }
            return s1.pop();
      }
    
      public static int view(){
            if(s1.empty()){
                  System.out.println("Queue is empty");
                  return 1;
            }
            return s1.peek(); 
      }   
      }

      public static void main(String args[]){

            queue q = new queue();

            q.add(2);
            q.add(3);
            q.add(4);

            while(!q.isEmpty()){
                  System.out.println(q.remove());
            }
      }
}