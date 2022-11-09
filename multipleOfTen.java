import java.util.Scanner;

public class multipleOfTen {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);

            /* Only not multiple of ten */
            do {
                  System.out.println("Enter your number ");
                  int n = l.nextInt();
                  if (n % 10 == 0) {
                        break;
                  }
                  System.out.println("n is " + n);
            } while (true);

            /* If only multiple of ten */
            do {
                  System.out.println("Enter your number ");
                  int n = l.nextInt();
                  if (n % 10 == 0) {
                        continue;
                  }
                  System.out.println("n is " + n);
            } while (true);
      }
}
