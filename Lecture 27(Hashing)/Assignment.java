import java.util.*;
class Assignment {


     static class Node{
            int data;
            Node left;
            Node right;
            int hd;

            Node(int data){
                  this.data = data;
                  this.left =null;
                  this.right =null;
                  this.hd = Integer.MAX_VALUE;
            }
    }  
      public static void helperView(Node root,int curr,int hd,Map<Integer,int[]>map){
                if(root == null){
                    return;
                }
                if(!map.containsKey(hd)){
                    map.put(hd,new int[]{root.data,curr});
                }
                else{
                    int p[] = map.get(hd);
                    if(p[1]<curr){
                        p[1] =curr;
                        p[0] = root.data;
                    }
                    map.put(hd,p);
                }

                helperView(root.left,curr+1,hd-1,map);
                helperView(root.right,curr+1,hd+1,map);

      }


    public static void assis1(Node root){
            HashMap<Integer,int[]>map = new HashMap<>();
            helperView(root,0,0,map);

            for(int[] val:map.values()){
                System.out.print(val[0]+" ");
            }
    }  

    public static void assis2self(int arr[],int k){
            HashMap<Integer,Integer>m = new HashMap<>();
            Integer a[] = new Integer[2];
            for(int i=0;i<arr.length;i++){
                    m.put(i,arr[i]);
            }

            for(int i=0,j=arr.length-1;i<j;){
                    if((arr[i] + arr[j]) == k){
                        a[0] = m.get(arr[i]);
                        a[1] =m.get(arr[j]);
                        return;
                    }
                    else if((arr[i] + arr[j]) > k){
                        j--;
                    }
                    else{
                        i++;
                    }
            }
    }
    
    public static int[] assis2(int arr[],int k){
        HashMap<Integer,Integer>m = new HashMap<>();
        Integer a[] = new Integer[2];
        for(int i=0;i<arr.length;i++){
            int diff = k-arr[i];
            if(m.containsKey(diff)){
                return new int[] {i,m.get(diff)};
            }
            m.put(arr[i],i);
        }
        return new int[] {0,0};
          
    }

    public static StringBuilder assis3(String s){
            Map<Character,Integer> m = new HashMap<>();
            for(int i=0;i<s.length();i++){
                    char ch = s.charAt(i);
                        m.put(ch,m.getOrDefault(ch,0)+1);
            }
            PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue()?a.getKey()-b.getKey():b.getValue()-a.getValue());

            for(Map.Entry<Character,Integer> e:m.entrySet()){
                    pq.add(e);
            }
            
            StringBuilder str = new StringBuilder("");
            while(pq.size() !=0){
                char ch = pq.poll().getKey();
                int val = m.get(ch);

                while(val !=0){
                    str.append(ch);
                    val--;

                }
            }

            return str;
    }
    public static void main(String args[]){
            Node root=new Node(20);root.left=new Node(8);root.right=new Node(22);root.left.left=new Node(5);root.left.right=new Node(3);root.right.left=new Node(4);root.right.right=new Node(25);root.left.right.left=new Node(10);root.left.right.right=new Node(14);

            assis1(root);

            int a[] = {2, 17,7, 15};
            int res[]=assis2(a,9);

            for(int i=0;i<res.length;i++){
                System.out.print(res[i] +" ");
            }
            
            System.out.print(assis3("bbccaaccdeddedededeeoooooppppppijbg"));
    }
}