package bites.examples;

public class Quiz {


    String questionOne;
    String questionTwo;

//    main method:
    public static void main(String[] args) {
        Quiz myQuiz = new Quiz(
                "Name the first planet from the Sun?",
                "Name the fifth planet from the Sun?");

        System.out.println(myQuiz.getQuestionOne());
        System.out.println(myQuiz.getQuestionTwo());

    }

//    constructor:
    public Quiz(String question_one, String question_two) {
//        Instance fields (type declared above)
        this.questionOne = question_one;
        this.questionTwo = question_two;
    }

//    Instance method:
    public String getQuestionOne() {
        return this.questionOne;
    }

//    Instance method:
    public String getQuestionTwo() {
        return this.questionTwo;
    }

}
