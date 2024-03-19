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

    public T get(int index){
        if (index<0 || index>=size)
            throw new NoSuchElementException();

        Node current = first;

        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.item;
    }

    public T remove(int index){
        if (index < 0 || index >= size)
            throw new NoSuchElementException();
        Node before = null, current = first;
        for (int i = 0; i < index; i++) {
            before = current;
            current = current.next;
        }
        if(before == null)
            first = first.next;
        else
            before.next = current.next;
        if(first == null)
            last = null;

        size--;
        return current.item;
    }

    public boolean removeFirst(T item){
        if (isEmpty())
            return false;

        if (first.item.equals(item)){
            first = first.next;
            if (first == null)
                last = null;
            size--;
            return true;
        }

        Node before = null, current = first;
        while (current != null && !current.item.equals(item)){
            before = current;
            current = current.next;
        }

        if (current == null)
            return false;

        if (current == last)
            last = before;

        before.next = current.next;
        size--;
        return true;
    }

    public boolean removeLast(T item){
        if (isEmpty())
            return false;

        if (last.item.equals(item)){
            if (first == last) {
                first = null;
                last = null;
                size--;
                return true;
            }
            Node current = first;
            while (current.next != last)
                current = current.next;
            current.next = null;
            last = current;
            size--;
            return true;
        }

        Node before = null, current = first;
        while (current != null && !current.item.equals(item)){
            before = current;
            current = current.next;
        }

        if (current == null)
            return false;

        if (current == first)
            first = current.next;
        else
            before.next = current.next;

        size--;
        return true;
    }

    public boolean removeAll(T item){
        boolean removed = false;
        while (removeFirst(item))
            removed = true;
        return removed;
    }

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

    public boolean isPalindrome(){
        if (isEmpty() || size == 1)
            return true;

        Node front = first;
        Node back = last;

        while (front != back && front.previous != back) {
            if (!front.item.equals(back.item))
                return false;
            front = front.next;
            back = back.previous;
        }

        return true;
    }

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