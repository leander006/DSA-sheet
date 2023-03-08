import java.util.*;
class DuplicatePara {

      public static boolean duplicate(String str){
            Stack<Character> s = new Stack <> ();
            
            for(int i=0;i<str.length() ;i++){
                  
                  if(str.charAt(i) == ')'){
                        int count=0;
                        while( s.pop() != '('){
                              count++;
                        }
                        if(count <1){
                              return false;
                        }                        
                  }
                  else{
                        s.push(str.charAt(i));
                  }
                  
            }

            return true;
      }
    
      public static void main(String args[]){
            String s = "[(a+b)]";
            System.out.print(duplicate(s));
      }
}