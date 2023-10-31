# Instance Fields

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

In this bite, you will learn how to use instance fields in Java.

## Introduction

You might have noticed that there's something crucial missing from what we've 
covered so far - instance variables!

In Java, instance variables (properties that belong to a specific instance of 
a class) are called instance fields. Using instance fields requires you to 
learn three things:

1. How to pass values in when creating instances of a class
2. How to assign those values to instance fields
3. How to then use instance fields

### Passing values

Passing values when creating an instance of a class is pretty straightforward: 
just put them between the parentheses. Imagine we wanted to create an instance 
of a class called `Post`, providing some content. The code would look something 
like this:

```java
Post post = new Post("Hello, I'm really enjoying my holidays!");
```

And if you needed to pass in the name of the author as well, you could do 
something like this:

```java
Post post = new Post("Hello, I'm really enjoying my holidays!", "Phileas Fogg");
```

### Assigning values to fields

When creating an instance of a class, you can use a constructor method to grab
values that are passed in, and assign them to instance variables. The 
constructor method always has the same name as the class. For example:

```java
class Post {
  // a constructor method - is it an instance method or a static method?
  // It's defined to take two arguments: content and author
  public Post(String content, String author) {
    // assign instance fields
  }
}
```

Whenever you want to refer to an instance variable within the current instance, 
Java utilises the keyword `this` (in the same way that you might use `self` in
Ruby or Python).

```java
this.content = content;
this.author = author;
```

But, what about the _typing_? Don't we have to declare the _type_ for `content` 
and `author`? Yes, we do! See below for the full example in Java, which includes 
type declarations.

```java
class Post {

  // type declarations
  String content;
  String author;

  // constructor
  public Post(String content, String author) {
    // assigning the content instance field
    this.content = content;
    // assigning the author instance field
    this.author = author;
  }
}
```

## Demonstration

[Demonstration Video](https://youtu.be/jAB5rTNDB8I)

## Exercise

Define a class called Quiz. When instantiated, it should take two questions as 
arguments, like so:

```java
new Quiz("what is the capital of Burkina Faso?", "What is the capital of Bhutan?");
```

There should be two instance methods:

* getQuestionOne -> returns the first question
* getQuestionTwo -> returns the second question

Inside the `main` method, create an instance of Quiz, call the two instance 
methods and print the return values.

[Example Solution](https://youtu.be/oFkHM5HFzZk)

## Challenge

Create a class called `ProgrammingLanguage` which has three instance fields:

* `String name`
* `Integer yearOfCreation`
* `String creator`

In the main method, create three instances of the `ProgrammingLanguage` class 
and print the three instance fields of each one.

[Next Challenge](06_arithmetic_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F05_instance_fields_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F05_instance_fields_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F05_instance_fields_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F05_instance_fields_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F05_instance_fields_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
