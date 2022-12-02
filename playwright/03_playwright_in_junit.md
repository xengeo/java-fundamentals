You've seen Playwright running, and driving itself around a web browser, 
following the commands that you programmed. In the previous exercise, we 
wrote our Playwright code directly into the main function of a class, as it 
allowed us to get our hands dirty more quickly. 

However, these are tests, so going forwards we are going to structure them as 
such. You can incorporate Playwright code into JUnit tests, so that they can 
be executed alongside your unit tests. And when we're running within a larger 
test suite, we can also take advantage of some JUnit features which allow us 
to perform setup and teardown actions before/after our tests.

<!-- OMITTED -->

## Creating a new Playwright test in JUnit

Let's rewrite the `HelloMakers` example from the previous exercise, but this 
time in a JUnit test.

Create a new class called `MakersTest` and insert the following code into it:

```java
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class MakersTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
```

There's a lot of JUnit structural code here that you might not be familiar 
with yet. Here's a brief but important explanation:

* Methods with a `@BeforeAll` annotation are run once, at the start of the 
test run. In this case, we're instantiating Playwright and launching a
Chromium browser.
* Methods with an `@AfterAll` annotation are run once, at the end of the
test run. In this case, we close Playwright as we're finished with it.
* Methods with a `@BeforeEach` or `@AfterEach` are run before/after every 
individual test. In this case, we're creating a new browser context for each 
test, and then creating a new page (tab) which we can reference within the 
tests.

## Adding a test

Now all that's left to do is incorporate our Makers test. If we want to create 
a test which prints the page title into the terminal, all we have to do is add 
the following test snippet within our `MakersTest` class:

```java
    @Test
    void shouldPrintPageTitle() {
        page.navigate("https://makers.tech");
        System.out.println(page.title());
    }
```

Now you should be able to trigger the `shouldPrintPageTitle()` test 
individually (or run the entire `MakersTest` test class) and observe the page 
title being printed successfully in the terminal.

## Summary

That's all there is to it! You can add subsequent test methods beneath this 
one, and (because of the `@BeforeEach` and `@AfterEach` annotations) you 
can rest assured that each test will be run in a fresh browser context.

We'll be writing all of our subsequent Playwright tests in this way. We'll 
begin by looking more closely at the individual building blocks of a 
Playwright test.

[Next Challenge](04_locators.md)

[Next Challenge](04_locators.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F03_playwright_in_junit.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F03_playwright_in_junit.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F03_playwright_in_junit.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F03_playwright_in_junit.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F03_playwright_in_junit.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->