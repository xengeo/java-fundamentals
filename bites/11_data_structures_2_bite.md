# HashMaps

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

In this bite, you'll learn how to store dictionary-style data (with keys and 
values) by using a Java HashMap.

## Introduction

HashMaps are Java's equivalent to Dictionaries - they are used to store data 
as key-value pairs. Of course, we need to consider _typing_ here too! When you 
declare a HashMap in Java, you need to state the type of both the keys and 
values. So, for example, if you wanted to represent a restaurant menu as a 
HashMap, you might decide that the keys would be the name of each item 
(Strings) and the values would be the prices (Integers). Let's see an example.

```java
// create an empty HashMap ready to store String keys and Integer values
HashMap<String, Integer> menu = new HashMap<String, Integer>();
```

Beyond creating an empty HashMap, you need to know the following:

* New key-value pairs are added using `put`
* Using `put` can also update an existing key-value pair
* Values are read using `get`
* Key-value pairs are removed using `remove`

Let's see all of the above in action:

```java
// create the empty HashMap
HashMap<String, Integer> menu = new HashMap<String, Integer>();

// add a key-value pair
menu.put("huel", 2);

// add another key-value pair
menu.put("coffee", 1);

// update the price of the coffee
menu.put("coffee", 2);

// check the price of huel
menu.get("huel");
// => 2

// remove huel from the menu
menu.remove("huel");
```

## Demonstration

[Demonstration Video](https://youtu.be/mEwjt6l96JQ)

## Exercise 1

If you don't already have one, define a class called `ScratchPad` so that you 
can do some scripting in the `main` method.

Then, in the `main` method:

* Assign an empty `HashMap<String, Integer>` to a variable called `scores`
  * The keys will be quiz team names
  * The values will be their scores
* Practice using `put` to add quiz team scores to the `HashMap`
* Practice using `get` to retrieve the score for a team

[Example Solution](https://youtu.be/oMclCjDzcGo)

## Exercise 2

Change `scores` from `HashMap<String, Integer>` to `HashMap<String, Integer[]>` 
so that the values are all `Integer` arrays which can be used to give a 
breakdown of how a team scored in each of three quiz rounds.

Then:

* Practice using `put` to add quiz team scores to the `HashMap`
* Practice using `get` to retrieve the scores for a team

<details>
  <summary>Getting an error of "Array initializer is not allowed here"?</summary>
  
  If you've got something in your code like:
  
  ```java
  scores.put("Quizzy Rascal", {1,2,3});
  ```
  
  you'll find that IntelliJ is flagging `{1,2,3}` as problematic. While this
  syntax for an `Integer[]` is OK in contexts like:
  
  ```java
  Integer[] myIntegers = {1,2,3};
  ```
  
  this shorthand initialisation isn't allowed in a method call, so you have to
  explicitly tell Java that's what you want i.e.
  
  ```java
  scores.put("Quizzy Rascal", new Integer[] {1,2,3});
  ```
</details>

[Example solution](https://youtu.be/FOuxIG-F4Vg)

## Exercise 3

This one is quite challenging, so don't be disheartened if you get stuck and 
have to check the example solution! (But do take a moment to digest the video 
before moving on.)

Define a class called `RockPaperScissors` which has:

* a static field called `rules` which holds a nested `HashMap` (see below for 
further guidance)

The `rules` `HashMap` should work like this:

```java
// player 1 chooses "rock", player 2 choose "paper"
rules.get("rock").get("paper");
// => player 1 loses
```

The first `.get` returns a `HashMap` and the second `.get` returns the outcome. 
Building the `rules` `HashMap` will require a bit of planning and several 
programmatic steps.

[Example Solution](https://youtu.be/-sOWDLdQ574)

## Challenge

Define a class called `ScrabbleScore` with:

* a static field called `letterValues` which holds a `HashMap` of points for 
each letter. Each key should be a single letter and each value should be its 
points value.
* a static method called `calculate` which takes a `String` and returns the 
Scrabble score for the word, as an `Integer` e.g.:

```java
\\ Scrabble player places down the word "EXQUISITELY"
calculate("EXQUISITELY");
\\ => 30
```

__Note__: In the English language version of
[Scrabble](https://en.wikipedia.org/wiki/Scrabble), tiles are worth the
following:

* 1 point - A, E, I, O, U, L, N, S, T, R
* 2 points - D, G
* 3 points - B, C, M, P
* 4 points - F, H, V, W, Y
* 5 points - K
* 8 points - J, X
* 10 points - Q, Z

You might find you need to do a little searching around on the web for this one,
especially for how to get hold of individual letters from the word. There are
_lots_ of different approaches you could take here, some of which will require
using a new `Character` type.

<details>
  <summary>Please give me a hint!</summary>
  
  Calculating the Scrabble score for a whole word will require a few steps:
  
  * Creating a variable to hold the total score - it should start at 0
  * Splitting the word into letters
  * Looping over the letters to get the score for each one
  * Adding the score for each letter to the total score
  * Returning the total score

</details>

[Next Challenge](12_interfaces_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
