import java.util.*;
class View {
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
     static class Pair{
            int hd;
            Node node;

            Pair(int hd,Node node){
                this.hd = hd;
                this.node = node;
            }
    }     
    public static void LeftView(Node root,ArrayList<Node> arr,int level){
        if(root == null){
                return;
        }

        if(level == arr.size()){
                arr.add(root);
        }

        LeftView(root.left,arr,level+1);
        LeftView(root.right,arr,level+1);

        // For right view call first root.right then root.left

    }
    public static List<List<Integer>> helper(Node root,int idx){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            // for(int i=0;i<size;i++){
                Node curr = q.remove();
                list.add(curr.data);
                idx++;
                System.out.print(curr.data+" ");
                if(idx % 2 == 0){
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
                else{
                    if(curr.right != null){
                        q.add(curr.right);
                    } 
                     if(curr.left != null){
                        q.add(curr.left);
                    }                  
                }
            // }
            idx++;
            // res.add(list);
        }
        return res;
    }
    public static void TopView(Node root){
                Queue<Pair> q = new LinkedList<>();
                Map<Integer,Integer> m = new TreeMap<>();
                q.add(new Pair(0,root));

                while(!q.isEmpty()){
                        Pair p = q.poll();
                        // for bottom view remove if condition
                        if(!m.containsKey(p.hd)){
                            m.put(p.hd,p.node.data);
                        }
                        if(p.node.left != null){
                                q.add(new Pair(p.hd-1,p.node.left));
                        }
                        if(p.node.right != null){
                                q.add(new Pair(p.hd+1,p.node.right));
                        }       
                }

                for(Map.Entry<Integer,Integer> e:m.entrySet()){
                        System.out.print(e.getValue());
                }
    }
    public static void main(String args[]){
            Node root = new Node(1);

            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.right = new Node(5);

            ArrayList<Node> arr = new ArrayList<>();
        //     LeftView(root,arr,0);
            TopView(root);
        //     helper(root,0);

        //     for(Node a : arr){
        //         System.out.print(a.data+" ");
        //     }
    }

}