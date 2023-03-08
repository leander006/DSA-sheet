import java.util.*;
class ReverseString {

      public static String reverseStr(String str){
             StringBuilder sb = new StringBuilder("");
            Stack <Character> s = new Stack<>();
            for(int i=0;i<str.length();i++){
                  s.push(str.charAt(i));
            }

            while(!s.isEmpty()){
                  sb.append(s.pop());
            }
            return sb.toString();
      }

      public static void main(String args[]){

            String s ="abc";
            System.out.print(reverseStr(s));

      }
    
}