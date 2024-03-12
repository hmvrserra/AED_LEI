import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue size after enqueue: " + queue.size());
        queue.printAllElements();

        System.out.println("Dequeue test:");
        String dequeued = queue.dequeue();
        System.out.println("Dequeued: " + dequeued);
        System.out.println("Queue size after dequeue: " + queue.size());
        queue.printAllElements();

        System.out.println("isEmpty() test: " + queue.isEmpty());

        System.out.println("Enqueue elements for shift test (D E F)");

        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println("Queue size pre-test: " + queue.size());
        queue.printAllElements();
        System.out.println("Shifting..");

        queue.shift();
        System.out.println("Queue size after shift: " + queue.size());
        queue.printAllElements();

        // Test 2

            /*System.out.println("Shift test with 0 elements");
            queue = new Queue<>();
            queue.shift();*/


        System.out.println("Shift test with 1 elements { A }");
        queue = new Queue<>();
        queue.enqueue("A");
        try {
            queue.shift();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Shift test with 2 elements { A, B }");
        queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        try {
            queue.shift();
            System.out.println("Queue size after shift: " + queue.size());
            queue.printAllElements();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Shift test with 100 elements { A, B }");
        queue = new Queue<>();
        try {
            for (int i = 0; i < 100; i++) {
                String randomCharAsString = "" + (char) (new
                        Random().nextInt(94) + 33);
                queue.enqueue(randomCharAsString);
            }
            System.out.println("Queue size after enqueing 100 elements: " + queue.size());
            queue.printAllElements();
            queue.shift();
            System.out.println("Queue size after shift: " + queue.size());
            queue.printAllElements();
            for (int i = 0; i < 5; i++) {
                System.out.println("Dequeuing: " + queue.dequeue());
                System.out.println("Queue size after shift: " + queue.size());
                queue.printAllElements();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // Test using ints

        Queue<Integer> queue2 = new Queue<>();

        try {
            for (int i = 0; i < 20; i++) {
                queue2.enqueue((int) (Math.random() * 50));
            }
            System.out.println("Queue size after enqueing 20 elements: " + queue2.size());
            queue2.printAllElements();
            queue2.shift();
            System.out.println("Queue size after shift: " + queue2.size());
            queue2.printAllElements();
            for (int i = 0; i < 5; i++) {
                System.out.println("Dequeuing: " + queue2.dequeue());
                System.out.println("Queue size after shift: " + queue2.size());
                queue2.printAllElements();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

/*********************************************************************************************************************/
    public void printAllElements() {
        String outputString = "";
        for(T str : this) {
            outputString += str.toString() + " ";
        }
        System.out.println(outputString);
    }
/*********************************************************************************************************************/
}