
public class Assisgnment {

      public static int Assig1(int arr[][], int k) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (arr[i][j] == k) {
                              sum++;
                        }
                  }
            }
            return sum;
      }

      public static int Assig2(int arr[][]) {
            int sum = 0, i = 1;
            for (int j = 0; j < arr[0].length; j++) {
                  sum += arr[i][j];
            }

            return sum;

      }

      public static void array(int arr[][]) {
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        System.out.print(arr[i][j] + " ");
                  }
                  System.err.println();
            }
      }

      public static void Assig3(int arr[][]) {

            int res[][] = new int[arr[0].length][arr.length];
            for (int i = 0; i < arr[0].length; i++) {
                  for (int j = 0; j < arr.length; j++) {
                        res[i][j] = arr[j][i];
                  }
            }

            for (

                        int i = 0; i < res.length; i++) {
                  for (int j = 0; j < res[0].length; j++) {
                        System.out.print(res[i][j] + " ");
                  }
                  System.out.println();

            }

      }

      public static void main(String[] args) {
            int arr[][] = { { 1, 2, 3 }, { 2, 3, 4 }, { 4, 5, 6 }, { 2, 5, 6 } };
            int arr1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
            // int res = Assig2(arr);
            // System.out.println("The count of key is " + res);
            array(arr1);
            Assig3(arr1);
      }
}
