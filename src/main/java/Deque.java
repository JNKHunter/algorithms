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
        oldFirst.prev = first;
        first.prev = null;
        n++;
    }

    public void addLast(Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        oldLast.next = last;
        last.prev = oldLast;
        last.next = null;
        n++;
    }

    public Item removeFirst(){
        Node<Item> oldFirst = first;
        first = oldFirst.next;
        oldFirst.next = null;
        first.prev = null;
        return oldFirst.item;
    }

    public Item removeLast(){
        Node<Item> oldLast = last;
        last = oldLast.prev;
        last.next = null;
        oldLast.prev = null;
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
            if(!hasNext()) { throw new NoSuchElementException() }
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