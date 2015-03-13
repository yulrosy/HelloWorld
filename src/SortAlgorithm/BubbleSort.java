package SortAlgorithm;

import java.util.Arrays;

/*
    最好的时间复杂度为O(n),最坏为O(n2)
 */
public class BubbleSort {
    //升序
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        sort(new int[]{6, 2, 4, 1, 5, 9});
    }

}
