public class BuildTree {
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

        static class Info{
                int dia;
                int hei;
                
                Info(int dia ,int hei){
                        this.dia = dia;
                        this.hei = hei;
                }
        }
        // static class Info{
        //         Node node;
        //         int hd;
                
        //         public Info(Node node ,int hd){
        //                 this.node = node;
        //                 this.hd = hd;
        //         }
        // }  

     static class BinaryTree{
               static class Info{
                Node node;
                int hd;
                
                public Info(Node node ,int hd){
                        this.node = node;
                        this.hd = hd;
                }
        }  
            static int idx =-1;
            public static Node buildTree(int nodes[]){
                  idx++;
                  if(nodes[idx] == -1){
                        return null;
                  }
                  
                  Node newNode = new Node(nodes[idx]);
                  newNode.left= buildTree(nodes);
                  newNode.right = buildTree(nodes);
                  
                  return newNode;

            }
            public static void preOrder(Node root){
                    if(root == null){
                        //     System.out.print("-1 ");
                            return;
                    }
                    System.out.print(root.data+" ");
                    preOrder(root.left);
                    preOrder(root.right);
            }
        //     public static void inOrder(Node root){
        //             if(root == null){
        //                 //     System.out.print("-1 ");
        //                     return;
        //             }
        //             inOrder(root.left);
        //             System.out.print(root.data+" ");                    
        //             inOrder(root.right);
        //     }  
        //     public static void postOrder(Node root){
        //             if(root == null){
        //                 //     System.out.print("-1 ");
        //                     return;
        //             }
        //             postOrder(root.left);
        //             postOrder(root.right);
        //             System.out.print(root.data+" ");   
        //     }   
            
        //     public static void levelOrder(Node root){
        //         if(root == null){
        //                 return;
        //         } 
                
        //         Queue<Node> q = new LinkedList<>();
        //         q.add(root);
        //         q.add(null);
                
        //         while(!q.isEmpty()){
        //                 Node currentNode = q.remove();
        //                 if(currentNode == null){
        //                         System.out.println("");
        //                         if(q.isEmpty()){
        //                                 return;
        //                         }
        //                         else{
        //                                 q.add(null);
        //                         }
        //                 }
        //                 else{
        //                       System.out.print(currentNode.data+" ");  
        //                       if(currentNode.left != null){
        //                               q.add(currentNode.left);
        //                       }
        //                       if(currentNode.right !=null){
        //                               q.add(currentNode.right);
        //                       }
        //                 }
        //         }
        //     }
            
        //     public static int height(Node root){
        //          if(root == null){
        //                 return 0; 
        //          }  
                 
        //          return Math.max(height(root.left),height(root.right)) +1;
        //     }
        //     public static int count(Node root){
        //          if(root == null){
        //                 return 0; 
        //          }  
                 
        //          return (count(root.left)+count(root.right)) +1;
        //     }
  
        //     public static int sum(Node root){
        //          if(root == null){
        //                 return 0; 
        //          }  
                 
        //          return (sum(root.left)+sum(root.right))+ root.data ;
        //     }
        //     public static int diameter1(Node root){
        //         if(root == null){
        //                 return 0;
        //         } 
        //         int leftDiameter = diameter1(root.left);
        //         int rightDiameter = diameter1(root.right);
        //         int leftHeight = height(root.left);
        //         int rightHeight = height(root.right);
                
        //         int selfHeight = leftHeight + rightHeight +1;
                
        //         return Math.max(selfHeight,Math.max(leftHeight,rightHeight));
        //     }
            
        //     public static Info diameter(Node root){
        //         if( root == null){
        //                 return new Info(0,0);
        //         }
        //         Info leftInfo = diameter(root.left);
        //         Info rightInfo = diameter(root.right);
                
        //         int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia),leftInfo.hei + rightInfo.hei+1 );
        //         int hei = Math.max(leftInfo.hei, rightInfo.hei) + 1;
                
        //         return new Info(dia,hei);
        //     }
            
        //     public static boolean isIdentical(Node root , Node subRoot){
        //             if(root == null && subRoot == null){
        //                     return true;
        //             }
        //             else if(root == null || subRoot == null || root.data != subRoot.data){
        //                     return false;
        //             }
        //             if(!isIdentical(root.left, subRoot.left)){
        //                     return false;
        //             }
        //             if(!isIdentical(root.right, subRoot.right)){
        //                     return false;
        //             } 
        //             return true;
        //     }
        //     public static boolean isSubTree(Node root , Node subRoot){
        //         if(root == null){
        //                 return false;
        //         }   
        //         if(root.data  == subRoot.data){
        //                 return isIdentical(root,subRoot);
        //         }
        //         return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
        //     }
        public static void KthLevel(Node root,int level , int k){
                if(root == null){
                        return;
                }
                if( level == k ){
                        System.out.print(root.data +" ");
                        return;
                }
                
                KthLevel(root.left,level+1,k);
                KthLevel(root.right,level+1,k);
        }
            
