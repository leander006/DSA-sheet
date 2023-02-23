public class DoublyLL {

      public static class Node {
            int data;
            Node next;
            Node prev;

            public Node(int data) {
                  this.data = data;
                  this.next = null;
                  this.prev = null;
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
            head.prev = newnode;
            // New head
            head = newnode;

      }

      // Add Last
      public void addLast(int data) {
            Node newnode = new Node(data);
            size++;
            if (head == null) {
                  tail = head = newnode;
                  return;
            }
            // Link
            newnode.prev = tail;
            tail.next = newnode;
            // New head
            tail = newnode;

      }

      // Remove first

      public int removeFirst() {
            if (head == null) {
                  System.out.println("Empty ");
                  size--;
                  return Integer.MIN_VALUE;
            }
            if (size == 1) {
                  int val = head.data;
                  head = tail = null;
                  size--;
                  return val;
            }

            head = head.next;
            head.prev = null;
            size--;

            return head.data;
      }

      // Remove last

      public int removeLast() {
            if (head == null) {
                  System.out.println("Empty ");
                  size--;
                  return Integer.MIN_VALUE;
            }
            if (size == 1) {
                  int val = head.data;
                  head = tail = null;
                  size--;
                  return val;
            }

            tail = tail.prev;
            tail.next = null;
            size--;

            return head.data;
      }

      // Print ll
      public void printLl() {
            Node temp = head;
            if (head == null) {
                  System.out.println("Linked List is empty");
                  return;
            }
            while (temp != null) {
                  System.out.print(temp.data + "<->");
                  temp = temp.next;
            }
            System.out.println("null");
      }

      public void reverse() {
            Node curr = tail = head;
            Node prev = null;
            Node next;
            while (curr != null) {
                  next = curr.next;
                  curr.next = prev;
                  curr.prev = next;
                  prev = curr;
                  curr = next;
            }
            head = prev;
      }

      public static void main(String[] args) {
            DoublyLL dl = new DoublyLL();
            dl.addFirst(2);
            dl.addFirst(1);
            dl.addLast(3);
            dl.printLl();
            dl.reverse();
            dl.printLl();
            // System.out.println(dl.size);
            // dl.removeFirst();
            // dl.printLl();
            // System.out.println(dl.size);
            // dl.removeLast();
            // dl.printLl();
            // System.out.println(dl.size);
      }
}
