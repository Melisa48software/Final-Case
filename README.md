# LCW Automation Project

## Project Overview
This project automates a series of user interactions on the LCW (www.lcw.com) website. It simulates real-world scenarios such as logging in, navigating categories, applying filters, sorting products, adding items to the cart and favorites, and validating the cart and favorites functionalities.

## Technologies Used
- **Programming Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Reporting Tool:** Allure Reports


## Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher.
- **Maven:** Installed and configured in the system's PATH.
- **Google Chrome Browser:** Latest version.
- **ChromeDriver:** Version compatible with your Chrome browser.
- **Allure CLI (optional):** For generating and viewing reports.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```bash
   cd LCWAutomationProject
   ```

3. Add required Maven dependencies in `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.x.x</version>
       </dependency>
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.x.x</version>
           <scope>test</scope>
       </dependency>
       <dependency>
           <groupId>io.qameta.allure</groupId>
           <artifactId>allure-testng</artifactId>
           <version>2.x.x</version>
       </dependency>
   </dependencies>
   ```

4. Configure the `config.properties` file:
   ```properties
   base.url=https://www.lcw.com

5. Ensure the `chromedriver` executable path is correctly set in the `LCWAutomationProject.java` file:
   ```java
   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
   ```

## Running Tests
1. Open a terminal in the project directory.
2. Run the tests using Maven:
   ```bash
   mvn test
   ```

## Generating Reports
1. Install Allure CLI (if not already installed):
   ```bash
   brew install allure # For macOS
   scoop install allure # For Windows
   ```

2. After tests are executed, generate the report:
   ```bash
   allure serve target/allure-results
   ```

## Key Test Scenarios
- **Login Test:** Validates the login functionality with correct credentials.
- **Category Navigation:** Ensures proper navigation through categories and subcategories.
- **Filtering and Sorting:** Verifies product filtering by size and color, and sorting by popularity.
- **Cart Functionality:** Confirms product addition to the cart and its validation.
- **Favorites Functionality:** Ensures products can be added to favorites and are displayed correctly.
- **Checkout Process:** Tests navigation through the checkout process up to payment selection.

## Notes
- Ensure stable internet connectivity while running the tests.
- Update the `config.properties` file with valid credentials before running the tests.

