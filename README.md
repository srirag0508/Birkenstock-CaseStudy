# Birkenstock Case Study Automation Project

## Introduction

This repository contains an automated test suite for the Fit Guide functionality on the Birkenstock product page. The Fit Guide assists users in finding the perfect size for their Birkenstock shoes. The automation is implemented using Selenium WebDriver with Java.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Test Automation Scenario](#test-automation-scenario)
- [Page Objects and Functions](#page-objects-and-functions)
- [Running the Tests](#running-the-tests)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Ensure you have the following software installed on your machine:

1. **Java Development Kit (JDK):** [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Maven:** [Download Maven](https://maven.apache.org/download.cgi)

3. **WebDriver:** Download the appropriate WebDriver executable for your browser (e.g., ChromeDriver, GeckoDriver).

4. **Java IDE:** Use IntelliJ IDEA or your preferred Java IDE. [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Project Structure

Organize your project with the following structure:

```plaintext
Birkenstock-CaseStudy
|-- Features
|-- src
|   |-- main
|   |   `-- java
|   |       `-- pages
             -- stepdefinition
             -- util
    |-- resources
        -- drivers
|   |-- test
|   |   `-- java
|   |       `-- TestRunner
|-- pom.xml
|-- .gitignore
|-- README.md

```


## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/srirag0508/Birkenstock-CaseStudy.git
   ```

2. **Open the project in your IDE:**

   Open the project in your preferred Java IDE, such as IntelliJ IDEA.

3. **Configure WebDriver path:**

   In your test scripts, configure the path to the WebDriver executable for your chosen browser.

## Test Automation Scenario

### Fit Guide Fly-in on PDP

1. **Navigate to PDP:**

   Open the product page ( Link](https://www.birkenstock.com/gb/arizona-birko-flor-nubuck/arizona-core-birkoflornubuck-0-eva-u_650.html)).

2. **Click on the Fit Guide link to open it.**

3. **Under the left foot:**

   - Select length and width from the dropdown:
     - Length: 220 mm
     - Width: 85 mm

4. **Under the right foot:**

   - Select length and width from the dropdown:
     - Length: 220 mm
     - Width: 85 mm

5. **Click on "Calculate Size."**

6. **Verify the resulted Size.**

7. **Verify the resulted Width.**

8. **Click on "Add to Shopping Cart."**

## Page Objects and Functions

Create Page Objects and their member functions for better test structure. For example, you can create a Page Object for the Fit Guide page with functions like `selectFootSize`, `calculateSize`, `verifySize`, `addToCart`, etc.

```java
// Example Page Object for Fit Guide
public class FitGuidePage {
    // Define WebElements and member functions here
}
```

## Running the Tests

Execute the automation scenario by running the test script:

```bash
mvn clean test
```

## Contributing

Contributions are welcome! Fork the repository, make your changes, and submit a pull request.

