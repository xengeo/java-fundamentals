# Getting Started with Java and IntelliJ

Getting started with Java and IntelliJ - if you prefer to watch a video, skip down to the [demonstration](#demonstration)

## Installations

### IntelliJ IDE

You can write Java using any text editor but the most popular tool is IntelliJ. So you're going to start using that now, because it'll pay off in the long run but it will take a bit of time to get used to, so be ready for that.

[Download the community version here](https://www.jetbrains.com/idea/download/#section=mac)

### Java Development Kit

Java Development Kits (JDK) contain a bunch of tools (including a version of Java) that you need for running Java code on your machine. The only thing to be aware of here is the version that you're downloading - right now, version 17 is the best choice even though there are more recent versions.

Luckily, you can install version 17 using homebrew :)

```shell
; brew install openjdk@17
```

Then, do this to verify that everything worked

```shell
; java --version
```

And you should see output a bit like this

```shell
openjdk 17.0.5 2022-10-18
OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
OpenJDK 64-Bit Server VM Temurin-17.0.5+8 (build 17.0.5+8, mixed mode)
```

>  the most important thing is that you have a version which starts with `17`. Other details might be different and that's fine.

<details>
  <summary>Why is version 17 better than version 18, 19, etc..?</summary>
  <p>
    OK so there isn't yet a version 200 but at there are newer versions than 17, so why not use them? Java versions are a bit unusual in that they are not all intended for long term support (LTS). Some versions are sort of temporary and will stop being updated sooner than others. The table below shows that 17 is the most recent version LTS version.
  </p>
    <table>
      <tr>
        <th>Version</th>
        <th>Release</th>
        <th>End Of Active Support</th>
      </tr>
      <tr>
        <td>20</td>
        <td>21 March 2023</td>
        <td>19 Sept 2023</td>
      </tr>
      <tr>
        <td>19</td>
        <td>20 Sept 2022</td>
        <td>21 March 2023</td>
      </tr>
      <tr>
        <td>18</td>
        <td>22 March 2022</td>
        <td>19 Sept 2023</td>
      </tr>
      <tr style="color: green">
        <td>17</td>
        <td>14 Sept 2021</td>
        <td>30 Sept 2029</td>
      </tr>
    </table>
</details>

## Demonstration

[Demonstration Video](https://youtu.be/OIUMNboMyhs)


[Next Challenge](02_running_java_bite.md)

<!-- BEGIN GENERATED SECTION DO NOT EDIT -->

---

**How was this resource?**  
[😫](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F01_getting_started_bite.md&prefill_Sentiment=😫) [😕](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F01_getting_started_bite.md&prefill_Sentiment=😕) [😐](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F01_getting_started_bite.md&prefill_Sentiment=😐) [🙂](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F01_getting_started_bite.md&prefill_Sentiment=🙂) [😀](https://airtable.com/shrUJ3t7KLMqVRFKR?prefill_Repository=makersacademy%2Fjava-fundamentals-with-intellij&prefill_File=out%2Fproduction%2Fjava_fundamentals_with_intellij%2Fbites%2F01_getting_started_bite.md&prefill_Sentiment=😀)  
Click an emoji to tell us.

<!-- END GENERATED SECTION DO NOT EDIT -->
