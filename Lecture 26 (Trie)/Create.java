public class Create{
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

      public static boolean search(String key){
            Node curr = root;
            for(int level=0;level<key.length();level++){
                    int idx = key.charAt(level) - 'a';
                    if(curr.children[idx] == null){
                        return false;
                    }
                    curr = curr.children[idx];
            }
            return curr.isEndOfWord == true;
      }                  

      public static boolean wordBreak(String word){
              if(word.length() == 0){
                      return true;
              }
             for(int i=1;i<=word.length();i++){
                if(search(word.substring(0,i)) && wordBreak(word.substring(i))){
                       return true;
               }
               
            }
                return false;
        }        

      public static void main(String args[]){
        //     String words[] ={"the","a","there","their","any","three"};
            String words[] ={"i","like","samsung","sam","mobile","very"};            
            for(int i=0;i<words.length;i++){
                    insert(words[i]);
            }
            
        //     System.out.println(search("i") +" ");
        //     System.out.println(search("th") +" ");
            
            System.out.print(wordBreak("ilikesamsung")+" ");    
                
                
      }

}