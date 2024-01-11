package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import algorithm.utils.GenerateArray;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort {

    private void sortFunction(int[] array) {
//        获取最大值
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
//        最大值长度
        int maxLength = String.valueOf(max).length();
//        基数List
        LinkedList<Integer>[] radixList = new LinkedList[10];
        for (int i = 0; i < radixList.length; i++) {
            radixList[i] = new LinkedList<Integer>();
        }
        for (int i = 1; i <= maxLength ; i++) {
//            把数组中的数放到基数List中
            for (int j = 0; j < array.length; j++) {
                radixList[getRadix(array[j], i)].add(array[j]);
            }
//            重新装载到原数组
            int index = 0;
            for (int j = 0; j < radixList.length; j++) {
                while (radixList[j].isEmpty() == false) {
                    array[index++] = radixList[j].remove();
                }
            }
        }
    }

//    获取数字应该放在哪个基数中
    public int getRadix(int num, int pos) {
        int result = 0;
        for (int i = 1; i <= pos; i++) {
            result = num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        RadixSort radixSort = new RadixSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        radixSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");
    }
}
