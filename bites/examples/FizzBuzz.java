package bites.examples;

public class FizzBuzz {

    //    static method - runs on the class, as opposed to an instance of the class
    public static String play(Integer number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else {
            return number.toString();
        }
    }

    //    main method
    public static void main(String[] args) {

//        for (Integer number = 1; number <= 100; number++) {
//            System.out.println(play(number));
//        }

        Integer counter = 100;
        while (counter >= 1) {
            System.out.println(play(counter));
            counter--;
        }
    }
}