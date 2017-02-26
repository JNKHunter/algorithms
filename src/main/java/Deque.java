import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jhunter on 2/25/17.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;


    public Deque(){
        first = null;
        last = null;
    }

    private class Node<Item>{
        private Node<Item> next;
        private Node<Item> prev;
        private Item item;

    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void addFirst(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (oldFirst != null){
            oldFirst.prev = first;
        } else {
            last = first;
        }

        first.prev = null;
        n++;
    }

    public void addLast(Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        if (oldLast != null){
            oldLast.next = last;
        } else {
            first = last;
        }

        n++;
    }

    public Item removeFirst(){
        if (first == null){
            throw new NoSuchElementException();
        } else {
            Node<Item> oldFirst = first;
            first = oldFirst.next;
            oldFirst.next = null;

            if (first != null){
                first.prev = null;
            }

            --n;

            return oldFirst.item;
        }
    }

    public Item removeLast(){
        Node<Item> oldLast = last;
        last = oldLast.prev;
        last.next = null;
        oldLast.prev = null;
        --n;
        return oldLast.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<Item>(first);
    }


    private class DequeIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public DequeIterator(Node<Item> first){
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
            //noop
        }
    }

    public static void main(String[] args) {

    }
}