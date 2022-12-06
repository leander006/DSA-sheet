
public class Pattern {
      public static void hollow_rectangle(int row, int col) {
            for (int i = 1; i <= row; i++) {
                  for (int j = 1; j <= col; j++) {
                        if (i == 1 || i == row || j == 1 || j == col) {
                              System.out.print(" * ");
                        } else {
                              System.out.print("   ");
                        }
                  }
                  System.out.println();
            }
      }

      public static void inverted_half_pyramind(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n - i; j++) {
                        System.out.print("  ");
                  }
                  for (int j = 1; j <= i; j++) {
                        System.out.print(" *");
                  }
                  System.out.println();
            }
      }

      public static void inverted_half_pyramid_number(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n - i + 1; j++) {
                        System.out.print(j);
                  }
                  System.out.println();
            }
      }

      public static void floyd_triangle(int n) {
            int k = 0;
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= i; j++) {
                        System.out.print((++k) + "  ");
                  }
                  System.err.println();
            }

      }

      public static void zero_one_triangle(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= i; j++) {
                        if ((i + j) % 2 == 0) {
                              System.out.print(" " + 1 + " ");
                        } else {
                              System.out.print(" " + 0 + " ");
                        }
                  }
                  System.out.println();
            }
      }

      public static void butterfly(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                  }
                  for (int j = 1; j <= 2 * (n - i); j++) {
                        System.out.print(" ");
                  }
                  for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                  }
                  System.out.println();
            }
            for (int i = n; i >= 1; i--) {
                  for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                  }
                  for (int j = 1; j <= 2 * (n - i); j++) {
                        System.out.print(" ");
                  }
                  for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                  }
                  System.out.println();
            }

      }

      public static void solid_Rhombus(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n - i; j++) {
                        System.out.print("  ");
                  }
                  for (int j = 1; j <= n; j++) {
                        System.out.print(" *");
                  }
                  System.out.println();
            }

      }

      public static void hollow_Rhombus(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n - i; j++) {
                        System.out.print("  ");
                  }
                  for (int j = 1; j <= n; j++) {
                        if (i == 1 || i == n || j == 1 || j == n) {
                              System.out.print(" *");
                        } else {
                              System.out.print("  ");
                        }
                  }
                  System.out.println();
            }

      }

      public static void daimond(int n) {
            for (int i = 1; i <= n; i++) {
                  for (int j = 1; j <= n - i; j++) {
                        System.out.print("  ");
                  }
                  for (int j = 1; j <= (2 * i) - 1; j++) {
                        System.out.print(" *");
                  }
                  System.out.println();
            }
            for (int i = n; i >= 1; i--) {
                  for (int j = 1; j <= n - i; j++) {
                        System.out.print("  ");
                  }
                  for (int j = 1; j <= (2 * i) - 1; j++) {
                        System.out.print(" *");
                  }
                  System.out.println();
            }

      }

      public static void main(String[] args) {
            hollow_rectangle(4, 9);
            inverted_half_pyramind(4);
            inverted_half_pyramid_number(9);
            floyd_triangle(4);
            zero_one_triangle(15);
            butterfly(4);
            solid_Rhombus(5);
            hollow_Rhombus(5);
            daimond(9);
      }
}
