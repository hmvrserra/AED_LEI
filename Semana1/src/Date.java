import java.util.Scanner;

public class Date {

    private int month;
    private int day;
    private int year;

    //Constructor
    public Date(int month, int day, int year){
        this.month=month;
        this.day=day;
        this.year=year;
    }

    //Validation
    private int daysInMonth(int month){
        if (month==11||month==9||month==6||month==4){
            return 30;
        }else if(month==2){
            if (isLeapYear(year)){
                return 29;
            }
            return 28;
        }else{
            return 31;
        }
    }

    private boolean isLeapYear(int year){
        return year%4==0&&year%100!=0||year%400==0;
    }

    public boolean isValid(){
        boolean validYear=this.year>=0;
        boolean validMonth=this.month>=1&&this.month<=12;
        boolean validDay=this.day>=1&&this.day<=daysInMonth(month);
        return validYear&&validMonth&&validDay;
    }

    //Methods
    public int month(){
        return month;
    }

    public int day(){
        return day;
    }

    public int year(){
        return year;
    }

    public String toString(){
        return month+"/"+day+"/"+year;
    }

    public boolean before(Date other){
        if(this.year<other.year){
            return true;
        }else if(this.year==other.year&&this.month<other.month){
            return true;
        }else if(this.year==other.year&&this.month==other.month&&this.day<other.day){
            return true;
        }
        return false;
    }

    public int daysSinceBeginYear(){
        int numDays=this.day;
        for(int i=1; i<month; i++){
            numDays+=daysInMonth(i);
        }
        return numDays;
    }

    public int daysUntilEndYear(){
        if(isLeapYear(this.year))
            return 366-daysSinceBeginYear();
        return 365-daysSinceBeginYear();
    }

    public int daysBetween(Date other) {
        int numDays = 0;
        if(before(other)){
            for (int i=this.year+1; i<other.year; i++) {
                if (isLeapYear(i))
                    numDays+=366;
                numDays+=365;
            }
        }else{
            for (int i=other.year+1; i<this.year; i++) {
                if (isLeapYear(i))
                    numDays+=366;
                numDays+=365;
            }
        }
        numDays+=(this.daysUntilEndYear()+other.daysSinceBeginYear());
        return numDays;
    }
}