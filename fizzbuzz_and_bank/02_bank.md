# Java Three Ways: Bank

_**This is a Makers Wheel.** Wheels are designed to develop your skills
efficiently. They are organised around a central exercise, supported by a range
of resources including text, video, and external documentation. [Read more about
how to use Makers
Wheels.](https://github.com/makersacademy/course/blob/main/labels/wheels.md)_

In this exercise you'll test-drive Bank. Where Fizzbuzz introduced you to the
rudimentary conditions and loops of the language, Bank introduces you to
way modules of code are organised in a language.

- [Exercise](#exercise)
- [Supporting Materials](#supporting-materials)
  - [Java's Paradigm](#javas-paradigm)
  - [Java Classes](#java-classes)
  - [Java Lists & Generics](#java-lists--generics)
  - [How to isolate your tests in Java](#how-to-isolate-your-tests-in-java)

## Exercise

_This is the exercise. You may or may not be able to do this yet. Use the
supporting materials below this exercise to help you._

Your task is to write an application that a user can call to make bank
transactions and then print a bank statement to the terminal.

Here are the requirements:

* Implement deposits and withdrawals.
* Implement an account statement that prints a heading row, and the date, amount
  and balance of each transaction, most recent first.
* You don't need to implement a command-line or user interface, test-driving
  and calling it in your main method.
* Data can be kept in memory, doesn't need to be in a database.

Below is an example of how your code should be called, and what it should
output.

```java
// For: src/main/java/tech/makers/bank/Main.java
// Note the package:
package tech.makers.bank;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        BankAccount bankAccount = new BankAccount();

        // Given a client makes a deposit of 1000 on 2021-01-10
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));

        // And a deposit of 2000 on 2021-01-13
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));

        // And a withdrawal of 500 on 2021-01-14
        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        // When she prints her bank statement
        System.out.println(bankAccount.generateStatement());
    }
}
```

Then she would see:

```
date || credit || debit || balance
14/01/2021 || - || 500.00 || 2500.00
13/01/2021 || 2000.00 || - || 3000.00
10/01/2021 || 1000.00 || - || 1000.00
```

## Supporting Materials

### Java's Paradigm

Java is a statically typed, object-oriented language. Here's what that means:

* **Statically Typed** means you are responsible for telling the compiler
  what type all of the variables are.
* **Object Oriented** means it structures large programs using Objects. Those
  objects encapsulate (control within them) state and expose methods that
  operate on that state for others to call. They are created from templates
  called Classes.

Here's an example of a secret diary program. Take a careful read of it to
understand what it is doing and compare it to languages you know.

```java
// For: src/main/java/tech/makers/diary/Diary.java

// You'll see the above in IntelliJ as src/main/java/tech.makers.bank/Diary
// The `tech.makers.bank` is called a package, it separates your code from
// the code of other libraries, and it's best practice to use one.
// It's also specified in the code:
package tech.makers.diary;

public class Diary {

//  Below is an instance variable.
    private String contents;
//          ^^^^^^-- We have to explicitly define the type of the variable.

//  In Java, you define the constructor as a method with the same name as
//  the class. It will be called automatically when `new Diary()` is called.
    public Diary(String contents) {
        this.contents = contents;
//      ^^^^^-- We use `this.` to write to instance variables if there's
//              a local variable or parameter of the same name.
    }

//  vvvvvv-- Here we define that this is a public method, a method that can be
//           called from outside the class.
    public String read() {
//         ^^^^^^ We have to define the return value of every method. And then
//                we absolutely have to return an object of that type!
        return contents;
    }
}
```

```java
// For: src/main/java/tech/makers/diary/SecretDiary.java
package tech.makers.diary;

public class SecretDiary {
    private Diary diary;
    private Boolean locked;

    public SecretDiary(Diary diary) {
        this.diary = diary;
        locked = true;
    }

    public void unlock() {
//         ^^^^-- A `void` return type means 'I won't return anything'.
        locked = false;
    }

    public void lock() {
        locked = true;
    }

    public String read() {
        if (locked) {
            return "Go away!";
        } else {
            return diary.read();
//                           ^^^^^^^-- Here we call the `read` method on `Diary`
        }
    }
}
```

```java
// For: src/main/java/tech/makers/diary/Main.java
package tech.makers.diary;

public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary("Eric Cantona is the best footballer!");
        SecretDiary secretDiary = new SecretDiary(diary);

        System.out.println(secretDiary.read());
        // Prints: "Go away!"

        secretDiary.unlock();
        System.out.println(secretDiary.read());
        // Prints: "Eric Cantona is the best footballer!"
    }
}
```

You are probably familiar with the idea of breaking up programs using objects
to ensure they stay small and simple. Java is one of the main languages that
popularised this style of programming. You will have noticed by now that you
can't write Java code except within objects — so the programmers who were new
to OO would have had no choice but to get used to it!

You will also have noticed that the type of everything is specified by you, the
programmer instead of inferred by the compiler. Why bother to do this? One
reason is that it makes it easier to find mistakes and perform automatic fixes.

Let's say you want to make your diary contain secret codes rather than strings.
To do this, try making this change to the above `Main` class:

```java
// Remove:
Diary diary = new Diary("Eric Cantona is the best footballer!");
// And add:
Diary diary = new Diary(1337);
```

You will see a wavy red line under the number. Move your cursor there and hit 
`Option + Enter`. You will see a few 'Context Actions'. Click the one that
reads "Change 1st parameter of constructor 'Diary' from String to int".

Now go to your `Diary` class and do the same thing over the red line there. Keep
going until you get to `return "Go away!"` and change that to `return -1`.

Now run `main` and observe the results.

The IDE did almost all of the work for us here. We didn't have to think about
all the different changes we needed to make, because we'd already written into
the program everything the IDE needed to know to tell us that. Java and its
static typing are a bit more work, but they allow our tools to do much better
analysis for us.

This may seem like a small thing now, but when you're working in a Java codebase
with hundreds of classes you will find that it is a powerful advantage.

### Java Classes

<!-- OMITTED -->

Take a look at the official Java documentation for [Java Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html).

### Java Lists & Generics

Lists in Java are fundamentally similar to other languages. However, in a
statically typed language we need to do a bit more work.

Here's a simple example of a list:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello, world!");
        System.out.println(list.get(0));
        // Prints out "Hello, world!"
    }
}
```

Want a literal list? Here you go:

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = List.of(1, 2);
        System.out.println(list.get(0));
        // Prints out "1"
    }
}
```

But if you try to add an item to that list...

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = List.of(1, 2);
        list.add(3);
        System.out.println(list.get(0));
    }
}
```

You'll get an error! Why? 

There are many different kinds of lists in Java. They are efficient at different
tasks, and they can do different sorts of things. `ArrayList`s are **mutable** —
that means you can change them after creation. Lists produced by `List.of` are
**immutable** — that means you can't change them after creation.

That's useful if you want to make sure nothing ever changes your list. But for
most of our purposes we'll need mutable data structures, and so most of the time
you should be using `ArrayList`.

Let's look at another example:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello, world!");
        // This time we'll assign the item to a variable.
        String item = list.get(0);
        System.out.println(item);
    }
}
```

This will refuse to compile! It will say:

```
error: incompatible types: Object cannot be converted to String
        String item = list.get(0);
```

But it _is_ a `String`! We know that! Why doesn't Java?

Java doesn't know because we've not specified what kind of objects `list` should
contain. We know we're just putting strings into it, but Java doesn't know that.
For all it knows, you might pass it to another method that puts Integers in it.
That's not OK in a statically typed language.

So we have a tool called Generics. They work like this:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Here we specify what type of objects are going to go into `list`.
        // Sort of like what 'flavour' of ArrayList it should be.
        ArrayList<String> list = new ArrayList<String>();
        //                                     ^^^^^^
        // You might also see   `new ArrayList<>()`
        // Which just means 'I'm not saying that again!'
        //                  'Look at the type annotation earlier in the line'.
        list.add("Hello, world!");
        String item = list.get(0); // <-- Now this works!
        System.out.println(item);
        // Prints out "Hello, world!"
    }
}
```

And if you need to have a mix of data types in one `List`? It's possible, but
not really convenient and certainly not encouraged. Try to avoid it.

### How to isolate your tests in Java

Have you completed Bank yet? If not, just test without isolation by allowing
your classes to call other classes and asserting that they return the right
values. Do test isolation at the end. Not because that's best practice, but
because you have a lot to learn and it's best to take it step by step.

Ready to go? OK. 

Testing classes in isolation from each other can be very useful. There are two
main arguments:

1. If your object calls 5 other objects each of which call 5 others, if any of
   those 25 classes break then your tests will fail. Multiply this across a
   large codebase, and it can be very hard to make changes without having to
   then go and fix 100s of tests that aren't really related to your change.
   This slows down developers, which makes the team slower, which makes the
   business slower to deliver value to customers.
2. If your object calls a class that is non-deterministic — e.g. a random number
   or the current date, then your tests won't be deterministic either. Put
   simply, if you do `assertEqual('2021-06-19', today.toString())` then you'll
   have to update your tests every day! A big waste of time.


Let's look again at the `SecretDiary` example:

```java
// For: src/main/java/tech/makers/diary/Diary.java
package tech.makers.diary;

public class Diary {

    private String contents;

    public Diary(String contents) {
        this.contents = contents;
    }
    public String read() {
        return contents;
    }
}

// For: src/main/java/tech/makers/diary/Diary.java
package tech.makers.diary;

public class SecretDiary {
    private Diary diary;
    private Boolean locked;

    // Note that we are injecting the dependency here
    // By passing a Diary into SecretDiary as an argument to the constructor.
    // So we'd need to call with `new SecretDiary(new Diary("Hello!"))`
    // This is the first step to mocking.
    public SecretDiary(Diary diary) {
        this.diary = diary;
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public void lock() {
        locked = true;
    }

    public String read() {
        if (locked) {
            return "Go away!";
        } else {
            return diary.read();
        }
    }
}

// For: src/test/java/tech/makers/diary/SecretDiaryTest.java
package tech.makers.diary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretDiaryTest {
    @Test
    void refusesToReadWhenLocked() {
        Diary diary = new Diary("Test Secrets!");
        SecretDiary secretDiary = new SecretDiary(diary);
        assertEquals("Go away!", secretDiary.read());
    }

    @Test
    void readsWhenUnlocked() {
        Diary diary = new Diary("Test Secrets!");
        SecretDiary secretDiary = new SecretDiary(diary);
        secretDiary.unlock();
        assertEquals("Test Secrets!", secretDiary.read());
    }
}
```

We are injecting the dependency on `Diary` here, which is good. But 
`SecretDiary` will still call through to `Diary` in the tests. 

To truly test in isolation we need to create a mock for `Diary`. There are
frameworks that can do this, for example [Mockito](https://site.mockito.org).
You will learn to use those, but for now it can be useful to learn a way that
doesn't require a full library.

If you're following along at home, right-click the `Diary` class file and select
`Refactor -> Extract Interface`. Set "Interface name" to `IDiary`, click the 
checkbox next to the method `read` and hit the button. Hit 'No' when it asks
if it can go and change everything for you.

You'll see that IntelliJ creates a new file and calls it `IDiary`. It looks
like this:

```java
package tech.makers.diary;

public interface IDiary {
    String read();
}
```

This is called an **Interface**. An interface is a design for a class. It
specifies its public interface — the methods it should have, their arguments,
their return values — without specifying how it should implement them — the
code. Interfaces are often prefixed with `I` to signal that that's what they
are.

In this case, we're specifying that Classes that conform to `IDiary` should
have at least one method called `read` that takes no arguments and returns a
`String`.

If you go into `Diary` now, you'll see that it has also changed:

```java
// For: src/main/java/tech/makers/diary/Diary.java
package tech.makers.diary;

public class Diary implements IDiary {
  //               ^^^^^^^^^^ ^^^^^^ Signals that we're following the rules or
  //                                 'contract' of that interface.

    // Anything private isn't part of the public interface, so is not in
    // the interface file either.
    private String contents;

    // The constructor is generally not part of the interface.
    public Diary(String contents) {
        this.contents = contents;
    }
    
    @Override // Signals that we're overriding a method from the interface
    public String read() {
        return contents;
    }
}
```

Why is this useful? Because now we can do this in `SecretDiary`:

```java
// For: src/main/java/tech/makers/diary/Diary.java
package tech.makers.diary;

public class SecretDiary {
    private IDiary diary;
    private Boolean locked;

    // We don't require a Diary anymore, just an IDiary — something that has
    // a method `String read()` on it.
    public SecretDiary(IDiary diary) {
        this.diary = diary;
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public void lock() {
        locked = true;
    }

    public String read() {
        if (locked) {
            return "Go away!";
        } else {
            return diary.read();
        }
    }
}
```

Which allows us to create our own sneaky mock of `Diary` to use in our tests!

```java
// For: src/test/java/tech/makers/diary/SecretDiaryTest.java
package tech.makers.diary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretDiaryTest {
    @Test
    void refusesToReadWhenLocked() {
        MockDiary mockDiary = new MockDiary();
        SecretDiary secretDiary = new SecretDiary(mockDiary);

        assertEquals("Go away!", secretDiary.read());
        assertEquals(false, mockDiary.iGotCalled);
    }

    @Test
    void readsWhenUnlocked() {
        MockDiary mockDiary = new MockDiary();
        SecretDiary secretDiary = new SecretDiary(mockDiary);
        secretDiary.unlock();

        assertEquals("You've successfully called through to MockDiary", secretDiary.read());
        assertEquals(true, mockDiary.iGotCalled);
    }
    
    // This is called an Inner Class. It only exists for our tests.
    // We can control its behaviours and so it is great for mocking.
    private class MockDiary implements IDiary {
        public Boolean iGotCalled = false;

        public String read() {
            // If you wanted to assert on what a method really got called with.
            // You could assign it to a field. We'll use this to be doubly
            // sure that `read` isn't called when `SecretDiary` is locked.
            iGotCalled = true;
            return "You've successfully called through to MockDiary";
        }
    }
}
```

Now we've isolated our tests. When testing `SecretDiary`, `Diary` definitely
won't be called. You can even try deleting `Diary` to prove it. Which means
it's now extra important for `Diary` to have its own tests.

Interfaces are a powerful tool in Java even beyond testing. They allow you to
define templates for classes that are then checked by the compiler. In your job,
you will probably find yourself being asked to create a new implementation of an
interface at some point. They're also very useful for refactoring — a change in
the interface will cause Java and your IDE to automatically flag where other
classes need to catch up.

Now try it yourself in Bank.


<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F02_bank.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F02_bank.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F02_bank.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F02_bank.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=fizzbuzz_and_bank%2F02_bank.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
