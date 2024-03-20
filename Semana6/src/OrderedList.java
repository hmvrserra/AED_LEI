import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedList<T extends Comparable<T>> implements Iterable<T> {


    //...

    public void sort(){

    }

    public void shuffle(){

    }

    public boolean isSorted(){

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


}

