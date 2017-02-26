import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jhunter on 2/25/17.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;


    public Deque() {
        first = null;
        last = null;
    }

    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> prev;
        private Item item;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (first == null) {
            first = new Node<Item>();
            first.next = null;
            last = first;
        } else {
            Node<Item> oldFirst = first;
            first = new Node<Item>();
            first.next = oldFirst;
            oldFirst.prev = first;
        }

        first.item = item;
        first.prev = null;

        n++;
    }

    public void addLast(Item item) {
        if (last == null) {
            last = new Node<Item>();
            last.next = null;
            first = last;
        } else {
            Node<Item> oldLast = last;
            last = new Node<Item>();
            last.prev = oldLast;
            oldLast.next = last;
        }

        last.item = item;
        last.next = null;

        n++;
    }

    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            Node<Item> oldFirst = first;
            first = oldFirst.next;
            oldFirst.next = null;

            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }

            --n;

            return oldFirst.item;
        }
    }

    public Item removeLast() {

        if (last == null) {
           throw new NoSuchElementException();
        } else {
            Node<Item> oldLast = last;
            last = oldLast.prev;
            oldLast.prev = null;

            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }

            --n;
            return oldLast.item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(first);
    }


    private class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public DequeIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            // noop
        }
    }
}