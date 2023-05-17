import java.util.Scanner;

public class Strings {

      public static boolean pali(String str) {
            for (int i = 0; i < str.length() / 2; i++) {
                  if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                        return false;
                  }
            }
            return true;

      }

      public static float getShortesPath(String str) {
            float x = 0, y = 0;
            for (int i = 0; i < str.length(); i++) {
                  char ch = str.charAt(i);
                  if (ch == 'S') {
                        y--;
                  }

                  else if (ch == 'N') {
                        y++;
                  } else if (ch == 'W') {
                        x--;
                  } else {
                        x++;
                  }
            }
            float X = x * x, Y = y * y;

            return (float) Math.sqrt(X + Y);

      }

      public static String sub_String(String str, int s, int e) {
            String st = "";
            for (int i = 0; i < e; i++) {
                  st += str.charAt(i);
            }

            return st;
      }

      public static String Largest(String fruits[]) {
            String largest = fruits[0];
            for (int i = 1; i < fruits.length; i++) {
                  if (largest.compareTo(fruits[i]) < 0) {
                        largest = fruits[i];
                  }
            }

            return largest;

      }

      public static void main(String[] args) {
            String str = new String();
            Scanner l = new Scanner(System.in);
            str = l.nextLine();
            boolean res = pali(str);
            System.out.println("The string is palindrone " + res);
            float resp = getShortesPath(str);
            System.out.println("The string is palindrone " + resp);
            String respo = sub_String(str, 0, 5);
            System.out.println("The substring is " + respo);
            String f[] = { "abc", "bcdc", "dhdhd", "eeeee" };
            String respon = Largest(f);
            System.out.println("The substring is " + respon);
      }
}
