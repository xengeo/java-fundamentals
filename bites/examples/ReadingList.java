package bites.examples;

import java.util.Arrays;

public class ReadingList {

//    Declaring the type of the instance field, which is set in the constructor method
    String[] unread;

//    Constructor method - runs when you initialise an instance of ReadingList
    public ReadingList() {
        this.unread = new String[10];
    }

    public void add(String book) {
        Integer index = 0;
        for (String item : this.unread) {
            if (item == null) {
                this.unread[index] = book;
                break;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        ReadingList myReadingList = new ReadingList();
        myReadingList.add("The Philosopher's Stone");
        System.out.println(Arrays.toString(myReadingList.unread));
        myReadingList.add("The Chamber of Secrets");
        myReadingList.add("The Prisoner of Azkaban");
        myReadingList.add("The Goblet of Fire");
        System.out.println(Arrays.toString(myReadingList.unread));
    }
}

