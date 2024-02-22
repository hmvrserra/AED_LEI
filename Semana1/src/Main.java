import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //INPUT
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza o mês:");
        int month = sc.nextInt();

        System.out.println("Introduza o dia:");
        int day = sc.nextInt();

        System.out.println("Introduza o ano:");
        int year = sc.nextInt();

        //OUTPUT
        Date d = new Date(month,day,year);
        if(!d.isValid())
            throw new IllegalArgumentException("A data inserida é inválida.");

        System.out.println("A data é: " + d.toString());

        System.out.println("É o dia número " + d.daysSinceBeginYear() + " deste ano.");

        System.out.println("Faltam " + d.daysUntilEndYear() + " dias até ao ano " + (year+1) + ". \n");

        //INPUT

        System.out.println("Introduza um novo mês:");
        int month2 = sc.nextInt();

        System.out.println("Introduza um novo dia: ");
        int day2 = sc.nextInt();

        System.out.println("Introduza um novo ano: ");
        int year2 = sc.nextInt();

        sc.close();

        //OUTPUT
        Date d2 = new Date(month2,day2,year2);
        if(!d2.isValid())
            throw new IllegalArgumentException("A nova data inserida é inválida.");

        System.out.println("Entre a data inicialmente inserida e a nova data existem " + d.daysBetween(d2) + " dias.");
    }
}
