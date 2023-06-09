import java.util.*;
class Implementation {

      static class HashMap<K,V>{
            private class Node{
                  K key;
                  V value;

                  public Node(K key, V value){
                        this.key = key;
                        this.value = value;
                  }
            }
                  private int n;
                  private int N;

                  private LinkedList<Node> bucket[];
                  @SuppressWarnings("unchecked")
                  public HashMap(){
                       this.N = 4;
                       this.bucket = new LinkedList[4];
                        for(int i=0;i<4;i++){
                              this.bucket[i] = new LinkedList<>();
                        }
                  }

                  private int hashFunction(K key){
                        int hc = key.hashCode();
                        return Math.abs(hc) % N ;
                  }

                  private int searchLL(K key, int bi){
                        LinkedList<Node> ll = bucket[bi];
                        int di=0;

                        for(int i=0;i<ll.size();i++){
                              Node node = ll.get(i);
                              if(node.key == key){
                                    return di;
                              }
                              di++;
                        }
                        return -1;
                  }
                  @SuppressWarnings("unchecked")
                  private void rehash(){
                        LinkedList<Node> oldBucket[] = bucket;
                        bucket = new LinkedList[N*2];
                        N = 2*N;
                        for(int i=0;i<bucket.length;i++){
                              bucket[i]= new LinkedList<>();
                        }

                        // Node -> add again

                        for(int i=0;i<oldBucket.length;i++){
                              LinkedList<Node> ll = oldBucket[i];
                              for(int j=0;j<ll.size();j++){
                                    Node node = ll.remove();
                                    put(node.key,node.value);
                              }
                        }
                  }
                  public void put(K key , V value){
                        int bi = hashFunction(key);
                        int di = searchLL(key,bi);
                        if(di !=-1){
                              Node node = bucket[bi].get(di);
                              node.value = value;
                        }
                        else{
                              bucket[bi].add(new Node(key,value));
                              n++;
                        }

                        double lambda = (double)n/N;
                        if(lambda >2){
                              rehash();
                        }

                  }

                  public boolean containsKey(K key){
                        int bi = hashFunction(key);
                        int di = searchLL(key,bi);
                        if(di != -1){
                              return true;
                        }
                        else{
                              return false;
                        }
                  }

                  public V get(K key){
                        int bi = hashFunction(key);
                        int di = searchLL(key,bi);

                        if(di !=-1){
                              Node node = bucket[bi].get(di);
                              return node.value;
                        }
                        else{
                             return null;
                        }  
                  }
                  public V remove(K key){
                        int bi = hashFunction(key);
                        int di = searchLL(key,bi);

                        if(di !=-1){
                              Node node = bucket[bi].remove(di);
                              n--;
                              return node.value;
                        }
                        else{
                             return null;
                        }  
                  }
                  public ArrayList<K>keySet(){
                        ArrayList<K> keys = new ArrayList<>();
                        for(int i=0;i<bucket.length;i++){
                              for (Node node :bucket[i]) {
                                   keys.add(node.key); 
                              }
                        }
                        return keys;
                  }

                  public boolean isEmpty(){
                        return n==0;
                  }
      }


    public static void main(String[] args){
            HashMap<String,Integer> hm = new HashMap<>();
            hm.put("India",100);
            hm.put("China",150);
            hm.put("Nepal",40);

            // ArrayList<String>ll =hm.keySet();
            for ( String key:hm.keySet()) {
                 System.out.println(key);
            }
            
    }
}