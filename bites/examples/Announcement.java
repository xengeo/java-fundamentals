package bites.examples;

public class Announcement {

    public static void main(String[] args) {

        Announcement myAnnouncement = new Announcement();
//        These are instances of the Announcement class
//        calling the instance methods
        System.out.println(myAnnouncement.celebration());
        System.out.println(myAnnouncement.changeOfPlan());
        System.out.println(myAnnouncement.apology());
        System.out.println(myAnnouncement.politeNotice());
        System.out.println(myAnnouncement.helpNeeded());
    }

    //    Instance methods which returns a string
    public String celebration() {
        return "This is a celebration!";
    }

    public String changeOfPlan() {
        return "Oh no! Change of plan...";
    }

    public String apology() {
        return "I'm sorry";
    }

    public String politeNotice() {
        return "This is a polite notice";
    }

    public String helpNeeded() {
        return "Help is needed";
    }
}
