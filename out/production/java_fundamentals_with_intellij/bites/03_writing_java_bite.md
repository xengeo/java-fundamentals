# Writing Java

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to build a minimal Java program

## Introduction

In this section, you'll learn how to build a minimal Java program. Let's start by looking at the program you ran in the previous step.

```java
// we created a class called Message
class Message {
  // we added a slightly odd looking method called main
    public static void main(String[] args) {
      // this line does the printing
        System.out.println("Hello? Is anyone out there?");
      // note that each line inside a method MUST end with a semi colon
    }
}
```

At this point, you probably have a few questions including...

### Did we really need that class?

Yes, we did - all Java code must be encapsulated (contained within) a class. You can't just stick `System.out.println("Hello, World")` in a file on its own and (successfully) execute it.

### What is `public static void`?

Java method definitions often involve a few different keywords. Here we needed to use three:

* `public` - makes the method publicly accessible. One alternative would be. This means it can be used from outside the Message class.

* `static` - static methods are the equivalent to Python's class methods. I.e. You don't need to create an instance of the class in order to call the method.

* `void` - this is where things get really interesting! Java is a _strongly typed_ language which means we must declare what _type_ of thing methods will return. Our `main` method doesn't return anything though and we declare that using the `void` keyword. If you were writing a method that would return a `String` you'd use `String` instead of void. If the method was going to return an `Integer`, you'd use `Integer`... and so on.

### Is `String[] args` one argument or two?

This is one argument. As mentioned above, Java is _strongly typed_. In addition to declaring what methods return, we also have to declare what they receive as arguments. In this case, we use `String[]` to declare that our `main` method will receive an array of `String`s. If it were going to receive a single `String` we'd change `String[] args` to `String arg`.

<br>
<details>
<summary>How would we declare that the method would receive an array of <code>Iteger</code>s?</summary>
We'd use <code>Integer[] args</code>
</details>
<br>

### Does the filename have to match the class name?

Yes, it does and your code will not compile if they do not match.

### How does the `main` method get called?

If you pay close attention to the code above, you'll see that we just define the class and `main` method but there is no place that we do anything like `Message.main()`. Clearly the `main` method does get called because we see `Hello? Is anyone out there?` printed.

The `main` method is a special method in Java programs that is called automatically when a program is executed. So, every Java program must have one, and only one, `main` method. If you your program has no `main` methods, it will not compile. If your program has more than one `main` method, it will not compile.

> You can test this quite easily by renaming the `main` method to _anything_ else and trying to run your code.

## Exercise

Create a new java class by right-clicking on the `examples` directory in IntelliJ and selecting `New -> Java Class`. You'll be prompted to choose a name - call it `JavaQuiz`. IntelliJ will then create a new file with the beginning of a class definition. It should look like this:

```java
package bites.examples;

public class JavaQuiz {
}
```

Without copy-pasting any code, write a `main` method and, in the method body, print out your answers to these questions...

> Don't forget those semi colons!

1. Does all Java code have to be inside a class?
2. What is compilation?
3. What is special about the main method?
4. What does `void` mean?

<br>
<details>
  <summary>Click here to see our solution</summary>
</details>
<br>

## Demonstration

<!-- OMITTED -->

[Demonstration Video]()

## Challenge

Create another Java class, with a main method. Call it whatever you like. Inside the main method print `args` and some messages that explain what's being printed. Your program should compile and execute without errors.


[Next Challenge](04_static_methods_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_writing_java_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_writing_java_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_writing_java_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_writing_java_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F03_writing_java_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
