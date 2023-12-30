
public class Detecting_cycle {

      public static class Node {
            int data;
            Node next;

            public Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      };

      public static Node head;
      public static Node tail;
      public static int size;

      // Add first
      public static void addFirst(int data) {
            Node newnode = new Node(data);
            size++;
            if (head == null) {
                  tail = head = newnode;
                  return;
            }
            // Link
            newnode.next = head;
            // New head
            head = newnode;

      }

      // Print ll
      public static void printLl() {
            Node temp = head;
            if (head == null) {
                  System.out.println("Linked List is empty");
                  return;
            }
            while (temp != null) {
                  System.out.print(temp.data + "->");
                  temp = temp.next;
            }
            System.out.println("null");
      }

      public static boolean cycle() {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;

                  if (slow == fast) {
                        return true;
                  }
            }
            return false;
      }

      public static void delete_cycle() {
            Node fast = head;
            Node slow = head;
            boolean cycle = false;
            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;

                  if (slow == fast) {
                        cycle = true;
                        break;
                  }
            }

            if (cycle == false) {
                  return;
            }

            // Finding meeting point

            slow = head;
            Node prev = null;

            while (slow != fast) {
                  prev = fast;
                  slow = slow.next;
                  fast = fast.next;
            }

            // Make prev null

            prev.next = null;
      }

      public static void main(String[] args) {

            head = new Node(1);
            //
            Node temp = new Node(2);
            head.next = temp;
            head.next.next = new Node(3);
            head.next.next.next = temp;

            System.out.println(cycle());
            delete_cycle();
            System.out.println(cycle());
            // printLl();
      }
}
