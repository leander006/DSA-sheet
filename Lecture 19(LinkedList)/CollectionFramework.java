import java.util.*;

public class CollectionFramework {

      public static void main(String[] args) {
            LinkedList<Integer> ll = new LinkedList<>();
            ll.addFirst(2);
            ll.addLast(3);
            ll.addFirst(1);
            ll.addLast(4);

            System.out.println(ll);

            ll.removeFirst();
            System.out.println(ll);

            ll.removeLast();
            System.out.println(ll);
      }
}
