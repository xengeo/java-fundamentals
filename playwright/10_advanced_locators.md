# Advanced locators in Playwright

In the [Locators exercise](./04_locators.md), we learned some of the most 
common and useful ways to uniquely identify elements on a webpage. The 
information that you've absorbed thus far will probably work for ~90% of the 
elements that you'll encounter.

But the web isn't all forms, links and buttons. Sometimes we'll encounter 
something on a webpage which can't easily be expressed in the form of an 
element - or maybe it's not an element at all. For example:

* Downloading a file (which might take some time)
* Uploading a file (e.g. via a Browse dialog)
* Handling a pop-up message / alert

A great site for exploring unusual website behaviours, and testing your 
automation skills against them, is a Heroku site which is simply called 
[The Internet](https://the-internet.herokuapp.com/). We'll take a look at one 
of these, and then you're free to continue exploring them to see how many you 
can complete!

## File Downloads

If you click on a link which downloads a file, you might not know how long that 
file download is going to take. Maybe it's just a simple text file; maybe it's 
a multi-gigabyte movie file. As with most timing-related activities in 
Playwright, the library contains some defaults which help you to handle an 
action of potentially unknown length.

Firstly, we utilise the `waitForDownload()` method of Playwright's page object, 
and save its result into an object of type Download.

```java
Download myFile = page.waitForDownload(() -> {
    // Use a standard Playwright locator to find the link, and click it.
    page.getByText("Click here to download").click();
});
// Save the file to a specified location on disk.
myFile.saveAs(Paths.get("/path-to-save/my-file.txt"))
```

The `saveAs()` method will only return when the file has finished downloading, 
so depending on the size of the file, your test may appear to pause here for a 
little while.

You can try this out for yourself by creating a test which browses to 
[The Internet](https://the-internet.herokuapp.com/), clicks the "File Download" 
link, and then clicks on any of the files which is listed. After the test has 
completed, you should be able to see that the file has been downloaded to 
whichever path you specified.

### Challenge

1. Write a test which downloads a text file (i.e one which ends in a `.txt` 
extension) from the [The Internet](https://the-internet.herokuapp.com/) 
website. 
2. In your test, after the file has been downloaded, write some Java code 
which locates the new file on disk, and prints its contents into the 
console.

## Keep exploring!

Now it's "Choose Your Own Adventure" time! Look at some of the other examples 
on [The Internet](https://the-internet.herokuapp.com/). Experiment with writing 
automation which can successfully complete each one, and have the test assert 
that it completes successfully.

Some of these will be fun, but trivial. Some will be taxing, and may even 
border on impossible. Follow your energy, and use this as information to guide 
your future automation experiences.

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F10_advanced_locators.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F10_advanced_locators.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F10_advanced_locators.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F10_advanced_locators.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=playwright%2F10_advanced_locators.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
