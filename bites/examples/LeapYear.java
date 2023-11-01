package bites.examples;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeapYear {

//    main method
    public static void main(String[] args) {
//        System.out.println(LeapYear.isLeapYear(2000));
//        System.out.println(LeapYear.isLeapYear(1970));
//        System.out.println(LeapYear.isLeapYear(1900));
//        System.out.println(LeapYear.isLeapYear(1988));
//        System.out.println(LeapYear.isLeapYear(1500));
        System.out.println(LeapYear.listLeapYearsInRange(2000, 2023));
        System.out.println(LeapYear.closestLeapYear(2007));
        System.out.println(LeapYear.closestLeapYear(2006));
        System.out.println(LeapYear.closestLeapYear(1937));
        System.out.println(LeapYear.closestLeapYear(1981));
        System.out.println(LeapYear.closestLeapYear(1850));
        System.out.println(LeapYear.closestLeapYear(1912));

    }

    private static Boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0; // Simplified - returns true or false which equates to leap year answer
    }

    public static ArrayList<Integer> listLeapYearsInRange(Integer startYear, Integer endYear) {
        ArrayList<Integer> leapYears = new ArrayList();
        while (startYear <= endYear) {
            if (LeapYear.isLeapYear(startYear)) {
                leapYears.add(startYear);
            }
            startYear++;
        }
        return leapYears;
    }

    public static ArrayList<Integer> closestLeapYear(Integer year) {

//        results list to return
        ArrayList<Integer> leapYears = new ArrayList<>(2);

//        First check if original year is a leap year
        if (LeapYear.isLeapYear(year)) {
            leapYears.add(year);
            return leapYears;
        }

//        Assign starting points for forward and back years
        Integer forwardYear = year + 1;
        Integer backYear = year - 1;

//        run while loop to check both years if leap year
        while (true) {
            if (LeapYear.isLeapYear(forwardYear) && LeapYear.isLeapYear(backYear)) {
                leapYears.add(backYear);
                leapYears.add(forwardYear);
                break;
            } else if (LeapYear.isLeapYear(forwardYear)) {
                leapYears.add(forwardYear);
                break;
            } else if (LeapYear.isLeapYear(backYear)) {
                leapYears.add(backYear);
                break;
            }

//            Reassign variables if neither conditions passed
            forwardYear++;
            backYear--;
        }

        return leapYears;
    }
}
