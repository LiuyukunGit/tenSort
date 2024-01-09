package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.util.Arrays;

public class SelectSort {

    public void swap(int[] array, int index1, int index2){
        array[index1] = array[index1] ^ array[index2];
        array[index2] = array[index1] ^ array[index2];
        array[index1] = array[index1] ^ array[index2];
    }

    public void sortFunction(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minNumIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            if (minNumIndex != i){
                swap(array, minNumIndex, i);
            }
        }
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        SelectSort selectSort = new SelectSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
//        输出原数组
        System.out.println(Arrays.toString(array));
//        选择排序
        long beginTime = System.currentTimeMillis();
        selectSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
