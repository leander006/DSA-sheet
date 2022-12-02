import java.util.Scanner;

public class DecimalToBinary {
      public static int decimalToBinary(int n) {
            int bin = 0;
            int count = 0;
            while (n > 0) {
                  int binNum = n % 2;
                  bin += (int) binNum * Math.pow(10, count);
                  count++;
                  n = n / 2;
            }
            return bin;
      }

      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            int n = l.nextInt();
            int res = decimalToBinary(n);
            System.out.println(res);
      }
}
