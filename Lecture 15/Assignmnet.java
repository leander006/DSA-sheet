
public class Assignmnet {
      public static void range(int arr[], int i, int key) {
            if (i == arr.length) {
                  return;
            }
            if (arr[i] == key) {
                  System.out.print(i + " ");
            }
            range(arr, i + 1, key);
      }

      public static void convert(int n) {
            String arr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
            if (n == 0) {
                  return;
            }
            int lastDigit = n % 10;
            // System.out.print("num " + num + " ");
            convert(n / 10);
            System.out.print(arr[lastDigit] + " ");

      }

      public static int length(String str, int i) {
            if (i == str.length()) {
                  return 0;
            }

            return (1 + length(str, i + 1));
      }

      public static int sub_string_count(String str, int i, int j, int n) {
            if (n == 1) {
                  return 1;
            }

            if (n <= 0) {
                  return 0;
            }
            int res = (sub_string_count(str, i + 1, j, n - 1) + sub_string_count(str, i, j - 1, n - 1)
                        - sub_string_count(str, i + 1, j - 1, n - 2));
            if (str.charAt(i) == str.charAt(j)) {
                  res++;
            }
            return res;
      }

      public static void tower_of_hanoi(int n, String s, String h, String d) {
            if (n == 1) {
                  System.out.println("Transfer from " + s + " to " + d);
                  return;
            }
            tower_of_hanoi(n - 1, s, d, h);
            System.out.println("Transfer from " + s + " to " + d);
            tower_of_hanoi(n - 1, h, s, d);
      }

      public static void string_reverse(String s, int i) {
            if (i == 0) {
                  System.out.println(s.charAt(i));
                  return;
            }
            System.out.print(s.charAt(i));
            string_reverse(s, i - 1);
      }

      public static void main(String[] args) {
            int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
            String str = "abcab";
            String str1 = "abac";
            range(arr, 0, 2);
            convert(2021);
            System.out.println(length(new String("abcdefg"), 0));
            System.out.println(sub_string_count(str, 0, str.length() - 1, str.length()));
            tower_of_hanoi(3, "A", "B", "C");
            string_reverse(str1, str1.length() - 1);

      }
}
