package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import algorithm.utils.GenerateArray;

import java.util.Arrays;

public class MergeSort {

    public void sortFunction(int[] array) {
//        分配一个辅助数组
        int[] tempArray = new int[array.length];
        mergeSortFunction(array, tempArray, 0, array.length - 1);
    }

    public void mergeSortFunction(int[] array, int[] tempArray, int begin, int end) {
//        如果只有一个元素就不需要划分了
        if (begin < end) {
//            找中间点  递归划分左右半区
            int mid = begin + ((end - begin) >> 1);
            mergeSortFunction(array, tempArray, begin, mid);
            mergeSortFunction(array, tempArray, mid + 1, end);
//            合并
            merge(array, tempArray, begin, mid, end);
        }
    }

    public void merge(int[] array, int[] tempArray, int begin, int mid, int end) {
        int leftPos = begin;
        int rightPos = mid + 1;
        int tempArrayPos = begin;

//        合并
        while (leftPos <= mid && rightPos <= end) {
            if (array[leftPos] < array[rightPos]) {
                tempArray[tempArrayPos++] = array[leftPos++];
            } else {
                tempArray[tempArrayPos++] = array[rightPos++];
            }
        }
//        如果半区还剩余元素
        while (leftPos <= mid) {
            tempArray[tempArrayPos++] = array[leftPos++];
        }
        while (rightPos <= end) {
            tempArray[tempArrayPos++] = array[rightPos++];
        }
        for (int i = begin; i <= end; i++) {
            array[i] = tempArray[i];
        }
    }


    public static void main(String[] args) {
        int arrayLegth = 10;
        int[] array = new int[arrayLegth];
        MergeSort mergeSort = new MergeSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLegth);
        System.out.println(Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        mergeSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
