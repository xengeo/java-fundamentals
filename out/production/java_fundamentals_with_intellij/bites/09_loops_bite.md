# Loops

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to use loops in Java.

## Introduction

In this section, you'll learn about two type of loop, both of which you've seen before in Python

* for loops
* while loops

## For Loops

Python has it's own special way of doing for loops, whereas Java uses a more generic (or classic) approach. I.e. You'll see for loops that are very similar to Java's in many other languages.

Here's an example of a for loop in Java

```java
for(Integer counter = 1; counter < 10; counter++) {
  System.out.println("Hello this is loop number " + counter)
}
```

This loop can be considered as having 4 parts.

1. Something to keep track of how many loops have been executed. In this case, we use a variable called `counter` and it's given an initial value of 1 - `Integer counter = 1`

> I've used `counter` here because I wanted to use a variable name with meaning but you'll often see `i` used instead.

2. A continuation condition. The code above will continue executing while `counter < 10`.

3. What to do at the end of each loop - normally you would increment `counter` or `i` by doing `counter++`

4. Some code to be executed for every loop: `System.out.println("Hello this is loop number " + counter)`

## While Loops

Java's while loops are more similar to Python's and they're a bit like scrambled for loops - they have the same basic components but the structure is a bit different. Here's an example.

```java
Integer counter = 0;
while(counter < 10) {
  System.out.println("Hello this is loop number " + counter)
  counter++
}
```

We still have to declare some way of keeping track (`counter`), a continuation condition, something to do at the end of each loop (increment `counter`) and some code to run during each loop.

**So why are both needed?**

Mostly it's to provide different options, which make more or less sense depending on the use case. If you want to do something a set number of times, a `for` loop is probably neater. If you want to do something until something outside of your control changes, a `while` loop would probably make more sense.

### Demonstration

<!-- OMITTED -->

[Demonstration Video]()

### Exercise 1

Add a for loop to your FizzBuzz program so that it generates the sequence for numbers 1 to 100.

[Example Solution]()
### Exercise 2

Adapt your FizzBuzz program to use a while loop instead of for loop.

> Question: for FizzBuzz, do you find the for loop or the while loop more readable?

[Example Solution]()

## Challenge

Adapt your FizzBuzz solution to generate the sequence for numbers 100 to 1. I.e. The original sequence in reverse.


[Next Challenge](10_data_structures_1_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F09_loops_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F09_loops_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F09_loops_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F09_loops_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F09_loops_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
