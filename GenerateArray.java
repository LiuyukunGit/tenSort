package algorithm.tenSort;

/**
 * 作者：刘玉昆（神奇的布欧）
 * WX：l1243278923
 * QQ：1243278923
 * 公众号：布欧Share
 */

import java.util.Arrays;
import java.util.Random;

public class GenerateArray {
    public int[] randomArray(int length){
        int[] numArray = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            numArray[i] = random.nextInt(length * 10);
        }
        return numArray;
    }


    public static void main(String[] args) {
        new GenerateArray().randomArray(11);
    }
}
