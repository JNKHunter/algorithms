import java.util.Iterator;

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
        public Node<Item> next;
        public Item item;

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
        n++;
    }

    public void addLast(Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        oldLast.next = last;
        last.next = null;
        n++;
    }

    public Item removeFirst(){
        Node<Item> oldFirst = first;
        first.next = first;
        oldFirst.next = null;
        return oldFirst.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }





    private class DequeIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {

        }

        @Override
        public void remove() {
            //noop
        }
    }
}