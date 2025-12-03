🧩 Key Features of the Framework
✔ Playwright browser automation
✔ Cucumber BDD with natural language steps
✔ TestNG test runner
✔ Page Object Model for clean structure
✔ Screenshots on failure
✔ Video recording on failure
✔ Allure reporting
✔ Config file for environment settings

📘 ParaBank Automation Framework – Playwright + Java
This repository contains an automated testing framework for ParaBank, built using:
•	Automation Tool: Playwright
•	Programming Language: Java
•	Build Tool: Maven
•	Frameworks: Cucumber (BDD), TestNG
•	Reporting: Allure Reports

📁 Project Structure
Below is the updated structure exactly matching your project:
ParaBank
│
├── pom.xml
├── config.properties
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.parabank
│   │   │       ├── core
│   │   │       │    ├── BaseFactory.java
│   │   │       │    └── CoreFunctions.java
│   │   │       │
│   │   │       ├── pages
│   │   │       │    ├── CustomerCarePage.java
│   │   │       │    ├── HomePage.java
│   │   │       │    └── LandingPage.java
│   │   │       │
│   │   │       ├── steps
│   │   │       │    └── LoginSteps.java
│   │   │       │
│   │   │       └── utils
│   │   │            └── Utilities.java
│   │   │
│   │   └── resources
│   │
│   ├── test
│   │   ├── java
│   │   │   └── com.parabank.tests
│   │   │        ├── BaseTest.java
│   │   │        └── RunnerTest.java
│   │   │
│   │   └── resources
│   │        └── features
│   │             └── *.feature
│   │
│   └── test-output
│
├── target
│   ├── videos
│   ├── surefire-reports
│   ├── generated-test-sources
│   └── generated-sources
│
└── allure-results
    ├── *.json
    ├── *.txt
    └── *.attachment files

---

## 🧪 Test Scenarios Covered

### **1. Login into Para Bank**

- Navigate to landing page  
- Enter username  
- Enter password  
- Click login  
- Validate total balance is displayed  

### **2. Contact Us: Submit Customer Care Form**

- Navigate to landing page  
- Click **Contact Us**  
- Submit form using table data  
- Verify success "Thanks" message  

---

## 📄 Feature File

The project includes the following Gherkin scenarios:

```gherkin
Feature: Para Bank Application Tests

  Background:
    Given user is on landing page

  Scenario: Login into Para Bank with valid credentials
    When user enters username
    And user enters password
    And user clicks on login button
    Then user can see total balance

  Scenario: User submitting details to customer care
    When user clicks on contactus
    And user submits contact us form
      | Name     | Email               | Phone       | Message                             |
      | Srinivas | srinivas@test.com   | 9876543210  | Need help regarding my login        |
    Then user can see Thanks message

▶️ How to Run Tests
Run all tests from terminal:
mvn clean test
📊 Viewing Allure Report
Step 1: Generate report
allure serve allure-results
This opens a live Allure dashboard in your browser.
🧰 Tech Stack Summary
Category	Technology
Automation Tool	Playwright
Language	Java
Build Tool	Maven
Test Runner	TestNG
BDD Framework	Cucumber
Reporting	Allure Reports
Design Pattern	Page Object Model (POM)

