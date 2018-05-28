package sort;

import java.util.Arrays;

/**
 * Created by DELL on 2018-05-28.
 */
public class BubbleSort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }


    /**
     *  最差时间复杂度 ---- O(n^2)
     *  最优时间复杂度 ---- O(n^2)
     *  平均时间复杂度 ---- O(n^2)
     *  所需辅助空间 ------ O(1)
     *  @param arr
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >i ; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j - 1);
                }
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
