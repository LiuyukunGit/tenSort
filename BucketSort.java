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
import java.util.Collections;
import java.util.List;

public class BucketSort {


    public void sortFunction(int[] array, int bucketNum) {
//        获取最大值和最小值
//        把max初始化为一个极小的值   min初始化为一个极大的值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // 创建bucketNum个桶
        List<List<Integer>> bucketList = new ArrayList<List<Integer>>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        // 将数据放入桶中
        for (int i : array) {
            // 确定元素存放的桶号
            int bucketIndex = (i - min) * (bucketNum - 1) / (max - min);
            List<Integer> list = bucketList.get(bucketIndex);
            list.add(i);// 将元素存入对应的桶中

        }
        // 遍历每一个桶
        for (int i = 0, arrIndex = 0; i < bucketList.size(); i++) {
            List<Integer> bucket = bucketList.get(i);
//            排序
            Collections.sort(bucket);
            for (int num : bucket) {
                array[arrIndex++] = num;
            }
        }

    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int buckNum = 5;
        int[] array = new int[arrayLength];
        BucketSort bucketSort = new BucketSort();
        GenerateArray generateArray = new GenerateArray();
        array = generateArray.randomArray(arrayLength);
        System.out.println(Arrays.toString(array));
        long beginTime = System.currentTimeMillis();
        bucketSort.sortFunction(array, buckNum);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("运行时长：" + (endTime - beginTime) + "ms");

    }
}
