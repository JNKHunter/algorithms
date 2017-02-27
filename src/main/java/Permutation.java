import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by jhunter on 2/26/17.
 */
public class Permutation {

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        String[] values = StdIn.readAllStrings();

        for (int i = 0; i < values.length; i++) {
            queue.enqueue(values[i]);
        }

        for (int j = 0; j < num; j++) {
            StdOut.println(queue.dequeue());
        }

    }
}
