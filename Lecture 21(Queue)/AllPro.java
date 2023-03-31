import java.util.*;
class AllPro {

      public static void reverse(Queue<Integer> q){
            Stack<Integer> s = new Stack <>();
            while(!q.isEmpty()){
                  s.push(q.remove());
            }

            while(!s.isEmpty()){
                  q.add(s.pop());
            }

      }
      public static void interLeave(Queue<Integer>q){
            Queue<Integer> firstQueue = new ArrayDeque<>();
            int size = q.size();

            for(int i=0;i<size/2;i++){
                  firstQueue.add(q.remove());
            }
            while(!firstQueue.isEmpty()){
                  q.add(firstQueue.remove());
                  q.add(q.remove());
            }

      }

      public static void printNonRepeating(String s){
            Queue<Character> q = new ArrayDeque<>();
            int freq[] = new int[26];

            for(int i=0;i<s.length();i++){
                  char ch = s.charAt(i);
                  q.add(ch);
                  freq[ch - 'a']++;

                  while(!q.isEmpty() && freq[q.peek()-'a'] >1){
                        q.remove();
                  }

                  if(q.isEmpty()){
                        System.out.print("-1"+" ");
                  }
                  else{
                        System.out.print(q.peek()+" ");
                  }


            }
            System.out.println();
      }
    
      public static void main(String args[]){
            Queue<Integer> q = new ArrayDeque<>();
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            q.add(5);
            q.add(6);
            q.add(7);
            q.add(8);
            q.add(9);
            q.add(10);
            String s = "aabccxb";
            // printNonRepeating(s);
            // interLeave(q);
            while(!q.isEmpty()){
                  System.out.print(q.peek());
            }

            reverse(q);
            while(!q.isEmpty()){
                  System.out.print(q.remove());
            }

      }
}