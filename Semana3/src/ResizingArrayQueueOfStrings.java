public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int first;
    private int last;
    private int size;

    public ResizingArrayQueueOfStrings(){       //Constructor
        queue = new String[1];
        first = 0;
        last = 0;
        size = 0;
    }

    private void resize(int capacity) {       //Resizes the array
        String[] resized = new String[capacity];

        for (int i = 0; i < queue.length; i++) {
            resized[i] = queue[first];
            first = next(first);
        }
        queue = resized;
        first = 0;
        last = size;
    }

    private int next(int pos){
        return (pos + 1) % queue.length;
    }

    public void enqueue(String item){       //Add item to queue
        if (size == queue.length)
            resize(queue.length * 2);
        queue[last] = item;
        last = next(last);
        size++;

        if (size == 1)
            first = last;
    }

    public String dequeue(){        //Remove and return the least recently added item
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        String item = queue[first];
        first = next(first);
        size--;
        return item;
    }

    public boolean isEmpty(){       //Verifies if the queue is empty
        return size == 0;
    }

    public int size(){      //Returns the size of the queue
        return size;
    }

    public void shift(){        //Moves the last element to the start of the queue
        if (size < 2)
            throw new RuntimeException("Queue has less than two items");
        String last = queue[size - 1];
        for (int i = size - 1; i > 0; i--){
            queue[i] = queue[i - 1];
        }
        queue[0] = last;
        first = 0;
        this.last = size - 1;
    }

    /************************************************ EXTRA ****************************************************/

    public void printArray(){
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(queue[i]);
        }
        System.out.println("]");
    }
}