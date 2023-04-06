# TDD

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to TDD with Java and JUnit

## Introduction

If you've craving tests, this bite will sate your appetite.

Here, you'll learn how to test drive a single class using JUnit, the most popular testing framework for Java but your first task will be to install a tool called Gradle.

### Gradle

Back when you were using Python, you used a bunch of different tools to manage dependencies and Java has it's own equivalents - Gradle and Maven.

Here, and in the coming weeks, you'll learn how to use Gradle to manage your dependencies. You'll also use it to perform some tasks like run code and tests - so it's actually a bit more than a dependency management tool!

Start by installing gradle. If you see any errors, reach out to your peers and if they can't help please reach out to your coach. I.e. Don't spend a long time stuck at this point.

```shell
; brew install gradle
```

Now verify the installation.

```shell
; gradle -v
```

You should see some output about the version of Gradle you just installed.

### Initializing a Gradle Project

Using your iTerm or Terminal, head to the directory where you keep all your programming work. I keep min in `~/development`, then create a new directory for your project and `cd` into it. 

I'm going to build a something called Unicorn Tag, so my directory is called `unicorn_tag`.

Do `gradle init` to start creating a new Gradle project then...

1. Select `2` to build an `application`
2. Select `3` since your using Java
3. Select `1: no - only one application project`
4. Select `1: Groovy`
5. Enter `no` to not use the potentially unstable new features
6. Select `1: JUnit 4` to set up your project with JUnit 4 installed
7. Accept the default options that follow by pressing `return`

You should now have a whole bunch of new files inside your `unicorn_tag` directory, if you created one. Some of you will have accidentally initialized a Gradle project in the wrong directory. Don't fret - just delete them all, make sure you then `cd` into the correct directory and try again :)

### Your First Test



## Demonstration

<!-- OMITTED -->

[Demonstration Video]()

## Exercise

<!-- OMITTED -->

[Example Solution]()

## Challenge

<!-- OMITTED -->


[Next Challenge](15_spring_boot_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_tdd_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_tdd_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_tdd_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_tdd_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_tdd_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
