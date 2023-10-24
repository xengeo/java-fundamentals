package bites.examples;

public class StoryBuilder {

    String plot;

//    Constructor method - like __init__.py in python
    public StoryBuilder() {
        this.plot = "";
    }

    public void addPlotline(String text) {
        this.plot += text;
    }

    public String getPlot() {
        return this.plot;
    }

    public static void main(String[] args) {
        StoryBuilder myStory = new StoryBuilder();
        myStory.addPlotline("Here is my new plotline...");
        System.out.println(myStory.getPlot());
    }
}
