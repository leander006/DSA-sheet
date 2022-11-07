import java.util.Scanner;

public class assign3 {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            /*
             * Question 3
             */
            int input = l.nextInt();
            switch (input) {
                  case 1:
                        System.out.println("Monday");
                        break;
                  case 2:
                        System.out.println("Tuesday");
                        break;
                  case 3:
                        System.out.println("Wednesday");
                        break;
                  case 4:
                        System.out.println("Thursday");
                        break;
                  case 5:
                        System.out.println("Friday");
                        break;
                  case 6:
                        System.out.println("Saterday");
                        break;
                  case 7:
                        System.out.println("Sunday");
                        break;
                  default:
                        System.out.println("Error");
                        break;
            }

            /* Question 5 */
            int year = l.nextInt();
            if (year % 4 == 0) {
                  if (year % 100 == 0) {
                        if (year % 400 == 0) {
                              System.out.println("Leap year");
                        } else {
                              System.out.println("Not a leap year");
                        }
                  } else {
                        System.out.println("Leap year");
                  }
            } else {
                  System.out.println("Not a leap year");
            }
      }

}
