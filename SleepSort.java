package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import algorithm.utils.GenerateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SleepSort {

    public void sortFunction(int[] array) {
        List<Integer> tempArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            final int num = array[i];
            new Thread(() -> {
                try {
                    Thread.sleep(num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(num + " ");
//                tempArray.add(num);
            }).start();
        }
        for (int i = 0; i < tempArray.size(); i++) {
            array[i] = tempArray.get(i);
        }
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] array = new int[arrayLength];
        GenerateArray generateArray = new GenerateArray();
        SleepSort sleepSort = new SleepSort();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
        sleepSort.sortFunction(array);
    }
}
