public class ZigZag {
      public static class Node {
            int data;
            Node next;

            public Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      };

      public Node head;
      public Node tail;
      public int size;

      // Add first
      public void addFirst(int data) {
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
      public void printLl() {
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

      public void zigZag() {
            // Find mid
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            Node mid = slow;

            // Reverse ll

            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;

            while (curr != null) {
                  next = curr.next;
                  curr.next = prev;
                  prev = curr;
                  curr = next;
            }

            // Alt merge zigzag

            Node left = head;
            Node right = prev;
            Node nextL ,nextR;

            while(left !=null && right !=null){
                  nextL = left.next;
                  left.next = right;
                  nextR = right.next;
                  right.next = nextL;

                  left = nextL;
                  right = nextR;
            }
      }

      public static void main(String[] args) {
            ZigZag ll = new ZigZag();
            ll.addFirst(5);
            ll.addFirst(4);
            ll.addFirst(3);
            ll.addFirst(2);
            ll.addFirst(1);

            ll.printLl();

            ll.zigZag();

            ll.printLl();
      }
}
