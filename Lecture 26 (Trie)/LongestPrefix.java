
class LongestPrefix {
         static class Node{
            Node children[] = new Node[26];
            boolean isEndOfWord= false;

            Node(){
                  for(int i=0;i<26 ;i++){
                        children[i]= null;
                  }
            }
      }
      public static Node root = new Node();
        
      public static void insert(String word){
            Node curr = root;
            for(int level=0;level<word.length();level++){
                    int idx = word.charAt(level) - 'a';
                    if(curr.children[idx] == null){
                        curr.children[idx] = new Node();
                    }
                    curr = curr.children[idx];
            }
            curr.isEndOfWord = true;
      }

      public static String ans="";
      public static void longestWord(Node root , StringBuilder temp ){
            if( root == null){
                  return;
            }

            for(int i=0;i<26;i++){
                  if(root.children[i] !=null && root.children[i].isEndOfWord == true){
                        char ch =(char)(i+'a');
                        temp.append(ch);
                        if(temp.length() > ans.length()){
                              ans = temp.toString();
                        }
                        longestWord(root.children[i],temp);
                        temp.deleteCharAt(temp.length() -1); // backtracking
                        // we removed the char that we added before calling recurrsion function 
                  }
            }
      }

      public static void main(String args[]){
        //     String words[] ={"the","a","there","their","any","three"};
        //     String words[] ={"i","like","samsung","sam","mobile","very"};         
            String words[] ={"w","wo","wor","worl","world"};                        
            for(int i=0;i<words.length;i++){
                    insert(words[i]);
            }
            
        //     System.out.println(search("i") +" ");
        //     System.out.println(search("th") +" ");
            
        //     System.out.print(wordBreak("ilikesamsung")+" ");   

        longestWord(root, new StringBuilder(""));
             System.out.print(ans);     
                
      }

}