import java.util.*;
class Assignment {
         static class Node1{
            ArrayList<String> data;
            Node1 children[] = new Node1[26];
            boolean isEndOfWord= false;

            Node1(){
                  for(int i=0;i<26 ;i++){
                        children[i]= null;
                  }
                  data= new ArrayList<>();
            }
      }

      static class Node2{
                  Node2 children[] = new Node2[26];
                  boolean isEndOfWord= false;

                  Node2(){
                        for(int i=0;i<26;i++){
                              children[i]= null;
                        }
                  }

      }

      static Node1 root1 ;
      public static Node2 root2 = new Node2();

      static ArrayList<ArrayList<String>>ans1;
      public static ArrayList<ArrayList<String>> getAnagram(String[] str){
            root1 = new Node1();
            ans1 = new ArrayList<>();

            for(String word: str){
                  build(word);
            }

            dfs(root1);


            return ans1;
      }

      public static void build(String str){
            Node1 temp=root1;
            char s[] = str.toCharArray();
            Arrays.sort(s);

            for(char c :s){
                  if(temp.children[c - 'a'] == null){
                        temp.children[c-'a'] = new Node1();
                  }
                  temp = temp.children[c -'a'];
            }
            temp.isEndOfWord = true;
            temp.data.add(str);
      }

      public static void dfs(Node1 root1){
            if(root1.isEndOfWord){
                  ans1.add(root1.data);
            }
            for(int i=0;i<26;i++){
                  if(root1.children[i] !=null){
                        dfs(root1.children[i]);
                  }
            }
      }

      public static void insert(String s){
            Node2 temp = root2;

            for(int i=0;i<s.length();i++){
                  int idx = s.charAt(i) - 'a';
                  if(temp.children[idx] == null){
                        temp.children[idx]= new Node2();
                  }
                  temp = temp.children[idx];
            }
            temp.isEndOfWord = true;
      }

      static String ans2 ="";

      public static String longestWord(Node2 root ,StringBuilder temp){
            
            if(root == null){
                  return "";
            }

            for(int i=0;i<26;i++){
                  if(root.children[i] != null && root.children[i].isEndOfWord == true){
                        char c = (char)(i+'a');
                        temp.append(c);
                        if(temp.length() > ans2.length()){
                              ans2 = temp.toString();
                        }
                        longestWord(root.children[i],temp);
                        temp.deleteCharAt(temp.length() -1);
                  }
            }
            return ans2;
      }
      
      
      public static void main(String args[]){
        //     String words[] ={"the","a","there","their","any","three"};
            // String words[] ={"eat","tea","tan","ate","nat","bat"};            
            
            // getAnagram(words);

            // for(int i=0;i<ans1.size();i++){
            //       System.out.print(ans1.get(i)+" ");
            // }    

            String words[] ={"a","banana","app","appl","ap","apply","apple"};                        
            for(int i=0;i<words.length;i++){
                    insert(words[i]);
            }
            
        //     System.out.println(search("i") +" ");
        //     System.out.println(search("th") +" ");
            
        //     System.out.print(wordBreak("ilikesamsung")+" ");   
            longestWord(root2, new StringBuilder(""));
             System.out.print(ans2);     
                
      }

}