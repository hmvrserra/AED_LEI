import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedList<T extends Comparable<T>> implements Iterable<T> {

    private Node first, last;
    private int size;

    public OrderedList(){
        first = null;
        last = null;
        size = 0;
    }

    public void add(T item){
        if (isEmpty()){
            last = new Node(item, null, last);
            first = last;
        }else{
            last.next = new Node(item, null, last);
            last = last.next;
        }
        size++;
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

    public boolean isEmpty(){
        return size == 0;
    }

    public void sort(){
        for (int i = 0; i < size; i++){
            for (int j = i; j > 0 && less(getNodeAtIndex(j).item, getNodeAtIndex(j - 1).item); j--){
                swap(j, j - 1);
            }
        }
    }

    public void shuffle(){
        for (int i = 0; i < size; i++){
            int random = (int) ((i + 1) * Math.random());
            swap(i, random);
        }
    }

    public boolean isSorted(){
        for (Node current = first; current != null; current = current.next ){
            if (less(current.next.item, current.item))
                return false;
        }
        return true;
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

    public Iterator<T> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

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


    /************************************* EXTRA ***********************************/

    private boolean less(T a,T b){
        return a.compareTo(b) < 0;
    }

    private Node getNodeAtIndex(int index){
        Node current = first;

        for (int i = 0; i < index; i++){
            current = current.next;
        }

        return current;
    }
    public void swap(int i, int j){
        if (i < 0 || j >= size){
            throw new IndexOutOfBoundsException();
        }

        if (i == j)
            return;

        Node nodeI = getNodeAtIndex(i);
        Node nodeJ = getNodeAtIndex(j);

        T temp = nodeI.item;
        nodeI.item = nodeJ.item;
        nodeJ.item = temp;
    }

    public void printList() {
        for (Node current =  first; current != null; current = current.next) {
            System.out.print(current.item + " ");
        }
        System.out.println();
    }

}