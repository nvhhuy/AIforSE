# 🎯 Unit Testing Challenge - Team LuxeStay

## Slide Presentation Outline (15 minutes)

**Competition:** Unit Testing với AI Prompt  
**Team:** LuxeStay  
**Date:** October 25, 2025

---

## SLIDE 1: TITLE SLIDE

**Duration:** 10 seconds

### Content:

```
Unit Testing Challenge
AuthService Testing Suite

Team LuxeStay
---
DE170779 - Phan Thanh Tùng (Team Leader)
SE161796 - Trần Hữu Hiếu (Technical Lead)
DE180397 - Nguyễn Võ Hoàng Huy (Developer)
DE190477 - Nguyễn Thành Long (Developer)
DE180672 - Hoàng Tấn Thành (Documentation & QA)

October 25, 2025
```

### Visual Suggestions:

- Background: Professional gradient (blue/green)
- Team logo (if available)
- Large, bold title
- Team member names in smaller font

### Speaker Notes:

> "Good morning/afternoon judges. We are Team LuxeStay, and today we'll demonstrate our comprehensive unit testing solution for the AuthService component of a hotel management system."

---

## SLIDE 2: AGENDA

**Duration:** 20 seconds

### Content:

```
Presentation Outline (15 minutes)

1. 🎯 Feature Selection (2 min)
2. 🚀 Live Test Execution (3 min)
3. 💻 Code Walkthrough (5 min)
4. 📊 Coverage Report (2 min)
5. 🤖 AI Integration (2 min)
6. ❓ Q&A (1 min)
```

### Visual Suggestions:

- Numbered list with icons
- Time allocation clearly shown
- Clean, simple layout

### Speaker Notes:

> "Our presentation follows the challenge structure: feature selection, live testing, code examples, coverage analysis, AI usage, and Q&A."

---

## SLIDE 3: CORE FEATURE - AUTHSERVICE

**Duration:** 1 minute

### Content:

```
Why AuthService?

✅ Security-Critical
   → Handles passwords & session management

✅ Perfect Complexity
   → 5 methods with multiple edge cases

✅ Realistic & Practical
   → Every application needs authentication

✅ Highly Testable
   → Clear inputs/outputs, mockable dependencies
```

### Visual Suggestions:

- 4 quadrants with icons
- Checkmarks for each point
- AuthService class diagram (simple)

### Speaker Notes:

> "We selected AuthService because it's security-critical, has perfect complexity with 5 methods and multiple edge cases, is realistic - every application needs authentication, and is highly testable with clear I/O and mockable dependencies."

---

## SLIDE 4: AUTHSERVICE METHODS

**Duration:** 30 seconds

### Content:

```
5 Methods Tested

1. register()     → Create new account
2. login()        → Authenticate user
3. verify()       → Validate session token
4. logout()       → End session
5. requireAccount() → Get authenticated user

All methods covered with 16 comprehensive tests
```

### Visual Suggestions:

- Method list with descriptions
- Flow diagram: register → login → verify → logout
- Icon for each method

### Speaker Notes:

> "AuthService has 5 core methods: register for account creation, login for authentication, verify for token validation, logout for session cleanup, and requireAccount for fetching authenticated users."

---

## SLIDE 5: TEST SUITE OVERVIEW

**Duration:** 30 seconds

### Content:

```
Test Suite Statistics

✅ 16 Test Cases (107% of requirement)
✅ 100% Pass Rate (16/16)
⚡ 2.5 Seconds Execution Time
📊 87.5-100% Coverage

Test Breakdown:
• Register:  5 tests (happy path + edge cases)
• Login:     5 tests (validation + security)
• Verify:    2 tests (token management)
• Logout:    2 tests (cleanup + idempotency)
• RequireAccount: 2 tests (authorization)
```

### Visual Suggestions:

- Big numbers (16, 100%, 2.5s, 87.5%)
- Pie chart or bar chart for test distribution
- Green checkmarks for all passed

### Speaker Notes:

> "We created 16 comprehensive test cases, exceeding the 15 minimum requirement. All tests pass with 100% success rate in just 2.5 seconds, achieving 87.5-100% code coverage."

---

## SLIDE 6: LIVE DEMO TRANSITION

