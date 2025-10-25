# Unit Testing Challenge - AuthService

**Team Name:** LuxeStay  
**Competition Date:** October 25, 2025  
**AI Tool Used:** ChatGPT  
**Duration:** 180 minutes

---

## 📋 Project Overview

This project demonstrates comprehensive unit testing for the **AuthService** component of a hotel management system using AI-assisted test generation.

### Core Feature: Authentication Service

**File:** `src/main/java/com/luxestay/hotel/service/AuthService.java`

**Responsibilities:**

- User registration with password encryption
- User login with credential validation
- Session token management
- Account verification and retrieval

**Technologies:**

- Spring Boot 3.3.3
- JUnit 5 (Jupiter)
- Mockito 5.11.0
- JaCoCo (Code Coverage)
- BCrypt Password Encoding

---

## 🎯 Test Coverage Summary

### Test Statistics

- **Total Test Cases:** 16
- **Tests Passed:** 16/16 ✅
- **Test Execution Time:** ~2.5 seconds
- **Target Coverage:** ≥80%

### Test Breakdown by Method

#### 1. Register Tests (5 tests)

- ✅ `register_WhenEmailNotExists_ShouldSaveAndReturnToken`
- ✅ `register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException`
- ✅ `register_WhenRoleNotFound_ShouldThrowIllegalStateException`
- ✅ `register_ShouldEncryptPasswordWithBCrypt`
- ✅ `register_ShouldAssignCustomerRoleToNewAccount`

#### 2. Login Tests (5 tests)

- ✅ `login_WhenCredentialsValid_ShouldReturnToken`
- ✅ `login_WhenEmailNotFound_ShouldThrowIllegalArgumentException`
- ✅ `login_WhenAccountInactive_ShouldThrowIllegalStateException`
- ✅ `login_WhenPasswordMismatch_ShouldThrowIllegalArgumentException`
- ✅ `login_ShouldStoreTokenInSessionsMap`

#### 3. Verify Tests (2 tests)

- ✅ `verify_WhenValidToken_ShouldReturnAccountId`
- ✅ `verify_WhenTokenInvalid_ShouldReturnEmpty`

#### 4. Logout Tests (2 tests)

- ✅ `logout_WhenValidToken_ShouldRemoveFromSessions`
- ✅ `logout_WhenTokenNotExists_ShouldNotThrowException`

#### 5. RequireAccount Tests (2 tests)

- ✅ `requireAccount_WhenTokenInvalid_ShouldThrowIllegalArgumentException`
- ✅ `requireAccount_WhenValidToken_ShouldReturnAccount`

---

## 🚀 How to Run Tests

### Option 1: IntelliJ IDEA (Recommended)

#### Run Tests:

1. Open `src/test/java/com/luxestay/hotel/service/AuthServiceTest.java`
2. Right-click → **Run 'AuthServiceTest'**
3. Or press `Ctrl + Shift + F10`

#### Run with Coverage:

1. Right-click on `AuthServiceTest.java`
2. Select **Run 'AuthServiceTest' with Coverage**
3. View coverage report in IntelliJ's Coverage panel

### Option 2: Maven Command Line

```bash
# Run tests only
mvn test -Dtest=AuthServiceTest

# Run tests with coverage report
mvn clean test

# Open coverage report (generated at target/site/jacoco/index.html)
start target\site\jacoco\index.html
```

### Option 3: Batch Script (Windows)

```bash
# Double-click or run:
run-tests-with-coverage.bat
```

This will:

- Execute all tests
- Generate JaCoCo coverage report
- Automatically open the HTML report in browser

---

## 📦 Project Structure

```
be_hotel/
├── src/
│   ├── main/java/com/luxestay/hotel/
│   │   ├── service/
│   │   │   └── AuthService.java          # Service under test
│   │   ├── repository/
│   │   │   ├── AccountRepository.java
│   │   │   └── RoleRepository.java
│   │   ├── model/
│   │   │   ├── Account.java
│   │   │   └── Role.java
│   │   └── dto/auth/
│   │       ├── RegisterRequest.java
│   │       ├── LoginRequest.java
│   │       └── AuthResponse.java
│   └── test/java/com/luxestay/hotel/
│       └── service/
│           └── AuthServiceTest.java      # Unit tests (16 tests)
├── prompts/
│   └── log.md                             # AI prompt history
├── coverage/                              # Coverage reports
├── pom.xml                                # Maven dependencies + JaCoCo
└── README.md                              # This file
```

---

## 🔧 Dependencies

### Testing Framework

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

Includes:

- JUnit 5 (Jupiter)
- Mockito 5.11.0
- AssertJ 3.25.3
- Spring Test

### Coverage Tool

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.11</version>
</plugin>
```

---

## 🧪 Testing Approach

### 1. Mocking Strategy

All dependencies are mocked using Mockito:

- `AccountRepository` - Database access
- `RoleRepository` - Role lookup
- `BCryptPasswordEncoder` - Password encryption

### 2. Test Data Setup

- Reusable test fixtures in `@BeforeEach`
- Isolated test cases (no shared state)
- Clear Given-When-Then structure

### 3. Assertion Library

Using **AssertJ** for fluent assertions:

```java
assertThat(response.getToken()).isNotNull();
assertThatThrownBy(() -> service.register(req))
    .isInstanceOf(IllegalArgumentException.class)
    .hasMessage("Email đã tồn tại");
