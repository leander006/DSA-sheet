import java.util.Scanner;

public class Prime {

      // public static boolean isPrime(int n) {
      // for (int i = 2; i <= n - 1; i++) {
      // if (n % i == 0) {
      // return false;
      // }
      // }
      // return true;
      // }
      public static boolean isPrimeOpt(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                  if (n % i == 0) {
                        return false;
                  }

            }
            return true;
      }

      public static void printPrime(int n) {
            for (int i = 2; i <= n; i++) {
                  if (isPrimeOpt(i) == true) {
                        System.out.println(i);
                  }

            }
      }

      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            printPrime(n);

      }
}
