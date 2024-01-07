package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.util.Arrays;

public class BubbleSort {
    public void swap(int[] array, int index1, int index2){
        array[index1] = array[index1] ^ array[index2];
        array[index2] = array[index1] ^ array[index2];
        array[index1] = array[index1] ^ array[index2];
    }
    public void sortFunction(int[] array){
//        第一层循环控制轮次   -1因为最后一轮时侯已经有序了
        for (int i = 0; i < array.length - 1; i++) {
//            优化冒泡排序  如果外层循环过后没交换过元素，count仍为0   表示数组已经有序
            int count = 0;
//            内层循环  判断大小交换
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    count++;
                }
            }
            if(count == 0){
                break;
            }
        }
    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arrayLength = 10;
        long beginTime, endTime;
        GenerateArray generateArray = new GenerateArray();
        int[] array = new int[arrayLength];
        array = generateArray.randomArray(arrayLength);
//        原始数组
        System.out.println(Arrays.toString(array));
//        冒泡排序后的数组
//        监控排序运行时间
        beginTime = System.currentTimeMillis();
        bubbleSort.sortFunction(array);
        endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长为：" + (endTime - beginTime) + "ms");
    }
}
