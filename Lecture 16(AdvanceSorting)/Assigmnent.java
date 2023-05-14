public class Assigmnent {

      public static void print_array(String arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static String[] mergeAsc(String arr[], int s, int e) {
            if (s == e) {
                  String[] a = { arr[s] };
                  return a;

            }
            int mid = s + (e - s) / 2;
            // System.out.println(mid);
            String[] arr1 = mergeAsc(arr, s, mid);
            String[] arr2 = mergeAsc(arr, mid + 1, e);
            return merge(arr1, arr2);
      }

      public static String[] merge(String arr1[], String arr2[]) {
            int m = arr1.length, n = arr2.length, i = 0, j = 0, idx = 0;
            String[] arr3 = new String[m + n];

            while (i < m && j < n) {
                  if (isAlphabeticallyGreater(arr1[i], arr2[j])) {
                        arr3[idx] = arr1[i];
                        i++;
                        idx++;
                  } else {
                        arr3[idx] = arr2[j];
                        j++;
                        idx++;
                  }
            }
            while (i < m) {
                  arr3[idx] = arr1[i];
                  i++;
                  idx++;
            }
            while (j < n) {
                  arr3[idx] = arr2[j];
                  j++;
                  idx++;
            }
            return arr3;
      }

      public static boolean isAlphabeticallyGreater(String str1, String str2) {
            if (str1.compareTo(str2) < 0) {
                  return true;
            }
            return false;
      }

      // Assignment 2

      public static int mergeCount(int arr[], int s, int e) {
            if (s == e) {
                  return arr[s];
            }

            int mid = s + (e - s) / 2;

            int left = mergeCount(arr, s, mid);
            int right = mergeCount(arr, mid + 1, e);

            if (left == right) {
                  return left;
            }

            int countInLeft = check(arr, left, s, e);
            int countInRight = check(arr, right, s, e);

            int res = countInLeft > countInRight ? left : right;

            return res;
      }

      public static int check(int arr[], int num, int l, int h) {

            int count = 0;
            for (int i = l; i <= h; i++) {
                  if (arr[i] == num) {
                        count++;
                  }
            }

            return count;
      }

      // Assignment 3

      public static int mergeUpd(int arr[], int s, int mid, int e) {
            int inv = 0, i = s, j = mid, k = 0;
            int res[] = new int[(e - s + 1)];

            while (i < mid && j <= e) {
                  if (arr[i] <= arr[j]) {
                        res[k] = arr[i];
                        i++;
                        k++;
                  } else {
                        res[k] = arr[j];
                        inv += mid - i;
                        j++;
                        k++;
                  }
            }
            while (i < s) {
                  res[k] = arr[i];
                  i++;
                  k++;
            }
            while (j <= e) {
                  res[k] = arr[j];
                  j++;
                  k++;
            }
            for (i = s, k = 0; i <= e; i++, k++) {
                  arr[i] = res[k];
            }
            return inv;
      }

      public static int mergeInv(int arr[], int s, int e) {
            int inv = 0;

            if (s < e) {
                  System.out.println("s " + s + " e " + e);
                  int mid = (e + s) / 2;
                  inv += mergeInv(arr, s, mid);
                  inv += mergeInv(arr, mid + 1, e);
                  inv += mergeUpd(arr, s, mid, e);
            }
            return inv;
      }

      public static void main(String[] args) {
            // String arr[] = { "sun", "earth", "mars", "mercury" };
            // print_array(arr);
            // String res[] = mergeAsc(arr, 0, arr.length - 1);
            // print_array(res);
            int arr[] = { 2, 4, 1, 3, 5 };
            // System.out.println(mergeCount(arr, 0, arr.length - 1));
            System.out.println(mergeInv(arr, 0, arr.length - 1));
      }
}
