import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    private Node first, last;
    private int size;

    public Queue(){     //constructor
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T item){

    }

    public T dequeue(){

    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void shift(){

    }

    public Iterator<T>  iterator(){

    }




    private class Node {
        public T item;
        public Node next;
    }
}
