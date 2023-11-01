package bites.examples;

import java.util.ArrayList;

public class Queue {

    ArrayList<String> people;

    public Queue() {
        this.people = new ArrayList<>();
    }

    public void add(String name) {
        this.people.add(name);
    }

    public void next() {
        System.out.println("Next:\t" + this.people.get(0));
        this.people.remove(0);
    }

    public void state() {
        System.out.println("Currently waiting:\t" + this.people);
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.add("Eddie");
        queue.add("Leo");
        queue.add("David");
        queue.add("Phoebe");
        queue.add("Hannah");
        queue.state();
        queue.next();
        queue.state();
        queue.next();
        queue.state();
    }

}
