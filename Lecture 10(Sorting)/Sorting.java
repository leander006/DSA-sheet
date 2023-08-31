
public class Sorting {
      public static void buble_sort(int arr[]) {
            for (int i = 0; i < arr.length - 1; i++) {
                  int swap = 0;
                  for (int j = 0; j < arr.length - 1 - i; j++) {
                        if (arr[j] > arr[j + 1]) {
                              int temp = arr[j];
                              arr[j] = arr[j + 1];
                              arr[j + 1] = temp;
                              swap++;
                        }
                        if (swap == 0) {
                              System.out.println("Already sorted");
                              return;
                        }

                  }

            }

            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
      }

      public static void selection_sort(int arr[]) {
            int swap = 0;
            for (int i = 0; i < arr.length; i++) {
                  int minEle = i;
                  for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] < arr[minEle]) {
                              minEle = j;
                              swap++;
                        }
                  }
                  int temp = arr[minEle];
                  arr[minEle] = arr[i];
                  arr[i] = temp;

                  if (swap == 0) {
                        System.out.println("Already sorted");
                        return;
                  }
            }

            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
      }

      public static void insertion(int arr[]) {
            for (int i = 1; i < arr.length; i++) {
                  int cur = arr[i];
                  int prev = i - 1;
                  while (prev >= 0 && arr[prev] > cur) {
                        arr[prev + 1] = arr[prev];
                        prev--;
                  }
                  arr[prev + 1] = cur;
            }

            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }

      }

      public static void count_sort(int arr[]) {
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                  largest = Math.max(largest, arr[i]);
            }
            int count[] = new int[largest + 1];
            for (int i = 0; i < arr.length; i++) {
                  count[arr[i]]++;
            }

            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                  while (count[i] > 0) {
                        arr[j] = i;
                        j++;
                        count[i]--;
                  }
            }
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
      }

      public static void main(String[] args) {
            int num[] = { -2 ,1, 2 ,-1, 0 };
            // buble_sort(num);
            // selection_sort(num);
            // insertion(num);
            count_sort(num);
      }
}
