import java.util.ArrayList;

public class Target_sum_in_pair {

      public static boolean brute_force(ArrayList<Integer> arr, int sum) {

            for (int i = 0; i < arr.size(); i++) {
                  for (int j = i + 1; j < arr.size(); j++) {
                        if (arr.get(i) + arr.get(j) == sum) {
                              return true;
                        }
                  }
            }

            return false;
      }

      public static boolean optimized_approch(ArrayList<Integer> arr, int sum) {
            int lp = 0, rp = arr.size() - 1;
            while (lp != rp) {

                  if ((arr.get(lp) + arr.get(rp)) == sum) {
                        return true;
                  }
                  if ((arr.get(lp) + arr.get(rp)) < sum) {
                        lp++;
                  } else {
                        rp--;
                  }
            }
            return false;
      }

      public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            arr.add(2);
            arr.add(3);
            arr.add(4);
            arr.add(5);
            arr.add(6);
            arr.add(7);
            arr.add(8);

            System.out.println(brute_force(arr, 8));

            System.out.println(optimized_approch(arr, 8));
      }
}
