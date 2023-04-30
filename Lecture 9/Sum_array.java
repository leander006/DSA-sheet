
public class Sum_array {
      public static void sub_array(int num[]) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < num.length; i++) {
                  for (int j = i; j < num.length; j++) {
                        int sum = 0;
                        for (int k = i; k <= j; k++) {
                              sum += num[k];
                        }
                        if (max < sum) {
                              max = sum;
                        }

                  }
                  // System.out.println("Max is " + max);
            }
      }

      public static void sub_array_updated(int num[]) {
            int max = Integer.MIN_VALUE;
            int prefix[] = new int[num.length];
            int sum = 0;
            prefix[0] = num[0];
            for (int i = 1; i < num.length; i++) {
                  prefix[i] = prefix[i - 1] + num[i];
            }
            for (int i = 0; i < num.length; i++) {

                  for (int j = i; j < num.length; j++) {
                        sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                        if (max < sum) {
                              max = sum;
                        }

                  }

            }
            System.out.println(max);
      }

      public static void kadanes(int num[]) {
            int mx = Integer.MIN_VALUE;
            int cs = 0;
            for (int i = 0; i < num.length; i++) {
                  cs = cs + num[i];
                  if (cs < 0) {
                        cs = 0;
                  }
                  mx = Math.max(mx, cs);
            }

            System.out.println("The maximum sum is " + mx);
      }

      public static void main(String[] args) {
            int num[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

            sub_array(num);
            sub_array_updated(num);
            kadanes(num);
      }
}
