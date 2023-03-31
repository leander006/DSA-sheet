import java.util.*;
class StackByQueue {
    
      static class stack{

            static Queue<Integer> q1= new ArrayDeque<>();
            static Queue<Integer> q2= new ArrayDeque<>();
            public static boolean isempty(){
                  return q1.isEmpty() && q2.isEmpty();
            }

            public static void push(int data){
                  if(!q1.isEmpty()){
                        q1.add(data);
                  }
                  else{
                        q2.add(data);
                  }
            } 

            public static int get(){
            int top=-1;
            if(isempty()){
                  System.out.println("Queue is empty");
                  return top;  
            }
            if(!q1.isEmpty()){
                  while(!q1.isEmpty()){
                        top= q1.remove();
                        if(q1.isEmpty()){
                              break;
                        }
                        else{
                              q2.add(top);
                        }
                  }
            }
            else{
                  while(!q2.isEmpty()){
                        top= q2.remove();
                        if(q2.isEmpty()){
                              break;
                        }
                        else{
                              q1.add(top);
                        }
                  }
            }
            return top;
            }
            
            public static int view(){
             int top=-1;
            if(isempty()){
                  System.out.println("Queue is empty");
                  return top;  
            }

            if(!q1.isEmpty()){
                  while(!q1.isEmpty()){
                        top= q1.remove();
                        q2.add(top);
                  }
            }
            else{
                  while(!q2.isEmpty()){
                        top= q2.remove();
                        q1.add(top);
                  }
            }
            return top;
            }
      }
      public static void main(String args[]){
            stack s = new stack();
            s.push(1);
            s.push(2);
            s.push(3);
            // System.out.println(s.isempty()+" s.isEmpty() "+s.view()+" s.view()");
            // s.get();
            //       System.out.println(s.isempty()+" s.isEmpty() "+s.view()+" s.view()");
            // s.get();
            //       System.out.println(s.isempty()+" s.isEmpty() "+s.view()+" s.view()");
            // s.get();

            while(!s.isempty()){
                  System.out.println(s.view());
                  s.get();
            }
      }
}