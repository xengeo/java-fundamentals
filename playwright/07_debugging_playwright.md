In the Golden Square module, you experienced the power of debugging as a 
technique for gaining visibility into problems within your code. In this 
challenge, you will apply these same techniques to debugging Playwright tests.

<!-- OMITTED -->

## Running Playwright in headed mode

One of the reasons for Playwright's speed is that it runs in headless mode by
default. This means that the browser is not visible on your screen, which can 
make it harder to debug your tests.

Whenever you use a `launch()` command to start a browser, you can add a
`setHeadless` option, and set it to `false`. This will cause the browser to 
open on your screen, and you will be able to see what the browser is doing as 
your test runs.

In your tests, you've been starting your Chromium instance from within the 
`launchBrowser()` test method:

```java
browser = playwright.chromium().launch();
```

Modify this startup command to add the following launch option, which will 
instruct Playwright to open the browser in headed mode:

```java
browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
```

If you run your test, you'll see a browser appear, and then disappear very 
quickly! That's because Playwright is still running at its natural 
computational speed, which is great for performance, but not so great if we 
want to follow what's actually happening in the test. To slow down Playwright,
we can use the `setSlowMo` option. This will cause Playwright to wait for the 
specified number of milliseconds between each action it takes.


```java
browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
    .setHeadless(false)
    .setSlowMo(2000));
```

Now when you run a test, you'll see the browser open, and then wait for two
seconds before doing each step. This gives you visibility of what's actually 
happening in your test, to assist you with debugging problems.

## Using pauses to step through your test

Once you've configured Playwright to run in headed mode, you can take 
advantage of an even more powerful debugging technique: pausing your test.

When you run a Playwright test, it will run from start to finish, without
pausing for any reason. However, you can add a `pause()` command to your test
at any point, and this will cause Playwright to pause when it reaches that
point.

Let's demonstrate this by injecting a pause into an existing test. In one of 
your test scripts, add a pause immediately after navigating to a page, e.g:

```java
page.navigate("https://makers.tech");
page.pause();
```

Make sure that you're also using `setHeadless(false)` when launching your 
browser. Now run your test, and you'll see the browser open, navigate to the
page, and then pause with the Playwright Inspector window open:

![Playwright Inspector paused after starting test.](resources/inspector3.png)

You'll notice that there are two green buttons visible in the Inspector 
toolbar. The one on the left is a "Resume" button, which will cause Playwright
to continue running your test. The other is "Step Over", which will cause
Playwright to run the next line of code in your test. By using "Step Over", 
you can continue to proceed through your test line-by-line, to identify what's 
happening within your test.

At each step, you'll also see debug output in the Inspector's log panel. This 
gives you additional visibility into the actions that Playwright is performing 
in order to identify elements on the page.

## Recording in Playwright Inspector

When the Inspector window is open, you'll notice there's also a Record button 
in the toolbar. When you press this, the Inspector will start recording your
actions: as you click on elements in the browser, or complete form fields, 
you'll see the corresponding Playwright commands appear in the Inspector's
window.

![Playwright Inspector recording actions in real-time.](resources/inspector4.png)

Alternatively, you can instruct the Inspector to open directly in recording 
mode, by launching it in "Code Generator" mode from the command-line. Assuming 
that you added the `loadInspector()` task to your Gradle file within the 
[Locators exercise](04_locators.md), you can run the following command:

```bash
./gradlew loadInspector --args=https://makers.tech"
```

When you run this command, the Inspector will launch with the specified 
website loaded, and will immediately start recording your actions. This can 
be a useful shortcut for identifying locators and actions, although it won't 
know what assertions you want to make - you'll need to add those manually.

