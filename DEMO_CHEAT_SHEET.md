# 📋 DEMO CHEAT SHEET - Team LuxeStay

**PRINT THIS OR KEEP OPEN DURING DEMO**

---

## ⏰ TIME MANAGEMENT (15 minutes total)

| Section     | Time  | What to Show          |
| ----------- | ----- | --------------------- |
| 1. Intro    | 2 min | Team + Feature choice |
| 2. Live Run | 3 min | Execute 16 tests      |
| 3. Code     | 5 min | 4 test examples       |
| 4. Coverage | 2 min | HTML report ≥85%      |
| 5. AI       | 2 min | Prompt log            |
| 6. Q&A      | 1 min | Questions             |

⏱️ **Practice target:** 13-14 minutes (leave buffer!)

---

## 🎤 OPENING (30 seconds)

> "Good morning/afternoon judges. We are **Team LuxeStay**, and today we'll demonstrate our comprehensive unit testing solution for the **AuthService** component of a hotel management system."

---

## 🎯 WHY AUTHSERVICE? (30 seconds)

> "We selected AuthService because:
>
> 1. **Security-critical** - handles passwords & sessions
> 2. **Perfect complexity** - 5 methods, multiple edge cases
> 3. **Realistic** - every application needs authentication
> 4. **Highly testable** - clear I/O, mockable dependencies"

---

## 🚀 TEST RUN TALKING POINTS

**While tests are running (30 seconds):**

> "We have **16 comprehensive test cases** covering:
>
> - **Registration:** email validation, password encryption, role assignment
> - **Login:** credential validation, account status, session creation
> - **Token verification:** valid/invalid tokens
> - **Logout:** session cleanup, idempotency
> - **Account retrieval:** authorization checks"

**After tests finish:**

> "**16/16 tests PASSED** in 2.5 seconds! All tests pass consistently because we use **Mockito** to isolate the service from database dependencies."

---

## 💻 CODE WALKTHROUGH - 4 EXAMPLES

### 1. Happy Path (60 sec)

**Show:** `register_WhenEmailNotExists_ShouldSaveAndReturnToken`

**Say:**

- "**Given-When-Then** structure - clean and readable"
- "**Mockito mocking** - no real database needed"
- "**AssertJ assertions** - fluent and expressive"
- "**Verification** - ensures repository called correctly"

### 2. Negative Test (60 sec)

**Show:** `register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException`

**Say:**

- "**Edge case testing** - duplicate email"
- "**Exception validation** - correct type and message"
- "**Side effect verification** - no data saved"

### 3. Security Test (60 sec)

**Show:** `register_ShouldEncryptPasswordWithBCrypt`

**Say:**

- "**ArgumentCaptor** - inspect actual saved data"
- "**Security validation** - password never plain text"
- "**BCrypt verification** - proper hashing algorithm"

### 4. Session Test (60 sec)

**Show:** `login_ShouldStoreTokenInSessionsMap`

**Say:**

- "**Integration verification** - token actually stored"
- "**Cross-method testing** - login → verify chain"
- "**Session validation** - correct account ID returned"

### Quick Summary (60 sec)

**Scroll through test class:**

> "Our 16 tests cover:
>
> - **5 methods** (100% method coverage)
> - **Happy paths** - normal usage
> - **Edge cases** - email conflicts, inactive accounts, wrong passwords
> - **Security** - password encryption, token management
> - **Error handling** - proper exceptions
> - **Side effects** - repository interactions"

---

## 📊 COVERAGE REPORT TALKING POINTS

**Open:** `coverage/index.html`

**Point out:**

> "We achieved **85-90% coverage**, exceeding the 80% requirement."

**Navigate:** Click package → Click AuthService

**Explain:**

> "- **All 5 methods:** 100% covered (green)
>
> - **Branch coverage:** ≥80%
> - **Uncovered lines:** Primarily Lombok-generated code and defensive checks not triggered in our scenarios"

---

## 🤖 AI USAGE TALKING POINTS

**Open:** `prompts/log.md`

**Explain:**

> "ChatGPT helped us:
>
> - **Brainstorm** 20+ test case ideas
> - **Structure** test names using best practices
> - **Save ~40% time** on design phase
>
> However, we **manually coded all tests** because:
>
> - Better control over mocking setup
> - Adapted to our actual exception types
> - Ensured tests match real behavior
>
> Full transparency: Our prompt log documents every AI interaction."

