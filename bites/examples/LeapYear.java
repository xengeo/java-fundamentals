package bites.examples;

public class LeapYear {

//    main method
    public static void main(String[] args) {
        System.out.println(LeapYear.isLeapYear(2000));
        System.out.println(LeapYear.isLeapYear(1970));
        System.out.println(LeapYear.isLeapYear(1900));
        System.out.println(LeapYear.isLeapYear(1988));
        System.out.println(LeapYear.isLeapYear(1500));
    }

    private static Boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0; // Simplified - returns true or false which equates to leap year answer
    }
}
