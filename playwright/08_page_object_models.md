In this exercise, we'll look at how we can structure our Playwright tests to 
make them easier to read and maintain. We'll do this by using a technique called
Page Object Models.

<!-- OMITTED -->

## Intro

So far, we've been writing all of our Playwright tests in isolation, with no 
knowledge of what code we've written in previous tests. It's functional, but
it doesn't scale well. If your application has many pages, your tests will 
quickly become full of repeated code, and they'll be difficult to maintain if 
anything changes in your application. For instance, if the URL for your "About 
Us" page was modified from `/about` to `about-us`, you'd have to find every 
test which referred to the old URL, and modify it.

The recommended solution to this in Playwright (and other automation 
frameworks) is to use a technique called Page Object Models. This involves
creating a separate class for each page in your application, and then importing
these classes into your tests. This allows your test code to be much 
"cleaner", because it focuses on the actions that are being performed, rather 
than the steps of automation which are required to achieve those actions.

## Example of a test to refactor

Create a new class called `MakersSearchTest`, with JUnit/Playwright set up
correctly, and add the following two tests:

```java
// in MakersSearchTest.java

@Test
void shouldFindSearchResultsForJava() {
    page.navigate("https://makers.tech");
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first().click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).fill("java");
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).press("Enter");
    assertThat(page.locator("h1")).containsText("Results for java");
}

@Test
void shouldNotFindSearchResultsForBadger() {
    page.navigate("https://makers.tech");
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first().click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).fill("badger");
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).press("Enter");
    assertThat(page.locator("h1")).containsText("No results for badger");
}
```

The tests (and their names) should be relatively self-explanatory. We're 
performing a search for the term `java`, and confirming that the search 
results page indicates that results were found. Then we're performing a 
search for `badger`, and checking that no results are coming back.

There's a lot of duplication in these tests though, and we'd like for our 
tests to be a bit easier to read. 

## Introducing a Page Object

Let's create a Page Object for our search page, which extracts all of the 
code related to our search page into a separate class, with its own 
helper methods.

Create a new class called `MakersSearchPage`, and move the code which is 
specific to the search page into this class. We can then import this class 
into our test class, and use it to perform the search.

```java
// in MakersSearchPage.java

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class MakersSearchPage {
    private Page page;
    private Locator searchBox;
    private Locator searchResultsHeading;

    public MakersSearchPage(Page page) {
        this.page = page;
        this.searchBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers"));
        this.searchResultsHeading = page.locator("h1");
    }

    public void navigate() {
        page.navigate("https://faq.makers.tech/en/knowledge");
    }

    public void searchFor(String searchTerm) {
        searchBox.fill(searchTerm);
        searchBox.press("Enter");
    }

    public Locator getSearchResultsHeading() {
        return this.searchResultsHeading;
    }
}
```

What we've done here is encapsulate all of the code which is specific to the
search page into a new class. Within its constructor, we've also defined all 
of the locators that we want to use within our tests. (Currently, we've only 
specified the ones which are relevant to this test - the search box, and the 
search results header. In a real Page Object Model, we'd also define locators
for all of the other elements on the page.)

## Incorporating our Page Object

Now that we have our search page class, we can import this into our code and 
modify the steps to be much simpler:

```java
@Test
void shouldFindSearchResultsForJava() {
  MakersSearchPage searchPage = new MakersSearchPage(page);
  searchPage.navigate();
  searchPage.searchFor("java");
  assertThat(searchPage.getSearchResultsHeading()).containsText("Results for java");
}

@Test
void shouldNotFindSearchResultsForBadger() {
  MakersSearchPage searchPage = new MakersSearchPage(page);
  searchPage.navigate();
  searchPage.searchFor("badger");
  assertThat(searchPage.getSearchResultsHeading()).containsText("No results for badger");
}
```

You'll notice a few things about these refactored tests:

* The tests themselves no longer need to be concerned with the structure of 
the page. The `MakersSearchPage` class (which we have imported into the tests) 
takes care of this for us.
* As a result of this, if we ever made any changes to the search page - for 
instance, if we changed the text in the search field from "Search for answers" 
to something else - we'd only need to make the change in one place (the 
`searchBox` attribute in the `MakersSearchPage` class).
* There's potentially still some room for improvement here. For instance, we 
could write a method in our `MakersSearchPage` class which returns true or 
false depending on whether or not search results were found. Then our test 
could simply assert "did we find any results or not?".
* You might have noticed that we've embedded the URL for the search page in 
the `navigate()` method of our search page class. This is different to what 
our test was previously doing, where we identified the navigation item in the 
menu and clicked on it. If we were to extend our Page Object Model, we could 
create another class called something like `NavigationMenu`, and move all of 
our menu locator code into that class.

## Challenge

Revisit the challenge that you completed in the [Actions 
exercise](05_actions.md), where you searched for 'car tax' on the GOV.UK 
website. 

* Modify your test to use a Page Object for the search results page.
* Extend your Page Object to contain locators to some other elements on the 
search results page - for example, the "Sort by" drop-down - and incorporate 
these elements into a new test.
* Review your tests, and check that they no longer contain any code which 
is responsible for creating locators or performing actions - all of this 
should now be handled within your Page Object.

## Summary

Page Object Models are a great way to make your tests more readable, and to
make them easier to maintain. They also help to reduce the amount of
duplication in your tests, which is always a good thing.

We'll be looking much more at Page Object Models during the Automating 
Checking module.

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F08_page_object_models.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F08_page_object_models.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F08_page_object_models.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F08_page_object_models.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F08_page_object_models.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
