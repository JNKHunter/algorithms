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
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i) % q.length];
        }

        q = temp;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (n == q.length) resize(2*q.length);
        q[last++] = item;
        n++;
    }

    public Item dequeue() {

        if (n <= 0) throw new NoSuchElementException();
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        int rand = StdRandom.uniform(first, last);
        Item item = q[rand];

        if (rand != last-1) {
            q[rand] = q[last-1];
        }

        q[--last] = null;
        n--;

        if (first == q.length) first = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    public Item sample() {
        if (n <= 0) throw new NoSuchElementException();
        return q[StdRandom.uniform(first, last)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueue.RandomQueueIterator(this);
    }

    private class RandomQueueIterator implements Iterator<Item> {

        private int i;
        private int randomItemsSize;
        private Item[] randomItems;

        public RandomQueueIterator(RandomizedQueue queue) {
            i = 0;
            randomItemsSize = queue.size();
            randomItems = (Item[]) new Object[queue.size()];


            for (int j = 0; j < randomItemsSize; j++) {
                randomItems[j] = (Item) queue.dequeue();
            }

            for (int k = 0; k < randomItemsSize; k++) {
                queue.enqueue(randomItems[k]);
            }

        }

        public boolean hasNext() { return i < randomItemsSize; }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return randomItems[i++];
        }
    }
}
