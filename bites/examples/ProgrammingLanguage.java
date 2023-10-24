package bites.examples;

public class ProgrammingLanguage {

    String name;
    Integer yearOfCreation;
    String creator;

    public static void main(String[] args) {
        ProgrammingLanguage python = new ProgrammingLanguage(
                "Python", 2004, "ThePythonCreator");
        ProgrammingLanguage java = new ProgrammingLanguage(
                "Java", 1990, "TheJavaCreator");
        ProgrammingLanguage javascript = new ProgrammingLanguage(
                "JavaScript", 1998, "TheJavaScriptCreator");

        System.out.println(python.name + " " + python.yearOfCreation + " " + python.creator);
        System.out.println(java.name + " " + java.yearOfCreation + " " + java.creator);
        System.out.println(javascript.name + " " + javascript.yearOfCreation + " " + javascript.creator);
    }

//    Constructor method
    public ProgrammingLanguage(String name, Integer yearOfCreation, String creator) {
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.creator = creator;
    }
}
