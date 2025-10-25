# 🎯 Gamma AI Prompt - Team LuxeStay (10 Slides - Tiếng Việt)

## HƯỚNG DẪN SỬ DỤNG:

1. Vào: https://gamma.app
2. Click "Create new" → "Paste in text"
3. Copy TOÀN BỘ nội dung bên dưới (từ "---START---" đến "---END---")
4. Paste vào Gamma AI
5. Chọn theme: "Modern" hoặc "Minimal"
6. Click "Generate"
7. Chỉnh sửa nếu cần

---

## ---START--- (COPY TỪ ĐÂY)

# Unit Testing Challenge với AI

### Nhóm LuxeStay - Kiểm thử AuthService

**Thành viên:**

- DE170779 - Phan Thanh Tùng (Trưởng nhóm)
- SE161796 - Trần Hữu Hiếu (Technical Lead)
- DE180397 - Nguyễn Võ Hoàng Huy
- DE190477 - Nguyễn Thành Long
- DE180672 - Hoàng Tấn Thành

---

# Tại sao chọn AuthService?

## 4 Lý do chính:

### 🔐 Quan trọng về bảo mật

Xử lý mật khẩu và quản lý phiên đăng nhập

### 🎯 Độ phức tạp phù hợp

5 phương thức với nhiều trường hợp ngoại lệ

### 💼 Thực tế và thiết thực

Mọi ứng dụng đều cần xác thực người dùng

### ✅ Dễ kiểm thử

Input/output rõ ràng, có thể mock dependencies

---

# 5 Phương thức được kiểm thử

## Các chức năng chính:

1. **register()** → Tạo tài khoản mới
2. **login()** → Xác thực người dùng
3. **verify()** → Kiểm tra session token
4. **logout()** → Kết thúc phiên
5. **requireAccount()** → Lấy thông tin user đã xác thực

**Tổng cộng: 16 test cases toàn diện**

---

# Thống kê Test Suite

## Kết quả xuất sắc:

- ✅ **16 Test Cases** (107% yêu cầu)
- ✅ **100% Pass Rate** (16/16 đều pass)
- ⚡ **2.5 giây** thời gian thực thi
- 📊 **87.5-100%** độ bao phủ

## Phân bổ tests:

- Register: 5 tests
- Login: 5 tests
- Verify: 2 tests
- Logout: 2 tests
- RequireAccount: 2 tests

---

# Demo Trực tiếp: Chạy Tests

## Kết quả thực thi:

### ✅ Tests Passed: 16/16

### ⏱️ Thời gian: 2.509 giây

### 🎯 Tỷ lệ thành công: 100%

## Các khía cạnh được test:

- Kiểm tra email hợp lệ
- Mã hóa mật khẩu
- Gán quyền người dùng
- Kiểm tra trạng thái tài khoản
- Quản lý session token
- Xử lý lỗi

---

# Ví dụ Test: Happy Path

## Test đăng ký thành công:

```java
@Test
void register_WhenEmailNotExists_ShouldSaveAndReturnToken() {
    // GIVEN - Thiết lập mock
    when(accountRepository.existsByEmail(anyString()))
        .thenReturn(false);

    // WHEN - Gọi phương thức
    AuthResponse response = authService.register(request);

    // THEN - Kiểm tra kết quả
    assertThat(response.getToken()).isNotNull();
    verify(accountRepository).save(any(Account.class));
}
```

**Điểm nổi bật:**

- Cấu trúc Given-When-Then
- Sử dụng Mockito để mock
- AssertJ để kiểm tra
- Verify repository được gọi

---

# Độ bao phủ Code (Coverage)

## Vượt mục tiêu 80%!

### Chi tiết:

- **Class Coverage:** 100% (1/1 classes)
- **Method Coverage:** 100% (5/5 methods)
- **Branch Coverage:** 87.5% (7/8 branches)
- **Line Coverage:** 100% (31/31 lines)

### Những gì đã được test:

✅ Tất cả phương thức public
✅ Các trường hợp thành công (happy paths)
✅ Các trường hợp ngoại lệ (edge cases)
✅ Bảo mật (mã hóa mật khẩu)
✅ Xử lý lỗi

---

# Tích hợp AI trong Dự án

## 🤖 Công cụ: ChatGPT

### Đóng góp của AI:

- Gợi ý 20+ ý tưởng test cases
- Đề xuất quy ước đặt tên
- Cung cấp kịch bản edge cases
- Tiết kiệm ~40% thời gian thiết kế

### Con người thực hiện:

- Viết tay tất cả 370+ dòng code
- Điều chỉnh theo exception types thực tế
- Tùy chỉnh chiến lược mocking
- Đảm bảo tests khớp với hành vi thực

**Minh bạch:** Toàn bộ lịch sử prompt trong log.md

---

# Kết quả Cuộc thi

## Vượt trội mọi yêu cầu:

- ✅ **16/15 Tests** (107%)
- ✅ **100% Pass Rate**
- ✅ **2.5 giây** thực thi
- ✅ **87.5-100%** coverage
- ✅ **130/180 phút** hoàn thành (72%)

