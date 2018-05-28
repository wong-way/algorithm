package sort;

import java.util.Arrays;

/**
 * Created by DELL on 2018-05-28.
 */
public class MergeSort {
    /**
     *
     * 最差时间复杂度 ---- O(nlogn)
     * 最优时间复杂度 ---- O(nlogn)
     * 平均时间复杂度 ---- O(nlogn)
     * 所需辅助空间 ------ O(n)
     * @param arr 排序的数组
     * @param left 左边界
     * @param right 右边界
     */
    public void mergeSort(int arr[], int left, int right)    // 递归实现的归并排序(自顶向下)
    {
        if (left == right)    // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            temp[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (i=left;i<=right;i++){
            arr[i] = temp[i - left];
        }
    }



    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
