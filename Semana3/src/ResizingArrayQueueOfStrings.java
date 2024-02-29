public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int intiialQueueLength;
    private int first;
    private int last;
    private int size;

    public ResizingArrayQueueOfStrings(){       //Constructor
        intiialQueueLength = 5;
        queue=new String[intiialQueueLength];
        first=0;
        last=0;
        size=0;
    }

    private void resizeArrayByOne() {       //Resizes the array by one
        String[] resized = new String[queue.length+1];

        for (int i = 0; i < queue.length; i++) {
            resized[i] = queue[i];
        }
        queue=resized;
    }

    public void enqueue(String item){       //Add item to queue
        if (size == queue.length)
            resizeArrayByOne();
        for (int i = 0; i < queue.length; i++){
            if (queue[i] == null){
                queue[i] = item;
                size++;
                break;
            }
        }
    }

    public String dequeue(){        //Remove and return the least recently added item
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        String item = queue[first];
        String[] copy = new String[queue.length-1];
        for (int i = 0; i < copy.length; i++){
            copy[i]=queue[i+1];
        }
        queue=copy;
        size--;
        return item;
    }

    public boolean isEmpty(){       //Verifies if the queue is empty
        return size==0;
    }

    public int size(){      //Returns the size of the queue
        return size;
    }

    public void shift(){        //Moves the last element to the start of the queue

    }
}