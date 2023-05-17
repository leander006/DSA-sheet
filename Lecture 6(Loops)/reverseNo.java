import java.util.Scanner;

public class reverseNo {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            System.out.println("Take a number ");
            int n = l.nextInt();
            int reverse = 0;
            while (n > 0) {
                  int lasNo = n % 10;
                  n = n / 10;
                  reverse = (reverse * 10) + lasNo;
            }
            System.out.println("The reverse number is " + reverse);
      }
}
