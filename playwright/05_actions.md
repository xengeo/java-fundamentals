In the previous exercise, we looked at the different ways in which you can 
locate elements on a webpage. The good news is, that was the hard part! Once 
you've successfully located an element, Playwright has a variety of methods 
on its Locator objects which will allow you to interact with an element in 
the same way as a real user would.

<!-- OMITTED -->

## Intro

In our initial introduction to Playwright, we discussed that most end-to-end 
automation takes the form of "open a web browser, perform some actions, and 
check the results". You can already do the first one - and you're half-way to 
the second one!

You may have noticed in the last exercise that when we were getting references 
to objects on our page, we saved them into a variable which was a `Locator` 
object type:

```java
Locator usernameField = page.getByLabel("Username");
```

A Locator is one of Playwright's core object types. Just like the objects that 
you've already created in your own classes, Locators have special methods 
which allow you to interact with them, such as typing text into fields, 
ticking checkboxes, or selecting an item in a list. If a user can do it, then 
Playwright will allow you to do it too.

## Types of Action

Most of your interactions with a webpage will consist of either entering 
values into a form, or clicking links on a page. Thankfully, these 
interactions tend to be delightfully easy to work with in Playwright.

Let's look at the example HTML form which we used in the previous exercise: 

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
```

<details>
  <summary>Remind yourself how this form looks in a web browser</summary>
    
    ![Screenshot of login form](loginform.png)

</details>

### Text boxes

When you have a locator which references a text input, you can use the 
`.fill()` method to specify the value that you want to enter into the field: 

```java
Locator usernameField = page.getByLabel("Username");
usernameField.fill("sue_smith");
```

This is the quickest way to enter text into a text box, as it simulates 
pasting the entire text into the field in one go. If it's important for you to 
simulate a user typing the text one character at a time (for instance, if your 
form performs special validations on every keystroke) then you can 
alternatively use `type()` to enter the characters one at a time:

```java
Locator usernameField = page.getByLabel("Username");
usernameField.type("sue_smith"); // This will type s, u, e, _, s, m, i, t, h
``` 

### Checkboxes and radio buttons

You're probably already getting the hang of this. If you have a checkbox 
locator, and you want to tick that checkbox, you just request to `check()` it:

```java
Locator rememberMe = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember me"));
rememberMe.check();
```

After running this line of code, the checkbox will be checked. And there's an 
equivalent `uncheck()` command if you want to uncheck it:

```java
rememberMe.uncheck();
```

You don't need to worry about the existing state of the checkbox - if you 
call `check()` on a checkbox which is already checked, it will remain checked. 
And if the checkbox is already unchecked, then calling `uncheck()` will leave 
the box unchecked.

### Drop-down lists

A drop-down list (represented by an HTML `<select>` element, with `<option>` 
sub-elements) can be interacted with by specifying either the value, the 
label, or the index of the item that you wish to select. For instance, all 
of the below examples will select the first item in the "Your location" 
drop-down:

```java
Locator dropDown = page.getByLabel("Your location");

// Select the first item using its value (ID)
dropDown.selectOption("eu");

// Select the first item using its label
dropDown.selectOption(new SelectOption().setLabel("Europe"));

// Select the first item using its index (starts with zero)
dropDown.selectOption(0);
```

When there are multiple ways to perform an action, it's often difficult to 
know which is the "correct" way. There aren't any solid rules, but here is 
some guidance to bear in mind:

* Using the label ("Europe") is most similar to what a user would do. 
However, if the labels are likely to change frequently, this might make your 
tests harder to maintain.
* Using the value ("eu") is likely to be more stable, because values tend to 
be less likely to change. However, sometimes it won't always be obvious what 
the value refers to; imagine if the value for Europe was "176543" for 
instance - this would make it harder to understand what your test is doing.
* Selecting an option by index is generally not a good idea, because if 
somebody changes the order of the elements in the list (or adds/removes 
elements) then suddenly your test will be selecting an unexpected option.

### Clicking on a link

If you want to click a link on a webpage, it's as simple as performing a 
`click()` action on the relevant locator:

```java
Locator forgotPwdLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forgot your password?"));
forgotPwdLink.click();
```

Hey presto - your browser page has now changed! If you were to take a 
screenshot at this point, you'd see that you were now on the "Forgot password" 
page.

### ...And more

There are many more unusual actions that you might wish to perform on an 
elements, with examples listed in [the Playwright documentation for 
Actions]((https://playwright.dev/java/docs/input). Such actions include:

* Pressing a keyboard shortcut
* Hovering the mouse over an element
* Performing a "drag and drop" operation
* Uploading files via your browser

## Exercise

We're going to continue working on our tests for the TodoMVC website. After 
the previous exercise, your TodoMVC test should look a bit like this:

```java
// in TodoTest.java

    @Test
    void shouldPrintPageTitle() {
        page.navigate("https://todomovc.com");
        Locator githubButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View on GitHub"));
        System.out.println(githubButton.textContent());

        // We are going to continue the exercise here!

    }
```

You've already got a reference to the "View on GitHub" button, and actually we 
already showed you how to use one of its methods (you used `textContent()` to 
print out the value of the element).

Let's modify the test above, using what you've learned up to this point:

* Locate and click the "React" link. (There are several links which contain 
this text - you'll need to add an option which selects the one named exactly 
"React".)
* After you click the link, save a screenshot `react.png` into your project.
* Print the title of the new page into your terminal.

If you run your test, you should see the React page title in your terminal: 

```
React • TodoMVC
```

And if you open your `react.png` screenshot, you should see a picture of the 
To-Do List application where we're going to perform assertions in the next 
exercise.

[Example solution]() <!-- OMITTED -->

## Challenge

You are part of the team which is maintaining the GOV.UK website. You want 
to make sure that users are able to search for information about car tax, 
and are able to access the car tax page from the search results.

In a new Java class, write a Playwright test which performs the following 
steps:

* Browse to the GOV.UK homepage (www.gov.uk)
* Locate the search box, and type the text `car tax`
* Press the search button
* On the search results page, click the "Tax your vehicle" link
* Take a screenshot, save it as `tax.png`
* Run your test, and check that `tax.png` successfully displays a 
screenshot of the Tax Your Vehicle page
* If you see a "Cookies on GOV.UK" banner at the top of the screenshot, 
try modifying your test so that it dismisses the banner (by accepting or 
rejecting cookies) before taking the screenshot.

## Summary

Now you're equipped with all of the components that you need to understand in 
order to automate your way around a website. All that's left is to plug in 
some assertions, so that you can test whether your application is performing 
in the way that you want it to.

[Next Challenge](06_assertions.md)

[Next Challenge](06_assertions.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F05_actions.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F05_actions.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F05_actions.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F05_actions.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F05_actions.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
