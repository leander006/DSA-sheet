public class Basic {

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

      // Add last

      public static void addLast(int data) {
            Node newnode = new Node(data);
            size++;
            if (head == null) {
                  tail = head = newnode;
                  return;
            }
            // Link
            tail.next = newnode;
            // New tail
            tail = newnode;

      }
      // Add at middle

      public static void addMiddle(int idx, int data) {
            Node newnode = new Node(data);
            if (idx == 0) {
                  addFirst(data);
            }
            size++;
            Node temp = head;
            int i = 0;
            while (i < idx - 1) {
                  temp = temp.next;
                  i++;
            }

            // New links
            newnode.next = temp.next;
            temp.next = newnode;

      }

      // Print

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

      // Remove first

      public static int removeFirst() {
            if (size == 0) {
                  System.out.println("Linked List is empty");
                  return Integer.MIN_VALUE;
            }
            if (size == 1) {
                  int val = head.data;
                  head = tail = null;
                  size = 0;
                  return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
      }

      /// Remove last
      public static int removeLast() {
            if (size == 0) {
                  System.out.println("Linked List is empty");
                  return Integer.MIN_VALUE;
            }
            if (size == 1) {
                  int val = tail.data;
                  head = tail = null;
                  size = 0;
                  return val;
            }
            Node prev = head;
            for (int i = 0; i < size - 2; i++) {
                  prev = prev.next;
            }
            int val = tail.data;
            prev.next = null;
            tail = prev;
            size--;
            return val;
      }

      // Remove from Nth last node

      public static void remove_nth_node(int n) {
            Node temp = head;
            int sz = 0;
            while (temp != null) {
                  temp = temp.next;
                  sz++;
            }
            if (n == sz) {
                  head = head.next;
                  return;
            }
            Node prev = head;
            int i = 1;
            while (i < (sz - n)) {
                  prev = prev.next;
                  i++;
            }
            prev.next = prev.next.next;

      }
      // Search in ll

      public static int search(int target) {
            if (size == 0) {
                  System.out.println("Linked List is empty");
                  return -1;
            }
            if (head.data == target) {
                  return 0;
            }
            Node curr = head;
            for (int i = 0; i < size; i++) {
                  if (curr.data == target) {
                        return i;
                  } else {
                        curr = curr.next;
                  }
            }
            return -1;
      }

      // Recursion search
      public static int helper(Node head, int target) {
            if (head == null) {
                  return -1;
            }
            if (head.data == target) {
                  return 0;
            }
            int idx = helper(head.next, target);
            if (idx == -1) {
                  return -1;
            }
            return (idx + 1);
      }

      public static int rec_search(int target) {
            return helper(head, target);
      }

      // Reverse ll

      public static void Reverse() {
            Node Prev = null;
            Node Curr = tail = head;
            Node Next;

            while (Curr != null) {
                  Next = Curr.next;
                  Curr.next = Prev;
                  Prev = Curr;
                  Curr = Next;
            }
            head = Prev;
      }

      // Find mide node

      public static Node middle(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next; // +1
                  fast = fast.next.next; // +2
            }
            return slow;
      }

      // Palindrone

      public static boolean Palindrone() {
            if (head == null || head.next == null) {
                  return true;
            }

            // Find middle element

            Node midNode = middle(head);

            // Reverse half ll

            Node Prev = null;
            Node Curr = midNode;
            Node Next;

            while (Curr != null) {
                  Next = Curr.next;
                  Curr.next = Prev;
                  Prev = Curr;
                  Curr = Next;
            }

            // Check if both ll same

            Node left = head;
            Node right = Prev;

            while (right != null) {
                  if (left.data != right.data) {
                        return false;
                  }
                  left = left.next;
                  right = right.next;
            }
            return true;
      }

      public static void main(String[] args) {
            addFirst(1);
            addFirst(2);
            // addLast(1);
            // addLast(1);
            // addLast(2);
            // addMiddle(2, 69);
            printLl();
            // Reverse();
            // removeFirst();
            // remove_nth_node(3);
            System.out.println(Palindrone());
            // printLl();
            // removeLast();
            // printLl();
            // System.out.println("Search function " + search(99));
            // System.out.println("Search function " + rec_search(69));
            // System.out.println(size);
      }
}
