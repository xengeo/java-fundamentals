package bites.examples;

public class Discounter {

//    Type declaration
    Integer discount;

//    constructor method
    public Discounter(Integer discount) {
        this.discount = discount;
    }

//    instance method (i.e. no 'static' so can be used on instances of class) returns an int
    public Integer applyTo(Integer num) {
        return num - (num / 100 * this.discount); // reduces total by percentage
    }

//    Main method - executed automatically
    public static void main(String[] args) {
        Discounter discounter = new Discounter(20);
        System.out.println(discounter.applyTo(100));
        System.out.println(discounter.applyTo(200));
    }
}
