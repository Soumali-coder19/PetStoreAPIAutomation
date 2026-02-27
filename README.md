# 🐾 PetStore API Automation

A comprehensive **automated testing suite** for the PetStore API that validates all core functionality—creating, reading, updating, and deleting user accounts.

---

## 🎯 What Does This Project Do?

This project ensures the **PetStore API works correctly** by automatically testing every feature. Instead of manually checking if the API works, this automation:

✅ **Creates test user accounts** and verifies they're added successfully  
✅ **Retrieves user data** to confirm information is stored correctly  
✅ **Updates user profiles** and validates changes take effect  
✅ **Deletes user accounts** and ensures removal is complete  

All tests run automatically and generate easy-to-read reports showing what passed and what failed.

---

## 🛠️ Technology Stack

| Component | Purpose |
|-----------|---------|
| **Java** | Programming language for writing tests |
| **REST Assured** | Library for testing APIs |
| **TestNG** | Framework for organizing and running tests |
| **Log4j2** | Logging tool to track test execution details |
| **JavaFaker** | Generates random realistic test data |
| **Apache POI** | Reads test data from Excel files |
| **Extent Reports** | Creates beautiful HTML test reports |

---

## 📋 Project Structure

```
PetStoreAutomation/
├── src/test/java/
│   ├── api/
│   │   ├── endpoints/              # API endpoint definitions
│   │   │   ├── Routes.java         # Stores all API URLs in one place
│   │   │   ├── userEndPoints.java  # Methods for user API operations
│   │   │   └── userEndPoints2.java # Alternative endpoint implementation
│   │   ├── payload/
│   │   │   └── User.java           # User data structure (POJO)
│   │   ├── test/
│   │   │   ├── UserTests.java      # Main test cases (CRUD operations)
│   │   │   ├── UserTests2.java     # Additional test scenarios
│   │   │   └── DDTests.java        # Data-driven tests (Excel-based)
│   │   └── utilities/
│   │       └── DataProviders.java  # Test data sources & helpers
│   └── resources/
│       ├── testng.xml              # Test execution configuration
│       └── routes.properties        # API endpoint URLs (configurable)
├── test-output/                    # Auto-generated test results
│   ├── index.html                  # Main test report dashboard
│   ├── emailable-report.html       # Email-friendly test summary
│   └── junitreports/               # JUnit XML reports
├── Reports/                        # Extent Reports (detailed HTML reports)
├── pom.xml                         # Maven project configuration & dependencies
└── README.md                       # Project documentation (this file)
```

