import java.util.*;

public class Assignment {
      public static int count(int num[], int ele) {
            int c = 0;
            for (int i = 0; i < num.length; i++) {
                  if (num[i] == ele) {
                        c++;
                  }
            }

            return c;
      }

      public static boolean Assig1(int num[]) {
            int maxTotal = 0;
            for (int i = 0; i < num.length; i++) {
                  int max = count(num, num[i]);
                  maxTotal = Math.max(maxTotal, max);
            }
            if (maxTotal >= 2) {
                  return false;
            }
            return true;
      }

      public static boolean Assig1_1(int num[]) {
            for (int i = 0; i < num.length; i++) {
                  for (int j = i + 1; j < num.length; j++) {
                        if (num[i] == num[j]) {
                              return true;
                        }
                  }
            }
            return false;

      }

      public static boolean Assig1_2(int num[]) {
            HashMap<Integer, Integer> res = new HashMap<>();
            for (int i = 0; i < num.length; i++) {
                  if (res.containsValue(num[i])) {
                        return true;
                  } else {
                        res.put(i, num[i]);
                  }
            }

            return false;
      }

      // public static int Assig2(int num[]) {
      // int s = 0, e = num.length-1;
      // while()
      // return -1;
      // }

      public static int Assig3(int price[]) {
            int maxProfit = 0;
            int buyPrice = Integer.MAX_VALUE;
            for (int i = 0; i < price.length; i++) {
                  if (buyPrice < price[i]) {
                        int profit = price[i] - buyPrice;
                        maxProfit = Math.max(maxProfit, profit);
                  } else {
                        buyPrice = price[i];
                  }
            }
            return maxProfit;
      }

      public static int Assig4(int num[]) {
            int maxwater = 0;
            int n = num.length;
            int leftArr[] = new int[n];
            leftArr[0] = num[0];
            for (int i = 1; i < n; i++) {
                  leftArr[i] = Math.max(leftArr[i - 1], num[i]);
            }
            int rightArr[] = new int[n];
            rightArr[n - 1] = num[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                  rightArr[i] = Math.max(rightArr[i + 1], num[i]);
            }
            for (int i = 0; i < n; i++) {
                  int waterTrapped = Math.min(leftArr[i], rightArr[i]);
                  maxwater += waterTrapped - num[i];
            }
            return maxwater;
      }

      public static int Assig4_1(int[] height) {
            int n = height.length;
            int res = 0, l = 0, r = n - 1;
            int rMax = height[r], lMax = height[l];
            while (l < r) {
                  if (lMax < rMax) {
                        l++;
                        lMax = Math.max(lMax, height[l]);
                        res += lMax - height[l];
                  } else {
                        r--;
                        rMax = Math.max(rMax, height[r]);
                        res += rMax - height[r];
                  }
            }
            return res;
      }

      public static List<List<Integer>> Assig5(int arr[]) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i = 0; i < arr.length; i++) {
                  for (int j = i + 1; j < arr.length; j++) {
                        for (int k = j + 1; k < arr.length; k++) {
                              if (arr[i] + arr[j] + arr[k] == 0) {
                                    List<Integer> a = new ArrayList<>();
                                    a.add(arr[i]);
                                    a.add(arr[j]);
                                    a.add(arr[k]);
                                    Collections.sort(a);
                                    res.add(a);
                              }
                        }
                  }
            }
            return res;

      }

      public static void main(String[] args) {
            int num[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
            int price[] = { 7, 6, 4, 3, 1 };
            int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
            int input[] = { -1, 0, 1, 2, -1, -4 };
            // boolean res = Assig1_1(num);
            // System.out.println("Every element is distinct " + res);
            // int res = Assig3(price);
            // System.out.println(res);
            int res = Assig4(height);
            System.out.println(res);
            // List<List<Integer>> res = Assig5(input);
            // System.out.println(res.get(0));
            // System.out.println(res.get(1));
      }
}
