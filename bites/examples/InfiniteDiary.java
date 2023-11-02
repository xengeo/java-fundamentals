package bites.examples;

import java.util.ArrayList;

public class InfiniteDiary implements GenericDiary {

    ArrayList<String> diaryEntries = new ArrayList<String>();

//    public InfiniteDiary() {
//        this.diaryEntries = new ArrayList<>();
//    }

    @Override
    public void addEntry(String entry) {
        this.diaryEntries.add(entry);
    }

    @Override
    public void removeEntry(int entryIndex) {
        this.diaryEntries.remove(entryIndex);
    }

    @Override
    public String readEntry(int entryIndex) {
        Integer diaryLength = this.diaryEntries.size();
        if (entryIndex >= diaryLength) {
            return "Invalid entry index";
        } else {
            return this.diaryEntries.get(entryIndex);
        }
    }

    public static void main(String[] args) {
        InfiniteDiary myDiary = new InfiniteDiary();
        myDiary.addEntry("Hello, this is my diary entry");
        myDiary.addEntry("Here is my next diary entry");
        myDiary.addEntry("And another");
        InfiniteDiary myOtherDiary = new InfiniteDiary();
        System.out.println(myOtherDiary.readEntry(1));
        System.out.println(myDiary.readEntry(0));
        myDiary.removeEntry(2);
        myDiary.readEntry(2);
        System.out.println(myDiary.diaryEntries);
    }
}
