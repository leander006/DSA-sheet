import java.util.*;
class Assign {
    static class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                  this.data = data;
                  this.left =null;
                  this.right =null;
            }
    }  
  static class Res{
        public int val;
}
 static class BinaryTree
  {
    static Map<String,Integer> m = new HashMap<>();

    static int idx = -1;
    public static Node buildTree (int nodes[])
    {
      idx++;
      if (nodes[idx] == -1)
	{
	  return null;
	}

      Node newNode = new Node (nodes[idx]);
      newNode.left = buildTree (nodes);
      newNode.right = buildTree (nodes);

      return newNode;

    }
    public static void preOrder (Node root)
    {
      if (root == null)
	{
	  return;
	}
      System.out.print (root.data + " ");
      preOrder (root.left);
      preOrder (root.right);
    }
 
    public static String duplicate(Node root){

        if(root == null){
              return "";  
        }
        String str = "(";
        str+= duplicate(root.left);
        str+= Integer.toString(root.data);
        str+= duplicate(root.right);
        str+= ")";
        

        if(m.get(str) != null && m.get(str) == 1){
                System.out.print(root.data+" ");
        }
        // System.out.println(" m.containsKey(str) "+m.containsKey(str));
        if(m.containsKey(str)){
                m.put(str,m.get(str)+1);
        }
        else{
                m.put(str,1);
        }

        return str;
    }        
    
    public static int sum(Node root,Res res){
         if(root == null){
                 return 0;
         }
         int left = sum(root.left , res);
         int right = sum(root.right ,res);
         int single_sum = Math.max(Math.max(left,right)+root.data,root.data);
         int top_sum = Math.max(single_sum,left+right+root.data);
         res.val = Math.max(res.val,top_sum);
         return single_sum;
    }
  }
      public static void main (String args[])
  {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

    BinaryTree tree = new BinaryTree ();
//     Node root = tree.buildTree (nodes);
Node root = null;root = new Node(1);root.left = new Node(2);root.right = new Node(3);root.left.left = new Node(4);root.right.left = new Node(2);root.right.left.left = new Node(4);root.right.right = new Node(4);
// Node root = new Node(10);root.left = new Node(2);root.right = new Node(10);root.left.left = new Node(20);root.left.right = new Node(1);root.right.right = new Node(-25);root.right.right.left = new Node(3);root.right.right.right = new Node(4);


//     tree.duplicate(root);
        Res res =new Res();
        res.val=0;
        tree.sum(root,res);
        System.out.println( " Sum is "+ res.val );


  }
}