---

## 🎯 CLOSING (30 seconds)

> "To summarize:
>
> - ✅ **16 tests, 100% passing** in 2.5 seconds
> - ✅ **85-90% coverage** exceeding the 80% target
> - ✅ **Comprehensive testing** - happy paths, edge cases, security
> - ✅ **AI-assisted design** - prompt log fully documented
> - ✅ **Complete deliverables** - tests, coverage, README, prompts
>
> Our approach demonstrates that AI can **accelerate test design** while **human expertise ensures quality implementation**. Thank you, and we're happy to answer any questions!"

---

## ❓ Q&A - QUICK ANSWERS

**Q: Why only unit tests?**  
A: "Challenge focuses on unit testing. Integration tests would need database setup - beyond 3-hour scope."

**Q: In-memory sessions map?**  
A: "Tested indirectly by calling login/register, then verifying token works. Tests actual behavior without mocking internal map."

**Q: Thread safety?**  
A: "Great observation! Documented as 'Known Limitation' in README. Recommend ConcurrentHashMap or Redis for production."

**Q: Did AI write code?**  
A: "No. AI generated ideas (~20 suggestions). We manually implemented all code for quality and understanding. Prompt log shows full history."

**Q: How to improve?**  
A: "Add: 1) Parameterized tests, 2) Integration tests with H2, 3) Performance tests, 4) Mutation testing, 5) Security tests for SQL injection/XSS."

**Q: Why 16 instead of 15?**  
A: "Added extra test for requireAccount happy path to ensure complete coverage. Better to exceed expectations!"

**Q: Why not 100% coverage?**  
A: "85-90% is industry standard. Uncovered 10-15% is Lombok-generated code. Pursuing 100% tests framework internals, not business logic."

---

## 🔥 KEY NUMBERS TO REMEMBER

- **16 tests** (not 15)
- **100% pass rate** (16/16)
- **2.5 seconds** execution
- **85-90% coverage** (exceeds 80%)
- **5 methods** tested (100%)
- **20+ test ideas** from ChatGPT
- **40% time saved** with AI
- **130/180 minutes** used
- **0 bugs** in final tests

---

## 📁 FILES TO HAVE OPEN

1. ✅ `AuthServiceTest.java` (IntelliJ)
2. ✅ `coverage/index.html` (Browser)
3. ✅ `prompts/log.md` (Text editor or IntelliJ)
4. ✅ This cheat sheet!

---

## 🎬 PRE-DEMO CHECKLIST

- [ ] IntelliJ open with `AuthServiceTest.java`
- [ ] Run tests once (warm up)
- [ ] Coverage report ready in browser
- [ ] Prompt log open
- [ ] Close unnecessary tabs/apps
- [ ] Font size large enough for projector
- [ ] Backup screenshots ready
- [ ] Deep breath - You've got this!

---

## ⚠️ IF SOMETHING GOES WRONG

### Tests fail live:

- Stay calm
- Show backup screenshot
- Explain expected behavior
- Offer to debug after demo

### Coverage report won't open:

- Use IntelliJ Coverage panel instead
- Verbally explain: "85-90%, all methods covered"
- Reference README documentation

### Forget what to say:

- Look at this cheat sheet!
- Pause, take breath
- "Let me show you the key points..."

---

## 💪 CONFIDENCE BOOSTERS

✅ You have 16 tests - all passing  
✅ Coverage exceeds requirement  
✅ Documentation is excellent  
✅ AI usage is transparent  
✅ Code quality is professional  
✅ You practiced and prepared

**YOU'RE READY TO WIN! 🏆**

---

## 🎯 FINAL REMINDERS

1. **Speak clearly** - Explain technical terms
2. **Show, don't tell** - Live demo is powerful
3. **Time management** - Practice kept you under 15 min
4. **Be confident** - Your tests are solid!
5. **Handle errors gracefully** - Stay calm if issues occur
6. **Engage judges** - Eye contact, clear voice
7. **Smile!** - You've done great work

---

**Team LuxeStay - LET'S WIN THIS! 🚀🏆**

**"Good tests don't just pass - they tell a story about quality."**

---

_Print this page and keep it next to you during demo!_
