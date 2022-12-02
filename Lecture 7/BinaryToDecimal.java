import java.util.Scanner;

public class BinaryToDecimal {
      public static int binaryTodecimal(int n) {
            int p = 0;
            int dec = 0;
            while (n > 0) {
                  int ld = n % 10;
                  dec += ld * Math.pow(2, p);
                  n = n / 10;
                  p++;
            }

            return dec;

      }

      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            int res = binaryTodecimal(n);
            System.out.println(res);
      }
}
