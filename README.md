# 📌 Selenium JUnit Automation Assignment

This project contains three automated tasks using Selenium and JUnit:

1. **Practice Form Automation** – [Digital Unite Practice Form](https://www.digitalunite.com/practice-webform-learners)
2. **Guest Registration Form Automation** – [WP Everest Guest Form](https://demo.wpeverest.com/user-registration/guest-registration-form/)
3. **Web Scraping** – [Dhaka Stock Exchange Share Price Table](https://dsebd.org/latest_share_price_scroll_by_value.php)

---
## 📋 Description (Task Overview)

### ✅ Task 1: Automate Web Form Submission

URL: [Digital Unites Practice Webform](https://www.digitalunite.com/practice-webform-learners)

#### Steps:
1. Input all fields in the web form.
2. Upload a file (2MB limit) during the form submission.
3. Click the submit button.
4. After successful submission, assert the expected message: **"Thank you for your submission!"**.

### ✅ Task 2: Automate User Registration Form

URL: [Demo WP Everest User Registration](https://demo.wpeverest.com/user-registration/guest-registration-form/)

#### Steps:
1. Input the following fields:  
   - First Name  
   - Last Name  
   - User Email  
   - Gender  
   - Date of Birth  
   - Nationality  
   - Phone  
   - Country (Bangladesh)  
   - Terms & Conditions  
2. Click the submit button.
3. Assert that the registration is successful.

### ✅ Task 3: Scrape Data from Share Price Table

URL: [DSE Share Price](https://dsebd.org/latest_share_price_scroll_by_value.php)

#### Steps:
1. Print all cell values from the table.
2. Store the values in a text file.

---



## 💠 Tools Used

- **IntelliJ IDEA**: Integrated Development Environment (IDE) used for coding.
- **Selenium**: Used for automating web interactions.
- **JUnit**: Framework for unit testing and assertion.
---
## 📊  Tech Stack
- **Java**
- **JUnit 5**
- **Selenium WebDriver**
- **Gradle**
- **Maven Surefire Plugin (for report)**

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/AARdacca/Junit-Selenium-Practice1
2. Open the Project in any IDE
3. Add Dependency in the build.gradle file and reload gradle from the top right
   - Dependencies Add:
     - [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.31.0)
     - [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2)
    
    image
4. Verification
   - For the web forms:
      - Check the assertion logs for success or failure messages.
   - For the table scraping:
      - Verify the console output and the generated text file (e.g., store.txt).
5. Output Files
   - Logs: Test results and execution details are logged in the console.
   - Text File: Scraped table data is stored in store.txt.

## 📃 Project Reports
### 📖 All Report
- At a glance view for Task 1, Task 2, Task 3
- Package view
- Classes view
#### Report At a glance
image
#### Report Package
image
#### Report Classes
image

### 📖 1. Webform Automation for Digital Unite
- Automated field inputs.
- Implemented file upload functionality.
- Asserted the expected success message: "Thank you for your submission!".
#### Report
image
### 📖 2. Guest Registration Automation for WP Everest
- Automated field inputs for First Name, Last Name, Email, Password, Gender, DOB, Nationality, Phone, Country, and acceptance of Terms & Conditions.
- Asserted successful registration upon submission.
#### Report 

image

### 📖 3. Web Scraping for DSEBD Stock Prices
- Scraped table data from the provided webpage using Selenium.
- Printed all table cell values in the console.
- Stored the scraped data into a text file for reference. 
#### Report

image

#### Text File

image




## 🎥 Demo Video

📺 [Click here to watch the demonstration](https://drive.google.com/file/d/1OnrqYBIy2tQdki5FEibTUTar6Q0NoVqs/view?usp=sharing)

---

## 📦 Author / Maintainer

*Ali Ahasan*

---

## 📆 Submission Checklist

- [x] Project uploaded to **GitHub** ✅ 
- [x] `.idea`, `.gradle`, `build`, `gradle`, `logs` folders/files added to **`.gitignore`** ✅ 
- [x] Project information clearly documented in `README.md` ✅
- [x] Recorded video for each task and **linked in `README.md`** ✅
- [x] Test execution **report screenshots attached to `README.md`** ✅
- [x] **Final GitHub repository link submitted** ✅