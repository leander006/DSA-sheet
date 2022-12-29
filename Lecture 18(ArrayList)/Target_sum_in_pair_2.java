import java.util.ArrayList;

public class Target_sum_in_pair_2 {
      public static boolean optimized_approch(ArrayList<Integer> arr, int target) {
            int pivot = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                  if (arr.get(i) > arr.get(i + 1)) {
                        pivot = (i + 1);
                  }
            }

            int lp = pivot;
            int rp = pivot - 1;

            while (lp != rp) {

                  if ((arr.get(lp) + arr.get(rp)) == target) {
                        return true;
                  }
                  if ((arr.get(lp) + arr.get(rp)) < target) {
                        lp = (lp + 1) % arr.size();

                  } else {
                        rp = (arr.size() + rp - 1) % arr.size();

                  }
            }

            return false;
      }

      public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(11);
            arr.add(12);
            arr.add(4);
            arr.add(5);
            arr.add(6);
            arr.add(7);
            arr.add(8);

            System.out.println(optimized_approch(arr, 23));
      }
}