---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have:
- **Java 8 or higher** - [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.6+** - [Install Maven](https://maven.apache.org/install.html)
- **Git** - [Install Git](https://git-scm.com/)
- **Internet connection** - Tests require access to the Swagger PetStore API

### Installation Steps

#### Step 1: Clone the Repository
```bash
git clone https://github.com/Soumali-coder19/PetStoreAPIAutomation.git
cd PetStoreAutomation
```

#### Step 2: Verify Java & Maven Installation
```bash
java -version
mvn -version
```

#### Step 3: Install Project Dependencies
```bash
mvn clean install
```
This downloads all required libraries (REST Assured, TestNG, Log4j2, etc.)

#### Step 4: Run All Tests
```bash
mvn test
```

#### Step 5: View Test Reports
Open one of these in your web browser:
- **`test-output/index.html`** - Main TestNG dashboard
- **`Reports/`** - Detailed Extent Reports (with screenshots & logs)

---

## 📊 Test Cases Covered

### Core User API Tests

| Test Name | What It Tests | Purpose |
|-----------|---------------|---------|
| **testPostUser** | Creating a new user account | Verifies the API can create users with correct data |
| **testGetUserByName** | Fetching user by username | Confirms retrieval of stored user information |
| **testUpdateUserByName** | Updating user profile data | Validates that changes are properly saved |
| **testDeleteUserByName** | Removing a user account | Ensures cleanup and proper deletion |

### Data-Driven Testing
- **DDTests.java** - Runs the same tests with multiple user datasets from Excel
- Validates API behavior across different scenarios
- Provides comprehensive coverage with minimal code repetition

### Test Execution Flow
```
1. Setup Test Data (Generate random user information)
   ↓
2. Create User (POST request)
   ↓
3. Read User (GET request)
   ↓
4. Update User (PUT request)
   ↓
5. Delete User (DELETE request)
   ↓
6. Generate Report (HTML + XML reports)
```

---

## 📈 Understanding Test Reports

### HTML Test Dashboard

After running tests, open **`test-output/index.html`** to see:

```
┌─────────────────────────────────────┐
│     Test Execution Summary          │
├─────────────────────────────────────┤
│  Total Tests: 4                     │
│  ✅ Passed: 3                       │
│  ❌ Failed: 1                       │
│  ⏱️  Total Time: 9.5 seconds        │
│  Success Rate: 75%                  │
└─────────────────────────────────────┘
```

**What Each Color Means:**
- 🟢 **Green** - Test passed successfully
- 🔴 **Red** - Test failed (something went wrong)
- 🟡 **Yellow** - Test skipped

### Extent Reports

**Location:** `Reports/Test-Report-YYYY.MM.DD.HH.MM.SS.html`

Features:
- 📊 Detailed test metrics & charts
- 📝 Complete test logs
- 🔍 Step-by-step execution trace
- ⚠️ Error messages & stack traces (if any)
- ⏱️ Individual test timing information

---

## 🔄 How This Automation Works

### 1. **Test Setup**
```
Each test starts with:
- Generating random user data (name, email, phone, etc.)
- Setting up logging to track execution
- Preparing API request parameters
```

### 2. **API Call**
```
REST Assured sends HTTP requests:
- POST: Create new user
- GET: Retrieve user information
- PUT: Update user details
- DELETE: Remove user account
```

### 3. **Assertion & Validation**
```
The test verifies:
- HTTP Status Code (200 = Success, 405 = Method Not Allowed, etc.)
- Response content (correct user data returned)
- Expected behavior (data saved/deleted correctly)
```

### 4. **Logging**
```
Every action is logged:
"Creating new user..." → API called → Response received → Data verified
```

### 5. **Report Generation**
```
Results compiled into:
- HTML reports (readable by anyone)
- XML reports (machine-readable for CI/CD)
- Log files (for debugging)
```

---

## ⚙️ Configuration

### API Endpoint Configuration

**File:** `src/test/resources/routes.properties`

```properties
# Base URL for the API
base_url=https://petstore.swagger.io/v2

# User endpoints
post_url=${base_url}/user
get_url=${base_url}/user/{username}
update_url=${base_url}/user/{username}
delete_url=${base_url}/user/{username}
```

### Test Execution Configuration

**File:** `src/test/resources/testng.xml`

```xml
<suite name="PetStore User API Tests">
  <test name="User CRUD Tests">
    <classes>
      <class name="api.test.UserTests"/>
      <class name="api.test.UserTests2"/>
      <class name="api.test.DDTests"/>
    </classes>
  </test>
</suite>
```

### Logging Configuration

**File:** `src/test/resources/log4j2.xml`

Logs are written to:
- **Console** - Real-time output while tests run
- **File** - Stored in `logs/` directory for later review

---

## 🎯 Key Features & Best Practices

### ✨ Modular Architecture
- **Endpoints separated** - All API calls in dedicated endpoint classes
- **Reusable methods** - `userEndPoints.java` contains all CRUD operations
- **Configuration managed** - URLs stored in properties file (easy to change)

### ✨ Data Generation
- **JavaFaker library** - Creates realistic random test data
- **No hardcoded values** - Every test run uses different user information
- **Excel support** - Load test data from external files (DDTests)

### ✨ Professional Logging
- **Apache Log4j2** - Industry-standard logging framework
- **Multiple log levels** - DEBUG, INFO, WARN, ERROR
- **Timestamped logs** - Every action recorded with exact timing

### ✨ Comprehensive Reporting
- **Multiple formats** - HTML, XML, JSON
- **Beautiful dashboards** - Easy-to-understand visualizations
- **Detailed logs** - Full execution trace for debugging

### ✨ Maintainability
- **Clear naming** - Method names describe what they do
- **Comments** - Code is well-documented
- **Single Responsibility** - Each class has one clear purpose

---

## 🐛 Troubleshooting Guide

### ❌ "mvn command not found."
**Problem:** Maven is not installed or not in the system PATH  
**Solution:**
```bash
# Verify Maven installation
mvn -version

# If not installed, download from https://maven.apache.org/download.cgi
# Add Maven to your PATH environment variable
```

### ❌ "Cannot find test reports."
**Problem:** Tests ran, but you can't find the results  
**Solution:**
```bash
# After running: mvn test

# Look in these locations:
# 1. test-output/index.html (TestNG report)
# 2. Reports/ (Extent Reports)
# 3. test-output/junitreports/ (JUnit XML reports)
```

### ❌ "Connection refused" or Network errors
**Problem:** Tests fail with network errors  
**Solution:**
- Check your internet connection
- Verify the API is accessible: https://petstore.swagger.io/
- Check if you're behind a corporate firewall/proxy
- Restart your internet connection

### ❌ Tests fail with HTTP 405 errors
**Problem:** Test gets 405 (Method Not Allowed) response  
**Solution:**
- This might be expected behavior for certain endpoints
- Check `UserTests2.java` - it has different assertions than `UserTests.java`
- Review the test report for detailed error messages

### ❌ "Tests run, but reports are empty."
**Problem:** Tests passed, but no report generated  
**Solution:**
```bash
# Make sure to run:
mvn clean test

# NOT just: mvn test

# The 'clean' command removes old reports
# Then new reports are generated
```

---

## 📱 API Reference

### PetStore Swagger API

**Base URL:** `https://petstore.swagger.io/v2`

### User Endpoints

#### 1. Create User (POST)
```
POST /user
Content-Type: application/json

Request Body:
{
  "id": 123,
  "username": "john_doe",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "password": "secure123",
  "phone": "9876543210"
}

Response: 200 OK
```

#### 2. Get User (GET)
```
GET /user/{username}

Response: 200 OK
{
  "id": 123,
  "username": "john_doe",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "phone": "9876543210"
}
```

#### 3. Update User (PUT)
```
PUT /user/{username}
Content-Type: application/json

Request Body: (updated user data)
{
  "firstName": "Jonathan",
  "email": "jonathan@example.com"
}

Response: 200 OK
```

#### 4. Delete User (DELETE)
```
DELETE /user/{username}

Response: 200 OK
```

---

## 🎓 What we Learnt

This project demonstrates:

✅ **API Testing** - How to test web APIs programmatically  
✅ **Test Automation** - Writing automated tests that run without manual intervention  
✅ **Java Programming** - Using Java for test automation  
✅ **Testing Frameworks** - Working with industry-standard tools like TestNG and REST Assured  
✅ **Data-Driven Testing** - Running the same tests with different data sets  
✅ **Test Reporting** - Generating professional test reports  
✅ **Git & Version Control** - Managing code with GitHub  
✅ **Best Practices** - Clean code, maintainability, documentation  

---

## 📚 Learning Resources

| Topic | Resource |
|-------|----------|
| REST APIs | [REST API Basics](https://restfulapi.net/) |
| HTTP Methods | [HTTP/HTTPS Guide](https://developer.mozilla.org/en-US/docs/Web/HTTP) |
| TestNG | [TestNG Documentation](https://testng.org/) |
| REST Assured | [REST Assured Guide](https://rest-assured.io/) |
| Apache POI | [POI Documentation](https://poi.apache.org/) |
| Swagger PetStore | [Interactive API Docs](https://petstore.swagger.io/) |

---

## 🚦 CI/CD Integration

This project can be integrated with CI/CD pipelines like:
- **Jenkins** - Run tests automatically on every commit
- **GitHub Actions** - Built-in CI/CD for GitHub repositories
- **GitLab CI** - Integrated CI/CD pipelines
- **Azure DevOps** - Microsoft's continuous integration platform

**Example GitHub Actions workflow:**
```yaml
name: Run API Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-java@v2
        with:
          java-version: '11'
      - run: mvn clean test
```

---

## 💼 Project Statistics

| Metric | Value |
|--------|-------|
| **Language Breakdown** | Java (6.8%), HTML (80.9%), CSS (7.8%), JavaScript (4.5%) |
| **Test Coverage** | 4 core test cases + Data-driven variations |
| **Code Organization** | 3 main modules (endpoints, payloads, tests) |
| **Dependencies** | 10+ testing and utility libraries |
| **Report Formats** | HTML, XML, JSON |

---

## 🤝 Contributing

Found a bug? Want to improve something? Here's how:

1. **Fork the repository** - Create your own copy
2. **Create a branch** - `git checkout -b feature/improvement`
3. **Make changes** - Update or add new tests
4. **Commit** - `git commit -m "Add new test case"`
5. **Push** - `git push origin feature/improvement`
6. **Submit Pull Request** - Describe your changes

---

## 📞 Support & Questions

**Need Help?**
- 📖 Check the [Troubleshooting Guide](#-troubleshooting-guide) above
- 🔍 Review test logs in `test-output/` folder
- 📚 Consult the [Learning Resources](#-learning-resources)
- 🌐 Visit [Swagger PetStore API Docs](https://petstore.swagger.io/)

**Found an Issue?**
- Open a GitHub Issue in this repository
- Provide test output & logs
- Describe steps to reproduce

---

## 📄 License

This project is open-source and available under the **MIT License**.  
Feel free to use it for educational and professional purposes.

---

## ✅ Quick Verification Checklist

After setting up, verify everything works:

- [ ] Java is installed: `java -version` ✓
- [ ] Maven is installed: `mvn -version` ✓
- [ ] Repository cloned successfully ✓
- [ ] Dependencies installed: `mvn clean install` ✓
- [ ] Tests run without errors: `mvn test` ✓
- [ ] Test report opens in browser ✓
- [ ] All 4 tests show in report ✓
- [ ] Can read execution logs ✓

**If all checkboxes are ✓, you're all set!** 🎉

---

## 🎉 Next Steps

Now that you have the automation framework set up:

1. **Run tests regularly** - Track API health over time
2. **Add more test cases** - Expand coverage for edge cases
3. **Integrate with CI/CD** - Automate test execution on every code push
4. **Share reports** - Keep stakeholders updated on API quality
5. **Customize for your needs** - Adapt endpoints and tests for your use case

---

## 👨‍💻 Project Author

**Soumali-coder19**  
📧 GitHub: [@Soumali-coder19](https://github.com/Soumali-coder19)

---

## 📅 Last Updated

**February 2026**  
**Status:** ✅ Active & Maintained  
**Tested On:** Java 11+, Maven 3.6+

---

**Happy Testing! 🚀**

If this project helped you, consider giving it a ⭐ on GitHub!
