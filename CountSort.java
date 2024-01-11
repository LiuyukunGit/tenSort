package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import algorithm.utils.GenerateArray;

import java.util.Arrays;

public class CountSort {

    public void sortFucntion(int[] array) {
//        求数组中的最大值
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
//        定义一个数字存储各个值出现的次数
        int[] numCountArray = new int[max + 1];
//        遍历原数组  记录各个值出现次数
        for (int i = 0; i < array.length; i++) {
            numCountArray[array[i]]++;
        }

//        遍历numCountArray实现排序
        int arrayIndex = 0;
        for (int i = 0; i < numCountArray.length; i++) {
            for (int j = 0; j < numCountArray[i]; j++) {
                array[arrayIndex++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        CountSort countSort = new CountSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        countSort.sortFucntion(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
