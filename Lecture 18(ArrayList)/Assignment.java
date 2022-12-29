import java.util.ArrayList;
import java.util.Collections;

public class Assignment {

      // Monotonic arraylist or not [1,2,2,3]

      public static boolean monotonic(ArrayList<Integer> arr) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.size(); i++) {
                  min = Math.min(min, arr.get(i));
                  max = Math.max(max, arr.get(i));
            }
            if (min == arr.get(0) && max == arr.get(arr.size() - 1)) {
                  return true;
            }
            if (max == arr.get(0) && min == arr.get(arr.size() - 1)) {
                  return true;
            }
            return false;
      }

      // lonely no.

      public static ArrayList<Integer> lonely(ArrayList<Integer> arr) {
            Collections.sort(arr);
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 1; i < arr.size() - 1; i++) {
                  if (arr.get(i - 1) + 1 < arr.get(i) && arr.get(i) + 1 < arr.get(i + 1)) {
                        res.add(arr.get(i));
                  }
            }

            if (arr.size() == 1) {
                  res.add(arr.get(0));
            }

            if (arr.size() > 1) {
                  if (arr.get(0) + 1 < arr.get(1)) {
                        res.add(arr.get(0));
                  }
                  if (arr.get(arr.size() - 2) + 1 < arr.get(arr.size() - 1)) {
                        res.add(arr.get(arr.size() - 1));
                  }
            }
            return res;
      }

      public static int most_count(ArrayList<Integer> arr) {
            int count = 0;
            int res[] = new int[100];
            for (int i = 0; i < arr.size() - 1; i++) {
                  int ele = arr.get(i);
                  if (ele == arr.get(i + 1)) {
                        count++;
                  }
                  res[i] = count;
            }

            System.out.println(res);
            return count;
      }

      public static ArrayList<Integer> beautifull_array(int n) {
            ArrayList<Integer> res = new ArrayList<>();
            divide_and_conquer(1, 1, res, n);
            return res;
      }

      public static void divide_and_conquer(int s, int inc, ArrayList<Integer> res, int n) {
            if (s + inc > n) {
                  res.add(s);
                  return;
            }
            divide_and_conquer(s, 2 * inc, res, n);
            divide_and_conquer(s + inc, 2 * inc, res, n);
      }

      public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>();
            // arr.add(10);

            // arr.add(6);
            // arr.add(5);
            // arr.add(8);
            // arr.add(9);
            arr.add(1);

            arr.add(100);
            arr.add(200);
            arr.add(1);
            arr.add(100);

            // System.out.println(monotonic(arr));
            // System.out.println(lonely(arr));
            // System.out.println(most_count(arr));
            System.out.println(beautifull_array(5));
      }
}
