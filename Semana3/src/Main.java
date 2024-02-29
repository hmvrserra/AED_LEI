public class Main {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        // Test enqueue
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("This");
        queue.enqueue("Is");
        queue.enqueue("A");
        queue.enqueue("Test");

        // Test size
        System.out.println("Size: " + queue.size()); // Should print 6

        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "Hello"
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "World"

        // Test isEmpty
        System.out.println("Is Empty: " + queue.isEmpty()); // Should print false

        // Test dequeue until empty
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

        // Test isEmpty after dequeuing all items
        System.out.println("Is Empty: " + queue.isEmpty()); // Should print true
    }
}