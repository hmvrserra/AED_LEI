public class Main {
    public static void main(String[] args) {
        List<String> list = new List<String>();

        list.add("O");
        list.add("Sporting");
        list.add("Não");
        list.add("Não");
        list.add("Sporting");
        list.add("O");

        System.out.println(list.contains("O"));
        System.out.println(list.contains("Sporting"));
        System.out.println(list.contains("Não"));
        System.out.println(list.contains("Vai"));
        System.out.println(list.contains("Ser"));
        System.out.println(list.contains("Campeão"));

        System.out.println(list.isPalindrome());

        System.out.println(list.size());
        list.remove(5);
        System.out.println(list.size());
        list.remove(4);
        System.out.println(list.size());
        list.remove(3);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());

        System.out.println(list.get(0));
    }
}