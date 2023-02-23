public class CurcularLL {
      public static class Node {
            int data;
            Node next;

            public Node(int data) {
                  this.data = data;
            }
      };

      // Add to empty

      public Node addToEmpty(Node tail, int data) {
            if (tail != null) {
                  return tail;
            }
            Node newnode = new Node(data);
            // size++;
            // New head
            tail = newnode;
            newnode.next = tail;
            return tail;

      }

      // Add first
      public Node addFirst(Node tail, int data) {
            if (tail == null) {
                  return addToEmpty(tail, data);
            }

            Node newnode = new Node(data);
            // size++;
            newnode.next = tail.next;
            tail.next = newnode;

            return tail;

      }

      // Add tail

      public Node addtail(Node tail, int data) {
            if (tail == null) {
                  return addToEmpty(tail, data);
            }

            Node newnode = new Node(data);
            // size++;
            newnode.next = tail.next;
            tail.next = newnode;
            tail = newnode;

            return tail;

      }

      
      // Print

      public void traverse(Node tail) {
            Node p;
            if (tail == null) {
                  System.out.println("List is empty.");
                  return;
            }
            p = tail.next;
            do {
                  System.out.print(p.data + " ");
                  p = p.next;
            } while (p != tail.next);

      }

      public static void main(String[] args) {
            CurcularLL cl = new CurcularLL();
            Node tail = null;
            tail = cl.addFirst(tail, 3);
            tail = cl.addFirst(tail, 2);
            tail = cl.addFirst(tail, 1);
            tail = cl.addtail(tail, 4);
            cl.traverse(tail);
      }
}
