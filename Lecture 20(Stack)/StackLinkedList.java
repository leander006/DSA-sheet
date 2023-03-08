import java.util.*;
public class StackLinkedList {

      static class Node{
            int data;
            Node next;
            Node(int data){
            this.data=data;
            this.next=null;
            }
      }
       static class StackB{

            static Node head=null;
            static LinkedList<Integer> list = new LinkedList<>();
            public static boolean isEmpty(){
                  return head == null;
            }

            public static void push(int data){
                  Node newNode = new Node(data);
                  if(isEmpty()){
                        head= newNode;
                        return;
                  }
                  newNode.next = head;
                  head=newNode;

            }
            public static int pop(){
                  if(isEmpty()){
                        return -1;
                  }
                  int ele = head.data;
                  head= head.next;
                  return ele;
            }

            public static int peek(){
                  if(isEmpty()){
                        return -1;
                  }
                  int ele = head.data;     
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