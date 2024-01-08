package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShellSort {
    public void sortFunction(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            int i, j;
//            增量调整
            gap = gap >> 1;
            for (i = 0; i < array.length - gap; i++) {
                int temp = array[i + gap];
                for (j = i; j >= 0; j -= gap) {
                    if (temp < array[j]) {
                        array[j + gap] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        GenerateArray generateArray = new GenerateArray();
        ShellSort shellSort = new ShellSort();
        array = generateArray.randomArray(arrayLength);
//        原始数组
        System.out.println(Arrays.toString(array));
//        排序
        long beginTime = System.currentTimeMillis();
        shellSort.sortFunction(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时间：" + (endTime - beginTime) + "ms");
    }
}
