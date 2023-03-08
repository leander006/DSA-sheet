import java.util.*;
public class StackArrayList {

     static class StackB{
            static ArrayList<Integer> list = new ArrayList<>();
            public static boolean isEmpty(){
                  return list.size() ==0;
            }

            public static void push(int data){
                  list.add(data);
            }
            public static int pop(){
                  if(list.size() ==0){
                        return -1;
                  }
                  int ele = list.get(list.size()-1);
                  list.remove(list.size()-1);
                  return ele;
            }

            public static int peek(){
                  if(list.size() ==0){
                        return -1;
                  }
                  int ele = list.get(list.size()-1);
                  return ele;
            }
     }
    public static void main(String args[]){

            StackB s = new StackB();
            s.push(2);
            s.push(3);
            s.push(4);

            System.out.println(s.isEmpty());
            while(!s.isEmpty()){
                  System.out.println(s.peek());
                  s.pop();
            }
            System.out.println(s.isEmpty());
    }
}