package util;

import java.util.Random;

/**
 * Created by jhunter on 4/11/17.
 */
public class ArrayUtil {
    public static int[] generateRandomArray(int arraySize, int minValue, int maxValue){
        int[] theArray = new int[arraySize];

        Random rand = new Random();

        for (int i = 0; i < arraySize; i++) {
            theArray[i] = generateRandomInt(minValue, maxValue);
        }

        return theArray;
    }

    public static int generateRandomInt(int minValue, int maxValue) {
        Random rand = new Random();
        return rand.nextInt((maxValue - minValue) + 1) + minValue;
    }
}
