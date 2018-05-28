package sort;

import java.util.Arrays;

/**
 * Created by DELL on 2018-05-28.
 */
public class SelectionSort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    /**
     *  最差时间复杂度 ---- O(n^2)
     *  最优时间复杂度 ---- O(n^2)
     *  平均时间复杂度 ---- O(n^2)
     *  所需辅助空间 ------ O(1)
     *  稳定性 ------------ 不稳定
     *  @param arr 排序的数组
     */
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index =i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) index = j;
            }
            swap(arr,i,index);
        }
      
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
