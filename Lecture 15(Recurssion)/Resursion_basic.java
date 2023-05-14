
public class Resursion_basic {
      public static void printDec(int n) {
            // Base case
            if (n == 1) {
                  System.out.print(n + " ");
                  return;
            }
            // kaam (Work to be done)
            System.out.print(n + " ");
            // Inner call
            printDec(n - 1);
      }

      public static void printInc(int n) {

            if (n == 1) {
                  System.out.print(n + " ");
                  return;
            }
            printInc(n - 1);
            System.out.print(n + " ");
      }

      public static int fact(int n) {
            if (n == 0) {
                  return 1;
            }
            int factn_1 = fact(n - 1);
            return n * factn_1;
      }

      public static int sum_N(int n) {
            if (n == 1) {
                  return 1;
            }
            int sum_n_1 = sum_N(n - 1);
            return (n + sum_n_1);
      }

      public static int fabNo(int n) {
            if (n == 0) {
                  return 0;
            }
            if (n == 1) {
                  return 1;
            }
            // int factNo_1 = factNo(n - 1);
            return (fabNo(n - 1) + fabNo(n - 2));
      }

      public static boolean check_sort(int arr[], int i) {
            if (i == arr.length - 1) {
                  return true;
            }
            if (arr[i] > arr[i + 1]) {
                  return false;
            }
            return check_sort(arr, i + 1);

      }

      public static int first_occurence(int arr[], int i, int ele) {

            if (i == arr.length) {
                  return -1;
            }
            if (arr[i] == ele) {
                  return i;
            }
            return first_occurence(arr, i + 1, ele);

      }

      public static int last_occurence_byleander(int a[], int i, int ele) {
            if (i == 0) {
                  return -1;
            }
            if (a[i] == ele) {
                  return i;
            }
            return last_occurence_byleander(a, i - 1, ele);

      }

      public static int last_occurence(int arr[], int i, int ele) {
            if (i == arr.length) {
                  return -1;
            }
            if (last_occurence(arr, i + 1, ele) == -1 && arr[i] == ele) {
                  return i;
            }
            return last_occurence(arr, i + 1, ele);
      }

      public static int x_power_n(int x, int n) {
            if (n == 0) {
                  return 1;
            }
            return (x * x_power_n(x, n - 1));

      }

      public static int opt_x_power_n(int x, int n) {
            if (n == 0) {
                  return 1;
            }

            // int halfPow = opt_x_power_n(x, n / 2) * opt_x_power_n(x, n / 2); { o(n) }
            int halfPow = opt_x_power_n(x, n / 2); // { now actually o(logn)}
            int halfPowSqr = halfPow * halfPow;
            if (n % 2 == 0) {
                  return halfPowSqr;
            }
            return (x * halfPowSqr);

      }

      public static int place_tile(int n) {
            if (n == 0 || n == 1) {
                  return 1;
            }
            // for vertical placing of tile
            int placing1 = place_tile(n - 1);

            // for horizontal placing of tile

            int placing2 = place_tile(n - 2);

            return placing1 + placing2;
      }

      public static void remove_duplicates(String str, int i, StringBuilder newStr, boolean map[]) {
            if (i == str.length()) {
                  System.out.println(newStr);
                  return;
            }
            char currentChar = str.charAt(i);
            if (map[currentChar - 'a'] == true) {
                  remove_duplicates(str, i + 1, newStr, map);
            } else {
                  map[currentChar - 'a'] = true;
                  remove_duplicates(str, i, newStr.append(currentChar), map);
            }
      }

      public static int friend_pairing(int n) {
            if (n == 1 || n == 2) {
                  return n;
            }
            return (friend_pairing(n - 1) + (n - 1) * friend_pairing(n - 2));
      }
      // consecutive 11

      public static void print_binary(int n, int lastPlace, String str) {
            if (n == 0) {
                  System.out.println(str);
                  return;
            }
            print_binary(n - 1, 0, str + "0");
            if (lastPlace == 0) {
                  print_binary(n - 1, 1, str + "1");
            }
      }

      // consecutive 00
      public static void print_binary_upd(int n, int lastPlace, String str) {
            if (n == 0) {
                  System.out.println(str);
                  return;
            }
            print_binary_upd(n - 1, 1, str + "1");
            if (lastPlace == 1) {
                  print_binary_upd(n - 1, 0, str + "0");
            }
      }

      public static void main(String[] args) {
            int n = 5;
            int a[] = { 11, 12, 3, 4, 11 };
            String s = "apnaacoollege";
            // printDec(n);
            // printInc(n);
            // System.out.println(fact(n));
            // System.out.println(sum_N(n));
            // System.out.println(fabNo(n));
            // System.out.println(check_sort(a, 0));
            // System.out.println(first_occurence(a, 0, 24));
            // System.out.println(last_occurence_byleander(a, a.length - 1, 12));
            // System.out.println(last_occurence(a, 0, 11));
            // System.out.println(x_power_n(3, 5));
            // System.out.println(opt_x_power_n(3, 5));
            // System.out.println(place_tile(n));
            // remove_duplicates(s, 0, new StringBuilder(""), new boolean[26]);
            // System.out.println(friend_pairing(4));
            // print_binary(3, 0, new String(""));
            print_binary_upd(3, 1, new String(""));

      }
}
