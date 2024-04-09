public class Main {
    public static void main(String[] args) {

        OrderedList<Integer> orderedList = new OrderedList<>();

        //Adds a bunch of Integer items to the list
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.add(4);
        orderedList.add(5);
        orderedList.add(6);
        orderedList.add(7);
        orderedList.add(8);
        orderedList.add(9);
        orderedList.add(10);

        System.out.println("Initial List: ");   //Should print list in order "1 2 3 4 5 6 7 8 9 10"
        orderedList.printList();
        System.out.println("\n");

        orderedList.shuffle();  //Shuffles the list

        System.out.println("Shuffled List: ");   //Should print list with the same items but shuffled
        orderedList.printList();
        System.out.println("\n");

        orderedList.sort(); //Sorts the list using Insertion Sort

        System.out.println("Sorted List: ");   //Should print sorted list in order "1 2 3 4 5 6 7 8 9 10"
        orderedList.printList();
    }
}