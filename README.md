# Selenium Cucumber Sample Project

**Intendended use:** Sample project with Selenium and Cucumber using the ChromeDriver (win64 version) already set up. Can be used as a starting point for less technical teams.

## Installation
Import the project as a Maven project (tested in good old Eclipse IDE).

## Usage
Run "TestRunner.java" as a JUnit TestRunner or an individual test (e.g. "DuckDuckGoSearch.feature") as a Cucumber feature.

## App Behavior
- There is one sample Scenario implemented, a simple search in DuckDuckGo.
- The application saves reports in HTML and JSON to /target/HtmlReports/ and to /target/JsonReports/ respectively. This configuration is made with an annotation tag at the "TestRunner.java".
