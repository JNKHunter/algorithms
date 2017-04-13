import util.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jhunter on 4/13/17.
 */
public class FindDuplicates {


    public static void main(String[] args) {
        int[] values = ArrayUtil.generateRandomArray(10,1, 10);
        Set<Integer> duplicatesSet = new HashSet<>();


        for (int i = 0; i < values.length; i++) {

            if (values[Math.abs(values[i]) - 1] > 0) {
                values[Math.abs(values[i]) - 1] *= -1;
            } else {
                duplicatesSet.add(Math.abs(values[i]));
            }
        }

        for (int duplicate: duplicatesSet) {
            System.out.println(duplicate + "\n");
        }
    }
}
