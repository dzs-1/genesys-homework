![alt text](genesys_logo.png)
# Genesys Homework Assignment #

This project is an assignment for Genesys. It is a Java based testing framework utilizing various libraries.
There are four UI tests and one API test in the repository, which can be executed locally and remotely.

## Getting started
These instructions will show you to the necessary steps needed for setting up the project on your local machine, and running the tests.

### Prerequisites
+ JDK 17
+ Maven
+ IntelliJ IDEA
+ Git
+ Installed browsers: Chrome (default)

### Installing
1. Clone the repository with command line via HTTPS. Open git bash and type the following:
```
git clone https://github.com/dzs-1/genesys-homework
```
2. Open project using pom.xml in IntelliJ IDEA

## Running tests
There are multiple ways to run the tests in the repository based on your preference.
### 1. Run from IntelliJ
+ Create a run configuration under Run/Edit configurations in IntelliJ
  + In the Cucumber Java template, set the Main class to
     ```
     io.cucumber.core.cli.Main
     ```
  + Copy the package name from src/test/java/org/dozsapeter/genesys/ui_testing/runner/TestRunner.java
    "glue" part and add to the Glue section in the Cucumber Java template
    ```
    org.dozsapeter.genesys.ui_testing.step_definitions
    ```
  + Add user credentials to VM options in the template
    ```
     -Dusername=standard_user
     -Dpassword=secret_sauce
    ```
+ Apply the changes
+ The tests can now be run by clicking on Run icon in the feature file (or in the test class for API test)
  

### 2. Run from console
There are several choices possible for running the tests from console
You can set the browser where you want to run your tests.
+ Run all tests with default options:
    ```
    mvn test -Dusername=standard_user -Dpassword=secret_sauce
    ```
+ Run all tests with different browser:
    + Chrome (default)
    + Firefox
    + Safari
    + Edge

    ```
  mvn test -Dusername=standard_user -Dpassword=secret_sauce -Dbrowser=<lowercase-browser-name-here>
    ```
  DISCLAIMER:
  The tests were written using Chromedriver, other browser options may fail due to the differences in the drivers


+ Run only UI tests:
  ```
  mvn test -Dtest=TestRunner -Dusername=standard_user -Dpassword=secret_sauce
  ```
+ Run specific UI test(s) based on tag:

    ```
    mvn test -Dtest=TestRunner -Dusername=standard_user -Dpassword=secret_sauce -Dcucumber.filter.tags="@<cucumber-tag-here>"
    ```
+ Run only API test:
    ```
    mvn test -Dtest="**/*Test.java"
    ```
  
### 3. Run from GitHub
There is a simple GitHub Action in the repository which checks out the project, sets up Java and Chrome and runs all the tests in a Linux environment remotely.
Test results can be checked in the Action logs.
+ Go to the [GitHub repository](https://github.com/dzs-1/genesys-homework)
+ Click on the Actions tab
+ Click on Run workflow
  
## Built with
   + [Java](https://www.java.com/en/) - Programming language
   + [Maven](https://maven.apache.org) - Dependency management
   + [Selenium](https://www.selenium.dev) - Browser automation
   + [Cucumber](https://cucumber.io) - BDD testing framework
   + [JUnit](https://junit.org/junit5/) - Unit testing framework
   + [REST Assured](https://rest-assured.io) - REST API testing library
   + [GitHub Actions](https://github.com/features/actions) - CI/CD platform