Learn how Playwright (and similar frameworks) can help you to create reliable 
end-to-end tests for your applications. 

## Intro

As you've already discovered, unit testing is a key part of your test 
strategy when building web applications. It's reassuring to know that your 
individual components will work in isolation, but what about when somebody 
tries to use your application for real - how can you be certain that the 
website will even load successfully?

Maybe you've already been checking your changes manually in a web browser, and 
that's great. But do you want to rely on every developer doing this, every 
time they make a change? On multiple browsers? Wouldn't it be helpful if we 
could mimic realistic user activity, and have these scenarios checked 
automatically upon new changes to the code?

This is where automated "end-to-end tests" can help. End-to-end tests allow 
you to simulate the behaviour of real users, taking a "journey" on your 
website. For instance, a user journey for a shopping website might look like 
this:

* Browse to the website's homepage.
* Search for an item.
* Click on the item's page.
* Add the item to their basket.
* Proceed to the checkout page.
* Enter their payment details.
* Submit their payment.
* User sees a "Thank you for your order" page.

Wouldn't it be helpful if there was a way that you could automatically test 
scenarios such as this, in multiple different web browsers (such as Chrome, 
Firefox, Safari, or even mobile devices) to check that the experience is 
the same for your users, regardless of their device?

[Playwright](https://playwright.dev/) is a cross-platform, open-source 
framework from Microsoft which helps you to do just that. For instance, you 
could write a single test, and then run it against multiple different browsers 
to ensure that key scenarios in your application are functioning as expected 
on many different systems.

<details>
  <summary>:speech_balloon: I've heard of Selenium - is Playwright basically 
  the same?</summary>

  [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/) is 
  another popular framework for browser-based testing. It's been around for 
  longer than Playwright, which is both a good and a bad thing: it's widely 
  used, with a large support community, but it's also showing signs of its 
  age. It's slower than other frameworks (which is a big deal if you're 
  running hundreds of tests) and it's more difficult to write good code.
  
  When Playwright was first launched in 2020, it sought to address these two 
  big problems, by being both faster and easier-to-configure out-of-the-box. 
  You'll see some signs of this as you work through the challenges.

  You'll undoubtedly encounter Selenium at some point during your career, 
  and - just like when comparing two programming languages - you'll see that 
  there are many similarities. The frameworks have the same key components 
  that are listed below, they're just expressed through different syntax. If 
  you can write good automation in one framework, you can transfer these 
  skills to another framework just as easily.

</details>

## How does it work?

A simple way to think about how end-to-end browser-based testing works is 
that an automated process on a computer will "open a web browser, perform some 
actions, and check the results". But there are a couple of subtleties that are 
helpful to understand.

* **By default, browsers won't pop-up on the computer when the tests are 
running.** Playwright's default is a "headless mode", which means that it 
doesn't actually render a browser on the screen. This allows the tests to run 
much faster (imagine if it takes even 1 second to open a web browser; this 
soon adds up if you're running many tests). If you're debugging, it's possible 
to enable "headed" mode (so you _can_ see the browser) and Playwright has 
other tools for debugging which we'll take a look at shortly.
* **Playwright works with _rendering engines_, not browsers.** This is an 
important distinction which sets Playwright apart from some other frameworks, 
and again is geared towards speed. Think about the Google Chrome browser for a 
moment: it has lots of functions which aren't related to rendering a webpage. 
(For instance, it manages your bookmarks, extensions, and Google user 
profile.) If you just want to see whether your webpage loads correctly, you 
don't want to waste time with loading all of that - and so, when it comes to 
Chrome, Playwright is actually utilising 
[Chromium](https://www.chromium.org/Home/): the rendering engine which powers 
Google Chrome's ability to display webpages. (Chromium is also the rendering 
engine that's used by Microsoft's Edge browser - so by running tests against 
Chromium, you're effectively testing those two browsers in one scenario.)

## Key Components

In the upcoming challenges, you'll learn to use some of the key components of 
Playwright:

* **Locators**: A set of methods for creating objects to reference elements on 
a webpage. For instance, maybe you have multiple buttons on your webpage, but 
you want to locate the one which is labeled "Sign in".
* **Assertions:** Similar to how you've been writing assertions in your unit 
tests, to check that values have expected outputs, Playwright allows you to 
perform web-specific assertions, such as checking whether elements are 
enabled, or whether you have navigated to the correct URL.
* **Actions:** A set of methods which allow you to interact with webpages, for 
example by filling-in form fields, selecting checkboxes, or clicking on 
elements.

We'll also get hands-on with some of Playwright's debugging tools, and look at 
some examples of how you might choose to structure your Playwright code for 
maximum maintainability.

[Next Challenge](02_setting_up_playwright.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F01_about_playwright.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F01_about_playwright.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F01_about_playwright.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F01_about_playwright.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F01_about_playwright.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
