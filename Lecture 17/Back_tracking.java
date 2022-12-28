
public class Back_tracking {
      static int ways_to_print_nQueens = 0;

      public static void print_array(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void print_sudoku(int sudoku[][]) {
            for (int i = 0; i < 9; i++) {
                  for (int j = 0; j < 9; j++) {
                        System.out.print(sudoku[i][j] + " ");
                  }

                  System.out.println();
            }

      }

      public static void print_board(char board[][]) {
            System.out.println("------- New matrix ---------");
            for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board.length; j++) {
                        System.out.print("|" + board[i][j] + "|");
                  }

                  System.out.println();
            }

      }

      public static void changeArr(int arr[], int i, int val) {
            // Kaam
            if (i == arr.length) {
                  print_array(arr);
                  return;
            }

            // Recursion
            arr[i] = val;
            changeArr(arr, i + 1, val + 1); // Func call
            arr[i] = arr[i] - 2; // Backtracking step

      }

      public static void print_subset(String str, String newStr, int i) {
            // Kaam
            if (i == str.length()) {
                  if (newStr.length() == 0) {
                        System.out.println("null");
                  } else {
                        System.out.println(newStr);
                  }
                  return;
            }

            // Recursion

            print_subset(str, newStr + str.charAt(i), i + 1); // Yes want to include

            print_subset(str, newStr, i + 1); // No not to include
      }

      public static void find_permutation(String str, String ans) {
            // Base

            if (str.length() == 0) {
                  System.out.println(ans);
                  return;
            }
            // Recusrsion
            for (int i = 0; i < str.length(); i++) {
                  char currentChar = str.charAt(i);
                  String newStr = str.substring(0, i) + str.substring(i + 1);
                  find_permutation(newStr, ans + currentChar);
            }
      }

      // Find all possible soln
      public static void possi_Queens(char board[][], int row) {
            if (row == board.length) {
                  print_board(board);
                  return;
            }

            for (int i = 0; i < board.length; i++) {
                  if (isSafe(board, row, i)) {
                        board[row][i] = 'Q';
                        possi_Queens(board, row + 1);
                        board[row][i] = '_';

                  }

            }

      }

      // Find total no. of arrangment

      public static void count_Queens(char board[][], int row) {
            if (row == board.length) {
                  ways_to_print_nQueens++;
                  return;
            }

            for (int i = 0; i < board.length; i++) {
                  if (isSafe(board, row, i)) {
                        board[row][i] = 'Q';
                        count_Queens(board, row + 1);
                        board[row][i] = '_';

                  }

            }

      }

      // If solution exist or not

      public static boolean is_Queens(char board[][], int row) {
            if (row == board.length) {
                  return true;
            }

            for (int i = 0; i < board.length; i++) {
                  if (isSafe(board, row, i)) {
                        board[row][i] = 'Q';
                        if (is_Queens(board, row + 1)) {
                              return true;
                        }
                        board[row][i] = '_';

                  }

            }

            return false;
      }

      public static boolean isSafe(char board[][], int row, int col) {
            for (int i = row - 1; i >= 0; i--) {
                  if (board[i][col] == 'Q') {
                        return false;
                  }
            }

            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                  if (board[i][j] == 'Q') {
                        return false;
                  }
            }

            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                  if (board[i][j] == 'Q') {
                        return false;
                  }
            }
            return true;
      }

      public static int grid_ways(int i, int j, int n, int m) {
            if (i == n - 1 && j == m - 1) {
                  return 1;
            } else if (i == n || j == m) {
                  return 0;
            }
            int ways1 = grid_ways(i + 1, j, n, m);
            int ways2 = grid_ways(i, j + 1, n, m);
            return ways1 + ways2;
      }

      public static boolean sudoku_solver(int sudoku[][], int row, int col) {
            // Base case
            if (row == 9 && col == 0) {
                  return true;
            }

            // Recursion
            int nextRow = row, nextCol = col + 1;
            if (col + 1 == 9) {
                  nextRow = row + 1;
                  nextCol = 0;
            }
            if (sudoku[row][col] != 0) {
                  return sudoku_solver(sudoku, nextRow, nextCol);
            }
            for (int digit = 1; digit <= 9; digit++) {
                  if (is_safe(sudoku, row, col, digit)) {
                        sudoku[row][col] = digit;
                        if (sudoku_solver(sudoku, nextRow, nextCol)) {
                              return true;
                        }
                        sudoku[row][col] = 0;
                  }
            }
            return false;
      }

      public static boolean is_safe(int sudoku[][], int row, int col, int digit) {
            // Col
            for (int i = 0; i < 9; i++) {
                  if (sudoku[i][col] == digit) {
                        return false;
                  }
            }
            // Row
            for (int j = 0; j < 9; j++) {
                  if (sudoku[row][j] == digit) {
                        return false;
                  }
            }

            // grid
            int sr = (row / 3) * 3;
            int sc = (col / 3) * 3;

            for (int i = sr; i < sr + 3; i++) {
                  for (int j = sc; j < sc + 3; j++) {
                        if (sudoku[i][j] == digit) {
                              return false;
                        }
                  }
            }
            return true;
      }

      public static void main(String[] args) {
            // int arr[] = new int[5];
            // changeArr(arr, 0, 1);
            // print_array(arr);

            // print_subset(new String("abc"), new String(""), 0);
            // find_permutation(new String("abc"), new String(" "));
            int n = 4;

            char board[][] = new char[n][n];
            for (int i = 0; i < board.length; i++) {
                  for (int j = 0; j < board.length; j++) {
                        board[i][j] = '_';
                  }
            }

            // possi_Queens(board, 0);

            // count_Queens(board, 0);
            // System.out.println("No. of ways " + ways_to_print_nQueens);
            // if (is_Queens(board, 0)) {
            // System.out.println("solution exist");
            // } else {
            // System.out.println("solution doest not exist");
            // }
            // print_board(board);
            // System.out.println(grid_ways(0, 0, 3, 3));

            int sudoku[][] = {
                        { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                        { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                        { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                        { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                        { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                        { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                        { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                        { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                        { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
            };
            if (sudoku_solver(sudoku, 0, 0)) {
                  System.out.println("solution exists");
                  print_sudoku(sudoku);
            } else {
                  System.out.println("solution does not exists");
            }

      }
}
