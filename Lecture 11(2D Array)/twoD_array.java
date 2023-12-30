import java.util.Scanner;

public class twoD_array {

      public static void print_spiral(int arr[][]) {
            int startRow = 0, startCol = 0, endRow = arr.length - 1, endCol = arr[0].length - 1;
            int temp[] = new int[arr.length* arr[0].length];
            int ind=0;
            while (startRow <= endRow && startCol <= endCol) {
                  // top
                  for (int j = startCol; j <= endCol; j++) {
                        // System.out.print(arr[startRow][j] + " ");
                        temp[ind] = arr[startRow][j];
                        ind++;
                  }
                  // right
                  for (int i = startRow + 1; i <= endRow; i++) {
                        // System.out.print(arr[i][endCol] + " ");
                        temp[ind] = arr[i][endCol];
                        ind++;                        
                  }
                  // bottom
                  for (int j = endCol - 1; j >= startCol; j--) {
                        if (startRow == endRow) {
                              break;
                        }
                        // System.err.print(arr[endRow][j] + " ");
                        temp[ind] = arr[endRow][j];
                        ind++;                         
                  }
                  // left
                  for (int i = endRow - 1; i >= startRow + 1; i--) {
                        if (startCol == endCol) {
                              break;
                        }
                        // System.out.print(arr[i][startCol] + " ");
                        temp[ind] = arr[i][startCol];
                        ind++;                            
                  }
                  startCol++;
                  startRow++;
                  endCol--;
                  endRow--;
            }
            for(int jk=0;jk<temp.length;jk++){
                  System.out.print(temp[jk]);
            }
      }

      public static int daigonal_sum(int arr[][]) {
            int sum = 0;
            // for (int i = 0; i < arr.length; i++) {
            // for (int j = 0; j < arr[0].length; j++) {
            // if (i == j) {

            // sum += arr[i][j];
            // } else if (i + j == (arr.length - 1)) {
            // sum += arr[i][j];
            // }
            // }
            // }
            for (int i = 0; i < arr.length; i++) {
                  sum += arr[i][i];
                  if (i != arr.length - i - 1) {
                        sum += arr[i][arr.length - i - 1];
                  }
            }
            return sum;
      }

      public static int largest(int arr[][]) {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (arr[i][j] > max) {
                              max = arr[i][j];
                        }
                  }

            }
            return max;
      }

      public static void array(int arr[][]) {
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        System.out.print(arr[i][j] + " ");
                  }
                  System.err.println();
            }
      }

      public static boolean SearchEle(int arr[][], int key) {

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (arr[i][j] == key) {
                              return true;
                        }
                  }
            }

            return false;
      }

      public static boolean staircase_search(int arr[][], int k) {

            int row = 0, col = arr[0].length - 1;
            while (row < arr.length && col >= 0) {
                  if (arr[row][col] == k) {
                        return true;
                  } else if (k < arr[row][col]) {
                        col--;
                  } else {
                        row++;
                  }
            }
            return false;

      }

      public static void main(String[] args) {

            // Scanner l = new Scanner(System.in);
            // int r = l.nextInt();
            // int c = l.nextInt();
            // int arr[][] = new int[r][c];

            // for (int i = 0; i < r; i++) {
            // for (int j = 0; j < c; j++) {
            // arr[i][j] = l.nextInt();
            // }
            // }
            // System.err.println("2 D array is ");
            // for (int i = 0; i < r; i++) {
            // for (int j = 0; j < c; j++) {
            // System.out.print(arr[i][j] + " ");
            // }
            // System.err.println();
            // }
            // int res = largest(arr);
            // System.out.println("The largest number in 2 D array is " + res);
            int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
            // int arr1[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
            print_spiral(arr);
            // array(arr);
            // boolean res = staircase_search(arr, 9);
            // System.out.println("The Sum in 2 D array is " + res);
            // System.out.println("The element in 2 D array is present " + res);

      }
}
