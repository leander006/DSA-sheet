
public class Class_Eg {
      public static void main(String[] args) {
            Pen p1 = new Pen("green");
            System.out.println(p1.col);
            System.out.println(p1.penSize);
            p1.setCol("yellow");
            System.out.println(p1.col);
            p1.setSize(32);
            System.out.println(p1.penSize);
            p1.setCol("Green");
            System.out.println(p1.col);
      }

}

class Pen {
      String col;
      int penSize;

      Pen(String col) {
            this.col = col;
      }

      void setCol(String _col) {
            col = _col;
      }

      void setSize(int _size) {
            penSize = _size;
      }
}