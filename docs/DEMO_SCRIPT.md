# Demo Script - 15 Minutes

**Team:** [TÊN NHÓM CỦA BẠN]  
**Feature:** AuthService Unit Testing

---

## 📋 Demo Outline

**Total Time:** 15 minutes

| Section             | Duration | Content                   |
| ------------------- | -------- | ------------------------- |
| 1. Introduction     | 2 min    | Team + Feature overview   |
| 2. Live Test Run    | 3 min    | Execute tests in IntelliJ |
| 3. Code Walkthrough | 5 min    | Show key test cases       |
| 4. Coverage Report  | 2 min    | Display coverage metrics  |
| 5. AI Usage         | 2 min    | Prompt log explanation    |
| 6. Q&A              | 1 min    | Answer questions          |

---

## 🎤 Section 1: Introduction (2 minutes)

### Opening Statement

> "Good morning/afternoon judges. We are **[TÊN NHÓM]**, and today we'll demonstrate our comprehensive unit testing solution for the AuthService component of a hotel management system."

### Team Introduction

> "Our team consists of [số lượng] members who collaborated for 3 hours to deliver this testing suite."

### Feature Selection Justification

> "We selected **AuthService** as our core feature because:
>
> 1. It's **critical for security** - handles passwords and sessions
> 2. **Perfect complexity** - 5 methods with multiple edge cases
> 3. **Realistic** - every application needs authentication
> 4. **Testable** - clear inputs/outputs, easy to mock dependencies"

---

## 🚀 Section 2: Live Test Run (3 minutes)

### Step 1: Navigate to Test File

```
📁 be_hotel/src/test/java/com/luxestay/hotel/service/AuthServiceTest.java
```

### Step 2: Run Tests

**Action:** Right-click → "Run 'AuthServiceTest'"

**While running, explain:**

> "We have **16 comprehensive test cases** covering:
>
> - Registration: email validation, password encryption, role assignment
> - Login: credential validation, account status, session creation
> - Token verification: valid/invalid tokens
> - Logout: session cleanup, idempotency
> - Account retrieval: authorization checks"

### Step 3: Show Results

**Point out:**

- ✅ 16/16 tests PASSED (green checkmarks)
- ⚡ Fast execution (~2.5 seconds)
- 📊 100% success rate

> "All tests pass consistently because we use **Mockito** to isolate the service from database dependencies."

---

## 💻 Section 3: Code Walkthrough (5 minutes)

### Example 1: Happy Path Test (~60 seconds)

**Navigate to:** `register_WhenEmailNotExists_ShouldSaveAndReturnToken()`

**Explain:**

```java
@Test
void register_WhenEmailNotExists_ShouldSaveAndReturnToken() {
    // GIVEN - Setup mocks
    when(accountRepository.existsByEmail(anyString())).thenReturn(false);
    when(roleRepository.findByName("customer")).thenReturn(Optional.of(customerRole));
    when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");

    // WHEN - Call the method
    AuthResponse response = authService.register(validRegisterRequest);

    // THEN - Verify results
    assertThat(response.getToken()).isNotNull();
    verify(accountRepository).save(any(Account.class));
}
```

**Key Points:**

- ✅ **Given-When-Then** structure (clean and readable)
- ✅ **Mockito mocking** - no real database needed
- ✅ **AssertJ assertions** - fluent and expressive
- ✅ **Verification** - ensures repository was called

---

### Example 2: Negative Test (~60 seconds)

**Navigate to:** `register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException()`

**Explain:**

```java
@Test
void register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException() {
    // GIVEN
    when(accountRepository.existsByEmail(anyString())).thenReturn(true);

    // WHEN & THEN
    assertThatThrownBy(() -> authService.register(validRegisterRequest))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Email đã tồn tại");

    // Verify no save occurred
    verify(accountRepository, never()).save(any());
}
```

**Key Points:**

- ✅ **Edge case testing** - duplicate email
- ✅ **Exception validation** - correct type and message
- ✅ **Side effect verification** - no data saved

---

### Example 3: Security Test (~60 seconds)

**Navigate to:** `register_ShouldEncryptPasswordWithBCrypt()`

**Explain:**

```java
@Test
void register_ShouldEncryptPasswordWithBCrypt() {
    // ...setup...

    authService.register(validRegisterRequest);

    // Capture the account being saved
    ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
    verify(accountRepository).save(accountCaptor.capture());

    Account savedAccount = accountCaptor.getValue();
    assertThat(savedAccount.getPasswordHash()).isEqualTo("$2a$10$hashedPassword");
    assertThat(savedAccount.getPasswordHash()).isNotEqualTo("password123");
}
```

**Key Points:**

- ✅ **ArgumentCaptor** - inspect actual saved data
- ✅ **Security validation** - password never stored as plain text
- ✅ **BCrypt verification** - proper hashing algorithm

---

### Example 4: Session Management (~60 seconds)

**Navigate to:** `login_ShouldStoreTokenInSessionsMap()`

**Explain:**

```java
@Test
void login_ShouldStoreTokenInSessionsMap() {
    // GIVEN
    when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
    when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

    // WHEN
    AuthResponse response = authService.login(validLoginRequest);

    // THEN - Verify token works with verify()
    String token = response.getToken();
    Optional<Integer> accountId = authService.verify(token);

    assertThat(accountId).isPresent();
    assertThat(accountId.get()).isEqualTo(1);
}
```

**Key Points:**

- ✅ **Integration verification** - token actually stored
- ✅ **Cross-method testing** - login → verify chain
- ✅ **Session validation** - correct account ID returned

---

### Quick Overview of All Tests (~60 seconds)

**Scroll through test class, pointing out:**

