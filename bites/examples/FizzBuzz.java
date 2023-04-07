package bites.examples;

public class FizzBuzz {
    public static void main(String[] args) {
        Integer counter = 1;
        while(counter <= 100) {
            System.out.println(play(counter));
            counter++;
        }
    }

    private static String play(Integer number) {
        if(number % 15 == 0) {
            return "FizzBuzz";
        } else if(number % 5 == 0 ) {
            return "Buzz";
        } else if(number % 3 == 0) {
            return "Fizz";
        } else {
            return number.toString();
        }
    }
}
