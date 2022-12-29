
import java.util.ArrayList;
import java.util.Collections;

public class ArrayBasic {

      public static int max(ArrayList<Integer> Arr) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < Arr.size(); i++) {
                  max = Math.max(max, Arr.get(i));
            }

            return max;

      }

      public static void swap(ArrayList<Integer> arr, int i, int j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
      }

      public static void print(ArrayList<ArrayList<Integer>> Arr) {
            for (int i = 0; i < Arr.size(); i++) {
                  ArrayList<Integer> currentList = new ArrayList<>();
                  currentList = Arr.get(i);
                  for (int j = 0; j < currentList.size(); j++) {
                        System.out.print(currentList.get(j) + " ");
                  }
                  System.out.println();
            }
            // System.out.println();
      }

      public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(23);
            arr.add(13);
            arr.add(3);
            arr.add(63);
            arr.add(93);

            // System.out.println(max(arr));
            // print(arr);
            // swap(arr, 1, 2);
            // System.out.println(arr);

            Collections.sort(arr, Collections.reverseOrder());
            // System.out.println(arr);

            ArrayList<ArrayList<Integer>> Arr = new ArrayList<>();
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr1.add(23);
            arr1.add(3);
            arr1.add(34);
            arr1.add(13);
            arr1.add(03);
            ArrayList<Integer> arr2 = new ArrayList<>();
            arr2.add(93);
            arr2.add(23);
            arr2.add(3);
            arr2.add(903);
            arr2.add(9123);
            ArrayList<Integer> arr3 = new ArrayList<>();
            arr3.add(213);
            arr3.add(1123);
            arr3.add(32);
            arr3.add(623);
            arr3.add(923);

            Arr.add(arr1);
            Arr.add(arr2);
            Arr.add(arr3);

            System.out.println(Arr);
            print(Arr);

      }
}
