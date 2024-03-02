public class Main {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        // Test enqueue
        queue.enqueue("O");
        queue.enqueue("Sporting");
        queue.enqueue("Não");
        queue.enqueue("Vai");
        queue.enqueue("Ser");
        queue.enqueue("Campeão");

        // [0] = "O"
        // [1] = "Sporting"
        // [2] = "Não"
        // [3] = "Vai"
        // [4] = "Ser"
        // [5] = "Campeão"

        queue.printArray();


        // Test shift
        queue.shift();    //Last element in the queue becomes the first

        // [0] = "Campeão"
        // [1] = "O"
        // [2] = "Sporting"
        // [3] = "Não"
        // [4] = "Vai"
        // [5] = "Ser"

        queue.printArray();


        // Test size
        System.out.println("Size: " + queue.size()); // Should print 6

        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "Campeão"
        System.out.println("Dequeue: " + queue.dequeue()); // Should print "O"

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