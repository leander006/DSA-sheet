import java.util.*;
class OperationInHeap {
    
      public static class Heap{
            ArrayList<Integer> arr = new ArrayList<>();
            public void add(int data){
                  arr.add(data);

                  int x = arr.size() -1; //Child index
                  int par = (x-1) /2; //Parent index

                  while(arr.get(x) < arr.get(par)){
                        //Swap
                        int temp = arr.get(x);
                        arr.set(x,arr.get(par));
                        arr.set(par,temp);

                        x=par;
                        par = (x-1)/2;
                  }

            }

            public int peek(){
                  return arr.get(0);
            }
            public void heapify(int i){
                  int left = 2*i+1;
                  int right = 2*i+2;
                  int minIdx = i;

                  if(left<arr.size() && arr.get(minIdx) > arr.get(left)){
                        minIdx = left;
                  }
                  if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                        minIdx = right;
                  }

                  if(minIdx !=i ){
                        int temp = arr.get(i);
                        arr.set(i,arr.get(minIdx));
                        arr.set(minIdx,temp);
                        heapify(minIdx);
                  }
            }
            public boolean isEmpty(){
                  return arr.size() == 0;
            }
            public int remove(){
                  int data = arr.get(0);

                  // Swap
                  int temp = arr.get(0);
                  arr.set(0,arr.get(arr.size()-1));
                  arr.set(arr.size()-1,temp);

                  // Remove
                  arr.remove(arr.size()-1);
                  // Maintain heap
                  heapify(0);
                  return data;

            }

            public void heapifyArr(int arr[] ,int i,int size){
                  int left = 2*i+1;
                  int right = 2*i+2;
                  int maxIdx = i;

                  if(left < size && arr[left] < arr[maxIdx]){
                        maxIdx = left;
                  }

                  if(right < size && arr[right] < arr[maxIdx]){
                        maxIdx = right;
                  }

                  if(maxIdx !=i){
                        int temp = arr[i];
                        arr[i] = arr[maxIdx];
                        arr[maxIdx]= temp;

                        heapifyArr(arr,maxIdx,size);
                  }
            }

            public void heapSort(int arr[]){
                  int n = arr.length;

                  //Step 1 : Build max heap
                  for(int i =n/2 ; i>=0 ;i--){
                        heapifyArr(arr,i,n);
                  }

                  // Step 2 : Push arr at end

                  for(int i=n-1 ;i>0 ;i--){
                        int temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;

                        heapifyArr(arr,0,i);
                  }
            }
      }
      public static void main(String args[]){
            Heap h = new Heap();
            h.add(3);
            h.add(4);
            h.add(1);
            h.add(5);
            int arr[] = {1,5,3,4,2};
            for (var i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
                
            }
            System.out.println("");
            h.heapSort(arr);
             for (var i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
                
            }           
            // while(!h.isEmpty()){
            //       System.out.print(h.peek() +" ");
            //       h.remove();
            // }
      }
}