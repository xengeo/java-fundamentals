# Strings

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

In this bite, we will learn some of the ways in which you can modify or 
combine Strings within Java.

## Introduction

In this section, you'll learn how to manipulate Strings in Java. We'll cover:

* Concatenation: joining two Strings together, one after the other
* Interpolation: inserting values into the middle of Strings

### Concatenation

To join two strings together in Java, you use the `+` symbol. For example:

```java
"Hello, " + "world";
// => "Hello, world"
```

You can also do this using strings that are assigned to variables:

```java
String question = "Person 1: what is the world's oldest (currently spoken) language?";
String answer = "Person 2: Hindi";
// Note we're also concatenating a space to separate the question from the answer
String questionAndAnswer = question + " " + answer;
```

And you can concatenate arguments or variables:

```java
public String appreciate(String name) {
  return "Thank you, " + name;
}
```

### Interpolation

Interpolation is a _little_ bit more complex and there are a few approaches 
to choose from. We're going to use `String.format`, which takes several 
arguments: the initial string with some placeholders, and the values that you 
want to interpolate (insert). Here's an example:

> Java being Java, we need to declare what type of thing we're inserting. 
> `%s` means we're trying to insert Strings and %d means we're trying to insert 
> an integer. See the [docs for more examples](https://www.javatpoint.com/java-string-format).

```java
String.format("Last night I played football with %s, %s, %s and %s. We lost again!", "Warwick", "Mahbub", "Mark", "Jim");
String.format("The score was %d - %d", 5, 1);
```

## Demonstration

[Demonstration Video](https://youtu.be/-Ot3pWdDinU)

## Exercise

Add a new method to your `Order` class called `friendlyTotal` that returns the 
order total as part of a friendly message, using `String.format`. For example:

```java
order.friendlyTotal();
// => "Thanks! The total value of your order is £100."
```

[Example Solution](https://youtu.be/IerJJsyEDX0)

## Challenge

Define a class called `StoryBuilder` that has one String instance field 
called `plot` and two methods:

* addPlotline -> takes one String argument and concatenates it onto 'plot'
* getPlot -> returns `plot`

Use both methods inside the main method to build and then print a plot.

[Next Challenge](08_ifs_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F07_strings_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F07_strings_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F07_strings_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F07_strings_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F07_strings_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
