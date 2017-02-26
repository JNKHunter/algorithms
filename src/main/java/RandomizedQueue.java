import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jhunter on 2/25/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int n;
    private int first;
    private int last;


    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() { return n == 0; }

    public int size() { return n; }

    private void resize(int capacity) {
        assert capacity >= n;

        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++){
            temp[i] = q[(first + i) % q.length];
        }

        q = temp;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }

    public Item dequeue() {

        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            // to avoid loitering
        n--;
        first++;
        if (first == q.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    public Item sample() {
        return q[StdRandom.uniform(first, last)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueue.RandomQueueIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class RandomQueueIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}
