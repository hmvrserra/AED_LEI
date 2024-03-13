import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T> implements Iterable<T>{
    private Node first, last;
    private int size;


    public List(){
        first = null;
        last = null;
        size = 0;
    }

    public void add(T item) {
        if (isEmpty()){
            last = new Node(item, null, last);
            first = last;
        }else{
            last.next = new Node(item, null, last);
            last = last.next;
        }
        size++;
    }

    //public T get(int index){}

    //public T remove(int index){}

    //public boolean removeFirst(T item){}

    //public boolean removeLast(T item){}

    //public boolean removeAll(T item){}

    public boolean isEmpty(){
        return first == null;
    }

    public boolean contains(T item){
        if (isEmpty())
            return false;
        for (Node current = first; current != null; current = current.next) {
            if (current.item.equals(item))
                return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    //public boolean isPalindrome(){}


    public Iterator<T> iterator(){
        return new ListIterator();
    }


    private class Node{
        public T item;
        public Node next;
        public Node previous;

        public Node(T item, Node next, Node previous){
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private class ListIterator implements Iterator<T>{

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
}
