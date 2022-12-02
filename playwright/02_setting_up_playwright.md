In this exercise, you will set up Playwright in a new Java project, and use 
it to run a simple test against a real website in multiple browser contexts.

<!-- OMITTED -->

## Setting up a project with Playwright

First, create a new Gradle Java project called `playwright-demo`.

Once your project has initialised and downloaded its dependencies, it's time 
to integrate Playwright into the project. Open your project's `build.gradle` 
file, and add the following new line within the existing `dependencies` 
section:

```
implementation group: 'com.microsoft.playwright', name: 'playwright', version: '1.28.0'
```

Rebuild your project so that this new Gradle dependency is downloaded.

## Implementing Playwright into a test class

Create a new Java class in your project, and call it `HelloMakers.java`. 
Insert the below code into the file:

```java
// in HelloMakers.java

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class HelloMakers {
    public static void main(String[] args) {
        // Create a new instance of Playwright
        Playwright playwright = Playwright.create();

        // Use Playwright to open a new instance of Chromium
        Browser chromium = playwright.chromium().launch();

        // Open a new virtual page (tab) in your Chromium instance
        Page page = chromium.newPage();

        // Instruct the new page to browse to the Makers website
        page.navigate("https://makers.tech");

        // Take a screenshot of what's currently on the page,
        // and store it in a file called 'makers.png'
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("makers.png")));

        // Find the title of the webpage (the value inside the HTML
        // <title> element) and print it to the terminal
        System.out.println(page.title());

        // Close down Playwright and end the test
        playwright.close();
    }
}
```

Read through the code and comments, and check that you can understand what 
is happening on each line. (One of Playwright's strengths is that its code 
tends to be relatively easy to read, even if you're new to its syntax.)

Run this test - your terminal output should include the following (it's 
printing the webpage title):

```
> Task :HelloMakers.main()
Change Your Life - Become a Software Developer at Makers
```

You should also now see a file called `makers.png` in your project's tree 
view - you can open this in IntelliJ and confirm that it's a screenshot of 
the Makers website.

Congratulations, you've written some browser-based automation! Technically 
this isn't a test yet (we're not checking whether that's the intended page 
or not) but it's pretty neat, don't you think?

### Exercise

Create a new class, and integrate Playwright so that it performs the following 
activities:

* Launches an instance of Firefox 
* Browses to one of your favourite websites
* Prints the first word of the page title into the terminal
* Takes a screenshot of the website, and saves it to a file with a name of 
your choice.

[Example solution]() <!-- OMITTED -->

## Testing multiple browsers simultaneously

Not all web browsers are the same. In the early days of the web, competing 
browsers were built from the ground up, and while there are recommended 
"standards" for how webpages should be rendered, these were often open to 
interpretation. That's why we have sites such as 
[Can I Use...](https://caniuse.com/) which allow you to check whether specific 
technologies are supported by the browsers that you care about.

Things are nowhere near as bad as they used to be (farewell, Internet 
Explorer), but there's still value to be gained in running your tests against 
multiple browsers, especially those which are used most often by your 
customers.

One of Playwright's powers is the ability to run the same test against 
multiple browser engines, allowing you to test for cross-browser 
compatibility issues in the browsers that you care about. Let's create such 
an example!

Create a new Java class called `CrossBrowserTest` and give it the following 
content, reviewing the comments as you go to understand what it's doing:

```java
import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CrossBrowserTest {
    public static void main(String[] args) {

        // Create a new instance of Playwright
        Playwright playwright = Playwright.create();

        // Create an Array containing the browsers that
        // we want to test against
        List<BrowserType> browsersToTest = Arrays.asList(
                playwright.chromium(),
                playwright.firefox(),
                playwright.webkit());

        // Loop around our array of browsers
        // Load each browser into the `browserType` variable,
        // and then run the same test against each browser
        for (BrowserType browserType : browsersToTest) {

            // Launch whichever browser we're using in this loop
            try (Browser browser = browserType.launch()) {
                System.out.println("Running in " + browserType.name() + "...");

                // Create a new page (tab) in this browser
                Page page = browser.newPage();

                // Browse to the Makers website in this browser
                page.navigate("https://makers.tech");

                // Take a screenshot, and save it to a file which includes
                // the browser name in the filename (e.g. `makers-chromium.png`)
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("makers-" + browserType.name() + ".png")));

                System.out.println(page.title());
            }
        }

        // Close down Playwright and end the test
        playwright.close();
    }
}
```

When you run this code, the browser title gets printed three times (once for 
each browser):

```
> Task :CrossBrowserTest.main()
Running in chromium...
Change Your Life - Become a Software Developer at Makers
Running in firefox...
Change Your Life - Become a Software Developer at Makers
Running in webkit...
Change Your Life - Become a Software Developer at Makers
```

If you look in your project tree view, you should now see 
`makers-chromium.png`, `makers-firefox.png` and `makers-webkit.png`. They 
should all look the same, as long as we haven't introduced any 
browser-specific bugs on our site! 

## Challenge

Write a function to load the website `https://www.whatismybrowser.com/` in 
Firefox and WebKit. Take screenshots in both tests, and confirm that both get 
saved into your project folder. Open the two screenshots - you should see some 
subtle differences. (The big heading at the top of the page, for instance, 
should show either "Firefox" or "Safari" respectively.)

## Summary

You've demonstrated that you can get Playwright up-and-running within an 
IntelliJ project, and use it to launch and interrogate multiple browsers. 
Next, we'll begin to incorporate real-world scenarios, by plumbing Playwright 
into some JUnit tests.

[Next Challenge](03_playwright_in_junit.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F02_setting_up_playwright.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F02_setting_up_playwright.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F02_setting_up_playwright.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F02_setting_up_playwright.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F02_setting_up_playwright.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
