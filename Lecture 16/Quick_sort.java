
public class Quick_sort {
      public static void print_array(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.println();
      }

      public static void quick_sort(int a[], int s, int e) {
            if (s >= e) {
                  return;
            }
            int pidx = partition(a, s, e);
            quick_sort(a, s, pidx - 1);
            quick_sort(a, pidx + 1, e);
      }

      public static int partition(int a[], int s, int e) {
            int pivot = a[e];
            int i = s - 1;
            for (int j = s; j < e; j++) {
                  if (a[j] <= pivot) {
                        i++;
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                  }
            }
            i++;
            int temp = pivot;
            a[e] = a[i];
            a[i] = temp;
            return i;
      }

      public static void main(String[] args) {
            int arr[] = { 6, 3, 9, 8, 2, 5 };
            print_array(arr);
            quick_sort(arr, 0, arr.length - 1);
            print_array(arr);
      }
}
