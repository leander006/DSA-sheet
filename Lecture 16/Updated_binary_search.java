
public class Updated_binary_search {

      public static int search(int arr[], int target, int s, int e) {
            if (s >= e) {
                  return -1;
            }
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                  return mid;
            }

            // On line 1
            if (arr[s] <= arr[mid]) {
                  // On left side
                  if (arr[s] <= target && target <= arr[mid]) {
                        return search(arr, target, s, mid - 1);
                  }

                  // On right side
                  else {
                        return search(arr, target, mid + 1, e);
                  }
            }

            // On line 2
            else {
                  // On right side
                  if (arr[mid] <= target && target <= arr[e]) {
                        return search(arr, target, mid + 1, e);
                  }

                  // On left side
                  else {
                        return search(arr, target, s, mid - 1);
                  }
            }
      }

      public static void main(String[] args) {
            int arr[] = { 6, 7, 8, 1, 2, 3 };
            System.out.println(search(arr, 13, 0, arr.length - 1));
      }
}