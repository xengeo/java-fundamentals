package bites.examples;

import java.util.Arrays;

public class TenDayDiary implements GenericDiary {

    String[] diaryEntries = new String[10];;

//    public TenDayDiary() {
//        this.diaryEntries = new String[10];
//    }

    @Override
    public void addEntry(String entry) {
        int index = 0;
        while (index <= 10) {
            if (this.diaryEntries[index] == null) {
                this.diaryEntries[index] = entry;
                break;
            }
            index++;
        }
        if (index == 11) {
            System.out.println("There are no free spaces, " +
                    "please remove an entry first.");
        }
    }

    @Override
    public void removeEntry(int entryIndex) {
        this.diaryEntries[entryIndex] = null;
    }

    @Override
    public String readEntry(int entryIndex) {
        return this.diaryEntries[entryIndex];
    }

    public static void main(String[] args) {
        TenDayDiary myDiary = new TenDayDiary();
        myDiary.addEntry("This is my new diary entry!");
        myDiary.addEntry("This is another diary entry!");
        myDiary.addEntry("And another!");
        System.out.println(Arrays.toString(myDiary.diaryEntries));
        System.out.println(myDiary.readEntry(0));
        System.out.println(myDiary.readEntry(1));
        System.out.println(myDiary.readEntry(2));
        System.out.println(myDiary.readEntry(3));


    }
}
