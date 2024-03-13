public class Main {
    public static void main(String[] args) {
        List<String> list = new List<String>();

        list.add("O");
        list.add("Sporting");
        list.add("Não");
        list.add("Vai");
        list.add("Ser");
        list.add("Campeão");

        System.out.println(list.contains("O"));
        System.out.println(list.contains("Sporting"));
        System.out.println(list.contains("Não"));
        System.out.println(list.contains("Vai"));
        System.out.println(list.contains("Ser"));
        System.out.println(list.contains("Campeão"));
    }
}