**Duration:** 5 seconds

### Content:

```
LIVE DEMONSTRATION

Running 16 Tests...

[Screenshot of IntelliJ with AuthServiceTest.java]
```

### Visual Suggestions:

- Large "LIVE DEMO" text
- Arrow pointing to IntelliJ
- Animated loading icon (optional)

### Speaker Notes:

> "Now let's see these tests in action. I'll run the complete test suite live."

---

## SLIDE 7: TEST RESULTS

**Duration:** 2 minutes (during live demo)

### Content:

```
Test Execution Results

✅ Tests Passed: 16/16
⏱️ Time: 2.509 seconds
🎯 Success Rate: 100%

Coverage Areas:
• Email validation
• Password encryption
• Role assignment
• Account status checks
• Session token management
• Error handling
```

### Visual Suggestions:

- Screenshot of test results (green checkmarks)
- Execution time prominently displayed
- Coverage areas as bullet points

### Speaker Notes:

> "As you can see, all 16 tests passed in 2.5 seconds. We use Mockito to isolate the service from database dependencies, ensuring fast and reliable tests."

---

## SLIDE 8: CODE EXAMPLE 1 - HAPPY PATH

**Duration:** 1 minute

### Content:

```
Test Example 1: Happy Path Registration

@Test
void register_WhenEmailNotExists_ShouldSaveAndReturnToken() {
    // GIVEN - Setup mocks
    when(accountRepository.existsByEmail(anyString()))
        .thenReturn(false);
    when(roleRepository.findByName("customer"))
        .thenReturn(Optional.of(customerRole));

    // WHEN - Call the method
    AuthResponse response = authService.register(request);

    // THEN - Verify results
    assertThat(response.getToken()).isNotNull();
    verify(accountRepository).save(any(Account.class));
}

Key Points:
✅ Given-When-Then structure
✅ Mockito mocking
✅ AssertJ assertions
✅ Repository verification
```

### Visual Suggestions:

- Code snippet with syntax highlighting
- Arrows pointing to Given/When/Then sections
- Key points in colored boxes

### Speaker Notes:

> "Here's a happy path test. Notice the Given-When-Then structure for readability, Mockito mocking to avoid database dependencies, AssertJ for fluent assertions, and verification to ensure repository is called correctly."

---

## SLIDE 9: CODE EXAMPLE 2 - EDGE CASE

**Duration:** 1 minute

### Content:

```
Test Example 2: Edge Case - Duplicate Email

@Test
void register_WhenEmailAlreadyExists_ShouldThrow() {
    // GIVEN - Email exists
    when(accountRepository.existsByEmail(anyString()))
        .thenReturn(true);

    // WHEN & THEN - Expect exception
    assertThatThrownBy(() ->
        authService.register(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Email đã tồn tại");

    // Verify no save occurred
    verify(accountRepository, never()).save(any());
}

Key Points:
✅ Edge case testing
✅ Exception validation
✅ Side effect verification
```

### Visual Suggestions:

- Code with red highlights on exception parts
- "X" icon for duplicate email
- Emphasis on never() verification

### Speaker Notes:

> "This test handles duplicate email edge case. We verify the correct exception type and message, and importantly, ensure no data is saved when validation fails."

---

## SLIDE 10: CODE EXAMPLE 3 - SECURITY

**Duration:** 1 minute

### Content:

```
Test Example 3: Security - Password Encryption

@Test
void register_ShouldEncryptPasswordWithBCrypt() {
    // Setup and execute
    authService.register(request);

    // Capture saved account
    ArgumentCaptor<Account> captor =
        ArgumentCaptor.forClass(Account.class);
    verify(accountRepository).save(captor.capture());

    Account saved = captor.getValue();

    // Verify password encrypted
    assertThat(saved.getPasswordHash())
        .isEqualTo("$2a$10$hashedPassword");
    assertThat(saved.getPasswordHash())
        .isNotEqualTo("password123"); // Not plain text!
}

Key Points:
✅ ArgumentCaptor for inspection
✅ Security validation
✅ BCrypt verification
```

### Visual Suggestions:

- Lock icon for security
- "password123" → "hash" diagram
- Green checkmark for encrypted

