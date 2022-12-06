import java.util.Scanner;

public class Assisgment {

      public static double average(double a, double b, double c) {
            double res = (double) (a + b + c) / 3;
            return res;
      }

      public static boolean isEven(double a) {

            if (a % 2 == 0) {
                  return true;
            }
            return false;
      }

      public static boolean isPali(int a) {
            int aprev = a;
            int anew = 0;
            while (a > 0) {
                  int anext = a % 10;
                  anew = anew * 10 + anext;
                  a = a / 10;
            }
            System.out.println(anew);
            if (anew == aprev) {
                  return true;
            }
            return false;
      }

      public static int sum(int a) {
            int sum = 0;
            while (a > 0) {
                  int newA = a % 10;
                  sum += newA;
                  a /= 10;
            }
            return sum;
      }

      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            double a = l.nextDouble();
            int aPali = l.nextInt();
            int n = l.nextInt();
            double b = l.nextDouble();
            double c = l.nextDouble();

            System.out.println("Average is " + average(a, b, c));
            System.out.println("Number is even " + isEven(a));
            System.out.println("Number is palindrome " + isPali(aPali));
            System.out.println("Sum of number is " + sum(aPali));
      }
}
