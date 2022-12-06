
public class Imp_Sum {

      public static int[] reverse_Array(int num[], int n) {

            for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
                  int temp = num[i];
                  num[i] = num[j];
                  num[j] = temp;
            }

            return num;
      }

      public static void pair_in_array(int num[]) {
            for (int i = 0; i < num.length; i++) {
                  for (int j = i + 1; j <= num.length - 1; j++) {
                        System.out.print("(" + (i + 1) + "," + (j + 1) + ")");
                  }
                  System.out.println();
            }
      }

      public static void sub_array(int num[]) {

            for (int i = 0; i < num.length; i++) {
                  for (int j = i; j < num.length; j++) {
                        int sum = 0;
                        for (int k = i; k <= j; k++) {
                              sum += num[k];
                              System.out.print(num[k] + " ");
                        }
                        System.out.println("sum is " + sum);
                  }
                  System.out.println();
            }
      }

      public static void main(String[] args) {

            int num[] = { 1, 2, 3, 4, 5 };
            // int n = 10;
            // int res[] = reverse_Array(num, n);

            // for (int i = 0; i <= n - 1; i++) {
            // System.out.println(res[i]);
            // }
            // pair_in_array(num);
            sub_array(num);

      }
}
