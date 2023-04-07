# Static Methods

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

Learn to define and call your own static methods

## Introduction

In the previous step we learned that static methods are like Python class methods - they're called on a class, rather than on an instance of a class. We didn't, however, see any examples beyond `main`, which is called automatically.

In this section, we'll define and call some of our own static methods.

To recap, a simple Java class (with a main method) looks like this:

```java
class Announcement {
  public static void main(String[] args) {
    System.out.println("This is an Announcement!");
  }
}
```

### Defining Static Methods

In the example below, we define a static method called alert and then call it inside the main method.

```java
class Announcement {

  // a static method that returns nothing but prints a String
  public static void alert() {
    System.out.println("Be careful not to forget your main method!");
  }

  // a normal main method signature
  public static void main(String[] args) {
    // call our static method
    Announcement.alert()
  }

}
```

And if we wanted to make `alert` take an argument, we could do this...

```java
class Announcement {

  // a static method that returns nothing but prints a String
  public static void alert(String message) {
    System.out.println(message);
  }

  // a normal main method signature
  public static void main(String[] args) {
    // call our static method
    Announcement.alert("All trains to London are running early - good luck!")
  }

}
```

## Demonstration

[Demonstration Video]()

## Exercise

Define a new class called `Announcement`, give it a static method called `celebration` and call it like this inside the `main` method.

```java
System.out.println(Announcement.celebration())
```

> HINT: Like Python, Java uses the `return` keyword ;)

[Example Solution]()

## Challenge

Add more static methods to the `Announcement` class, all of which print appropriate messages of your choosing, then call them inside the main method.

* `changeOfPlan`
* `apology`
* `politeNotice`
* `helpNeeded`


[Next Challenge](04_instance_methods_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_static_methods_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_static_methods_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_static_methods_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_static_methods_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_static_methods_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
