public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new List<>();

        // Adding elements to the list
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        // Printing the elements of the list
        System.out.println("Elements in the list:");
        for (Integer element : myList) {
            System.out.print(element + " ");
        }
        System.out.println(); // New line for readability

        // Removing an element at index 2
        int removedElement = myList.remove(2);
        System.out.println("Removed element at index 2: " + removedElement);

        // Printing the updated list
        System.out.println("Elements in the list after removal:");
        for (Integer element : myList) {
            System.out.print(element + " ");
        }
        System.out.println(); // New line for readability

        // Checking if the list contains a certain element
        int searchElement = 20;
        System.out.println("Does the list contain " + searchElement + "? " + myList.contains(searchElement));

        // Getting the size of the list
        System.out.println("Size of the list: " + myList.size());

        // Checking if the list is empty
        System.out.println("Is the list empty? " + myList.isEmpty());
    }
}