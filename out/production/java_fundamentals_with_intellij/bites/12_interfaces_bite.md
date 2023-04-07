# interfaces

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to recognise and explain interfaces.

## Introduction

Java Interfaces don't really have a Python equivalent, so they're going to require some time and effort to properly understand and I'm going to use an analogy to start with.

Calculators, ATMs and telephones (oldish landline telephones) all have number pads that feature the numbers 0 to 9. These number pads are _interfaces_ between the a user and the inner workings of each device.

If you wanted to design a new machine that also has a number pad, you could say in your designs that the machine should _implement_ `number pad` interface. Then, whoever builds it would have a really clear understanding of what's needed.

> To empathise an important point: the inner workings of each device with the number pad interface are different. Pressing the number 1 on a calculator does not do the same thing as pressing the number 1 on an ATM.

**OK, let's go back to Java!**

Java interfaces are groups of methods without method bodies - like a number pad that has been disconnected from a calculator or telephone. Let's have a look at one...

```java
// an interface called number pad
interface number pad {
  // some methods without method bodies
  public void pressNumber(Integer number);
  public void pressCancel();
}
```

We can use the interface to declare that another class should implement these two methods, like so...

```java
// a class called Telephone that implements the number pad interface
class Telephone implements number pad {

  ArrayList<Integer> numberToDial;

  public Telephone() {
     this.numberToDial = new Arraylist<Integer>();
  }

  // we've said the class implements the number pad interface
  // so now we have to define the three number pad methods

  public void pressNumber(Integer number) {
    this.numberToDial.add(number);
  }

  public void pressCancel() {
    this.numberToDial = new ArrayList<Integer>();
  }
}
```

> If you declare that a class implements an interface and do not then define all the interface methods, the compiler will tell you off and it will not compile your code.

You'll not be creating many interfaces in the near future, beyond this bite, but you will see them being used in SpringBoot; a Java web framework that you'll definitely come across sooner or later.

## Demonstration

<!-- OMITTED -->

[Demonstration Video]()

## Exercise

Define an interface called `GenericDiary` which has the following methods:
- `addEntry`, which takes one `String` argument  - a new diary entry
- `removeEntry`, which takes one `Integer` argument - the index of the entry to be removed
- `readEntry`, which takes one `Integer` argument - the index of the entry to be read

Now define two classes, one called `TenDayDiary` and another called `InfiniteDiary`. Both of these classes should implement the `GenericDiary` interface but...

- ``TenDayDiary`` stores entries in a `String[10]`
- ``InfiniteDiary`` stores entries in an `ArrayList<String>`

> QUESTION: What benefit does this set up bring?

[Example Solution]()

## Challenge

Define an interface called `BirdBehaviours` in its own file (called BirdBehaviours.java). The `BirdBehaviours` interface should have three methods:
- `fly`
- `sing`
- `eat`

Then define three classes: `Penguin`, `Crow` and `Gull`. Each of these three classes should implement the `BirdBehaviours` interface. You can decide for yourself how each class implements each method in the `BirdBehaviours` interface :)




[Next Challenge](13_tdd_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F12_interfaces_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F12_interfaces_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F12_interfaces_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F12_interfaces_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F12_interfaces_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
