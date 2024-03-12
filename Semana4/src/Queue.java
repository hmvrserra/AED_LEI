import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>{

    private Node first, last;
    private int size;

    public Queue(){     //constructor
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        size++;
    }

    public T dequeue(){
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty())
            last = null;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void shift(){
        if (size() <= 1) {
            throw new RuntimeException("Queue has less than two elements");
        }
        Node newFirst = last;
        Node current = first;
        while (current.next != last) {
            current = current.next;
        }
        current.next = null;
        last.next = first;
        first = newFirst;
        last = current;
    }

    public Iterator<T>  iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T>{

        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }



    private class Node {
        public T item;
        public Node next;
    }
}
