package bites.examples;

import java.sql.SQLOutput;

class Message {


//    Define variables:
//    type declarations
    String author;
    String content;


//    "main" method:
    public static void main(String[] args) {

        Message myMessage = new Message(
                "Eddie",
                "Hello, I am writing Java");

        Message myOtherMessage = new Message(
                "Xenia",
                "Hello, I am also writing Java");

        System.out.println(myMessage.author);
        System.out.println(myMessage.content);

        System.out.println(myOtherMessage.author);
        System.out.println(myOtherMessage.content);
    }


//    constructor method (similar to init method in python classes
    public Message(String author, String content) {
        this.author = author;
        this.content = content;
    }
}