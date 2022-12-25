
public class Merge_sort {

      public static void print_array(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void merge_sort(int a[], int s, int e) {
            if (s >= e) {
                  return;
            }
            int mid = s + (e - s) / 2;
            merge_sort(a, s, mid);
            merge_sort(a, mid + 1, e);
            merge(a, s, mid, e);
      }

      public static void merge(int a[], int s, int mid, int e) {
            int temp[] = new int[e - s + 1];
            int i = s, j = mid + 1, k = 0;

            while (i <= s && j <= e) {
                  if (a[i] < a[j]) {
                        temp[k] = a[i];
                        i++;
                  } else {
                        temp[k] = a[j];
                        j++;
                  }
                  k++;
            }
            while (i <= mid) {
                  temp[k++] = a[i++];
            }
            while (j <= e) {
                  temp[k++] = a[j++];
            }
            for (k = 0, i = s; k < temp.length; k++, i++) {
                  a[i] = temp[k];
            }
      }

      public static void main(String[] args) {
            int arr[] = { 6, 4, 7, 8, 1, 9, 2 };
            print_array(arr);
            merge_sort(arr, 0, arr.length - 1);
            print_array(arr);
      }
}
