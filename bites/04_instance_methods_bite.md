# Instance Methods

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

In this bite, you will learn how to define and call your own instance methods.

## Introduction

As you'd expect, Java also has instance methods and these are called on 
instances of a class. In this section, you'll learn how to define and call 
instance methods, which means you'll also learn how to create instances of a 
class.

### Instantiation

To create an instance of the Announcement class, you would do this:

```java
new Announcement();
```

But you'll probably need to assign the instance to a variable. At this point, 
Java's _strong typing_ pops up again. In addition to declaring the return and 
argument types of methods, we also need to declare what type of thing a 
variable will hold. Here are some examples:

```java
String name = "Sita";
Integer age = 47;
```

> The type of `name` is `String` and the type of `age` is `Integer`.

When we're assigning our instance of Announcement, we'd do this:

```java
Announcement myAnnouncement = new Announcement();
```

> The type of `myAnnouncement` is `Announcement`.

If your head is starting to spin, don't panic - that's normal :)

Let's see the full example now:

```java
class Announcement {
  public static void main(String[] args) {
    // create an instance of Announcement and assign it to a variable
    Announcement myAnnouncement = new Announcement();
    // print the instance
    System.out.println(myAnnouncement);
  }
}
```

### Defining Instance Methods

If you leave out the `static` keyword, your method becomes an instance method 
and you ~can~ _must_ then call it on an instance of the class.

```java
// a static method
public static void myMethod() {
  System.out.println("a static method")
}

// an instance method
public void myMethod() {
  System.out.println("an instance method")
}
```

## Demonstration

[Demonstration Video](https://youtu.be/HiYWtOU6v7M)

## Exercise

Turn the static methods of your `Announcement` class into instance methods and 
call them in the `main` method.

[Example Solution](https://youtu.be/JhtmsL_xE5Y)

## Challenge

Define a class called `Bagel` which has three instance methods:

* `seeds` -> returns a `String` describing what seeds are on the bread.
* `filling` -> returns a `String` describing what is inside the bagel.
* `price` -> returns an `Integer` representing the price of this tasty Bagel.

Call each instance method inside the `main` method and print the return values.

[Next Challenge](05_instance_fields_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F04_instance_methods_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F04_instance_methods_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F04_instance_methods_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F04_instance_methods_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F04_instance_methods_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
