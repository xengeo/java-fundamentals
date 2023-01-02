By now, you know how to identify elements on a webpage using Playwright, 
and perform actions on the located elements. This already gives us the 
ability to move around a website just like a real user, but we're still 
missing the most fundamental purpose of a test: we need to check ("assert") 
that the outcome of our actions is what we expect.

<!-- OMITTED -->

## Intro

We've written a lot of Playwright code already, but it's been entirely focused 
on navigating and interacting with pages. We've not specifically written any 
code which will "pass or fail". (You may have seen failures already, but 
these will have been failures to locate elements on a page, or failures to 
interact with your located elements, rather than confirmation that your 
output is as expected.)

So far, we've gained visibility into what our tests are doing by printing 
messages to the terminal, and taking screenshots. While these will always be 
useful (particularly when you are debugging a system), you don't want to be 
checking hundreds of screenshots, dozens of times a day! That's where 
assertions come in.

## Types of Assertion

You'll be familiar with the concept of assertions already, from your 
experiences with writing unit tests. Assertions in Playwright are no 
different - in essence, they query a located element (or an attribute of an 
element) and check whether the value encountered is the same as the value 
that the test has been programmed to detect. For example, after logging-in as 
a user called Clive, locate the `<h1>` header message at the top of the 
screen and assert that it contains the text "Hello, Clive!"

```java
assertThat(page.locator("h1")).hasText("Hello, Clive!")
```

There are many types of assertions in Playwright - many more than we have time 
to cover here. Below are some examples of the ones that you will use most often.

### hasText / containsText

As per the example above, `hasText()` looks at the content of the specified 
locator, and asserts whether it is an exact match.

There's a similar assertion, `containsText()`, which you can utilise to check 
a partial match. For example, if you wanted to check that the header message
contained the user's name, you could use `containsText()` to assert that the
text "Clive" is present.

```java
// This will pass if the header message is "Hello, Clive!"
// It will also pass if the header is "Good morning, Clive"
assertThat(page.locator("h1")).containsText("Clive")
```

As we saw when creating locators, you can also use a [regular 
expression](pills/regular_expressions.md) to check for a particular pattern of 
text within an element.

### hasCount

This is a quick way of easily verifying whether a locator matches the 
expected number of items. For example, suppose you have a page which lists
all of the users in your system:

```html
<h3>List of users</h3>
<ul>
    <li>John</li>
    <li>Jane</li>
    <li>Jemma</li>
    <li>Jonas</li>
    <li>Jessica</li>
</ul>
```

You could assert that the number of users listed is correct, by counting how 
many list items are visible on the page.

```java
// This will pass if the number of users listed is 5
// It will fail if there are more (or fewer) than 5 users
assertThat(page.getByRole(AriaRole.LISTITEM)).hasCount(5);
```

### hasTitle

`hasTitle()` is a special assertion which checks the title of the current
page. This is useful if you want to check that you have navigated to the
correct page, or that you have been redirected to the correct page after
performing an action.

```java
// This will pass if the page title is "Users"
// It will fail if the page title is anything else
assertThat(page).hasTitle("Users");
```

### hasURL

Similarly, `hasURL()` allows you to check the web address of the current page, 
if you want to check that your previous action has taken you to the correct 
location.

```java
// This will pass if the page URL is "https://example.org/users"
// It will fail if the page URL is anything else
assertThat(page).hasURL("https://example.org/users");
```

### "not"

For any of Playwright's assertions, you can add "not" to the start of the
assertion to check that the assertion is false. For example, if you wanted
to assert that the page title does _not_ contain the word "Users":

```java
// This will pass if the page title is anything other than "Users"
// It will fail if the page title is "Users"
assertThat(page).not().hasTitle("Users");
```

### And more!

You can find a complete list of all the available assertion types within [the 
Playwright documentation for 
Assertions](https://playwright.dev/java/docs/test-assertions). Examples of 
some assertion types that we didn't cover above, which you might be interested 
in learning further about:

* Whether an element is empty
* Whether an element is visible on the page, or set as hidden
* Whether a form field is editable, or whether it is read-only
* Whether a form field currently has cursor focus
* Whether an element has a particular ID or CSS property

## Exercise

In previous exercises, we've worked with the TodoMVC application a bit. Now 
it's time to write a meaningful end-to-end test of its functionality.

Write a test for the TodoMVC application which does the following:

* Change the test so that it starts at `https://todomvc.com/examples/react/#/`
* Add an assertion which checks the title of the page is "React • TodoMVC"
* Add a new to-do item, "Buy some milk".
* Assert that the new item has been added to the list of to-do items.
* Assert that there is a message "1 item left" at the bottom of the list.
* Tick the checkbox to mark "Buy some milk" as completed.
* Assert that there is a message "0 items left" at the bottom of the list.

<!-- OMITTED -->

## Challenge

**This is a process feedback challenge.** That means you should record yourself
doing it and submit that recording to your coach for feedback. [How do I do
this?](https://github.com/makersacademy/golden-square-in-python/blob/main/pills/process_feedback_challenges.md)

You are part of the quality engineering team at Makers. You have been asked to 
create a simple end-to-end test for the Makers website, to check that some of 
the site's key features are working correctly.

You'll need to practice everything that you've learned in the past three 
challenges, to locate elements on the page and perform actions/assertions 
against them.

Record yourself writing a Playwright test to accomplish the following:

* Create a new Java class, and configure your initial JUnit/Playwright code.
* Instruct Playwright to browse to https://makers.tech
* Assert that the page title includes the text "Change Your Life".
* Assert that there is a link on the page titled "Code of Conduct".
* Assert that if you click the "Code of Conduct" link, you are taken to the 
page https://makers.tech/code-of-conduct/ and that the page title includes
the text "Code of Conduct".
* Browse back to the homepage.
* Assert that if you click the "FAQs" link, you are taken to the FAQs page.
* On the FAQs page, enter "badger" in the search box, and confirm that the 
results page contains the text "No results for badger".

After you're done, [submit your recording
here.](https://airtable.com/shrNFgNkPWr3d63Db?prefill_Item=java_play01)

## Summary

You've now seen all of the key building blocks of Playwright (which are the 
building blocks of most automation frameworks). You can locate elements on a 
page, perform actions on them, and assert that the page is in the correct
state.

But what about when things go wrong? We're going to move on to look at some 
of the debugging tools that Playwright provides.

[Next Challenge](07_debugging_playwright.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F06_assertions.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F06_assertions.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F06_assertions.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F06_assertions.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F06_assertions.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
