public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        // Display the elements in the queue
        System.out.println("Elements in the queue:");
        for (Integer item : queue) {
            System.out.println(item);
        }

        // Dequeue an element
        System.out.println("Dequeued element: " + queue.dequeue());

        // Display the elements in the queue after dequeue
        System.out.println("Elements in the queue after dequeue:");
        for (Integer item : queue) {
            System.out.println(item);
        }

        // Shift the elements in the queue
        queue.shift();

        // Display the elements in the queue after shifting
        System.out.println("Elements in the queue after shifting:");
        for (Integer item : queue) {
            System.out.println(item);
        }
    }
}