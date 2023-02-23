public class AssignmentLL {

  public static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // public static Node head;
  // Add first
  public void addFirst(Node head, int data) {
    Node newnode = new Node(data);
    if (head == null) {
      head = newnode;
      return;
    }
    // Link
    newnode.next = head;
    // New head
    head = newnode;
  }

  // Delete element

  public void deleteEle(Node head, int m, int n) {
    Node curr = head, t;
    while (curr != null) {
      for (int i = 1; i < m; i++) {
        curr = curr.next;
      }
      if (curr == null) {
        return;
      }
      t = curr.next;
      for (int i = 1; i <= n && t != null; i++) {
        t = t.next;
      }
      curr.next = t;
      curr = t;
    }
  }

  // Swap link of X and Y

  public static void swap(Node head, int x, int y) {
    if (x == y) {
      return;
    }
    // while(head !=null){
    Node prevX = null;
    Node currX = head;
    while (currX != null && currX.data != x) {
      prevX = currX;
      currX = currX.next;
    }
    Node prevY = null;
    Node currY = head;
    while (currY != null && currY.data != y) {
      prevY = currY;
      currY = currY.next;
    }

    if (currX == null || currY == null) {
      return;
    }

    if (prevX != null) {
      prevX.next = currY;
    } else {
      head = currX;
    }

    if (prevY != null) {
      prevY.next = currX;
    } else {
      head = currY;
    }

    Node temp = currX.next;
    currX.next = currY.next;
    currY.next = temp;
    // temp2.next=

    // temp.next = temp1.next;
    // temp1.next = temp2.next;

    // }
  }

  // Print ll
  public void printLl(Node head) {
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

  public Node intersection(Node head1, Node head2) {
    while (head1 != null) {
      Node temp = head2;
      while (temp != null) {
        if (temp == head1) {
          return head1;
        }
        temp = temp.next;
      }
      head1 = head1.next;
    }
    return null;
  }

  public static void skip(Node head, int m, int n) {
    Node curr = head;
    while (curr != null) {
      for (int i = 0; i < m - 1 && curr != null; i++) {
        curr = curr.next;
      }

      if (curr == null) {
        return;
      }

      Node t = curr.next;
      for (int j = 0; j < n && t != null; j++) {
        t = t.next;
      }
      curr.next = t;
      curr = t;
    }
  }

  public static Node merge(Node head1,Node head2){
    Node result =null;
    if(head1 == null){
      return head2;
    }
    else if( head2 ==null){
      return head1;
    }
  
    if(head1.data <= head2.data){
        result=head1;
        result.next = merge(head1.next,head2);
    }
    else{
        result = head2;
        result.next = merge(head1,head2.next);
    }
    return result;
       

  }

  public static Node sortMerge(Node arr[],int last){
    while(last!=0){
      int i=0,l=last;
      while(i<l){
        arr[i] = merge(arr[i],arr[l]);
        i++;
        l--;
        if(i>=l){
          last =l;
        }

      }
    }
    return arr[0];
  }

  public static void main(String[] args) {
    AssignmentLL l1 = new AssignmentLL();
    int k = 3;
    int n = 4;
    // AssignmentLL l2 = new AssignmentLL();

    // AssignmentLL sol = new AssignmentsLL();

    // Node head1, head2;

    // // head1 = new Node(10);
    // head2 = new Node(1);

    // Node newNode = new Node(2);
    // head2.next = newNode;

    // newNode = new Node(3);
    // head2.next.next = newNode;

    // newNode = new Node(4);
    // // head1.next = newNode;
    // head2.next.next.next = newNode;

    //     newNode = new Node(5);
    //     // head1.next = newNode;
    //     head2.next.next.next.next = newNode;

    //     newNode = new Node(6);
    //     // head1.next = newNode;
    //     head2.next.next.next.next.next = newNode;

    //     newNode = new Node(7);
    //     // head1.next = newNode;
    //     head2.next.next.next.next.next.next = newNode;

    //     newNode = new Node(8);
    //     // head1.next = newNode;
    //     head2.next.next.next.next.next.next.next = newNode;

    //     newNode = new Node(9);
    //     // head1.next = newNode;
    //     head2.next.next.next.next.next.next.next.next = newNode;
    //     newNode = new Node(10);
    //     // head1.next = newNode;
    //     head2.next.next.next.next.next.next.next.next.next = newNode;
    // newNode = new Node(30);
    // head1.next.next = newNode;

    // head1.next.next.next = null;

    // sol.printLl(head1);
    // sol.printLl(head2);

    // if (sol.intersection(head1, head2) == null) {
    // System.out.println("No intersection");
    // } else {
    // System.out.println("Found intersection " + sol.intersection(head1,
    // head2).data);
    // }
    // l1.addFirst(7);
    // // l1.addFirst(6);
    // l1.addFirst(3);
    // l1.addFirst(2);
    // l1.addFirst(1);

    // l2.addFirst(7);
    // // l2.addFirst(6);
    // l2.addFirst(5);
    // l2.addFirst(4);

    // l1.printLl(head2);
    // swap(head2, 3, 4);
    // // // l1.deleteEle(head2, 2, 2);
    // // l1.swap(head2, 4, 6);
    // l1.printLl(head2);
    //     skip(head2, 3, 2);
    //     l1.printLl(head2);
    // System.out.println(intersection(l1.head, l2.head));
Node arr[] = new Node[k];
arr[0] = new Node(1);
arr[0].next = new Node(3);
arr[0].next.next = new Node(5);
arr[0].next.next.next = new Node(7);
arr[1] = new Node(2);
arr[1].next = new Node(4);
arr[1].next.next = new Node(6);
arr[1].next.next.next = new Node(8);
arr[2] = new Node(0);
arr[2].next = new Node(9);
arr[2].next.next = new Node(10);
arr[2].next.next.next = new Node(11);
Node head = sortMerge(arr, k - 1);
l1.printLl(head);

  }
}
