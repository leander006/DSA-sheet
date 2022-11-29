import java.util.Scanner;

public class nestedLoop {
      public static void main(String[] args) {
            // for (int i = 1; i <= 4; i++) {
            // for (int j = 1; j <= i; j++) {
            // System.out.print(" * ");
            // }
            // System.out.println();
            // }
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            // for (int i = 1; i <= n; i++) {
            // for (int j = n + 1; j > i; j--) {
            // System.out.print(" * ");
            // }
            // System.out.println();
            // }

            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n ; j++) {
                        System.out.print(j);
                  }
                  System.out.println();
            }

      }
}
