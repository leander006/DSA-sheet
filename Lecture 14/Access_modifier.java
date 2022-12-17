public class Access_modifier {
      public static void main(String[] args) {
            Eg eg1 = new Eg();

            // Access within package 
            System.out.println(eg1.proname);
            System.out.println(eg1.dname);
            System.out.println(eg1.puname);
            eg1.getName();
      }
}

class Eg {
      private String prname = "private";
      public String puname = "public";
      String dname = "default";
      protected String proname = "protected";

      // Access within class
      void getName() {
            prname = "new";
            System.out.println(prname);
      }
}