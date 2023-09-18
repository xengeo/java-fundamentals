# arithmetic

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to do some maths with Java

## Introduction

> If you hate maths, fear not - we're going to do pretty simple stuff here :)

Java makes things simple, as the common operators are exactly what you would 
probably expect them to be.

```java
// addition
1 + 1
// subtraction
10 - 1
// multiplication
10 * 10
// division
10 / 10
// modulo
10 % 2
```

## Demonstration

[Demonstration Video](https://youtu.be/EjupOib4_gs)

## Exercise

Define a class called `Order` which has one instance Integer field called `total` and three instance methods:

* addAmount -> takes one Integer and adds it to the total
* addDiscount -> takes one Integer and subtracts it from the total
* getTotal -> returns the total

Use all these methods in the `main` to build an order and print the total.

[Example Solution](https://youtu.be/185qwN6VZC0)

## Challenge

Define a class called `Discounter` which has one Integer field called `discount` and one instance method:

* applyTo -> takes an integer, subtracts the `discount` and returns the new value

For example...

```java
Discounter discounter = new Discounter(20);
discounter.applyTo(100)
// returns 80
discounter.applyTo(200)
// returns 180
```

Inside the `main` method, create an instance of `Discounter` use the `applyTo` method and print the return values. As an added challenge, print some strings before and after the discount to explain what's going on.


[Next Challenge](07_strings_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F06_arithmetic_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F06_arithmetic_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F06_arithmetic_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F06_arithmetic_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F06_arithmetic_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
