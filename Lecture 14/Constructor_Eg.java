public class Constructor_Eg {
      public static void main(String[] args) {
            // student s1 = new student();
            // System.out.println(s1.name + s1.roll_no + s1.password);
            // student s2 = new student("leander");
            // System.out.println(s2.name + s2.roll_no + s2.password);
            student s3 = new student("leander", 146);
            s3.password = "1234";
            s3.marks[0] = 95;
            s3.marks[1] = 96;
            s3.marks[2] = 97;
            student s4 = new student(s3);

            s3.marks[2] = 98;

            System.out.println(s4.name + " " + s4.roll_no + " " + s4.password);
            for (int i = 0; i < s4.marks.length; i++) {
                  System.out.print(s4.marks[i] + " ");
            }

      }
}

class student {
      String name;
      int roll_no;
      String password;
      int marks[];

      // Non parameterized constructor
      student() {
            marks = new int[3];
            System.out.println("Constructor is called ");
      }

      // parameterized constructor
      student(String name) {
            marks = new int[3];
            this.name = name;
      }

      student(String name, int roll_no) {
            marks = new int[3];
            this.name = name;
            this.roll_no = roll_no;
      }

      // Copy constructor and (this.marks = s1.marks) so shallow constructor

      student(student s1) {
            marks = new int[3];
            this.name = s1.name;
            this.password = s1.password;
            this.marks = s1.marks;
      }

      // Deep constructor
      // student(student s1) {
      // marks = new int[3];
      // this.name = s1.name;
      // this.password = s1.password;
      // for (int i = 0; i < marks.length; i++) {
      // this.marks[i] = s1.marks[i];
      // }
      // }
}