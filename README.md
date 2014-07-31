### Cucumber-JVM in Groovy with IDE support and more.

This project shows how to create cucumber-jvm groovy projects which are more friendly in the IDE, specifically JetBrains IntelliJ IDEA!
* The steps files can share state via CustomWorld, which is nice for keeping your step defs tidy
* Groovy mixins make the above sharing explicit, used in each step def files, so your IDE can find the correct objects for autocompletion, instead of trusting Cucumber's magic
* Allows you to run features or Cucumber junit tests directly in IntelliJ from version 13, which is quite nice!

Forked from https://github.com/dkowis/cucumber-jvm-groovy-example in order to demonstrate more advanced setup.

### Versions
 * Gradle: 1.7 
 * Cucumber-jvm: as listed in the build.gradle file! (1.1.6 currently)

### Instructions

The project I forked from used gradle to run cucumber, but either way you run it doesn't work:
* "gradle cucumber" uses javaexec to call the cucumber Main class with glue options, as well as a classpath hack, but this doesn't seem to be able to find classes within a groovy script, ie CustomWorld, so it fails.
* "gradle test" runs RunCukesTest, but this fails as described below due to junit XML.

Therefore I added a pom.xml and "mvn clean install" works fine.

This pom.xml also contains a number of other examples and optional code. I move cucumber execution to the verify phase so I can run a sanity check in the test phase.

There are options in RunCukesTest to create a HTML report, and JUnit XML and JSON output, which can be used in Jenkins like any JUnit results.

===

To build the project you can follow standard gradle build stuffs.

I've added a custom cucumber task necessary to run the Cucumber CLI against the groovy scripts and the feature files.

```gradle cucumber```

to run that and you should then have a nice pretty green (for the most part) output from gradle as the cucumber features
are executed. It'd be easy enough to glue the cucumber task to happen as part of the testing cycle or before a deployment.

### NOTE

You can't run `gradle test`. It's XML output mechanism that it uses for executing the Junit tests doesn't like to make files
named 'Scenario: Regular Numbers.xml'. Easy to overcome using the `gradle cucumber` task, and probably a "bug" in gradle,
but I'm not yet bothered to bug them about it.