# 🎨 Hướng Dẫn Tạo PowerPoint từ Outline

**File:** `PRESENTATION_SLIDES.md` → PowerPoint/Google Slides

---

## 🚀 CÁCH NHANH NHẤT (10 phút)

### Option 1: Google Slides (RECOMMENDED)

1. **Tạo presentation mới:**

   - Vào https://slides.google.com
   - Click "Blank" presentation
   - Chọn theme: "Simple" hoặc "Modern"

2. **Copy-paste từng slide:**

   - Mở `PRESENTATION_SLIDES.md`
   - Copy nội dung từng slide
   - Paste vào Google Slides
   - Format lại (bold titles, bullet points)

3. **Thêm visuals:**

   - Insert → Image → Upload screenshots
   - Insert → Shape → Icons
   - Insert → Diagram → Flowcharts

4. **Export:**
   - File → Download → Microsoft PowerPoint (.pptx)
   - File → Download → PDF (backup)

---

### Option 2: PowerPoint Desktop

1. **Mở PowerPoint:**

   - New Presentation
   - Choose theme: "Ion" hoặc "Facet" (modern, clean)

2. **Tạo slides:**

   - Mỗi section trong outline = 1 slide
   - Copy content từ PRESENTATION_SLIDES.md
   - Format bằng PowerPoint styles

3. **Thêm animations (optional):**
   - Select object → Animations → Fade In
   - Không overuse animations!

---

## 📋 SLIDE-BY-SLIDE GUIDE

### Slide 1: Title Slide

**Template:** Title Slide
**Content:**

```
Title: Unit Testing Challenge - AuthService
Subtitle: Team LuxeStay

Team Members:
DE170779 - Phan Thanh Tùng (Team Leader)
SE161796 - Trần Hữu Hiếu (Technical Lead)
DE180397 - Nguyễn Võ Hoàng Huy
DE190477 - Nguyễn Thành Long
DE180672 - Hoàng Tấn Thành

Date: October 25, 2025
```

**Design:**

- Large title (44pt, bold)
- Team names smaller (18pt)
- Professional gradient background
- Optional: Team logo top-right

---

### Slide 2: Agenda

**Template:** Content with Heading
**Layout:**

- Title: "Presentation Outline"
- Numbered list with time allocations
  **Icons:**
- 🎯 Feature Selection
- 🚀 Live Demo
- 💻 Code
- 📊 Coverage
- 🤖 AI
- ❓ Q&A

---

### Slide 3: Why AuthService?

**Template:** Four Content
**Layout:** 2x2 grid
**Each Quadrant:**

```
Icon + Title
---
Security-Critical
→ Handles passwords & sessions

Perfect Complexity
→ 5 methods, multiple edge cases

Realistic & Practical
→ Every application needs auth

Highly Testable
→ Clear I/O, mockable dependencies
```

**Icons:** 🔒 🎯 💼 ✅

---

### Slide 4: AuthService Methods

**Template:** Content with Heading
**Layout:** Vertical list with icons

```
Method              Description
---
🔐 register()      → Create new account
🔑 login()         → Authenticate user
✅ verify()        → Validate token
🚪 logout()        → End session
👤 requireAccount() → Get authenticated user
```

---

### Slide 5: Test Suite Overview

**Template:** Content with Heading
**Layout:**

- Big numbers top (16, 100%, 2.5s, 87.5%)
- Table showing test breakdown
  **Chart:** Pie chart of test distribution

---

### Slide 6: Live Demo Transition

**Template:** Blank or Title Only
**Content:**

- Large text: "LIVE DEMONSTRATION"
- Subtitle: "Running 16 Tests..."
  **Background:** Screenshot of IntelliJ
  **Animation:** Fade in

---

### Slide 7: Test Results

**Template:** Content with Heading
**Content:**

- Screenshot of test results (green checkmarks)
- Stats: 16/16, 2.5s, 100%
- Bullet points: Coverage areas
  **Highlight:** All green, success theme

---

### Slides 8-11: Code Examples

**Template:** Content with Heading
**Layout:**

