class TreeToDLL {
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
    static Node prev =null,head =null;

    public static void convert(Node root){
      if(root == null) return ;
      convert(root.left);
      if(prev == null ) head = root;
      else{
            root.left = prev;
            prev.right = root;
      }
      prev = root;
      convert(root.right);
    }

    public static void main(Strings args[]){

            Node root = new Node(1);

            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.right = new Node(5);

            
    }
}