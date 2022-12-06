
public class Trapping_rain_water {
      public static int rainWater(int num[]) {
            int n = num.length;
            int leftArr[] = new int[n];
            int rightArr[] = new int[n];
            leftArr[0] = num[0];
            rightArr[n - 1] = num[n - 1];
            for (int i = 1; i < n; i++) {
                  leftArr[i] = Math.max(num[i], leftArr[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                  rightArr[i] = Math.max(num[i], rightArr[i + 1]);
            }
            int trapperWater = 0;
            for (int i = 0; i < n; i++) {
                  int waterLevel = Math.min(leftArr[i], rightArr[i]);
                  trapperWater += waterLevel - num[i];
            }
            return trapperWater;
      }

      public static void main(String[] args) {
            int num[] = { 4, 2, 0, 6, 3, 2, 5 };

            int res = rainWater(num);
            System.out.println("Max trapped water is " + res);
      }
}
