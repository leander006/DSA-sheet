
import java.util.Arrays;
import java.util.Scanner;

public class Assignment {
      public static int Assig1(String str) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                  if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                              || str.charAt(i) == 'u') {
                        sum++;
                  }
            }

            return sum;
      }

      public static boolean Assig2(String str1, String str2) {
            if (str1.length() != str2.length()) {
                  return false;
            }
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            char c1[] = str1.toCharArray();
            char c2[] = str2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            return Arrays.equals(c1, c2);

      }

      public static void main(String[] args) {
            Scanner l = new Scanner(System.in);
            String str1 = l.nextLine();
            String str2 = l.nextLine();
            // int res = Assig1(str);
            // System.out.println("The result is " + res);
            boolean res = Assig2(str1, str2);
            System.out.println("Strins are anagram " + res);
      }
}