### Speaker Notes:

> "Security is critical. This test uses ArgumentCaptor to inspect the actual data being saved, verifying passwords are never stored as plain text and proper BCrypt hashing is applied."

---

## SLIDE 11: CODE EXAMPLE 4 - INTEGRATION

**Duration:** 1 minute

### Content:

```
Test Example 4: Session Management Integration

@Test
void login_ShouldStoreTokenInSessionsMap() {
    // GIVEN - Mock repository
    when(accountRepository.findByEmail(anyString()))
        .thenReturn(Optional.of(account));
    when(passwordEncoder.matches(anyString(), anyString()))
        .thenReturn(true);

    // WHEN - Login
    AuthResponse response = authService.login(request);

    // THEN - Verify token stored & works
    String token = response.getToken();
    Optional<Integer> accountId = authService.verify(token);

    assertThat(accountId).isPresent();
    assertThat(accountId.get()).isEqualTo(1);
}

Key Points:
✅ Cross-method testing
✅ Session validation
✅ Integration verification
```

### Visual Suggestions:

- Flow diagram: login → token → verify
- Token represented as key icon
- Connection arrows between methods

### Speaker Notes:

> "This test demonstrates cross-method integration. We login, receive a token, then verify it actually works using the verify method. This tests real behavior, not just isolated units."

---

## SLIDE 12: TEST COVERAGE SUMMARY

**Duration:** 30 seconds

### Content:

```
Code Coverage Overview

📊 Overall: 87.5-100%
✅ Target: ≥80% (EXCEEDED!)

Detailed Breakdown:
• Class Coverage:  100% (1/1 classes)
• Method Coverage: 100% (5/5 methods)
• Branch Coverage: 87.5% (7/8 branches)
• Line Coverage:   100% (31/31 lines)

What We Covered:
✅ All public methods
✅ Happy paths
✅ Edge cases (email duplicates, inactive accounts)
✅ Security (password encryption)
✅ Error handling
```

### Visual Suggestions:

- Progress bars for each metric (all 80%+)
- Green color for passed metrics
- Comparison: Target vs Achieved

### Speaker Notes:

> "We achieved 87.5-100% coverage, exceeding the 80% requirement. All 5 methods, 31 lines, and 7 out of 8 branches are covered."

---

## SLIDE 13: COVERAGE REPORT DEMO

**Duration:** 1.5 minutes (live demo)

### Content:

```
LIVE: HTML Coverage Report

[Screenshot of coverage/index.html]

AuthService Coverage:
✅ 100% Class Coverage
✅ 100% Method Coverage
✅ 87.5% Branch Coverage
✅ 100% Line Coverage

Uncovered Code:
• Lombok-generated constructors
• Defensive null checks (not triggered)
• Framework initialization code
```

### Visual Suggestions:

- Browser screenshot showing report
- Green highlighted code (covered)
- Small red sections (uncovered) with explanations

### Speaker Notes:

> "Here's our HTML coverage report. Green shows covered code, red shows uncovered. The uncovered portions are primarily Lombok-generated code and defensive checks not triggered in our scenarios - this is acceptable and industry-standard."

---

## SLIDE 14: AI INTEGRATION

**Duration:** 1.5 minutes

### Content:

```
AI-Assisted Development

🤖 Tool Used: ChatGPT

AI Contribution:
✅ Brainstormed 20+ test case ideas
✅ Suggested test naming conventions
✅ Provided edge case scenarios
✅ Saved ~40% design time

Human Implementation:
✅ Manually wrote all 370+ lines of code
✅ Adapted to actual exception types
✅ Customized mocking strategies
✅ Ensured tests match real behavior

Transparency:
✅ Full prompt history in log.md
✅ Clear documentation of AI usage
✅ Honest about AI vs human contributions
```

### Visual Suggestions:

- Split screen: AI (left) vs Human (right)
- Icons for each contribution
- "Collaboration" theme
- Arrow from AI suggestions → Human implementation

### Speaker Notes:

> "ChatGPT helped brainstorm 20+ test case ideas, saving about 40% of design time. However, we manually implemented all code to ensure quality, adapt to our actual codebase, and maintain full understanding. Our prompt log shows complete transparency."

