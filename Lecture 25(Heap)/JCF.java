
import java.util.*;
class JCF {

      static class Student implements Comparable<Student>{
            String name;
            int rank;

            public Student(String name,int rank){
                  this.name=name;
                  this.rank=rank;
            }

            @Override
            public int compareTo(Student s2){
                  return this.rank -s2.rank;
            }
      }

    public static void main(String args[]){
            // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            // pq.add(2);
            // pq.add(3);
            // pq.add(1);
            // pq.add(7);

            PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.add(new Student("leander",99));
            pq.add(new Student("knock",98));
            pq.add(new Student("Angela",101));
            pq.add(new Student("yu",69));
            while(!pq.isEmpty()){
                  System.out.print(pq.peek().name +" ");
                  pq.remove();
            }
    }
}