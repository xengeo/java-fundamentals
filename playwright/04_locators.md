In this exercise, we'll look at some of the different ways in which Playwright 
enables you to identify elements on a webpage, which is essential if you want 
to perform actions (e.g. clicking buttons/links) or assertions (e.g. checking 
that an element has the value that you expect).

<!-- OMITTED -->

## Intro

When a sighted person looks at a webpage, and they want to identify an element 
on that page, they use their eyes. Suppose they want to find a "Sign in" 
button: they look through the webpage until they see a button which has the 
text "Sign in".

Computers don't have eyes (yet), so automation tools such as Playwright take 
a different view of the webpage. Playwright "views" the HTML source code of a 
page, in a structured format which is commonly known as the Document Object 
Model (DOM). In order to find the "Sign in" button, you need to give your 
automation a piece of information (commonly called a locator) which allows it 
to uniquely identify that element.

## Types of Locator

Let's look at an example snippet of HTML, and how we might design a locator 
which Playwright can use to identify a specific element.

```html
<span title="Login form">
    <h3>Enter your details</h3>
    <form>
        <p><label>Username <input type="text" name="usr"></label></p>
        <p><label>Password <input type="password" name="pwd"></label></p>
        <p><label for="zone">Your location:</label>
        <select name="zone" id="zone">
		  <option value="eu">Europe</option>
          <option value="row">Rest of World</option>
        </select></p>
        <p><input type="checkbox" /> Remember me</p>
        <p><input type="submit" value="Sign in"></p>
    </form>
    <p><a href="/reset">Forgot your password?</a></p>
</span>
<span title="Site version">
    <p>Version 3</p>
</span>
```

<details>
  <summary>See how this form looks in a web browser</summary>
    
    ![Screenshot of login form](loginform.png)

</details>

Here are some ways that you could access these HTML elements within 
Playwright:  

### getByRole()

```java
Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"));
```

This is Playwright's recommended approach for locators, as it's most similar 
to how real users will access the site. ("Find me the button which is labeled 
'Sign in'.")

The `getByRole()` method takes two parameters:

* Its "role" - the type of element that it is. In this case, we are retrieving 
a button, but if we'd been getting one of the input textboxes, we would have 
used `AriaRole.TEXTBOX` instead. Generally, most roles have a name which is 
equivalent to its HTML component, but IntelliJ will help you here - if you 
type `AriaRole.` then the autocomplete will show you all of the valid values.
* A collection of unique properties of the element - normally its text value.
Technically, `setName()` also accepts a partial text value; so if your sign-in 
button was labeled "Sign in using our secure server", then 
`setName("Sign in")` would still work.

Note that your locator needs to provide enough information to _uniquely_ 
identify the element. So if your website had three buttons labeled "Sign in", 
"Sign in help" and "Sign in later", your `setName("Sign in")` code would give 
an error at runtime, because it doesn't know which of those three buttons you 
want to access:

```
waiting for getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"))
  strict mode violation: getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")) resolved to 3 elements:
    1) ...<HTML of the 'Sign in' button>
    2) ...<HTML of the 'Sign in help' button>
    3) ...<HTML of the 'Sign in later' button>
```

In this specific scenario, you can use the `setExact(true)` option to indicate 
that you want to match the element with the exact name that you specified:

```java
Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setExact(true).setName("Sign in"));
```

### getByLabel()

```java
Locator usernameField = page.getByLabel("Username");
```

In your tests, you'll often be interacting with form elements (for instance, 
entering values into text boxes). If your form has been constructed properly, 
each form field should have an associated HTML `<label>` property, such as in 
our example above. Form labels are helpful for accessibility (because they 
allow screen readers to have a clear description for each form field) but they 
also allow for some beautifully concise test code! If you're working with 
forms, labels will be extremely helpful for you.

### getByText() 

```java
Locator siteVersion = page.getByText("Version 3");
```

This is another locator type which is generally very easy to understand, 
and is more powerful than it might initially seem: you can also use regular 
expressions to allow for more dynamic identification. Regular expressions 
allow you to use "patterns" to identify matching text, which is particularly 
helpful if you know an approximation of what the data might look like.

For instance, suppose this theoretical site was upgraded to Version 4. The 
locator above would no longer work, because the text "Version 3" isn't on 
the page any more! However, if you know that your site version will always 
be a number, you could write the locator as follows:

```java
// This will match "Version 3", "Version 4", even "Version 999"!
// \d means "a digit between 0 and 9"
// + means "at least 1 of them"
// Therefore \d+ means "at least 1 number"
Locator siteVersion = page.getByText(Pattern.compile("Version \d+");
```

(You can also use regular expressions with the `getByRole()` locator, and 
indeed pretty much anywhere in Playwright where standard text strings are 
accepted.)

### Locating elements by CSS or XPath Selector

```java
Locator rememberMe = page.locator("xpath=//span/form/input[@type='checkbox']");
```

This is a deliberately ugly example, provided more as a warning than a 
recommendation!

