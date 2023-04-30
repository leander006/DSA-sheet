import java.util.*;
class BuildTree{
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
        
        public static void inorder(Node root){
                if(root == null){
                        return ;
                }
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
        }
        
        public static boolean search(Node root, int val){
                if(root == null){
                        return false;
                }
                if(root.data == val){
                        return true; 
                }
                
                if(root.data > val){
                        return search(root.left,val);
                }
                else{
                        return search(root.right,val);
                }
        }
        
        public static Node delete(Node root , int val){
                if(root.data < val){
                        root.right = delete(root.right,val);
                }        
                else if(root.data > val){
                       root.left = delete(root.left,val);
                }
                else{
                        if(root.left == null && root.right == null){
                                return null;
                        }
                        
                        if(root.left == null){
                                return root.right;
                        }
                        else if(root.right == null){
                                return root.left;
                        }
                        Node IS = findInorderSuccessor(root.right);
 
                        root.data = IS.data;
                        root.right = delete(root.right,IS.data);
                }
                
                return root;
        }
        
        public static Node findInorderSuccessor(Node root){
                while( root.left != null){
                        root = root.left;
                }
                return root;
        }
        
        public static void print(Node root, int r1 , int r2){
            if(root == null){
                  return;
            }

            if(r1 <= root.data  && root.data <= r2){
                  print(root.left,r1,r2);
                  System.out.print(root.data+" ");
                  print(root.right,r1,r2);
            }

            else if(r1 < root.data){
                  print(root.left,r1,r2);              
            }
            else{
                  print(root.right,r1,r2);             
            }
        }

        public static void branchPrint(Node root, ArrayList <Integer> arr){
            if(root == null){
                  return;
            }
            arr.add(root.data);
            if(root.left == null && root.right == null){
                  printArray(arr);
            }
            branchPrint(root.left,arr);
            branchPrint(root.right,arr);
            arr.remove(arr.size()-1);
        }

        public static void printArray(ArrayList<Integer> arr){
            for(int i=0;i<arr.size();i++){
                  System.out.print(arr.get(i) + "->");
            }
            System.out.println("Null");
        }

        public static boolean isValid(Node root, Node min , Node max){
            if(root == null){
                  return true;
            }
            if( min != null && root.data <= min.data){
                  return false;
            }

            if( max !=null && root.data >= max.data){
                  return false;
            }

            return isValid(root.left,min,root) && isValid(root.right,root,max);
        }

        public static Node mirror(Node root){
            if(root ==null){
                  return null;
            }

            Node lefts = mirror(root.left);
            Node rights = mirror(root.right);

            root.left=rights;
            root.right = lefts;

            return root;
        }

        public static Node createBst(int a[], int s,int e){

                  if(s>e){
                        return null;
                  }
                  int mid = (s+e)/2;

                  Node root = new Node(a[mid]);
                  root.left = createBst(a,s,mid-1);
                  root.right = createBst(a,mid+1,e);

                  return root;
        }

        public static Node createBalBst(ArrayList <Integer> arr, int s,int e){
            if(s > e){
                  return null;
            }
            int mid = (s+e)/2;
            Node root = new Node(arr.get(mid));
            root.left = createBalBst(arr,s,mid-1);
            root.right = createBalBst(arr,mid+1,e);
            return root;
        }
        public static void getInorder(Node root , ArrayList<Integer> arr){
                  if(root ==  null){
                        return;
                  }

                  getInorder(root.left,arr);
                  arr.add(root.data);
                  getInorder(root.right,arr);
        }
        public static Node BalancedBST(Node root){
                  ArrayList<Integer> arr = new ArrayList<>();

                  getInorder(root,arr);
                  
                  root = createBalBst(arr,0,arr.size()-1);

                  return root;
        }

        static class Info{
            boolean isBST;
            int size;
            int min;
            int max;
            
            Info(boolean isBST, int size, int min ,int max){
                  this.isBST = isBST;
                  this.size = size;
                  this.min = min;
                  this.max = max;
            }
        }

        public static int maxSize =0;
        public static Info isBST(Node root){
            if(root == null){
                  return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }

            Info leftInfo= isBST(root.left);
            Info rightnfo = isBST(root.right);

            int size = leftInfo.size + rightnfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min,rightnfo.min));
            int max = Math.max(root.data,Math.max(leftInfo.max,rightnfo.max));

            if(root.data <= leftInfo.max || root.data >= rightnfo.min){
                  return new Info(false,size,min,max);
            }

            if(leftInfo.isBST && rightnfo.isBST){
                  maxSize = Math.max(maxSize,size);                
                  return new Info(true,size,min,max);
            }

            return new Info(false,size,min,max);
        }


        public static Node merge(Node root1, Node root2){
                  ArrayList<Integer> arr1 = new ArrayList<>();
                  ArrayList<Integer> arr2 = new ArrayList<>();
                  ArrayList<Integer> res = new ArrayList<>();

                  getInorder(root1,arr1);
                  getInorder(root2,arr2);

                  int i = 0;
                  int j = 0;

                  while(i < arr1.size() && j< arr2.size()){
                        if(arr1.get(i) < arr2.get(j)){
                              res.add(arr1.get(i));
                              i++;
                        }
                        else{
                              res.add(arr2.get(j));
                              j++;
                        }
                  }
                  while(i<arr1.size()){
                        res.add(arr1.get(i));
                        i++;
                  }

                  while(j<arr2.size()){
                        res.add(arr2.get(j));
                        j++;
                  }
                  
                  Node root = createBalBst(res,0,res.size()-1);

                  return root;
        }

	public static void main(String[] args) {
		int val[] = {8,5,3,1,4,6,10,11,14};
		Node root= new Node(8);
		
		for(int i=0;i<val.length;i++){
		        root =insert(root,val[i]);
		        
		}
            int a[] ={3,5,6,8,10,11,12};
         
            root.left = new Node(6);
            root.left.left = new Node(5);
            root.left.left.left = new Node(3);
            root.right = new Node(10);
            root.right.right = new Node(11);
            root.right.right.right = new Node(12);
            // Node root = createBst(a,0,a.length-1);
            // Node root= new Node(50);
            root.left = new Node(30);
            root.left.left = new Node(5);
            root.left.right = new Node(20);

            root.right = new Node(60);
            root.right.left = new Node(45);            
            root.right.right = new Node(70);
            root.right.right.left = new Node(65);            
            root.right.right.right = new Node(80);
		inorder(root);
            Node root2 =BalancedBST(root);
            System.out.println("");
            inorder(root2);
            System.out.println( "\n Largest size "+maxSize);
            Info info= isBST(root);
            System.out.println( " Largest size "+maxSize);         
            print(root,3,10);
            branchPrint(root,new ArrayList<> ());
            System.out.println(isValid(root,null,null));
            mirror(root);
            inorder(root);
	      delete(root,5);
            inorder(root);

            Node root1 = new Node(2);
            root1.left = new Node(1);
            root1.right = new Node(3);

            Node root2 = new Node(9);
            root2.left = new Node(4);
            root2.right = new Node(11);

            Node res = merge(root1,root2);

            inorder(res);

	}
}