- Title: Test name
- Left: Code snippet (screenshot or formatted text)
- Right: Key points (bullets)
  **Font:** Use Consolas or Courier New for code
  **Size:** 14-16pt for readability
  **Highlight:** Green for passed lines

**Tip:** Screenshot từ IntelliJ với syntax highlighting!

---

### Slide 12: Coverage Summary

**Template:** Content with Heading
**Layout:**

- Title: "Code Coverage Overview"
- Progress bars for each metric
- Color: Green (#10B981) for bars
  **Stats:**
- Class: 100%
- Method: 100%
- Branch: 87.5%
- Line: 100%

---

### Slide 13: Coverage Report Demo

**Template:** Content with Heading
**Content:**

- Screenshot of coverage report (browser)
- Annotations pointing to key metrics
  **Highlight:** Green code sections

---

### Slide 14: AI Integration

**Template:** Two Content
**Layout:** Split screen
**Left:** AI Contribution

- Bullet points
- Robot icon
  **Right:** Human Implementation
- Bullet points
- Person icon
  **Bottom:** Transparency statement

---

### Slide 15: AI Prompt Log

**Template:** Content with Heading
**Content:**

- Screenshot of prompts/log.md
- Highlight key sections
- "Transparency" badge

---

### Slide 16: Deliverables

**Template:** Content with Heading
**Layout:** Icon + Description list

```
📁 /prompts/log.md       → AI history
📁 /tests/               → 16 test cases
📁 /coverage/            → Coverage report
📁 README.md             → Documentation
🎤 Demo Materials        → Scripts & guides
```

---

### Slide 17: Key Achievements

**Template:** Content with Heading
**Layout:**

- Large numbers (center aligned)
- Star ratings
  **Color:** Gold/green theme
  **Icons:** Trophy 🏆

---

### Slide 18: Tech Stack

**Template:** Content with Heading
**Layout:** Grid of tech logos

- JUnit logo
- Mockito logo
- Maven logo
- Spring Boot logo
  **Text:** Version numbers below each

---

### Slide 19: Lessons Learned

**Template:** Content with Heading
**Layout:** Three columns

- What Worked (green)
- Improvements (yellow)
- Key Insight (blue, emphasized)

---

### Slide 20: Closing

**Template:** Section Header
**Content:**

- Summary bullets (centered)
- Key message (large quote)
- "Thank You" (huge)
- "Questions?" with icon
  **Background:** Gradient, professional

---

## 🎨 DESIGN TIPS

### Color Palette:

```
Primary Blue:   #2563EB (RGB: 37, 99, 235)
Success Green:  #10B981 (RGB: 16, 185, 129)
Accent Gold:    #F59E0B (RGB: 245, 158, 11)
Text Dark:      #1F2937 (RGB: 31, 41, 55)
Background:     #F9FAFB (RGB: 249, 250, 251)
```

### Fonts:

- **Headings:** Calibri Bold / Segoe UI Bold
- **Body:** Calibri / Segoe UI
- **Code:** Consolas / Courier New

### Sizes:

- **Title:** 40-44pt
- **Heading:** 32-36pt
- **Body:** 18-24pt
- **Caption:** 14-16pt

---

## 📸 SCREENSHOTS TO PREPARE

### Must-Have Screenshots:

1. **Test Results (Slide 7)**

   - IntelliJ Run panel showing 16/16 passed
   - Make sure all green checkmarks visible
   - Show execution time

2. **Code Examples (Slides 8-11)**

   - Screenshot each test method from IntelliJ
   - Enable syntax highlighting
   - Zoom to 150% for readability

3. **Coverage Report (Slide 13)**

   - Browser showing coverage/index.html
   - Highlight 87.5-100% coverage
   - Click through to AuthService detail

4. **Prompt Log (Slide 15)**
   - Screenshot of prompts/log.md
   - Show prompts and responses
   - Highlight key sections

### How to Take Screenshots:

- **Windows:** Win + Shift + S (Snipping Tool)
- **Crop:** Remove unnecessary UI elements
- **Save:** PNG format, high quality
- **Name:** descriptive (e.g., "test-results-16-passed.png")

---

## 🎬 ANIMATIONS (Optional)

### Recommended Animations:

- **Entrance:** Fade (0.5s) for content
- **Emphasis:** Pulse for important numbers
- **Exit:** None (don't waste time)

### Where to Use:

- Slide 5: Numbers fade in one by one
- Slide 7: Test results appear
- Slide 17: Achievements pop up

**Rule:** Less is more! Don't overdo animations.

---

## ✅ PRE-PRESENTATION CHECKLIST

- [ ] All 20 slides created
- [ ] Screenshots inserted and clear
- [ ] Font sizes readable from distance
- [ ] Colors consistent throughout
- [ ] Animations (if any) tested
- [ ] Typos checked
- [ ] Slide numbers added (optional)
- [ ] PDF backup created
- [ ] Test on presentation laptop
- [ ] Test with projector
- [ ] Remote clicker works (if using)

---

## 🚨 COMMON MISTAKES TO AVOID

❌ **Too much text** on slides  
✅ Use bullet points, short phrases

❌ **Tiny font sizes**  
✅ Minimum 18pt for body text

❌ **Too many animations**  
✅ Keep it simple and professional

❌ **Cluttered slides**  
✅ White space is good!

❌ **Reading slides word-for-word**  
✅ Slides = visual aid, not script

❌ **No contrast** (text hard to read)  
✅ Dark text on light background

---

## 📱 MOBILE BACKUP

Create a mobile-friendly version:

1. **Export to PDF:**

   - File → Export → PDF
   - Save as "LuxeStay-Presentation.pdf"

2. **Upload to Google Drive:**

   - Access from any device
   - Can present from phone if needed

3. **Email to all team members:**
   - Everyone has backup
   - Can access if laptop fails

---

## 🎯 FINAL TIPS

### Day Before Presentation:

1. ✅ Run through slides with team
2. ✅ Time each section (aim for 13-14 min)
3. ✅ Practice transitions
4. ✅ Test all live demos
5. ✅ Prepare backup screenshots

### Day of Presentation:

1. ✅ Arrive 30 min early
2. ✅ Test slides on actual projector
3. ✅ Check font sizes visible from back
4. ✅ Test all clickable links/demos
5. ✅ Have backup on USB + cloud

### During Presentation:

1. 🎤 Speak to judges, not slides
2. 👀 Make eye contact
3. 👉 Use pointer/laser to highlight
4. ⏰ Keep track of time
5. 😊 Stay confident!

---

## 📊 ALTERNATIVE: MARKDOWN TO SLIDES

### Using Marp (Markdown Presentation):

```bash
# Install Marp CLI
npm install -g @marp-team/marp-cli

# Convert to PowerPoint
marp PRESENTATION_SLIDES.md --pptx -o LuxeStay-Presentation.pptx

# Or PDF
marp PRESENTATION_SLIDES.md --pdf -o LuxeStay-Presentation.pdf
```

### Using reveal.js (HTML Slides):

```bash
# Create HTML presentation
# Copy content to reveal.js template
# Open in browser for presenting
```

---

## 🏆 WINNING PRESENTATION CHECKLIST

**Content:**

- [ ] Clear structure (agenda on slide 2)
- [ ] All requirements covered
- [ ] Live demos prepared
- [ ] Evidence/screenshots included
- [ ] Results clearly shown

**Design:**

- [ ] Professional appearance
- [ ] Consistent colors/fonts
- [ ] Readable from distance
- [ ] Not cluttered
- [ ] Visual aids support content

**Delivery:**

- [ ] Timing practiced (13-14 min)
- [ ] Team roles assigned
- [ ] Backup plans ready
- [ ] Equipment tested
- [ ] Confident and prepared

---

**YOU'RE READY TO CREATE AN AMAZING PRESENTATION! 🎯**

**Estimated Time to Create:**

- Basic slides: 30 minutes
- Add screenshots: 15 minutes
- Format & polish: 15 minutes
- **Total: ~1 hour**

**Start now and you'll have a professional presentation ready!** 🚀