```

### 4. Verification

- Repository interactions verified with `verify()`
- Argument capturing for complex assertions
- Password encryption verified

---

## ⚠️ Known Limitations

### 1. Session Management

- **Issue:** In-memory session map (`HashMap`) is not thread-safe
- **Impact:** Concurrent logins may cause race conditions
- **Recommendation:** Use `ConcurrentHashMap` or Redis for production

### 2. Token Generation

- **Issue:** Using `UUID.randomUUID()` - predictable for testing
- **Impact:** Tests may have different token values each run
- **Recommendation:** Mock UUID generation or use JWT tokens

### 3. Password Validation

- **Issue:** No password strength validation
- **Risk:** Weak passwords accepted (e.g., "123")
- **Recommendation:** Add password policy enforcement

### 4. Email Validation

- **Issue:** No email format validation
- **Risk:** Invalid emails may be stored
- **Recommendation:** Add email regex validation

### 5. Rate Limiting

- **Issue:** No brute-force protection
- **Risk:** Unlimited login attempts possible
- **Recommendation:** Implement rate limiting (e.g., Redis + Spring)

### 6. Account Locking

- **Issue:** Inactive accounts checked but no auto-lock mechanism
- **Risk:** Manual intervention required
- **Recommendation:** Add scheduled jobs for auto-locking

---

## 🔒 Security Considerations

### ✅ Implemented

- ✅ BCrypt password hashing (salt + adaptive hashing)
- ✅ Password never stored in plain text
- ✅ Account active status validation
- ✅ Session token-based authentication

### ⚠️ Missing (Out of Scope)

- ⚠️ HTTPS/TLS encryption (transport layer)
- ⚠️ CSRF protection
- ⚠️ SQL injection prevention (using JPA, but not explicitly tested)
- ⚠️ XSS protection
- ⚠️ Token expiration (sessions never expire)
- ⚠️ Refresh token mechanism

---

## 📊 Coverage Report Access

After running tests:

### JaCoCo HTML Report

```
target/site/jacoco/index.html
```

### IntelliJ Coverage Report

```
View → Tool Windows → Coverage
```

### Expected Coverage

- **AuthService:** ≥85%
- **All methods:** 100% (5/5 methods covered)
- **Branch coverage:** ≥80%

---

## 🤖 AI Assistance Summary

### Prompts Used

**Prompt #1: Test Case Design**

- Generated 20+ test case ideas
- Selected 16 most critical tests
- Covered happy paths, edge cases, and errors

**Prompt #2: Code Generation Guidance**

- Received detailed Given-When-Then descriptions
- Adapted to actual codebase exceptions
- Manual implementation for better control

### AI Tool

- **Model:** ChatGPT (GPT-4)
- **Usage:** Test case design and validation
- **Approach:** AI-suggested → Human-reviewed → Manual implementation

---

## 👥 Team Information

**Team Name:** LuxeStay

**Members:**

1. **DE170779** - Phan Thanh Tùng (Team Leader / Presenter)
2. **SE161796** - Trần Hữu Hiếu (Technical Lead)
3. **DE180397** - Nguyễn Võ Hoàng Huy (Developer)
4. **DE190477** - Nguyễn Thành Long (Developer)
5. **DE180672** - Hoàng Tấn Thành (Documentation & QA)

---

## 📝 Deliverables Checklist

- ✅ `/prompts/log.md` - AI prompt history
- ✅ `/tests/` - 16 test cases (≥15 required)
- ✅ `/coverage/` - Coverage report ≥80%
- ✅ `README.md` - This documentation
- ✅ Demo-ready - Tests run successfully in <3 seconds

---

## 🎓 Lessons Learned

### What Worked Well

1. **Clear feature selection** - AuthService had perfect complexity
2. **Mockito isolation** - No database needed
3. **AssertJ fluency** - Readable assertions
4. **IntelliJ integration** - Fast test execution

### Challenges Faced

1. **Sessions map isolation** - Initially considered using reflection
2. **Token randomness** - Solved by testing verify() indirectly
3. **Time management** - AI prompts saved 40% development time

### Time Breakdown

- Phase 1 (Analysis): 15 min
- Phase 2 (Test Design): 20 min
- Phase 3 (Coding): 60 min
- Phase 4 (Debug): 5 min (No bugs! 🎉)
- Phase 5 (Coverage): 10 min
- Phase 6 (Documentation): 15 min

**Total: 125/180 minutes** (55 minutes buffer)

---

## 🏆 Competition Results

**Status:** ✅ **READY FOR DEMO**

All requirements met:

- ✅ Core feature testing
- ✅ 16/15 test cases (107%)
- ✅ 100% tests passing
- ✅ Coverage ≥80%
- ✅ Complete documentation
- ✅ Prompt log available

---

## 📞 Contact

For questions about this submission, please contact:

- **Email:** [your-email@example.com]
- **GitHub:** [github-url]

---

**Last Updated:** October 25, 2025  
**Version:** 1.0
