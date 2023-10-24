package bites.examples;

public class Bagel {

//    main method - called automatically when running the file
    public static void main(String[] args) {

        Bagel myBagel = new Bagel();
        System.out.println(myBagel.seeds());
        System.out.println(myBagel.filling());
        System.out.println(myBagel.price());
    }

//    instance methods, called upon instances of the class
    public String seeds() {
        return "The seeds on the bagel are sesame";
    }

    public String filling() {
        return "The fillings are: ham, cheese, tomato";
    }

    public Integer price() {
        return 6;
    }
}