---

## SLIDE 15: AI PROMPT LOG DEMO

**Duration:** 30 seconds

### Content:

```
Prompt Log Transparency

[Screenshot of prompts/log.md]

Documented:
✅ All ChatGPT interactions
✅ Prompt inputs & outputs
✅ Decision reasoning
✅ Test case selection process
✅ Final results summary

Evidence of:
• AI-assisted design
• Human verification
• Iterative refinement
• Quality control
```

### Visual Suggestions:

- Screenshot of log.md
- Highlights on key sections
- "Transparency" badge

### Speaker Notes:

> "Our prompt log documents every AI interaction. You can see the prompts we sent, ChatGPT's responses, and our decision-making process. This demonstrates transparency and balanced AI-human collaboration."

---

## SLIDE 16: DELIVERABLES OVERVIEW

**Duration:** 30 seconds

### Content:

```
Complete Deliverables ✅

📁 /prompts/log.md
   → AI interaction history + final summary

📁 /tests/AuthServiceTest.java
   → 16 comprehensive test cases

📁 /coverage/
   → HTML report showing 87.5-100% coverage

📁 README.md
   → Complete documentation (300+ lines)
   → How to run, limitations, team info

🎤 Demo Materials
   → Scripts, cheat sheets, quick start guides
```

### Visual Suggestions:

- Folder icons for each deliverable
- Checkmarks showing completion
- File preview thumbnails

### Speaker Notes:

> "All deliverables are complete: prompt log with AI history, 16 test cases, coverage report exceeding 80%, comprehensive README, and demo materials."

---

## SLIDE 17: KEY ACHIEVEMENTS

**Duration:** 30 seconds

### Content:

```
Competition Results

✅ 16/15 Tests (107%)
✅ 100% Pass Rate
✅ 2.5 Second Execution
✅ 87.5-100% Coverage
✅ 130/180 Minutes Used (72%)

Quality Highlights:
⭐ Professional code quality
⭐ Comprehensive documentation
⭐ Transparent AI usage
⭐ Complete deliverables
⭐ Early completion with polish
```

### Visual Suggestions:

- Trophy icon
- Numbers in large, bold font
- Star ratings
- Green/gold color scheme

### Speaker Notes:

> "We exceeded all requirements: 16 tests instead of 15, 100% pass rate, fast execution, coverage above 80%, and finished early with time for documentation polish."

---

## SLIDE 18: TECHNICAL STACK

**Duration:** 20 seconds

### Content:

```
Technology Stack

Testing Framework:
• JUnit 5 (Jupiter)
• Mockito 5.11.0
• AssertJ 3.25.3

Coverage Tools:
• JaCoCo 0.8.11
• IntelliJ Coverage Runner

Build Tools:
• Maven 3.x
• Spring Boot 3.3.3

Modern & Industry-Standard ✅
```

### Visual Suggestions:

- Tech logos (JUnit, Mockito, Maven)
- Version badges
- "Modern Stack" emphasis

### Speaker Notes:

> "We used industry-standard, modern tools: JUnit 5 for testing, Mockito for mocking, AssertJ for assertions, and JaCoCo for coverage reporting."

---

## SLIDE 19: LESSONS LEARNED

**Duration:** 30 seconds

### Content:

```
What We Learned

✅ What Worked Well:
• Feature selection (AuthService = perfect complexity)
• Mockito isolation (no database needed)
• AI for brainstorming (saved time)
• Team collaboration (clear roles)

📈 Improvements for Next Time:
• Parameterized tests for similar scenarios
• Integration tests (with H2 database)
• Performance testing
• Mutation testing
• Earlier documentation start

💡 Key Insight:
"AI accelerates design, humans ensure quality"
```

### Visual Suggestions:

- Thumbs up/down icons
- Light bulb for insight
- Balance scale: AI ↔ Human

### Speaker Notes:

> "We learned that balanced AI-human collaboration works best. AI helps brainstorm and structure, while human expertise ensures quality and adaptation to real requirements."

---

## SLIDE 20: CLOSING & Q&A

**Duration:** 30 seconds + Q&A

### Content:

