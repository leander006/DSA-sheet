
public class Bit_manupilation {
      public static void odd_even(int n) {
            if ((n & 1) == 0) {
                  System.out.println("Even number");
            } else {
                  System.out.println("Odd number");
            }
      }

      public static int get_ith_bit(int n, int i) {
            int bitMask = 1 << i;
            if ((n & bitMask) == 0) {
                  return 0;
            }
            return 1;
      }

      public static int set_ith_bit(int n, int i) {
            int bitMask = 1 << i;
            return (n | bitMask);

      }

      public static int clear_ith_bit(int n, int i) {
            int bitMask = 1 << i;
            return (n & ~(bitMask));
      }

      public static int update_ith_bit(int n, int i, int newBit) {
            n = clear_ith_bit(n, i);
            int bitMask = newBit << i;
            return (n | bitMask);
      }

      public static int clear_last_ith_bit(int n, int i) {
            int bitMask = ~0 << i;
            return (n & bitMask);

      }

      public static int clear_ith_in_range(int n, int i, int j) {
            int a = ~0 << (j + 1);
            int b = 1 << i - 1;
            int bitMask = a | b;
            return n & bitMask;

      }

      public static boolean power_of_2(int n) {
            return (n & n - 1) == 0;
      }

      public static int count_set_bit(int n) {
            int count = 0;
            while (n > 0) {
                  if ((n & 1) != 0) {
                        count++;
                  }
                  n = n >> 1;
            }

            return count;
      }

      public static int fast_exponentail(int n, int x) {
            int ans = 1;
            while (x > 0) {
                  if ((x & 1) != 0) {
                        ans = ans * n;
                  }

                  n = n * n;
                  x = x >> 1;
            }
            return ans;
      }

      public static void main(String[] args) {
            // odd_even(0);
            // odd_even(3);
            int res = clear_ith_in_range(10, 2, 4);
            boolean res1 = power_of_2(16);

            // System.out.println(count_set_bit(16));
            System.out.println(fast_exponentail(5, 3));
      }
}
