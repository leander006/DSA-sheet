
public class Updated_binary_search {

      public static int search(int arr[], int target, int s, int e) {
            if (s >e) {
                  System.out.print("s"+s+"e"+e);
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
                        System.out.print("ll");
                        return search(arr, target, s, mid - 1);
                  }

                  // On right side
                  else {
                        System.out.print("lr");
                        return search(arr, target, mid + 1, e);
                  }
            }

            // On line 2
            else {
                  // On right side
                  if (arr[mid] <= target && target <= arr[e]) {
                        System.out.print("rl");
                        return search(arr, target, mid + 1, e);
                  }

                  // On left side
                  else {
                        System.out.print("rr");
                        return search(arr, target, s, mid - 1);
                  }
            }
      }

      public static void main(String[] args) {
            int arr[] = { 4 ,-1 ,0 ,2 ,3  };
            System.out.println(search(arr, 3, 0, arr.length - 1));
      }
}