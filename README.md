# 🚀 Automation Project – SauceDemo Testing  

## 📌 Overview  
This project is an automated testing framework built with **Java, Selenium, and TestNG**.  
It follows the **Page Object Model (POM)** design pattern to ensure clean, maintainable, and scalable test code.  

The tests cover key workflows on [SauceDemo](https://www.saucedemo.com/), including:  
- ✅ User Login / Logout  
- ✅ Adding and Removing Products from Cart  
- ✅ Purchasing Products  

---

## 🛠️ Tech Stack  
- **Java 17+**  
- **Maven** (dependency management)  
- **Selenium WebDriver** (browser automation)  
- **TestNG** (test framework)  
- **WebDriverManager** (automatic driver management)  

---

## 📂 Project Structure  
automationProject/<br>
│── src/main/java/com/automationProject/pages/ # Page Object classes<br>
│── src/test/java/com/automationProject/tests/ # Test classes<br>
│── src/test/java/com/automationProject/base/ # BaseTest (WebDriver setup/teardown)<br>
│── src/test/resources/testng.xml # Test suite configuration<br>
│── pom.xml # Maven dependencies


---

## ⚙️ Setup Instructions  

### 1. Clone the Repository  
```bash
https://github.com/diegosalazar01/POMProject.git
cd automationProject
```
### 2. Install Dependencies
```bash
mvn clean install
```
### 3. Run Tests
Run the full suite using TestNG:
```bash
mvn test -DsuiteXmlFile=src/test/resources/TestsSuite.xml
```

---

## 🧪 Test Scenarios
### 1. Logout Test

- Verifies that different users can log in and log out successfully.

### 2. Remove Elements Test

- Adds products to the cart.

- Removes them and validates the cart is empty.

### 3. Purchase Product Test

- Logs in with multiple users.

- Adds items to the cart.

- Completes the checkout process.

- Validates order confirmation messages.

## 🔑 Key Features

- Reusable BaseTest for WebDriver lifecycle.

- Page Object Model (POM) for maintainability.

- Data-driven testing with TestNG DataProviders.