[CSS](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Selectors) and 
[XPath](https://developer.mozilla.org/en-US/docs/Web/XPath) selectors are 
undeniably powerful, and they're the building blocks of many an automation 
framework (if you encounter Selenium, you'll definitely find yourself having 
to be more aware of how they work).

However, they're discouraged in Playwright, for several good reasons:

* Playwright attempts to browse a site "like a user". There aren't any users 
in the world who browse a website by saying "I'm going to find a  `<span>` 
element, and then find a `<form>` tag underneath that, and then find the 
`<input>` element which is coded to be a checkbox".
* Other people - including you, in the future! - will have to maintain your 
tests. All of the other locator types that we've looked at are quite verbose: 
it's fairly obvious what they're trying to accomplish. A complex CSS/XPath 
selector can be a real headache to maintain.
* When you tether your locators to the actual structure of the webpage, it's 
very easy to accidentally break your tests. Even the most minor change to the 
page (such as moving some text into a new paragraph) could make them grind to 
a halt. A redesign or refactor may mean that you have to completely throw away 
your CSS/XPath selectors and create them from scratch.

If used in an appropriate context, they can get you out of a real jam, but 
don't use them as the basis for a wider automation strategy.

You can read more about the syntax behind Text, CSS and XPath selectors in the 
[Playwright Selectors 
documentation](https://playwright.dev/java/docs/selectors).

### ...And more

There are many more locator types that you can investigate, and more advanced 
techniques that you can employ, such as chaining locators together, or 
filtering elements on the page to narrow the scope of what's being looked at. 
We'll cover these in later exercises, but for now, feel free to browse the
[Playwright Locators documentation](https://playwright.dev/java/docs/locators) 
for further examples (and if you haven't already, you should definitely 
bookmark these docs for future reference).

## Using the Playwright Inspector

You might be thinking that all of this sounds like a lot of hard work. 
Thankfully, Playwright provides a tool called Inspector, which can remove a 
lot of the guesswork and help you to create reliable locators.

To run Playwright Inspector on-demand, add the following code at the bottom of 
your `build.gradle` file:

```
task loadInspector(type: JavaExec) {
    mainClass = 'com.microsoft.playwright.CLI'
    classpath sourceSets.main.runtimeClasspath
    if (project.hasProperty('args')) {
        args project.getProperty('args')
    } else {
        args 'open'
    }
}
```

Now, in your terminal, you can run `./gradlew loadInspector` from your 
project's folder, and your machine will launch a Playwright Inspector window, 
with a companion Chromium tab:

![An empty Playwright Inspector window.](inspector1.png)

Let's see what Playwright Inspector can do for us. 

1. In your Chromium window, browse to `https://todomvc.com` and wait for the 
website to load.
2. In your Playwright Inspector window, click the "Explore" button, and then 
hover over the different elements on the TodoMVC website. You'll see that 
Playwright will suggest a locator which will uniquely identify that element:

![Playwright Inspector with 'Examples' locator.](inspector2.png)

3. Click on any element, and the locator for that element will appear in 
the Playwright Inspector window, allowing you to copy it for use in your tests.

We'll look at more of what the Inspector can do in upcoming exercises.

## Exercise

In the upcoming exercises, we're going to gradually build some valuable test 
scenarios for the TodoMVC website. Start by creating a new test class called 
`TodoTest`, and populating it with the same JUnit/Playwright code that we 
copied in [the previous exercise](03_playwright_in_junit.md).

Now add a new test scenario which navigates to the TodoMVC website:

```java
// in TodoTest.java

    @Test
    void shouldPrintPageTitle() {
        page.navigate("https://todomovc.com");
        // Now we are on the TodoMVC homepage.
        // We'll write the rest of our code here!

    }
```

Check that this runs and gives you a green tick - it's not doing anything 
spectacular yet, but this will at least allow you to confirm that your 
Playwright integration is setup correctly.

We have access to a variable `page` which gives us access to the content of 
that page. Now let's flex our locator creation muscles!

There are several buttons at the top of the page, one of which is labeled 
"View on GitHub". Can you add a line of code which locates the button, and 
stores a reference in a variable called `githubButton`? The line will start 
like this: `Locator githubButton = ......`

If you want to check whether your locator is working, we can print a debug 
message to the terminal. Assuming that you named the variable `githubButton` 
as requested, add the following code beneath it:

```java
// Get the text content of the specified element
System.out.println(githubButton.textContent());
```

If your locator has worked, then you should see the text `View on GitHub` (the 
content of the element) in the terminal when you run your code.

Next, look within the Examples section on the right-hand side of the page. You 
should see several tabs, the first of which is labeled "JavaScript". Can you 
locate this in the page, and print its content to the terminal?

[Example solution]() <!-- OMITTED -->

## Challenge

* Create a new test class, and add your JUnit/Playwright outline code 
(including all of the "before" and "after" methods).
* Create a new test, and instruct it to browse to one of your favourite 
websites.
* Launch the Playwright Inspector, and use it to identify the locators for 
some key elements of the website (e.g. a navigation link, or the "main" header 
of the page).
* Using the same technique as in the exercise above, create some code to 
locate those elements, and print their text content to your terminal.
* Run the test, and confirm that the text content is printed to the terminal.
* Deliberately change the code for your locator so that it will no longer 
match (e.g. make a subtle change to the text that it's looking for). Re-run 
your test, and check the output: do you see a failure message? If you saw 
this error message in a real-world scenario, how might it help you to track 
down the problem?

## Summary

Now you know how to identify elements on a page, it's time to start performing 
actions on those elements, and observing what happens!

[Next Challenge](05_actions.md)

[Next Challenge](05_actions.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F04_locators.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F04_locators.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F04_locators.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F04_locators.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F04_locators.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
