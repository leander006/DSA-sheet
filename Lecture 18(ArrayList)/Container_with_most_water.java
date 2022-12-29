import java.util.ArrayList;;

public class Container_with_most_water {

      public static int brute_force(ArrayList<Integer> height) {
            int maxWater = 0;
            for (int i = 0; i < height.size(); i++) {
                  for (int j = i + 1; j < height.size(); j++) {
                        int ht = Math.min(height.get(i), height.get(j));
                        int width = j - i;
                        int currentWater = ht * width;
                        maxWater = Math.max(maxWater, currentWater);
                  }
            }

            return maxWater;
      }

      public static int optimized_approch(ArrayList<Integer> height) {
            int maxWater = 0;
            int lp = 0, rp = height.size() - 1;
            while (lp < rp) {
                  int ht = Math.min(height.get(lp), height.get(rp));
                  int width = rp - lp;
                  int currentWater = ht * width;
                  maxWater = Math.max(maxWater, currentWater);

                  if (height.get(lp) < height.get(rp)) {
                        lp++;
                  } else {
                        rp--;
                  }
            }

            return maxWater;
      }

      public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            arr.add(8);
            arr.add(6);
            arr.add(2);
            arr.add(5);
            arr.add(4);
            arr.add(8);
            arr.add(3);
            arr.add(7);

            System.out.println(brute_force(arr));
            System.out.println(optimized_approch(arr));
      }
}
