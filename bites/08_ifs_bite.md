# If Statements

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

Learn to use if statements.

## Introduction

In this section, you'll learn how to build if statements in Java. Let's start by looking at an example and imagine that `weather` is normally set to either `"sunny"`, `"rainy"` or `"cold"`

```java
if(weather == "sunny") {
  System.out.println("Don't forget the suncream :)");
} else if(weather == "rainy") {
  System.out.println("You'll need an umbrella today!");
} else if(weather == "cold") {
  System.out.println("Be sure to wrap up warm");
} else {
  System.out.println("There is nothing remarkable about the weather today. What shall we talk about instead?")
}
```

Broadly speaking they're the same as if statements in Python.

- You must start with an `if`
- You can include an `else if`
- You can include an `else`

There are, however, some differences in the syntax (as you would expect).
- `else if` is the equivalent of `elif`
- You need brackets `()` around conditions i.e. After `if` and `else if`
- You need curly braces `{}` around code blocks

## Demonstration

<!-- OMITTED -->

[Demonstration Video](https://youtu.be/R-C40dKYd2Q)

## Exercise

FizzBuzz is a great exercise for practising if statements in a new language. Implement a FizzBuzz class that can give you the right result for one number - it doesn't need to loop through a sequence of numbers.

Your FizzBuzz class should have one static method:
* `play` -> takes one number as an argument and returns either Fizz, Buzz, FizzBuzz or the input number

**Example output...**

```java
FizzBuzz.play(1) => 1
FizzBuzz.play(3) => Fizz
FizzBuzz.play(5) => Buzz
FizzBuzz.play(15) => FizzBuzz
```

<br>
<details>
  <summary>Help, I'm stuck!</summary>

  <p>
    If you want to see a solution, watch the video below. If you want a hint, read on.
  </p>
  <p>
    Your <code>play</code> method has to return either an Integer or a String. Can you represent a String using a number (in a way that is meaningful to humans)? That could be tricky! Could you represent an Integer using a String? Yes, you could! The Integer could be represented as the String "1". So, in Java, how do you convert an Integer to a String? If you can do that, you can ensure that <code>play</code> will always return a String.
  </p>

</details>
<br>

[Example Solution](https://youtu.be/K5i32U_aF44)

## Challenge

> Please do a screen recording of yourself working on this challenge and submit it using [this form](https://airtable.com/shrvo9ePjlwnaiLv5?prefill_Item=java_ifs).

[Do the leap year kata in Java](https://github.com/makersacademy/skills-workshops/tree/main/process_review/exercises/leap_years)


[Next Challenge](09_loops_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F08_ifs_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F08_ifs_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F08_ifs_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F08_ifs_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F08_ifs_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
