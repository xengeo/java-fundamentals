# Data Structures - Array Lists and Arrays

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to use some of Java's data structures

## Introduction

There are lots of different data structures in Java but they're not all going to be useful in the immediate future. Here, you'll learn about the Java equivalents of Python's Lists.

> For this section, create a class called `Sandbox` so that you can write some experimental code in the `main` method.

## `ArrayList`s

The Java equivalent of a Python list is an ArrayList. Let's see some examples...

```java
ArrayList<String> contentsOfMyPocket = new ArrayList<String>();
contentsOfMyPocket.add("keys");
contentsOfMyPocket.add("phone");
contentsOfMyPocket.add("fluff");

ArrayList<Integer> reallyGreatNumbers = new ArrayList<Integer>();
reallyGreatNumbers.add(3);
reallyGreatNumbers.add(5);
reallyGreatNumbers.add(7);
reallyGreatNumbers.add(11);
```

Notice how, in each case, we have to declare what type of thing the ArrayList will contain. You might be wondering what would happen if you tried to add an Integer to `contentsOfMyPocket`. What would you expect to happen? Give it a try in the `main` method of your `Sandbox` class.

Now let's see how to read, change and remove ArrayList items.

```java
// first, create the ArrayList and add some Integers
ArrayList<Integer> reallyGreatNumbers = new ArrayList<Integer>();
reallyGreatNumbers.add(3);
reallyGreatNumbers.add(5);
reallyGreatNumbers.add(7);
reallyGreatNumbers.add(11);
// you can read / get an item using its index
reallyGreatNumbers.get(0)
// => 3
reallyGreatNumbers.get(1)
// => 5

// you can change an item using its index and the new value
reallyGreatNumbers.set(0, 11)
// would change the first item to 11

// you can remove an item using its index
reallyGreatNumbers.remove(0)
// would remove the first item
```

So there are four methods to remember here...
* `add` to add items
* `remove` to remove items
* `get` to read / get items
* `set` to change / set items

Finally, it's useful to know how to iterate through an ArrayList. There are a few options - let's go with the most python-like one for now. If you already have an ArrayList of `pebbles`, you could do this...

```java
for (String pebble : pebbles) {
  System.out.println(pebble);
}
```

Note the typing crops up again! Within the for loop, we use the variable `pebble` to hold each item as we iterate through the ArrayList. When declaring `pebble` we have to state what type of thing it will hold - in this case, by typing `String pebble`.

## Arrays

Java Arrays are a lot like `ArrayList`s but there is a crucial difference - Arrays are of fixed length. So, when you create a new empty Array, you need to state how many things it needs to hold. For example...

```java
String[] plantsIHaveKilled = new String[100];
```

The `String[100]` bit means that we want an empty array that will eventually hold Strings and that it should have 100 empty slots. If you end up killing more than 100 plants, you'll need to create a new Array with larger capacity and copy everything over.

> Dev: Oh Java, why must you make everything so complicated??
>
> Java: Hi - Java here! When you ask me to create a `String[]` I'll allocate just enough memory for that data structure and no more. If you need your array to hold 10 Strings, that's fine, but I'm not going to give you 11 Strings worth of memory as that would be a waste. If, however, you're genuinely unsure how many things your array will need to hold, I will gladly create an ArrayList for you but you should be aware that it will take up a lot more memory than, for example, a `String[5]`. So bear that in mind, particularly if you care about performance.
>
> Dev: Thanks, Java, you're a bit fussy but I kind of like you.

One nice thing about arrays is that you can create and manipulate them in a more concise manner.

```java
// create an array of four Strings
String[] famousCats = {"Larry", "Palmerston", "Geronimo", "Cat Stevens"}

// get the first item
famousCats[0]
// => "Larry"

// change the first item
famousCats[0] = "Grumpy Cat"

// remove the first item by replacing it will `null`
famousCats[0] = null
```

> You'll see both Arrays and `ArrayList`s used in the wild. At some point, you'll probably make the wrong choice - it happens to us all - then you'll get feedback and learn from the mistake :)

## Demonstration

<!-- OMITTED -->

[Demonstration Video]()

## Exercise

Define a class called `ReadingList` that has an instance field called `unread` that holds an Array of Strings. Also, define a method called `add` which takes one argument (a book title) and adds it to the first empty slot in your `unread` Array. NOTE: We're using Arrays here, not `ArrayList`s. This will make the task of adding items a bit more complex!

[Example Solution]()

## Challenge

Define a class called Queue which has an instance field called `people` that holds an ArrayList of Strings. Each item in the `people` ArrayList will be the name of a person in a queue. The class should have three methods.

* `add` - which adds people to the end of the `people` ArrayList
* `next` - which gets and removes the first person in the `people` ArrayList
* `state` - which prints a list of all the `people` who are currently queuing


[Next Challenge](13_interfaces_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F11_data_structures_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
