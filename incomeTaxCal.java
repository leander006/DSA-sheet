import java.util.Scanner;

public class incomeTaxCal {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            System.out.println("Enter your Salary ");
            double salary = l.nextDouble();
            double tax = 0;
            if (salary < 500000) {
                  tax = 0;
            } else if (salary >= 500000 && salary < 1000000) {
                  tax = (0.2 * salary);
            } else {
                  tax = (0.3 * salary);
            }

            System.out.println("The tax you are paying is " + tax);
      }
}
