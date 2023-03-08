import java.util.*;
class ReverseStack {
        public static void Push_At_Bottom(Stack<Integer>s,int data){
      if(s.isEmpty()){
            s.push(data);
            return;
      }
      int top=s.pop();
      Push_At_Bottom(s,data);
      s.push(top);
      
    }

    public static void reverse(Stack<Integer> s){
      if(s.isEmpty()){
            return;
      }
      int top = s.pop();
      reverse(s);
      Push_At_Bottom(s,top);
    }
    public static void main(String args[]){
      Stack<Integer> s =new Stack<>();
      s.push(1);
      s.push(2);
      s.push(3);

      reverse(s);

      while(!s.isEmpty()){
            System.out.println(s.pop());
      }
    }
}