            public static void topView(Node root){
                Queue<Info> q = new LinkedList<>();
                Map<Integer,Node> m = new HashMap<>();
                
                int min=0,max=0;
                q.add(new Info(root,0));
                q.add(null);
                
                while(!q.isEmpty()){
                        Info curr = q.remove();
                        if(curr == null){
                                if(q.isEmpty()){
                                        break;
                                }
                                else{
                                        q.add(null);
                                }
                        }
                        else{
                        if(!m.containsKey(curr.hd)){
                                m.put(curr.hd,curr.node);
                        }
                        if(curr.node.left !=null){
                                q.add(new Info(curr.node.left,curr.hd-1));
                                min = Math.min(min,curr.hd-1);
                        }
                        if(curr.node.right !=null){
                                q.add(new Info(curr.node.right,curr.hd+1));
                                max = Math.max(max,curr.hd+1);
                        }   
                        }                     
                }
                
                for(int i=min;i<=max;i++){
                        System.out.print(m.get(i).data+" ");
                }
                System.out.println("");
            }
            
            public static boolean getPath(Node root , int n, ArrayList<Node> path){
                    if(root == null){
                        return false;
                    }
                    path.add(root);
                    if( root.data == n){
                            return true;
                    }
                    
                    boolean leftPath = getPath(root.left,n,path);
                    boolean rightPath = getPath(root.right,n,path);
                    
                    if(leftPath || rightPath)
                    {
                        return true;    
                    }
                   
                    path.remove(path.size() -1);
                    return false;
            }
            
            public static Node lca(Node root ,int n1, int n2){
                    ArrayList<Node>path1 = new ArrayList<>();
                    ArrayList<Node>path2 = new ArrayList<>();
                    
                    getPath(root,n1,path1);
                    getPath(root,n2,path2);
                    
                    int i=0;
                    for(;i<path1.size() && i<path2.size() ;i++){
                            if(path1.get(i) != path2.get(i)){
                                break;
                            }
                    }
                    
                    Node lca = path1.get(i-1);
                    
                    return lca;
                    
            }
            
            public static Node lca2(Node root , int n1,int n2){
                    if( root == null || root.data ==n1 || root.data == n2){
                            return root;
                    }
                    
                    Node leftLca2 = lca2(root.left,n1,n2);
                    Node rightLca2 = lca2(root.right,n1,n2);
                    
                    if( leftLca2 == null){
                            return rightLca2;
                    }
                    
                    if(rightLca2 == null){
                            return leftLca2;
                    }
                    
                    return root;
            }
            
            public static int lcaDist(Node root ,int n){
                    if(root == null){
                            return -1;
                    }
                    if(root.data == n){
                            return 0;
                    }
                    
                    int leftDist = lcaDist(root.left,n);
                    int rightDist = lcaDist(root.right,n);
                    
                    if(leftDist == -1 && rightDist == -1){
                            return -1;
                    }else if(leftDist == -1){
                            return rightDist +1;
                    }
                    else{
                            return leftDist +1;
                    }
                    
                    
            }
            
            public static int minDis(Node root , int n1,int n2){
                    Node lca = lca2(root,n1,n2);
                    int dist1 = lcaDist(lca,n1);
                    int dist2 = lcaDist(lca,n2);
                    
                    return dist1 + dist2;
            }
            
            public static int kthAncestor(Node root , int n ,int k){
                    if(root == null){
                            return -1;
                    }
                    if(root.data == n){
                            return 0;
                    }
                    
                    int leftAnc = kthAncestor(root.left,n,k);
                    int rightAnc = kthAncestor(root.right,n,k);
                    
                    if(leftAnc == -1 && rightAnc ==-1){
                            return -1;
                    }
                    
                    int max = Math.max(leftAnc,rightAnc);
                    if(max +1 == k){
                           System.out.print(root.data+" ");
                    }
                    
                    return max+1;
                    
            }
            
            public static int sumTree(Node root){
                    if(root == null){
                        return 0;    
                    }
                    
                    int left=sumTree(root.left);
                    int right=sumTree(root.right);
                    
                    int data =root.data;
                    root.data = left+ right;
                    return data;
                    
                    
            }
    }
    public static void main(String args[]){
        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root=tree.buildTree(nodes);
        
        tree.preOrder(root);
        tree.inOrder(root);
        tree.postOrder(root);
        tree.levelOrder(root);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.print("height " + tree.height(root));
         System.out.print("count " + tree.count(root));
         System.out.print("sum " + tree.sum(root));        
        System.out.print("Root "+ root.data);
        System.out.print("diameter "+tree.isSubTree(root, subRoot));
        tree.topView(root);
        tree.KthLevel(root,0,2);
        System.out.print(tree.lca2(root,5,4).data+" ");
        System.out.print(tree.minDis(root,4,6)+" ");
        tree.kthAncestor(root,4,);
        System.out.println("");
        tree.sumTree(root);
        System.out.println("");        
        tree.preOrder(root);
        
        
    }
}