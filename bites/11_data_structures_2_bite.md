# HashMaps

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to use HashMaps

## Introduction

HashMaps are Java's equivalent to Dictionaries - they are used to store data as key-value pairs. Of course, we need to consider _typing_ here too! When you declare a HashMap in Java you need to state the type of both the keys and values. So, for example, if you wanted to represent a restaurant menu as a HashMap, you might decide that the keys would be the name of each item (Strings) and the values would be the prices (Integers). Let's see an example.

```java
// create an empty HashMap ready to store String keys and Integer values
HashMap<String, Integer> menu = new HashMap<String, Integer>()
```

Beyond creating an empty HashMap, you need to know the following
* New key-value pairs are added using `put`
* Using `put` can also update an existing key-value pair
* Values are read using `get`
* Key-value pairs are removed using `remove`

Let's see all of the above in action...

```java
// create the empty HashMap
HashMap<String, Integer> menu = new HashMap<String, Integer>()

// add a key-value pair
menu.put("huel", 2)

// add another key-value pair
menu.put("coffee", 1)

// update the price of the coffee
menu.put("coffee", 2)

// check the price of huel
menu.get("huel")
// => 2

// remove huel from the menu
menu.remove("huel")
```

## Demonstration

<!-- OMITTED -->

[Demonstration Video]()

## Exercise

Define a class called `RockPaperScissors` that has
- a static field called `rules` which holds a nested `HashMap` (see below for further guidance)
- a static method called play which takes of either "rock", "paper" or "scissors" and declares a winner.

The `rules` `HashMap` should work like this...

```java
// player 1 chooses "rock", player 2 choose "paper"
rules.get("rock").get("paper")
// => player 1 loses
```

[Example Solution]()

## Challenge

Define a class called `ScrabbleScore` with
- a static method called `calculate` which takes a `String` and returns the Scrabble score for the word, as an `Integer`
- a static field called `letterValues` which holds a `HashMap` of points for each letter. Each key should be a single letter and each value should be its points value.

<br>
<details>
  <summary>
    Please give me a hint!
  </summary>
  <p>
    Calculating the Scrabble score for a given word will require a few steps
    <ul>
      <li>Creating a variable to hold the total score - it should start at 0</li>
      <li>Splitting the word into letters</li>
      <li>Looping over the letters to get the score for each one</li>
      <li>Adding the score for each letter to the total score</li>
      <li>Returning the total score</li>
    </ul>
  </p>
</details>
<br>


[Next Challenge](12_interfaces_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_2_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
