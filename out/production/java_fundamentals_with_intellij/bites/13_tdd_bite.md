# Test Driven Development

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

In this bite, you'll learn how to use JUnit to incorporate test-driven 
development (TDD) practices into your Java coding.

## Introduction

If you've craving tests, this bite will sate your appetite.

Here, you'll learn how to test-drive a single class using JUnit, the most 
popular testing framework for Java, but your first task will be to install a 
tool called Gradle.

### Gradle

Java has a variety of tools available to help manage dependencies within your 
projects, with the most common being Gradle and Maven.

For the time being, you'll learn how to use Gradle to manage your dependencies. 
You'll also use it to perform some tasks like run code and tests - so it's 
actually a bit more than a dependency management tool!

Start by installing Gradle. If you see any errors, reach out to your peers and 
if they can't help then please reach out to your coach. (Whatever happens, 
don't spend a long time being stuck at this point.)

```shell
; brew install gradle
```

Now verify the installation.

```shell
; gradle -v
```

You should see some output about the version of Gradle you just installed.

### Initializing a Gradle Project

Using your iTerm or Terminal, head to the directory where you keep all of your 
Makers projects, create a new directory called `number_guesser`, and `cd` into 
it. 

We're going to build a programme called `NumberGuesser`, where player one
chooses a number and player two tries to guess it and receives helpful feedback
("higher" or "lower") from the program, to guide them in the right direction.

In your `number_guesser` directory, run `gradle init` to start creating a new 
Gradle project, then:

1. Enter `2` to build an `application`
2. Enter `3` since you're using Java
3. Enter `1: no - only one application project`
4. Enter `1: Groovy`
5. Enter `no` to not use the potentially unstable new features
6. Enter `1: JUnit 4` to set up your project with JUnit 4 installed
7. Accept the default options that follow by pressing `return`

You should now have a whole bunch of new files inside your `number_guesser` 
directory, if you created one. Some of you will have accidentally initialized 
a Gradle project in the wrong directory. Don't fret - just delete them all, 
make sure you then `cd` into the correct directory and try again :)

### Your First Test

Of course, the first code we'll write is a test but before that we need to do 
some planning. Here's how we want to be able to use our program:

```java
// player one creates a new game, passing in a secret number
NumberGuesser game = new NumberGuesser(10);

// player two guesses too low and sees some helpful feedback
game.guess(5);
// => "higher"

// player two guesses too high this time
game.guess(20);
// => "lower"

// and now they guess correctly
game.guess(10)
// => "correct-a-reno!!"
```

So we're going to need:

* tests
  * for when the number guessed is too low
  * for when the number guessed is too high
  * for when the number guessed is correct
* a class called `NumberGuesser`
* one method called `guess` that takes an `Integer` and returns `String`s
* a constructor that takes one `Integer` as an argument
* one instance field for holding the secret number

Let's write a test for when the guessed number is too low. This first test will 
drive us to define the `NumberGuesser` class, the constructor and the `guess` 
method.

```java
// app/src/test/java/number_guesser/NumberGuesserTest.java
package number_guesser;

import org.junit.Assert;
import org.junit.Test;

public class NumberGuesserTest {
  @Test
  public void testGuessingTooLowReturnsHigher() {
    NumberGuesser game = new NumberGuesser(10);
    // note that the expected value comes first
    // if it helps, imagine Yoda saying "higher, it should be"
    Assert.assertEquals("higher", game.guess(5));
  }
}
```

Now we can take a moment to break this down.

* Imports - we needed a couple here, both from JUnit. Most of the time IntelliJ 
will do these for you automatically, but for some static (class method) 
imports it might not do what you expect. In that case, you can give it a nudge 
by typing a few characters and then pressing `control` + `option` + `space` to 
bring up the autocomplete options.

* Annotations - just one this time (`@Test`). It tells JUnit that what follows 
should be executed as a test.

* Assertions - `Assert.assertEquals` and its counterpart 
`Assert.assertNotEquals` will get you a long way, but there are others which
will come in handy later on.

As things stand, the compiler (and IntelliJ) will complain about the fact that 
the `NumberGuesser` class doesn't exist. That's fine for now - we're going to 
continue test driving our code in the exercise which follows.

## Demonstration

[Demonstration Video](https://youtu.be/YkF5apE0oLE)

## Exercise

Based on the first test and what we've covered in previous sections, you know 
everything you need in order to complete the `NumberGuesser` program using TDD.

1. Do just enough to satisfy the compiler and no more. For example, you'll need
to define the `NumberGuesser` class.
2. Make the first test that we wrote together pass.
3. Complete the program by test driving two more scenarios, one where player two
guesses too high, and one where player two guesses correctly.

[Example Solution](https://youtu.be/2h5FEr9uJVc)

## Challenge

**This is a process feedback challenge.** That means you should record yourself
doing it and submit that recording to your coach for feedback. [How do I do
this?](https://github.com/makersacademy/golden-square-in-python/blob/main/pills/process_feedback_challenges.md)

Starting from scratch, test-drive an implementation of `FizzBuzz` that gives 
you the `FizzBuzz` value for a single number.

For example:

```java
FizzBuzz fizzBuzz = new FizzBuzz();
fizzBuzz.forNumber(1);
// => "1"
fizzBuzz.forNumber(3);
// => "Fizz"
fizzBuzz.forNumber(5);
// => "Buzz"
fizzBuzz.forNumber(15);
// => "FizzBuzz"
```

> After you're done, [submit your code and recording here.](https://airtable.com/shrvo9ePjlwnaiLv5?prefill_Item=java_tdd).

[Next Challenge](14_spring_boot_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F13_tdd_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F13_tdd_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F13_tdd_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F13_tdd_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F13_tdd_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
