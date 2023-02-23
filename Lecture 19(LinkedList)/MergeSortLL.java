public class MergeSortLL {

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

      // Get mid

      public Node getMid(Node head) {
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
            }

            return slow;
      }

      public Node mergeSort(Node head) {
            if (head == null || head.next == null) {
                  return head;
            }
            Node mid = getMid(head);
            Node rightHead = mid.next;
            mid.next = null;

            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);

            return merge(newLeft, newRight);
      }

      private Node merge(Node head1, Node head2) {
            Node mergedLL = new Node(-1);
            Node temp = mergedLL;

            while (head1 != null && head2 != null) {
                  if (head1.data <= head2.data) {
                        temp.next = head1;
                        head1 = head1.next;
                        temp = temp.next;
                  } else {
                        temp.next = head2;
                        head2 = head2.next;
                        temp = temp.next;
                  }
            }

            while (head1 != null) {
                  temp.next = head1;
                  head1 = head1.next;
                  temp = temp.next;
            }
            while (head2 != null) {
                  temp.next = head2;
                  head2 = head2.next;
                  temp = temp.next;
            }

            return mergedLL.next;
      }


      public static void main(String[] args) {
            MergeSortLL LL = new MergeSortLL();
            LL.addFirst(2);
            LL.addFirst(3);
            LL.addFirst(4);
            LL.addFirst(5);
            LL.addFirst(6);
            LL.addFirst(7);

            LL.printLl();
            LL.head = LL.mergeSort(LL.head);

            LL.printLl();
      }
}
