import java.util.*;
class Assisgnment {
    
      public static boolean ass1(LinkedList<Character>l){
            Stack<Character> s = new Stack<>();
            if(l.isEmpty() || l.size() ==1){
                  return true;
            }
            
           for(int i=0;i<l.size();i++){
                  s.push(l.get(i));

            }

            for(int i=0;i<s.size();i++){
                 if(l.get(i) != s.pop()){
                        return false;
                  }
            }
            return true;
      }
      
      public static int assign4(int[] height){
            int ans=0;
            Stack<Integer> stack = new Stack <>();
            for(int i=0;i<height.length;i++){
                  while((!stack.isEmpty()) && (height[stack.peek()] < height[i])){
                        int pop_height = height[stack.peek()];
                        stack.pop();
                        if(stack.isEmpty()){
                              break;
                        }
                        int dis = i- stack.peek()-1;
                        int minHeight = Math.min(height[stack.peek()],height[i]) - pop_height;
                        ans += minHeight * dis;

                  }
                  stack.push(i);

            }
            return ans;
      }
      public static void main(String args[]){

            int arr[] = { 7, 0, 4 ,2, 5, 0, 6 ,4 ,0, 6 };


            System.out.print(assign4(arr));

            
      }
}