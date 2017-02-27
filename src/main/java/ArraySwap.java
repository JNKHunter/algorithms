import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by jhunter on 2/26/17.
 */
public class ArraySwap {

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void shuffle(Object[] arrayToShuffle){

        int rand = 0;
        for (int i = 0; i < arrayToShuffle.length; i++) {
            rand = StdRandom.uniform(i + 1);
            exch(arrayToShuffle, i, rand);
        }

    }

    public static void main(String[] args) {

    }
}
