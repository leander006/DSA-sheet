import java.util.*;

public class sum {
      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            int a = l.nextInt();
            int b = l.nextInt();
            // Sum
            int sum = a + b;

            // Product
            int mul = a * b;

            // Area of cirlce
            float rad = l.nextFloat();
            float area = 3.14f * rad * rad;
            // Output

            System.out.println(sum);
            System.out.println(mul);
            System.out.println(area);
      }
}
