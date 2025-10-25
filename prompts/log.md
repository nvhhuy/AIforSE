# Prompt Log - Unit Testing Challenge

**Team Name:** LuxeStay  
**AI Tool:** ChatGPT  
**Core Feature:** AuthService (Authentication)  
**Date:** 2025-10-25

---

## Core Feature Analysis

**Selected Feature:** `AuthService.java`  
**Location:** `com.luxestay.hotel.service.AuthService`

**Methods to Test:**

1. `register(RegisterRequest req)` - Đăng ký tài khoản mới
2. `login(LoginRequest req)` - Đăng nhập
3. `verify(String token)` - Xác thực token
4. `logout(String token)` - Đăng xuất
5. `requireAccount(String token)` - Lấy account từ token

**Dependencies:**

- `AccountRepository`
- `RoleRepository`
- `BCryptPasswordEncoder`

**Edge Cases Identified:**

- Email đã tồn tại khi register
- Sai password khi login
- Account bị khóa (isActive = false)
- Token không hợp lệ
- Role không tồn tại

---

## Prompts & Outputs

### Prompt #1: Generate Test Cases

**Timestamp:** 10:00  
**Purpose:** Design comprehensive test cases for AuthService

**Input Prompt:**

```
I'm participating in a Unit Testing challenge. I need your help to generate comprehensive test cases for an AuthService class.

Context:
- Language: Java Spring Boot
- Testing Framework: JUnit 5 + Mockito
- Feature: Authentication Service

AuthService Methods:
1. register(RegisterRequest req) - Creates new account
2. login(LoginRequest req) - Login existing account
3. verify(String token) - Validates session token
4. logout(String token) - Removes session
5. requireAccount(String token) - Gets account or throws exception

Dependencies to Mock:
- AccountRepository
- RoleRepository
- BCryptPasswordEncoder

Task: Generate at least 15 test case names covering happy paths, edge cases, and error scenarios.
```

**ChatGPT Output:**

```
[Received 20 test cases - see full list in team notes]
```

**Decision:** ✅ **APPROVED** - Excellent coverage, will adapt to match actual exception types

---

### Test Cases Selection (15 selected from 20)

Based on actual `AuthService` implementation, selected these test cases:

#### ✅ REGISTER Tests (5 tests)

1. **register_WhenEmailNotExists_ShouldSaveAndReturnToken**

   - Happy path registration
   - Expected: password encrypted, token generated, AuthResponse returned

2. **register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException**

   - Edge case: duplicate email
   - Expected: throws IllegalArgumentException("Email đã tồn tại")

3. **register_WhenRoleNotFound_ShouldThrowIllegalStateException**

   - Edge case: missing "customer" role in DB
   - Expected: throws IllegalStateException

4. **register_ShouldEncryptPasswordWithBCrypt**

   - Security validation
   - Expected: passwordEncoder.encode() called, hash stored

5. **register_ShouldAssignCustomerRoleToNewAccount**
   - Role assignment validation
   - Expected: account has "customer" role

#### ✅ LOGIN Tests (5 tests)

6. **login_WhenCredentialsValid_ShouldReturnToken**

   - Happy path login
   - Expected: AuthResponse with token

7. **login_WhenEmailNotFound_ShouldThrowIllegalArgumentException**

   - Edge case: unknown email
   - Expected: throws IllegalArgumentException("Tài khoản không tồn tại")

8. **login_WhenAccountInactive_ShouldThrowIllegalStateException**

   - Edge case: isActive = false
   - Expected: throws IllegalStateException("Tài khoản đã bị khóa")

9. **login_WhenPasswordMismatch_ShouldThrowIllegalArgumentException**

   - Edge case: wrong password
   - Expected: throws IllegalArgumentException("Mật khẩu không đúng")

10. **login_ShouldStoreTokenInSessionsMap**
    - Session management validation
    - Expected: sessions.get(token) returns accountId

#### ✅ VERIFY Tests (2 tests)

11. **verify_WhenValidToken_ShouldReturnAccountId**

    - Happy path
    - Expected: Optional.of(accountId)

12. **verify_WhenTokenInvalid_ShouldReturnEmpty**
    - Edge case
    - Expected: Optional.empty()

#### ✅ LOGOUT Tests (2 tests)

13. **logout_WhenValidToken_ShouldRemoveFromSessions**

    - Happy path
    - Expected: sessions no longer contains token

14. **logout_WhenTokenNotExists_ShouldNotThrowException**
    - Idempotent behavior
    - Expected: no exception

#### ✅ REQUIRE_ACCOUNT Tests (1 test)

15. **requireAccount_WhenTokenInvalid_ShouldThrowIllegalArgumentException**
    - Error case
    - Expected: throws IllegalArgumentException("Bạn cần đăng nhập")

**Coverage Estimate:** ~85% (covers all methods + main edge cases)

---

### Prompt #2: Detailed Test Case Descriptions

**Timestamp:** 10:20  
**Purpose:** Get detailed Given-When-Then for each test case

**Input Prompt:**

```
Provide detailed test case descriptions with Given-When-Then format for the 15 selected test cases above.
```

**ChatGPT Output:**

```
[Received 22 detailed test cases with full descriptions]
Key additions:
- Null/blank input validation tests
- Encoder failure scenarios
- Repository failure scenarios
- Token boundary cases (null, whitespace)
```

**Decision:** ✅ **USED for implementation** - Selected 15 most critical cases matching actual code behavior

---

### Code Generation (Manual)

**Timestamp:** 10:25  
**Approach:** Create test class manually based on ChatGPT test cases + actual AuthService implementation  
**Reason:** More control over Mockito setup and faster than iterating with AI

---

## Final Results

**Test Execution Summary:**

- ✅ **Total Tests:** 16/16 PASSED
- ✅ **Execution Time:** 2.509 seconds
- ✅ **Success Rate:** 100%
- ✅ **Coverage:** Estimated ≥85%

**Test Class:** `AuthServiceTest.java`

- Lines of Code: ~370 LOC
- Methods Tested: 5/5 (register, login, verify, logout, requireAccount)
- Edge Cases Covered: Email duplicate, inactive account, wrong password, invalid token, missing role

**Key Testing Techniques Used:**

1. **Mockito Mocking:** All dependencies (@Mock annotations)
2. **ArgumentCaptor:** Verified password encryption and role assignment
3. **AssertJ Assertions:** Fluent and readable assertions
4. **Session Verification:** Tested token storage by calling verify() after login
5. **Exception Testing:** assertThatThrownBy() for negative cases

**AI Contribution:**

- Test case brainstorming: ~20 ideas from ChatGPT
- Selected 16 most relevant for actual implementation
- Manual coding with AI-guided structure
- Time saved: ~40% compared to manual design

**Challenges & Solutions:**

1. **Challenge:** Sessions map is instance variable
   - **Solution:** Used actual login/register to create sessions, then tested verify()
2. **Challenge:** UUID randomness in tokens

   - **Solution:** Captured token from response, used for subsequent verification

3. **Challenge:** No database for integration
   - **Solution:** Full Mockito mocking (unit test approach)

**Time Breakdown:**

- Analysis & Feature Selection: 15 min
- Test Case Design with AI: 20 min
- Test Code Implementation: 60 min
- Execution & Verification: 5 min
- Coverage Report: 10 min
- Documentation: 20 min
- **Total:** 130/180 minutes (72% time used)

**Status:** ✅ **READY FOR DEMO**
