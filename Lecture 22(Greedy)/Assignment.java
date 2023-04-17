import java.util.*;
class Assignment {
    
    static int ans = 100000000;  
    public static void ass1(String s){
            int l=0,r=0,count=0;
            for(int i=0;i<s.length();i++){
                  if(s.charAt(i) == 'L'){
                        l++;
                  }
                  else{
                        r++;
                  }
                  if(l ==r){
                        count++;
                        l=0;
                        r=0;
                  }
            }

            System.out.print("Count is "+ count);
    }  

    public static int ass2(int[] range , int k){
            if(k < 0){
                  return 0;
            }
            int l = range[0];
            int r = range[1];

            if( (r  & 1) > 0){
                  int count = (int)Math.ceil((r-l+1)/2);
                  if(k > count){
                        return 0;
                  }
                  else{
                        return ( r - 2*k +2);
                  }
            }
            else{
                  int count = (r-l +1)/2;
                  if(k> count){
                        return 0;
                  }
                  else{
                        return ( r - 2*k +1);
                  }
            }
    }

    public static char [] ass3(int n ,int k){
            char []arr = new char[n];
            Arrays.fill(arr,'a');

            for(int i = n-1; i>=0 ;i--){
                  k-=i;
                  if(k >=0){
                        if(k >=26){
                              arr[i] = 'z';
                              k -= 26;
                        }
                        else{
                              arr[i] = (char)(k + 97 -1);
                              k -= arr[i] - 'a'+1;
                              System.out.print("k"+i +" "+k+" ");
                        }
                  }
                  else{
                        break;
                  }
                  k+=i;
            }
            return arr;
    }
    public static void ass4(int arr[]){
            int res[][] = new int[arr.length][2];
            int Profit =0;
            for(int i=0;i<res.length;i++){
                  res[i][0]=i;
                  res[i][1] =arr[i];
            }
            Arrays.sort(res , Comparator.comparingDouble( o -> o[1]));
            // for(int i=0;i<res.length;i++){
            //       System.out.print(res[i][0]+ " "+ res[i][1]+" ");
            // }
            for(int i=res.length -1 ;i>0;i--){
                  // System.out.print(res[i][0]+ " "+ res[i][1]+" ");
                 if((res[i][0] > res[0][0]) && (res[i][1]> res[0][1])){
                  // System.out.print(res[i][0]+ " "+ res[i][1]+" ");
                        Profit =res[i][1] - res[0][1];
                        break;
                 }
            }
            System.out.print(Profit);
    }
    public static void ass5(int arr[],int n,int k ,int index,int sum,int maxSum){
            if(k ==1){
                  maxSum = Math.max(sum,maxSum);
                  sum=0;
                  for(int i= index ; i<n;i++){
                        sum +=arr[i];
                  }
                  maxSum = Math.max(sum,maxSum);
                  ans = Math.min(maxSum,ans);
                  return;
            }
            sum=0;
            for(int i=index;i<n;i++){
                  sum +=arr[i];
                  maxSum = Math.max(maxSum,sum);
                  ass5(arr,n,k-1,i+1,sum,maxSum);                 
            }

    }
    public static void main(String args[]){
            String s = "LRRRRLLRLLRL";
            // ass1(s);
            // int arr[]={-10,10};
            // System.out.print(ass2(arr,8));
            // System.out.print(ass3(5,42));
            // int arr[] = {7, 1, 5, 3, 6, 4};
            int arr[] ={1, 2, 3, 4};
            // ass4(arr);
            ass5(arr,4,3,0,0,0);
            System.out.print(ans);     
    }
}