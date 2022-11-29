import java.util.Scanner;

public class assign1 {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);

            /*
             * average
             */
            int A = l.nextInt();
            int B = l.nextInt();
            int C = l.nextInt();
            float av = (A + B + C) / 3;
            System.out.println("Average is " + av);

            /*
             * Area of square
             */
            int a = l.nextInt();
            int area = a * a;
            System.out.println("Area is " + area);

            /*
             * GST
             */
            float pencile = l.nextFloat();
            float pen = l.nextFloat();
            float eraser = l.nextFloat();
            float total = pen + pencile + eraser;
            double bill = total + (0.18f * total);

            System.out.println("Total bill after gst included is " + bill);

      }
}
