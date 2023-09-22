# Fizzbuzz

_**This is a Makers Wheel.** Wheels are designed to develop your skills
efficiently. They are organised around a central exercise, supported by a range
of resources including text, video, and external documentation. [Read more about
how to use Makers
Wheels.](https://github.com/makersacademy/course/blob/main/labels/wheels.md)_

In this exercise you will test-drive Fizzbuzz.

- [Exercise](#exercise)
- [Supporting Materials](#supporting-materials)
  - [Setting up a project](#setting-up-a-project)
  - [Creating a Method](#creating-a-method)
  - [Ifs and Loops](#ifs-and-loops)
  - [Strings](#strings)
  - [JUnit Tests](#junit-tests)

## Video Demonstration (set up)

[Here is a link](https://youtu.be/aXlOW3wq2tQ) to a set up video with Roi and 
Will. 

## Exercise

_This is the exercise. You may or may not be able to do this yet. Use the
supporting materials below this exercise to help you._

Your task is to test-drive a program that takes a max number and returns a
string. The string should list out the numbers counting up to and including the
given max number, substituting Fizz where the number is divisible by 3, Buzz
where it is divisible by 5, and FizzBuzz where it is divisible by both 3 and 5.

Here's an example:

```
CALLING:
  fizzbuzz(15)
SHOULD RETURN:
  "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz"
```

You're going to test drive this, which will be much easier if you avoid printing
to the terminal.

Here is a starting point in Java

```java
// For: src/test/java/FizzbuzzTest.java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzbuzzTest {
    @Test
    void testGenerateListsNumbersUpToOne() {
        Fizzbuzz subject = new Fizzbuzz();
        String result = subject.generate(1);
        assertEquals("1", result);
        // Note that in JUnit, the expected value comes first
        // This is called 'Yoda Conditions'.
    }

//    @Test
//    void testGenerateListsNumbersUpToTwo() {
//        Fizzbuzz subject = new Fizzbuzz();
//        String result = subject.generate(2);
//        assertEquals("1, 2", result);
//    }
}
```

```java
// For: src/main/java/Fizzbuzz.java
public class Fizzbuzz {
    public String generate(Integer upto) {
        return "1";
    }
}
```

You're done when your code passes the following acceptance criteria:

```
CALLING:
  fizzbuzz(100)
SHOULD RETURN:
  "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61, 62, Fizz, 64, Buzz, Fizz, 67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz, Fizz, 82, 83, Fizz, Buzz, 86, Fizz, 88, 89, FizzBuzz, 91, 92, Fizz, 94, Buzz, Fizz, 97, 98, Fizz, Buzz"
```

## Supporting Materials

### Setting up a project

Let's go ahead and set up a new project.

* Install the [IntelliJ IDE](https://www.jetbrains.com/idea/) Community Edition if you haven't already.
* Call your project `tryout`.
* Select a new Gradle Java project. 
* Select a JDK that uses version 17 of Java (Eclipse Temurin 17 for example)
* Wait for it to download and install the dependencies. This might take a few
  minutes.

### Creating a Method

Let's begin with a Hello World. Open IntelliJ and create a new Java class. This
is how:

* Go into `src/main/java` in the file tree.
* Right-click on the `java` directory and select `New -> Java Class`
* Ensure `Class` is selected, and type `Main` to give it that name.

It will come with a little bit of sample code. Make it look like this:

```java
public class Main {
    public static void main(String[] args) {
       System.out.println("Hello, world!");
    }
}
```

That's quite a lot just to print hello world! Don't worry, you'll get the hang
of it. Java intentionally asks you as a programmer to be very explicit in your
programs. For example, you have to say that this `main` method doesn't return
anything by putting `void` before it. This is annoying at first, but you will —
I hope — come to see how this gives Java its strengths in industry.

More on that later. For now, run it by clicking the little green arrow to the
left of `public static void main` and selecting `Run Main.main()`.

IntelliJ will do some work, and you'll see this in the bottom panel:

```shell
00:00:00: Executing task 'Main.main()'...

> Task :compileJava
> Task :processResources NO-SOURCE
> Task :classes

> Task :Main.main()
Hello, world!

BUILD SUCCESSFUL in 2s
2 actionable tasks: 2 executed
18:09:16: Task execution finished 'Main.main()'.
```

Can you spot the "Hello, world!" there? Great! Let's move on.

### Ifs and Loops

Conditional flow (if statements), and control flow (loops) work much in the 
same way as we have seen in other languages previously.

All that needs to be considered mainly, is the syntactical difference! Let's 
take a look at an if statement:

``` java
String name = "Will";

if (name == "Will") {
  System.out.println("Hey there, Will!");
} else {
  System.out.println("Ok, where have you hidden Will?");
}
```

Pretty straightforward. And if we wanted to include an `else if`:

``` java
String name = "Neil";

if (name == "Will") {
  System.out.println("Hey there, Will!");
} else if (name == "Neil") {
  System.out.println("Buenas dias, Neil.");
} else {
  System.out.println("Ok, where have you hidden the coaches?");
}
```

Great stuff. Let's take a look at a for loop. It follows a syntax that you may 
have seen if you've looked at JavaScript before (JS pinched their syntax from 
Java after all!)

``` java
Integer number = 12;

for (int i = 1; i < number; i++) {
  System.out.println("The number is:" + i);
}
```

Here the `for loop` is iterating up to the value of `number`. 

We first set the index variable (often called `i`) as an integer of 1.

Then we set the condition - if `i` is less than `number` do...

The execution which is to add 1 to `i` (with `i++`), and then open the code 
block to hold the executable code (the `System.out.println()` method.)


Take a look at the official Java documentation for [ifs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html) 
and [loops](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html).

### Strings

<!-- OMITTED -->

Take a look at the official Java documentation for [strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html).

### JUnit Tests

<!-- OMITTED -->

Take a look at the official JUnit 5 documentation for [How to write a test](https://junit.org/junit5/docs/current/user-guide/#writing-tests).


[Next Challenge](02_bank.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F01_fizzbuzz.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F01_fizzbuzz.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F01_fizzbuzz.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F01_fizzbuzz.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F01_fizzbuzz.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
