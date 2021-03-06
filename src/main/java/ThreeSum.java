import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jhunter on 4/11/17.
 * We are trying to beat O(n^3)
 */
public class ThreeSum {
    public static void main(String[] args) {

        int[] values = ArrayUtil.generateRandomArray(10,-2, 2);
        Arrays.sort(values);
        List<int[]> storedValues = new ArrayList<>();

        int leftPointer;
        int rightPointer;

        for (int i = 0; i < values.length - 3; i++) {

            leftPointer = i + 1;
            rightPointer = values.length - 1;

            while (leftPointer < rightPointer) {
                if (values[i] + values[leftPointer] + values[rightPointer] == 0) {
                    storedValues.add(new int[] {values[i], values[leftPointer], values[rightPointer]});
                }

                if (values[i] + values[leftPointer] + values[rightPointer] < 0) {
                    int curStart = leftPointer;
                    while (values[leftPointer] == values[curStart] && leftPointer < rightPointer) leftPointer++;
                }

                else {
                    int curEnd = rightPointer;
                    while (values[rightPointer] == values[curEnd] && leftPointer < rightPointer) rightPointer--;
                }
            }

        }

        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (int[] value : storedValues) {
            builder.append("Three sum values: ");
            for (int i = 0; i < value.length; i++) {
                builder.append(value[i]);
                builder.append(",");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }
}
