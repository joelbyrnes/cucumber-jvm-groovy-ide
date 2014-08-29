### Cucumber-JVM in Groovy with IDE support and more.

This project represents the distillation of my experience with Cucumber-JVM and what I consider best practise for self-contained, easy to create and run, automated tests driven by Specification By Example. I have used this model to create scheduled, automated tests which can test our project deployed in any environment, even smoke test a new production release.    

This is an example for how to create cucumber-jvm groovy projects which are more friendly in the IDE, specifically JetBrains IntelliJ IDEA!
* The steps files can share state via CustomWorld, which is nice for keeping your step defs tidy
* Groovy mixins make the above sharing explicit, used in each step def files, so your IDE can find the correct objects for autocompletion, instead of trusting Cucumber's magic
* Allows you to run features or Cucumber junit tests directly in IntelliJ from version 13, which is quite nice!
 
Forked from https://github.com/dkowis/cucumber-jvm-groovy-example in order to demonstrate more advanced setup.

## Screenshots

[![Running-feature](ide-screenshot.png)]
[![Running-test](ide-screenshot2.png)]

## Versions
 * Gradle: 1.7 
 * Cucumber-jvm: as listed in the build.gradle file (1.1.6 currently)

## Instructions

The project I forked from used gradle to run cucumber, but either way you run it doesn't work:
* "gradle cucumber" uses javaexec to call the cucumber Main class with glue options, as well as a classpath hack, but this doesn't seem to be able to find classes within a groovy script, ie CustomWorld, so it fails.
* "gradle test" runs RunCukesTest, but this fails as described below due to junit XML.

Therefore I added a pom.xml and "mvn clean install" works fine. I hope to get gradle working in future. 

This pom.xml also contains a number of other examples and optional code. I move cucumber execution to the verify phase so I can run a sanity check in the test phase and stop there if the environment is down rather than get a bunch of bad test results. 

There are options in RunCukesTest to create a HTML report, and JUnit XML and JSON output, which can be used in Jenkins like any JUnit results.

## NOTE

You can't run `gradle test`. It's XML output mechanism that it uses for executing the Junit tests doesn't like to make files
named 'Scenario: Regular Numbers.xml'. Easy to overcome using the `gradle cucumber` task, and probably a "bug" in gradle,
but I'm not yet bothered to bug them about it.

## To do 

* Describe more of the special features of this project, and why they are important/rationale
* Get it working in gradle, get rid of maven