> "Our 16 tests cover:
>
> - **5 methods** in AuthService (100% method coverage)
> - **Happy paths** - normal usage scenarios
> - **Edge cases** - email conflicts, inactive accounts, wrong passwords
> - **Security** - password encryption, token management
> - **Error handling** - proper exception types and messages
> - **Side effects** - verify repositories called correctly"

---

## 📊 Section 4: Coverage Report (2 minutes)

### Option A: IntelliJ Coverage (if ran with coverage)

**Show:** Coverage panel with green highlighted code

**Point out:**

- AuthService: **≥85% coverage** (green)
- All public methods: **100% covered**
- Branch coverage: **≥80%** (if/else branches tested)

---

### Option B: JaCoCo HTML Report

**Open:** `target/site/jacoco/index.html`

**Navigate:**

1. Click `com.luxestay.hotel.service`
2. Click `AuthService`

**Point out metrics:**

- **Instructions:** % of bytecode covered
- **Branches:** % of if/else covered
- **Lines:** % of code lines executed
- **Methods:** 5/5 methods covered

**Explain:**

> "We exceeded the 80% coverage requirement. The uncovered lines are primarily:
>
> - Lombok-generated constructors
> - Trivial getters/setters
> - Exception handlers not triggered in our scenarios"

---

## 🤖 Section 5: AI Usage (2 minutes)

### Show Prompt Log

**Navigate to:** `prompts/log.md`

**Scroll to Prompt #1:**

> "Here's our first prompt to ChatGPT where we asked for test case ideas."

**Highlight:**

- Clear context provided (Java, Spring Boot, JUnit 5)
- Specific request (15+ test cases)
- Comprehensive requirements (happy paths + edge cases)

**Scroll to Results:**

> "ChatGPT generated 20 test case ideas. We selected the 16 most relevant based on:
>
> 1. Actual code behavior (not all suggestions matched our implementation)
> 2. Coverage impact (prioritized critical paths)
> 3. Time constraints (3-hour limit)"

**Explain AI Contribution:**

> "AI helped us:
>
> - **Brainstorm edge cases** we might have missed
> - **Structure test names** using best practices
> - **Save ~40% time** on test design phase
>
> However, we **manually coded all tests** because:
>
> - Better control over mocking setup
> - Adapted to our actual exception types
> - Ensured tests match real behavior"

---

## ❓ Section 6: Q&A (1 minute)

### Anticipated Questions & Answers

**Q: Why only unit tests, no integration tests?**

> A: "The challenge focuses on unit testing. We isolated AuthService using Mockito to test business logic independently. Integration tests would require database setup, which is beyond the 3-hour scope."

**Q: How do you handle the in-memory sessions map in tests?**

> A: "Great question! We tested it indirectly by calling login/register (which store tokens), then verifying the token works using verify(). This tests the actual behavior without needing to mock or reset the internal map."

**Q: What about thread safety with HashMap?**

> A: "Excellent observation. We documented this in our README as a 'Known Limitation'. For production, we recommend ConcurrentHashMap or Redis. Our tests focus on functional correctness, not concurrency."

**Q: Did AI write all the code?**

> A: "No. AI generated test case ideas (~20 suggestions), but we manually implemented all test code. This gave us better control and understanding. Our prompt log shows the full AI interaction history."

**Q: How would you improve this with more time?**

> A: "We'd add:
>
> 1. **Parametrized tests** for multiple invalid inputs
> 2. **Integration tests** with H2 database
> 3. **Performance tests** for session lookup speed
> 4. **Mutation testing** to verify test quality
> 5. **Security tests** for SQL injection, XSS"

**Q: Why 16 tests instead of 15?**

> A: "We added an extra test for requireAccount's happy path to ensure complete coverage. Better to exceed expectations than barely meet them!"

---

## 🎯 Closing Statement (30 seconds)

> "To summarize:
>
> - ✅ **16 tests, 100% passing** in 2.5 seconds
> - ✅ **≥85% code coverage** exceeding the 80% target
> - ✅ **Comprehensive testing** - happy paths, edge cases, security
> - ✅ **AI-assisted design** - prompt log fully documented
> - ✅ **Complete deliverables** - tests, coverage, README, prompts
>
> Our approach demonstrates that AI can accelerate test design while human expertise ensures quality implementation. Thank you, and we're happy to answer any questions!"

---

## 📝 Pre-Demo Checklist

Before starting demo:

### IntelliJ Setup

- [ ] Open `AuthServiceTest.java` in editor
- [ ] Close unnecessary files/tabs
- [ ] Maximize IntelliJ window
- [ ] Ensure Run panel is visible
- [ ] (Optional) Run tests once to warm up

### Files to Have Open

- [ ] `AuthServiceTest.java` (main)
- [ ] `prompts/log.md` (for AI section)
- [ ] `README.md` (for quick reference)
- [ ] Coverage report (if generated beforehand)

### Backup Plans

- [ ] Screenshot of test results (if live run fails)
- [ ] Pre-recorded video (if technical issues occur)
- [ ] Printed coverage report (if browser issues)

### Equipment Check

- [ ] Projector/screen working
- [ ] IntelliJ font size large enough (zoom in if needed)
- [ ] Internet connection (for ChatGPT reference, if needed)
- [ ] Clicker/pointer (if available)

---

## 🎬 Practice Tips

1. **Time yourself:** Practice entire demo in 13-14 minutes (leave buffer)
2. **Know your tests:** Memorize key test names and locations
3. **Anticipate questions:** Prepare answers for tough technical questions
4. **Have backup:** Screenshot results in case live demo fails
5. **Stay calm:** If tests fail during demo, explain debugging process

---

**Good luck with your demo! You've got this! 🚀**
