
public class Assignment {
      // assignment 1
      public static void rat_in_maze(int maze[][], int row, int col, String str, int visited[][]) {
            if (row == maze.length - 1 && col == maze.length - 1) {
                  System.out.println(str);
                  return;
            }
            // Down
            if (row + 1 < maze.length && visited[row + 1][col] != 1 && maze[row + 1][col] == 1) {
                  visited[row + 1][col] = 1;
                  rat_in_maze(maze, row + 1, col, str + 'D', visited);
                  visited[row + 1][col] = 0;
            }
            // Left
            if (col - 1 > 0 && visited[row][col - 1] != 1 && maze[row][col - 1] == 1) {
                  visited[row][col - 1] = 1;
                  rat_in_maze(maze, row, col - 1, str + 'L', visited);
                  visited[row][col - 1] = 0;
            }
            // Right
            if (col + 1 < maze.length && visited[row][col + 1] != 1 && maze[row][col + 1] == 1) {
                  visited[row][col + 1] = 1;
                  rat_in_maze(maze, row, col + 1, str + 'R', visited);
                  visited[row][col + 1] = 0;
            }

            // Up
            if (row - 1 > 0 && visited[row - 1][col] != 1 && maze[row - 1][col] == 1) {
                  visited[row - 1][col] = 1;
                  rat_in_maze(maze, row - 1, col, str + 'U', visited);
                  visited[row - 1][col] = 0;
            }

      }

      // Assignment 2
      final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                  { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

      public static void letterCombination(String D) {
            int length = D.length();
            if (length == 0) {
                  System.out.println(".");
                  return;
            }
            keypad_combination(0, length, new StringBuilder(), D);

      }

      public static void keypad_combination(int pos, int length, StringBuilder sb, String D) {
            if (pos == length) {
                  System.out.println(sb.toString());
            } else {
                  char[] letter = L[Character.getNumericValue(D.charAt(pos))];
                  for (int i = 0; i < letter.length; i++) {
                        keypad_combination(pos + 1, length, new StringBuilder(sb.append(letter[i])), D);
                  }
            }

      }

      // Assignmnet 3
      public static void printChess(int chess[][]) {
            for (int i = 0; i < chess.length; i++) {
                  for (int j = 0; j < chess.length; j++) {
                        System.out.print(chess[i][j] + " ");
                  }
                  System.out.println();
            }

      }

      public static boolean knight_tour(int chess[][], int r, int c, int move, int xr[], int yc[]) {
            if (move == chess.length * chess.length) {
                  return true;
            }
            int nextX, nextY;

            for (int i = 0; i < 8; i++) {
                  nextX = r + xr[i];
                  nextY = c + yc[i];

                  if (is_safe(chess, nextX, nextY)) {
                        chess[nextX][nextY] = move;
                        if (knight_tour(chess, nextX, nextY, move + 1, xr, yc)) {
                              return true;
                        } else {
                              chess[nextX][nextY] = -1; // backtracking
                        }
                  }
            }
            return false;
      }

      public static boolean is_safe(int chess[][], int r, int c) {
            return (r >= 0 && c >= 0 && r < chess.length && c < chess.length && chess[r][c] == -1);
      }

      public static void main(String[] args) {

            int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
            int[][] visi = new int[maze.length][maze.length];
            // rat_in_maze(maze, 0, 0, "", visi);
            // System.out.println(isSafe(maze, 3, 3));
            // String s = "Abc";
            int chess[][] = new int[8][8];

            for (int x = 0; x < chess.length; x++)
                  for (int y = 0; y < chess.length; y++)
                        chess[x][y] = -1;

            int xr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
            int yc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
            chess[2][2] = 0;
            if (knight_tour(chess, 0, 0, 1, xr, yc)) {
                  printChess(chess);
            } else {
                  System.out.println("solution does not exist");
            }

            // letterCombination("");
            // knight_tour(chess, 0, 0, 1);
            // System.out.println(Character.getNumericValue(s.charAt(0)));

      }
}
