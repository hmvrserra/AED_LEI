public class Main {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("Olá  ");
        queue.enqueue("Boas");
        queue.enqueue("Adeus");
        if (queue.isEmpty())
            System.out.println("Está vazio");
        else
            System.out.println("Não está vazio");
    }
}