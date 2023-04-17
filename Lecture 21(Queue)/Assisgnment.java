import java.util.*;
class Assisgnment {

    static class job{
            char job_id;
            int profit;
            int deadline;

            job(char job_id,int profit, int deadline){
                  this.deadline = deadline;
                  this.job_id = job_id;
                  this.profit = profit;
            }

    }  



    public static void assis1(int n){
            Queue<String> q = new ArrayDeque<>();
            q.add("1");
            while( n -- >0){
                  String s1 = q.peek();
                  q.remove();
                  System.out.print(s1+" ");
                  q.add(s1+"0");
                  q.add(s1+"1");
            }
    }
    
    

    public static int assis2(int arr[]){
            Queue<Integer> q = new PriorityQueue<>();
            for(int i=0;i<arr.length ;i++ ){ 
                  q.add(arr[i]);
            }
            int res=0;
            while(q.size()>1){
                  int ele1 = q.poll();
                  int ele2 = q.poll();
                  res+=ele1 + ele2;
                  q.add(ele2+ele1);
            }
            return res;
    }

    public static void assis3(ArrayList<job> arr){
            int n = arr.size();
            Collections.sort(arr, (a, b) -> {return b.profit - a.profit;});

            int max=0;
            for(int i=0;i<n;i++){
                  if(arr.get(i).deadline >max){
                        max = arr.get(i).deadline;
                  }
            }
            char res[] = new char[max+1];
            for(int i=0;i<n;i++){
                  res[i]=' ';
            }
            int profit =0,countJob=0;
            for(int i=0;i<n;i++){
                  for(int j=arr.get(i).deadline ;j>0;j--){
                        if(res[j] ==' '){
                              res[j] =arr.get(i).job_id;
                              countJob++;
                              profit +=arr.get(i).profit;
                              // System.out.print(" i "+ i +" "+ "j " +j);
                              break;
                        }
                  }
            }
            for(int i=0;i<n+1;i++){
                  System.out.print(res[i]);
            }
    }

    public static void assis4(Queue<Integer> q,int k){
            Stack<Integer> s = new Stack<>();
            int k1=k;
            while(k --> 0){
                  s.add(q.remove());
            }
            while(!s.isEmpty()){
                  q.add(s.pop());
            }

            for(int i =0;i< q.size()-k1;i++){
                  q.add(q.remove());
            }
    }

    public static void assis5(int arr[],int k,int n){
            ArrayDeque <Integer> dq = new ArrayDeque<>();

            int i=0,j=0;
            while(j<arr.length){
                  while(!dq.isEmpty() && arr[j] > dq.peekLast()){
                        dq.removeLast();
                  }
                  dq.addLast(arr[j]);
                  if(j-i+1 < k){
                        j++;
                  }
                  
                  if(j-i +1 == k){
                        System.out.print(dq.peekFirst() + " ");
                        if(dq.peekFirst() == arr[i]){
                              dq.removeFirst();
                        }
                        i++;
                        j++;
                  }
            }
    }

    public static void main(String args[]){
            // assis1(5);
            int[] res={4,3,2,6,4,2,8,9};
            Queue<Integer> q = new ArrayDeque<>();
            q.add(10);
            q.add(20);
            q.add(30);
            q.add(40);
            q.add(50);
            q.add(60);
            q.add(70);
            q.add(80);
            q.add(90);
            q.add(100);
            ArrayList<job> arr = new ArrayList<job>();
            arr.add(new job('a', 20, 4));arr.add(new job('b', 10, 1));arr.add(new job('c', 40, 1));arr.add(new job('d', 30, 1));
           assis3(arr);
            // System.out.print(assis2(res));
            // while(!q.isEmpty()){
            //       System.out.print(q.remove()+" ");
            // }
            // assis4(q,5);
            // while(!q.isEmpty()){
            //       System.out.print(q.remove()+" ");
            // }
            // assis5(res,3,q.size());
    }
}