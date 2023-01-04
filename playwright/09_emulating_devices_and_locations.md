# Emulating devices and locations

We've already examined how it can be valuable to test across different 
browsers, to uncover potential browser-specific rendering or behavioural bugs. 
But even when we're only considering a single browser (e.g. Firefox), there are 
different ways in which that browser could operate which might affect a site's 
behaviour:

* If you run the browser on a device with a smaller screen size (such as a 
mobile device or tablet), or even a much larger screen size (e.g. a desktop 
machine with an ultra-wide monitor), the website may render differently: 
there's a software design paradigm known as "responsive design" where a 
website can be constructed to look completely different depending on the size 
of device that you are using.
* A site might render differently depending on your browser's locale or 
timezone; for instance, it might default to displaying its content in a 
different language, its prices in a different currency, or its times in a 
different timezone.
* A site may have implemented a dark/night mode, to provide better contrast 
during night hours.

These are all aspects of a site that we might specifically want to test - but 
we don't necessarily want to use a real, physical iPad every time that we want 
to check how our site behaves on an iPad!

<details>
  <summary>:speech_balloon: What's the difference between emulating and 
  simulating?</summary>

  The words **emulator** and **simulator** are both often used in very similar 
  contexts, and their differences generally aren't well understood, which means 
  that they are often used interchangeably. As a quick aside, here are some of 
  the differences between the two:

  * When you **simulate**, you are trying to recreate (or copy) something from 
  the real world, using the limited tools that you have available. Think of a 
  flight simulator: you're not really in the sky, but you're given all of the 
  controls, visuals, and possibly even movement that you would associate with a 
  real plane. However, it's not _the same as a plane_ - when you simulate, you 
  make assumptions, and this could lead to important bugs being missed.
  * When you **emulate**, you're providing a complete imitation of the real 
  thing. For all intents and purposes, it's the same: so in the flying world, 
  maybe you're sitting at the controls of a real plane but there's a co-pilot 
  doing all of the important stuff.

  For this reason, it's important to observe that when we talk about 
  replicating the behaviour of browser properties such as location and 
  device size, we are talking about **emulation**. Playwright isn't telling 
  Chromium "pretend that you have a 1024 x 1366 pixel screen size"; it creates 
  its Chromium instance with that size. And even if we're not telling the truth 
  about our timezone, we are still giving Chromium that genuine timezone 
  information - it's as if we're really in that timezone.

</details>

## Emulating screen size

You would typically specify this information when you initially create your 
browser context, so that all pages created from this context have the same 
size. You accomplish this by providing "browser context options", like so:

```java
context = browser.newContext(new Browser.NewContextOptions()
    .setViewportSize(1024,1366));
page = context.newPage();
page.navigate("https://makers.tech");
```

(You'll see a lot more about browser context options as we progress.)

Alternatively, you can override it for just a single page instance:

```java
page.setViewportSize(1024, 1366);
page.navigate("https://makers.tech");
```

(Note that it's important to navigate/reload to the page after changing the 
browser size, as many websites will only check the screen size when they're 
loading.)

Now, if you take a screenshot of your page (or run Playwright in headed mode), 
you should observe that the page is being loaded and rendered in a smaller, 
portrait orientation.

## Emulating timezones

In the same way as above, you can override the locale or timezone of your 
machine by setting browser context options. For example, suppose you have a 
test which browses to a World Time Zone site, and takes a screenshot:

```java
context = browser.newContext();
page = context.newPage();
page.navigate("https://everytimezone.com/");
page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("timezones.png")));
```

Take a look at this screenshot, and you'll see that it accurately displays the 
current time for your current location in the world.

Now modify your `browser.newContext()` statement, so that it passes-in a valid 
[timezone ID](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) for 
a different location in the world:

```java
context = browser.newContext(new Browser.NewContextOptions()
    .setTimezoneId("America/New_York"));
```

When you re-run the test, the screenshot should now show New York's local time.

<details>
  <summary>:speech_balloon: I've tried this on a different site, but it's 
  still behaving as if it's in my real country?</summary>

  Emulating being in a different part of the world is a tricky business, as 
  different websites will implement different checks in order to determine a 
  user's location. Some might use timezone ID, as above; but a lot of sites 
  will rely purely on a user's IP address.
  
  This is why, for example, it's not easy to use a different country's Netflix 
  unless you're using a genuine VPN connection. Regardless, it's helpful to 
  know that you can override where your browser is saying that it's from.

</details>

## Emulating dark mode

If a site supports dark mode, you don't want to have to wait until after sunset 
to be able to confirm whether it's behaving as expected! Let's take a look at 
this by utilising a site which supports dark mode, such as GitHub.

Browse to your GitHub profile page without making any modifications. If you 
take a screenshot, or view the page in headed mode, you'll see that (depending 
on the current time of day, and any customisations that you've applied) the page 
will render with either a light background or a dark background.

You can override the current colour scheme by explicitly specifying the 
required colour scheme when creating your browser context options:

```java
// This will force Playwright to use dark mode
context = browser.newContext(new Browser.NewContextOptions()
    .setColorScheme(ColorScheme.DARK));

// Or this will force Playwright to use light mode
context = browser.newContext(new Browser.NewContextOptions()
    .setColorScheme(ColorScheme.LIGHT));
```

## ...And there's more!

There are many other options that you can set during browser context creation; 
take a look at the [Playwright documentation for 
`browser.NewContext`](https://playwright.dev/java/docs/api/class-browser#browser-new-context) 
to see what some of these other options are. You'll likely have all sorts of 
ideas of interesting test scenarios that you could create by wielding these 
options! 

## Challenge

Let's write a pair of tests which help to demonstrate the difference between 
two different browser display modes. You've probably already got most of the 
code that you'll need for the first test.

1. Write a test which browses to the Makers website, and verifies that the 
"Code of Conduct" link is visible in the footer.
2. Write a test which loads the Makers website in a mobile resolution (e.g. 
390 width, 840 height) and verifies that the "Code of Conduct" link is NOT 
visible in the footer. (The site displays a smaller footer with fewer options 
when it's rendered on mobile.)

## Summary

We've seen that, aside from the benefits of testing across different browsers 
to test browser-specific scenarios, even within a single browser there are many 
different properties which can be varied to create interesting scenarios to 
test. We're going to be talking a lot more about strategies for selecting good 
scenarios to test (and to automate) in the next couple of modules.

[Next Challenge](10_advanced_locators.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F09_emulating_devices_and_locations.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F09_emulating_devices_and_locations.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F09_emulating_devices_and_locations.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F09_emulating_devices_and_locations.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F09_emulating_devices_and_locations.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
