package linkedlist;

/**
 * Created by John on 11/4/16.
 */
public class Queue <Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = item;
        if(isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()){
            last = null;
        }
        return item;
    }

}
