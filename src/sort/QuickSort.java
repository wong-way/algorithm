package sort;

import java.util.Arrays;

/**
 * Created by DELL on 2018-05-28.
 */
public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        int temp, i, j, pivot;
        if (left > right) return;
        pivot = arr[left];
        i = left;
        j = right;
        while (i < j) {
            while (arr[j] >=pivot && i < j)
                j--;
            while (arr[i] <=pivot && i < j)
                i++;
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        arr[left] = arr[i];
        arr[i] = pivot;
        System.out.println(Arrays.toString(arr));
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
