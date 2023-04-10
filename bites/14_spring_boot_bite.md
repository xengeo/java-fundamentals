# SpringBoot

_**This is a Makers Bite.** Bites are designed to train specific skills or
tools. They contain an intro, a demonstration video, some exercises with an
example solution video, and a challenge without a solution video for you to test
your learning. [Read more about how to use Makers
Bites.](https://github.com/makersacademy/course/blob/main/labels/bites.md)_

<!-- OMITTED -->

Learn to build simple web applications using SpringBoot

## Introduction

Spring is tool used to build web-applications in Java. It's like Sinatra but with a ton of extra features that will appear a bit magical at first - perhaps to your confusion and / or annoyance!

Spring**Boot** is a specific Spring setup that is slightly easier for newcomers to use.

It's a huge and complex tool which can be used to build all manner of web-applications. Here, we'll focus on building something relatively simple :)

### Spring Initializr

Those helpful folks at Spring have created an online tool to help you get set up with SpringBoot - it's called Spring Initializr. You can use it to configure an initial SpringBoot application and download a starter codebase.

[Here's one I configured earlier](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.0.5&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=hello-world&name=hello-world&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.hello-world&dependencies=web). If you click on `GENERATE`, you'll download the starter codebase as a zip file which you can then unzip and open in IntelliJ.

Once you've done that, you can start the application using the 'play' button in IntelliJ. If, for some reason, that doesn't work find the Gradle tab on the left and go to `tasks` -> `application` then double click `bootRun`.

IntelliJ will chuck a ton of text into the integrated terminal and then finally tell you that the application is running on port 8080 - go to `localhost:8080` in your browser and you'll see a SpringBoot error message! Congratulations, you're ready to go.

### Adding a Controller

At the moment, your little app doesn't know how to handle the `GET "/"` request which is generated when you go to `localhost:8080` so let's fix that.

You'll need a controller so that this request can me _mapped_ onto some code. Create a new Java class called `HelloWorldController` in the same directory as `HelloWorkdApplication`. Then paste in the code below. You'll notice a few new things, which I'll explain shortly.

```java
package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
```

#### Imports

These are just like Python imports. For your controller, you needed some tools that are defined in the Spring Web dependency - `GetMapping` and `RestController`.

#### Annotations

The expressions that start with `@` are called annotations. They are used to label chunks of code either for the compiler, for a tool that you're using (in this case, SpringBoot) or so that something specific happens at runtime (when your code is executed).

- `@RestController` tells SpringBoot that the following class is a controller for a web application.
- `@GetMapping` tells SpringBoot that this code should be used to handle a specific `GET` request.

You'll see lots of other annotations in Java, both in SpringBoot and elsewhere. For example, the JUnit testing framework using `@Test` to annotate tests so that they can be found and run when the test suite is executed.

> If you want to experiment with these annotations, see what happens when you change `@GetMapping("/")` to `@GetMapping("/hello")`.

### Adding Templates

We're going to use a templating engine called Thymeleaf. To set things up, we'll need to...

1. Add the Thymeleaf dependency to `build.gradle`
2. Configure SpringBoot to use Thymeleaf

#### Adding the Dependency

Find `build.gradle` and add a new line in the `dependencies` block - you don't need to comma separate lines there so don't add any commas. Start to add the dependency, as shown below, (no copy-pasting!) and you'll probably find that IntelliJ provides some helpful suggestions as you type.

```groovy
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf:3.0.4'
```

This helpful behaviour of IntelliJ will come in handy if you're looking for guidance on how to install a dependency but can only find the instructions to Maven, not Gradle.

[Show me the Maven syntax for Thymeleaf, I'm curious!](https://www.baeldung.com/spring-boot-start#simple-mvc-view)

#### Configuring SpringBoot

Web frameworks tend to have a set of configuration files that are separate from the business logic and SpringBoot is no different. You can also use multiple configuration files to, for example, specify different configurations for different environments.

Here we're going to use one configuration file and it's called `application.properties` - find it in `src` -> `main` -> `resources` then add the following (without the comments).

```java
spring.thymeleaf.cache=false
// tell springboot to use Thymeleaf
spring.thymeleaf.enabled=true 
// tell springboot where to find Thymeleaf templates
spring.thymeleaf.prefix=classpath:/templates/
// tell springboot what file extension your templates will have
spring.thymeleaf.suffix=.html
```

### Adding a Template

Now we're ready to add a template. Create a new HTML file in `templates` called `home` - if you specifically choose to add a new HTML file, you won't need to include the `.html` extension as IntelliJ will do that for you.

Add any HTML you like to your home page - be creative, if you're in the mood, but don't spend hours on it :)

Finally, change your controller action from this...

```java
@GetMapping("/")
public String index() {
	return "Greetings from Spring Boot!";
}
```

To this, which will now return a `ModelAndView`

```java
@GetMapping("/")
public ModelAndView index() {
	return new ModelAndView("home");
}
```

Then restart your server and go back to `localhost:8080` to see your shiny new page.

> The `Model` part of `ModelAndView` will make more sense once you start passing objects (models) through to your templates.

## Demonstration

<!-- OMITTED -->

[Demonstration Video](https://youtu.be/WdXXZuvkyAk)

## Exercise

Using your knowledge from previous modules about how web applications work and your new knowledge of Java...

* Add a link to home.html so that when a user clicks on it they see another page called `links.html`.

[Example Solution](https://youtu.be/h29FjjVSasM)

## Challenge

* Add another route and page so that when a user navigates to "/quotes" they see some famous quotes (not an error message). You can choose your own favourite quotes.


<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_spring_boot_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_spring_boot_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_spring_boot_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_spring_boot_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=bites%2F14_spring_boot_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
