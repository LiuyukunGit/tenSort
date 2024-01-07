package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.util.Arrays;

public class InsertSort {

    public void sortFunction(int[] array) {
        int i, j;
        for (i = 1; i < array.length; i++) {
//            临时元素储存
            int temp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int arrayLength = 1000;
        GenerateArray generateArray = new GenerateArray();
        int[] array = new int[arrayLength];
        array = generateArray.randomArray(arrayLength);
//        原始数组
        System.out.println(Arrays.toString(array));
//        插入排序
        long beginTime = System.currentTimeMillis();
        insertSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
//        排序后的结果
        System.out.println(Arrays.toString(array));
//        运行时间
        System.out.println("运行时间：" + (endTime - beginTime) + "ms");
    }
}