```
Summary

✅ 16 tests, 100% passing in 2.5 seconds
✅ 87.5-100% coverage (exceeds 80% target)
✅ Comprehensive testing (happy + edge cases)
✅ AI-assisted design, human implementation
✅ Complete deliverables & documentation

Key Message:
"AI can accelerate test design while
human expertise ensures quality implementation"

Thank You!
Questions? 🙋‍♂️

Team LuxeStay
October 25, 2025
```

### Visual Suggestions:

- Summary in colored boxes
- Team photo (if available)
- Contact information
- "Questions?" in large text

### Speaker Notes:

> "To summarize: 16 tests with 100% pass rate, coverage exceeding requirements, comprehensive testing, transparent AI usage, and complete deliverables. Our approach demonstrates that AI can accelerate design while human expertise ensures quality. Thank you, and we're happy to answer questions!"

---

## BACKUP SLIDES (If Extra Time or Questions)

### BACKUP SLIDE 1: KNOWN LIMITATIONS

```
Known Limitations & Future Improvements

Current Limitations:
⚠️ HashMap sessions (not thread-safe)
⚠️ No password strength validation
⚠️ Tokens never expire
⚠️ No rate limiting

Recommendations:
✅ Use ConcurrentHashMap or Redis
✅ Add password policy enforcement
✅ Implement token expiration
✅ Add brute-force protection

Documented in README.md
```

### BACKUP SLIDE 2: COMPETITIVE ADVANTAGES

```
Why We Stand Out

vs. Typical Submissions:
• More tests (16 vs 15)
• Better coverage (87.5% vs ~80%)
• Faster completion (130 vs 170 min)
• Superior documentation (7 vs 2-3 files)
• Professional code quality
• Complete demo preparation

We went above and beyond! 🏆
```

### BACKUP SLIDE 3: TIME BREAKDOWN

```
Time Management

Phase 1: Analysis & Feature Selection (15 min)
Phase 2: Test Case Design (20 min)
Phase 3: Code Implementation (60 min)
Phase 4: Execution & Debug (5 min) ← No bugs!
Phase 5: Coverage Report (10 min)
Phase 6: Documentation (20 min)

Total: 130/180 minutes (72%)
Extra time used for polish & demo prep
```

---

## 📝 PRESENTATION TIPS

### Before Presentation:

1. ✅ Test all live demos (run tests, open reports)
2. ✅ Have backup screenshots ready
3. ✅ Close unnecessary applications
4. ✅ Set font size large enough for projector
5. ✅ Practice transitions between slides

### During Presentation:

1. 🎤 Speak clearly and confidently
2. 👀 Make eye contact with judges
3. ⏰ Keep track of time (use phone/watch)
4. 💻 Show, don't just tell (live demos powerful!)
5. 😊 Stay calm if technical issues occur

### Transition Phrases:

- "Now let's see this in action..."
- "Moving on to coverage..."
- "As you can see here..."
- "This demonstrates..."
- "Let me show you..."

---

## 🎨 DESIGN RECOMMENDATIONS

### Color Scheme:

- **Primary:** Blue (#2563EB) - Professional, trustworthy
- **Secondary:** Green (#10B981) - Success, pass
- **Accent:** Gold (#F59E0B) - Achievement, excellence
- **Background:** White/Light gray (#F9FAFB)

### Fonts:

- **Titles:** Bold, large (32-40pt)
- **Body:** Clean sans-serif (18-24pt)
- **Code:** Monospace (16-20pt)

### Icons:

- Use consistent icon set (Font Awesome, Material Icons)
- Keep it simple and professional
- Don't overuse animations

---

## 📊 SLIDE COUNT SUMMARY

**Total Slides:** 20 main + 3 backup = 23 slides  
**Duration:** 15 minutes (13-14 min presentation + 1-2 min Q&A)  
**Average:** ~40-45 seconds per slide

---

## 🎯 SUCCESS CHECKLIST

- [ ] All slides created
- [ ] Live demos tested
- [ ] Backup screenshots prepared
- [ ] Timing practiced (13-14 min)
- [ ] Q&A answers memorized
- [ ] Team roles assigned
- [ ] Equipment tested

**YOU'RE READY TO WIN! 🏆**

---

_End of Presentation Slides_
