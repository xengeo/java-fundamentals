package bites.examples;

public class ReadingList {
    String[] unread = new String[4];

    public static void main(String[] args) {
        ReadingList readingList = new ReadingList();
        readingList.add("war and peace");
        readingList.add("the software craftsman");
        System.out.println(readingList.unread[0]);
        System.out.println(readingList.unread[1]);
        System.out.println(readingList.unread[2]);
        System.out.println(readingList.unread[3]);
    }

    private void add(String book) {
    }
}
