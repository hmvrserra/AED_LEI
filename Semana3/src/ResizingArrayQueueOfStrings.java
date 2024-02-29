public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int first;
    private int last;
    private int size;

    public ResizingArrayQueueOfStrings(){       //Constructor
        queue=new String[1];
        first=0;
        last=0;
        size=0;
    }

    private void resizeByOne() {
        String[] resized = new String[queue.length+1];

        for (int i = 0; i < resized.length; i++) {
            resized[i] = queue[i];
        }
        queue=resized;
    }

    public void enqueue(String item){       //Add item to queue
        if (size == queue.length)
            resizeByOne();
        for (int i = 0; i < queue.length; i++){
            if (queue[i] != null){
                queue[i] = item;
                size++;
                break;
            }
        }
    }

    public String dequeue(){
        String[] dequeue = new String[queue.length-1];
        String retString = queue[0];
        for (int i=0; i < dequeue.length; i++){
            dequeue[i]=queue[i+1];
        }
        queue=dequeue;
        return retString;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
}
