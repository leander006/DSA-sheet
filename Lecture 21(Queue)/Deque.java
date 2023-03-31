import java.util.*;
class Deque {
    
      static class s{
            static ArrayDeque<Integer> q = new ArrayDeque<>();

            public static boolean isEmpty(){
                  return q.isEmpty();
            }
            public static void push(int data){
                  q.addLast(data);
            }
            public static int pop(){
                  return q.removeLast();
            }
            public static int peek(){
                  return q.peekLast();
            }
      }

      static class q{
            static ArrayDeque<Integer> s = new ArrayDeque<>();

            public static boolean isEmpty(){
                  return s.isEmpty();
            }
            public static void push(int data){
                  s.addFirst(data);
            }
            public static int pop(){
                  return s.removeLast();
            }
            public static int peek(){
                  return s.getFirst();
            }
      }      
      public static void main(String args[]){
      //      s q= new s();
      //       q.push(2);
      //       q.push(3);
      //       q.push(4);

      //       while(!q.isEmpty()){
      //             System.out.println(q.pop());
      //       }

            q s = new q();

            s.push(2);
            s.push(3);
            s.push(4);

            while(!s.isEmpty()){
                  System.out.println(s.pop());
            }            
            
      }

}