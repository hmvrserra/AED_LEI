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

        // [0] = "Hello"
        // [1] = "World"
        // [2] = "This"
        // [3] = "Is"
        // [4] = "A"
        // [5] = "Test"

        queue.printArray();


        // Test shift
        queue.shift();    //Last element in the queue becomes the first

        // [0] = "Test"
        // [1] = "Hello"
        // [2] = "World"
        // [3] = "This"
        // [4] = "Is"
        // [5] = "A"

        queue.printArray();


        // Test size
        System.out.println("Size: " + queue.size()); // Should print 6

        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "Test"
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "Hello"

        // Test isEmpty
        System.out.println("Is Empty: " + queue.isEmpty()); // Should print false

        // Test dequeue until empty
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

        // Test isEmpty after dequeued all items
        System.out.println("Is Empty: " + queue.isEmpty()); // Should print true

    }
}