<details>
  <summary>:speech_balloon: Recording sounds quick and easy - why wouldn't I  
  create all of my tests this way?</summary>

  What you've experienced here is a feature which is common to most automation 
  tools, which is known as "record and playback". Often it's designed as a 
  good sales/marketing tool, to show off the power of the tool: "look how fast 
  you can write tests!"

  In the real world, however, record and playback is rarely a good idea. It 
  often produces code which works _now_, but breaks as soon as anything is 
  changed on the site: it won't have given the same level of thought when 
  selecting locators, for example. It also won't follow good automation 
  principles, such as avoiding duplicated code, which can make it harder to
  maintain.

  Similarly, there's real value in understanding the underlying logic of your 
  tests. If you need to modify a test (for instance, because of a planned 
  change to your application) it's much easier if you have the confidence and 
  ability to manually modify your test - otherwise you'll need to re-record 
  your test, which means remembering exactly what you did when you first 
  recorded it.

  That said, the code that's recorded by Playwright is generally pretty good,
  and if you're struggling to determine how to locate a particular element, 
  sometimes the recorder can help you to identify the right locator to use. 

</details>

## Saving videos of your tests

In [exercise 2](02_setting_up_playwright.md), you learned how to save a 
single screenshot of your webpage at any point during your test. During 
debugging, you may also wish to take advantage of Playwright's ability to 
capture videos of its test runs. This can be particularly helpful if you've 
encountered a problem that you want to demonstrate to a developer - it's 
much easier to explain what's happening by providing them a video of what 
you've encountered.

You can enable video capture at the point where you initialise your browser 
context within the tests. If you've been following along with our template, 
you've been creating these within the  `createContextAndPage()` function 
which runs before every test:

```java
    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }
```

In order to record videos, we just need to modify this context variable to 
specify the folder where we wish to save the video:

```java
    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir("videos"));
        page = context.newPage();
    }
```

If you make this modification to one of your tests and run it, you should see 
a new `videos` folder appear in your project, containing a video of your test
run. Playwright saves its videos in `.webm` format; you'll need to use a video 
player such as VLC Player to view them.

## Exercise

We're going to get more familiar with recording, playing-back, debugging 
and evaluating the code which Playwright Inspector is generating for us.

Let's open the Inspector in code generation mode, and take a look at the 
TodoMVC website. Run the following from the command-line:

```bash
./gradlew loadInspector --args="codegen https://todomvc.com"
```

Click on the "React" link to take you to the React version of the TodoMVC
application. Then perform the following actions:

* Add a new todo item
* Mark the todo item as completed
* Delete the todo item

Look in the Inspector window, and take a look at the code that it's 
captured. Compare this to code that you've written in previous challenges, 
and evaluate which version you prefer (or even whether it's produced the same 
code as you wrote). How do you feel about using the code generator, compared 
to writing the code yourself?

<!-- OMITTED -->

## Challenge

Launch the Code Generator from the command-line, browse to the Makers website, 
and use the Inspector to record the same actions that you performed in the 
previous challenge:

* Click the "Code of Conduct" link.
* Browse back to the homepage.
* Click the "FAQs" link.
* Enter "badger" in the search box, and press Search.

Look at the code that's been generated for you in the Inspector window. How 
does it compare to the code that you wrote manually in the previous challenge?

Copy the code out of the Inspector window, and into a new Java class. Run the 
test from within IntelliJ, and check that it completes successfully (remember 
that you're not actually performing any assertions yet).

Finally, manually re-add the assertions from your previous challenge:

* Assert that the homepage title includes the text "Change Your Life".
* Assert that the Code Of Conduct page title includes the text "Code of 
Conduct".
* Assert that you arrive successfully on the FAQs page.
* Assert that the search results page says "No results for badger".

Check that the test runs and all of the assertions are passing.

Finally, add "slow motion" mode to your Playwright instance, and instruct it 
to wait for 2 seconds between steps. Then configure your test so that it 
saves a video of the test run. 

Run the test, and check that the video has been saved in the `videos` folder.

## Summary

Now you're writing tests with Playwright, and bending the framework to your
will, it's time to start thinking about how you can make your tests more
robust and reliable. We're going to look at using Page Object Models to
reduce duplication, and increase the maintainability of your test code.

[Next Challenge](08_page_object_models.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F07_debugging_playwright.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F07_debugging_playwright.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F07_debugging_playwright.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F07_debugging_playwright.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F07_debugging_playwright.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
