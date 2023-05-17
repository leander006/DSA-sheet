
public class BinarySearch {
      public static int binarySearch(int num[], int ele) {
            int s = 0, e = num.length - 1;

            while (s <= e) {
                  int mid = (s + e) / 2;
                  if (num[mid] == ele) {
                        return mid;
                  } else if (num[mid] < ele) {
                        s = mid + 1;
                  } else {
                        e = mid - 1;
                  }
            }
            return -1;
      }

      public static void main(String[] args) {
            int num[] = { 1, 2, 33, 44, 55, 66, 77, 88, 99, 110 };

            int res = binarySearch(num, 70);
            System.out.println("Result is " + res);
      }
}
