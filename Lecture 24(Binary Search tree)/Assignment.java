import java.util.*;
class Assignment {
        public static class Node{
                int data;
                Node right;
                Node left;
                
                public Node(int data){
                        this.data=data;
                }
        }       
        public static Node insert(Node root, int data){
                if(root == null){
                        root=new Node(data);
                        return root;
                }
                
                if(root.data > data){
                        root.left= insert(root.left,data);                        
                }
                else{
                        root.right=insert(root.right,data);
                }
                return root;
        } 
        static int sum;
        public static void inorder(Node root){
                if(root == null){
                        return ;
                }
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
        }

        public static int Assi1(Node root ,int k1,int k2){
            Queue<Node> q = new LinkedList<>();
            if(root == null){
                  return 0;
            }
            q.add(root);
            
            while(!q.isEmpty()){
                  Node curr= q.peek();
                  q.remove();
                  if( k1<=curr.data && curr.data<=k2){
                        sum+=curr.data;
                  }

                  if(curr.left !=null && k1<=curr.data){
                        q.add(curr.left);
                  }
                  if(curr.right !=null && curr.data <=k2){
                        q.add(curr.right);
                  }
            }

            return sum;
        }

        public static int min_diff =Integer.MAX_VALUE;
        public static int min_key =-1;
        public static void Assi2(Node root, int k){
                  if(root == null){
                        return;
                  }

                  if(root.data == k){
                        min_key = k;
                        return;
                  }

                  if(min_diff > Math.abs(k-root.data)){
                        min_diff = Math.abs(k-root.data);
                        min_key =root.data;
                  }
                  if(root.data > k){
                        Assi2(root.left,k);
                  }
                  else{
                        Assi2(root.right,k);
                  }
                  // int min2= Math.min(Assi2(root.left,k),Assi2(root.right,k));
                  // System.out.println("min2 "+min2+" root "+root.data);                  
                  
        }
        
        public static void getInorder(Node root,ArrayList<Integer> arr){
                if(root == null){
                        return ;
                }
                getInorder(root.left,arr);
                arr.add(root.data);
                getInorder(root.right,arr);
        }
        
        public static int Assi3(Node root, int k){
            if(root == null){
                  return -1;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            getInorder(root,arr);
            return arr.get(k);
        }

        public static int Assi4(Node root1, Node root2,int x){
                  if(root1 == null || root2 == null){
                        return 0;
                  }
                  int count=0;
                  Stack<Node> s1= new Stack<>();
                  Stack<Node> s2 = new Stack<>();

                  Node top1,top2;
                  while(true){
                        while(root1 !=null){
                              s1.push(root1);
                              root1 =root1.left;
                        }

                        while(root2 !=null){
                              s2.push(root2);
                              root2= root2.right;
                        }
                        if(s1.isEmpty() || s2.isEmpty()){
                              break;
                        }
                        top1 = s1.peek();
                        top2 = s2.peek();
                        if((top1.data + top2.data) == x){
                        count++;
                        s1.pop();
                        s2.pop();
                        root1 = top1.right;
                        root2 =top2.left;
                        }

                        else if((top1.data + top2.data) <x){
                        s1.pop();
                        root1 = top1.right;
                        }
                        else{
                        s2.pop();
                        root2 =top2.left;
                        }

                  }
                  return count;


        }
        public static boolean isBinary(Node root){
                  if(root.right == null && root.left == null){
                        return true;
                  }
                  if(root.left !=null && root.right !=null && root.left.data<=root.data && root.data <= root.right.data){
                  System.out.println(root.left.data+" root.left.data "+root.right.data+" root.right.data "+root.data);                        
                        return true;
                  }
                  return false;
        }
        static int max=0;
        public static int Assi5(Node root){
            ArrayList<Integer> arr = new ArrayList<>();
            getInorder(root,arr);
            for(int i =0;i<arr.size() ;i++){  
                  System.out.print(arr.get(i)+" ");
            }            
            int sum=0;
            for(int i =0;i<arr.size()-2 ;i++){
                  if(arr.get(i) < arr.get(i+1) && arr.get(i+1) < arr.get(i+2)){
                        System.out.print("("+arr.get(i) + " "+ arr.get(i+1)+" "+arr.get(i+2)+")");
                        sum+=arr.get(i) +  arr.get(i+1);
                  }
            }

            return sum;
        }
        public static void main(String args[]){
		// Node root1= new Node(5);
            // root1.left = new Node(3);
            // root1.left.left = new Node(2);
            // root1.left.right = new Node(4);
            // root1.right = new Node(7);
            // root1.right.left = new Node(6);  
            // root1.right.right = new Node(8);  
		Node root1= new Node(5);
            root1.left = new Node(9);
            root1.left.left = new Node(6);
            root1.left.left.left = new Node(8);
            root1.left.left.right = new Node(7);            
            root1.right = new Node(2);
            root1.right.right = new Node(3);              
            Node root2= new Node(10);
            root2.left = new Node(6);
            root2.left.left = new Node(3);
            root2.left.right = new Node(8);
            root2.right = new Node(15);
            root2.right.left = new Node(11);  
            root2.right.right = new Node(18);  
            // System.out.print(Assi4(root1,root2,16));
            // inorder(root);

            // System.out.print(" Sum is "+Assi1(root,11,20));
            // System.out.print("\nMin is "+Assi2(root,2));
            // Assi2(root,18);
            // System.out.print("\nMin key "+ min_key
            // );

            // System.out.print("Min value "+ Assi3(root,3)
            // );
            System.out.print("\n"+Assi5(root1));

        }
}