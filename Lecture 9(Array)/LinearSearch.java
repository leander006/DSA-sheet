public class LinearSearch {
      public static int linearSearch(int num[], int ele) {
            for (int i = 0; i < num.length; i++) {
                  if (num[i] == ele) {
                        return i;
                  }
            }
            return 0;
      }

      public static void main(String[] args) {
            int num[] = { 12, 23, 44, 5, 6, 7, 34, 21, 26, 54 };

            int res = linearSearch(num, 44);
            System.out.println("Result is " + res);
      }
}
