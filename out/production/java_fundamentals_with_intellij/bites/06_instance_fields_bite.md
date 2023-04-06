# Instance Fields

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn how to use instance fields

## Introduction

You might have noticed that there's something crucial missing from what we've covered so far - instance variables!

In Java, instance variables (properties that belong to a specific instance of a class) are called instance fields. Using instance fields requires you to learn three things...

1. How to pass values in when creating instances of a class
2. How to assign those values to instance fields
3. How to then use instance fields

### Passing values

Passing values when creating an instance of a class is pretty straightforward, just put them between the parentheses. Imagine we wanted to create an instance of a class called `Post`, providing some content. The code would look something like this...

```java
Post post = new Post("Hello, I'm really enjoying my holidays!");
```

And if you needed to pass in the name of the author as well, you could so something like this...

```java
Post post = new Post("Hello, I'm really enjoying my holidays!", "Phileas Fogg");
```

### Assigning values to fields

In python, you used the `__init__` method to grab values that were passed during instantiation and assign them to instance variables. The Java equivalent is called a constructor method and it's name is always the same as the name of the class. For example...

```java
class Post {
  // a constructor method - is it an instance method or a static method?
  // I've defined it to take two args, content and author
  public Post(String content, String author) {
    // assign instance fields
  }
}
```

In python, you used the keyword `self` to refer to the current instance, when setting instance vars.

```python
self.content = content
self.author = author
```

The Java equivalent is `this`. So your fully fleshed out Java constructor would look like this...

```java
class Post {
  public Post(String content, String author) {
    this.content = content;
    this.author = author;
  }
}
```

## Demonstration

[Demonstration Video]()

## Exercise

Define a class called Quiz. When instantiated, it should take two questions as arguments. For example...

```java
new Quiz("what is the capital of Burkina Faso?", "What is the capital of Bhutan?");
```

There should be two instance methods:

* questionOne -> returns the first question
* questionTwo -> returns the second question

Inside the `main` method, create an instance of Quiz, call the two instance methods and print the return values.

[Example Solution]()

## Challenge

Create a class called `ProgrammingLanguage` which has three instance fields

* String name
* Integer yearOfCreation
* String creator

In the main method, create three instances of the `ProgrammingLanguage` class and print the three instance fields of each one.


[Next Challenge](07_arithmetic_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F06_instance_fields_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F06_instance_fields_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F06_instance_fields_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F06_instance_fields_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F06_instance_fields_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