## Điểm nổi bật:

⭐ Code chất lượng chuyên nghiệp
⭐ Tài liệu toàn diện
⭐ Sử dụng AI minh bạch
⭐ Deliverables đầy đủ
⭐ Hoàn thành sớm, có thời gian polish

---

# Tổng kết & Cảm ơn

## Kết quả:

✅ 16 tests, 100% pass trong 2.5 giây
✅ Coverage 87.5-100% (vượt mục tiêu 80%)
✅ Kiểm thử toàn diện (happy + edge cases)
✅ AI hỗ trợ thiết kế, con người implement
✅ Deliverables và tài liệu hoàn chỉnh

## Thông điệp chính:

**"AI có thể tăng tốc thiết kế test,
trong khi chuyên môn con người đảm bảo chất lượng"**

### Cảm ơn! Mời câu hỏi 🙋‍♂️

---

## ---END--- (COPY ĐẾN ĐÂY)

---

# 📝 CHÚ THÍCH VÀ HƯỚNG DẪN

## Sau khi Gamma AI tạo slides:

### 1. Thêm Screenshots (QUAN TRỌNG!)

**Slide 5 (Demo):**

- Insert hình: IntelliJ Run panel (16/16 tests passed)

**Slide 6 (Code Example):**

- Insert hình: Code screenshot từ IntelliJ

**Slide 7 (Coverage):**

- Insert hình: Coverage report (browser showing 87.5-100%)

**Slide 8 (AI Integration):**

- Insert hình: prompts/log.md screenshot

### 2. Chỉnh sửa màu sắc:

- Primary: Xanh dương (#2563EB)
- Success: Xanh lá (#10B981)
- Accent: Vàng gold (#F59E0B)

### 3. Kiểm tra font size:

- Titles: ≥40pt
- Body: ≥20pt
- Code: ≥16pt (monospace)

---

# 🎯 10 SLIDES NÀY BẢO QUÁT:

1. ✅ Title + Team members
2. ✅ Lý do chọn AuthService
3. ✅ 5 methods được test
4. ✅ Thống kê test suite
5. ✅ Kết quả demo trực tiếp
6. ✅ Ví dụ code test
7. ✅ Coverage report (87.5-100%)
8. ✅ AI integration (minh bạch)
9. ✅ Kết quả cuộc thi (achievements)
10. ✅ Tổng kết + Q&A

**Đủ cover tất cả requirements của cuộc thi trong 10-12 phút!**

---

# ⚡ ALTERNATIVE: PROMPT NGẮN HỞN

Nếu muốn Gamma AI tự động hơn, dùng prompt này:

```
Tạo presentation 10 slides về Unit Testing Challenge:

Slide 1: Title - Team LuxeStay, 5 thành viên, Unit Testing AuthService
Slide 2: Tại sao chọn AuthService? (4 lý do: bảo mật, phức tạp vừa, thực tế, dễ test)
Slide 3: 5 phương thức: register, login, verify, logout, requireAccount
Slide 4: Kết quả: 16 tests (107%), 100% pass, 2.5s, 87.5-100% coverage
Slide 5: Demo test results (16/16 passed)
Slide 6: Ví dụ test code (happy path, Given-When-Then)
Slide 7: Coverage report (100% class, 100% method, 87.5% branch, 100% line)
Slide 8: AI contribution (ChatGPT: 20+ ideas, 40% time saved; Human: 370+ lines code)
Slide 9: Achievements (vượt yêu cầu, 130/180 phút, chất lượng cao)
Slide 10: Tổng kết + Q&A

Theme: Modern, professional. Colors: Blue, Green, Gold.
Ngôn ngữ: Tiếng Việt.
```

---

# 🎨 SAU KHI TẠO XONG:

## Export Options:

1. **PowerPoint (.pptx)** → Để edit thêm
2. **PDF** → Backup, dễ share
3. **Link** → Present online (không cần tải)

## Chỉnh sửa cuối:

- [ ] Add 4 screenshots quan trọng
- [ ] Check font sizes (zoom to 150%)
- [ ] Test transitions
- [ ] Practice timing (10-12 min)

---

# 💡 TIPS DÙNG GAMMA AI:

1. **Paste text trực tiếp** (method 1) → Nhanh nhất
2. **Hoặc chat with AI** (method 2) → Tùy chỉnh nhiều hơn
3. **Chọn theme đơn giản** → "Modern" hoặc "Minimal"
4. **Không overuse animations** → Keep it professional
5. **Test trên projector** → Font đủ lớn chưa

---

# ⏰ THỜI GIAN DỰ KIẾN:

- Tạo slides với Gamma AI: **5 phút**
- Thêm screenshots (4 ảnh): **5 phút**
- Chỉnh sửa, format: **5 phút**
- Practice một lần: **15 phút**

**Total: 30 phút → DONE!** ✅

---

**Good luck, Team LuxeStay! 🚀🏆**
