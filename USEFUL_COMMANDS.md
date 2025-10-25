# 💻 COMMANDS TIỆN DỤNG - TEAM LUXESTAY

**Copy & paste commands bạn cần!**

---

## 🧪 TEST COMMANDS

### Run Tests in IntelliJ (RECOMMENDED)

```
1. Open: src/test/java/com/luxestay/hotel/service/AuthServiceTest.java
2. Right-click file → "Run 'AuthServiceTest'"
3. Or: Ctrl+Shift+F10 (Windows) / Cmd+Shift+R (Mac)
```

### Run with Coverage

```
1. Right-click AuthServiceTest.java
2. Select: "Run 'AuthServiceTest' with Coverage"
3. Or: Ctrl+Shift+F10 với Coverage icon
```

### Run Single Test

```
1. Place cursor in test method (e.g., register_Success)
2. Right-click → "Run 'register_Success()'"
3. Or: Ctrl+Shift+F10
```

### Maven (if mvn available)

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=AuthServiceTest

# Run with coverage
mvn test jacoco:report

# Clean and test
mvn clean test
```

---

## 📊 COVERAGE COMMANDS

### Generate Coverage in IntelliJ

```
1. Run → "Run 'AuthServiceTest' with Coverage"
2. View → Tool Windows → Coverage
3. Or: Ctrl+Alt+6 (Windows) / Cmd+Alt+6 (Mac)
```

### Export Coverage Report

```
1. After running with coverage
2. Coverage panel → Right-click → "Generate Coverage Report"
3. Choose: HTML
4. Save to: coverage/ folder
```

### Open Coverage in Browser

```bash
# Windows
start htmlReport/index.html

# Mac
open htmlReport/index.html

# Linux
xdg-open htmlReport/index.html

# Or double-click index.html in File Explorer
```

---

## 📁 FILE OPERATIONS

### Navigate to Files (PowerShell/Cmd)

```bash
# Go to project root
cd D:\hoc\FA25\SWP391\code-clone\be_hotel

# Open test file
code src\test\java\com\luxestay\hotel\service\AuthServiceTest.java

# Open prompt log
code prompts\log.md

# Open coverage report
start htmlReport\index.html
```

### Create ZIP for Submission

```powershell
# PowerShell
Compress-Archive -Path be_hotel\* -DestinationPath LuxeStay_Submission.zip

# Or right-click be_hotel folder → Send to → Compressed (zipped) folder
```

### Copy Files

```bash
# Copy coverage report
xcopy htmlReport coverage\htmlReport\ /E /I

# Copy test file
copy src\test\java\com\luxestay\hotel\service\AuthServiceTest.java docs\
```

---

## 🔍 SEARCH COMMANDS

### Find in Files (IntelliJ)

```
Ctrl+Shift+F (Windows) / Cmd+Shift+F (Mac)
```

### Find Test Cases

```bash
# PowerShell
Select-String -Path src\test\**\*.java -Pattern "@Test"

# Count tests
(Select-String -Path src\test\**\*.java -Pattern "@Test").Count
```

### Find TODO/FIXME

```bash
# PowerShell
Select-String -Path src\**\*.java -Pattern "TODO|FIXME"
```

---

## 📝 EDITOR COMMANDS

### Open in IntelliJ

```bash
# From command line (if IntelliJ CLI configured)
idea .

# Or: File → Open → Select be_hotel folder
```

### Open in VS Code

```bash
code .
```

### Open Multiple Files

```bash
# IntelliJ: Ctrl+E (recent files)
# IntelliJ: Ctrl+Shift+N (find file by name)
# IntelliJ: Double Shift (search everywhere)
```

---

## 🎤 DEMO COMMANDS

### Screenshot Commands (Windows)

```
Win + Shift + S        → Snipping tool (crop screenshot)
Win + PrtScn           → Full screenshot (saves to Pictures)
Alt + PrtScn           → Active window screenshot
```

### Open Demo Files Quickly

```bash
# PowerShell - Open all demo files at once
code docs\DEMO_SCRIPT.md
code docs\DEMO_CHEAT_SHEET.md
code prompts\log.md
start htmlReport\index.html
```

### Practice Demo

```bash
# Set timer
echo "Demo starts now! Time: $(Get-Date)"

# Or use PowerPoint presenter view with timer
```

---

## 🔧 MAVEN COMMANDS

### Build & Test

```bash
# Clean build
mvn clean compile

# Run tests
mvn test

# Skip tests (if needed)
mvn install -DskipTests

# Run specific test
mvn test -Dtest=AuthServiceTest

# Run with coverage
mvn test jacoco:report

# View coverage
start target\site\jacoco\index.html
```

### Check Dependencies

```bash
# List dependencies
mvn dependency:tree

# Update dependencies
mvn dependency:resolve
```

---

## 📦 GIT COMMANDS (if using Git)

### Basic Operations

```bash
# Status
git status

# Add files
git add prompts/ src/test/ htmlReport/ docs/ README.md

# Commit
git commit -m "Final submission - Team LuxeStay - 16 tests, 87.5-100% coverage"

# Push
git push origin main

# View history
git log --oneline
```

### Check What Changed

```bash
# Show changes
git diff

# Show changed files
git status --short

# Show recent commits
git log -5
```

---

## 🖥️ INTELLIJ SHORTCUTS

### Navigation

```
Ctrl+N              Find class
Ctrl+Shift+N        Find file
Ctrl+E              Recent files
Double Shift        Search everywhere
Ctrl+B              Go to declaration
Alt+F7              Find usages
```

### Running Tests

```
Ctrl+Shift+F10      Run test at cursor
Shift+F10           Rerun last test
Ctrl+F5             Rerun failed tests
Ctrl+Shift+F10      Run with Coverage
```

### Debugging

```
Shift+F9            Debug test
F8                  Step over
F7                  Step into
Shift+F8            Step out
F9                  Resume
```

### Editing

```
Ctrl+D              Duplicate line
Ctrl+Y              Delete line
Ctrl+/              Comment line
Ctrl+Shift+/        Comment block
Ctrl+Alt+L          Reformat code
```

---

## 📊 USEFUL QUERIES

### Count Test Cases

```bash
# PowerShell
(Get-Content src\test\java\com\luxestay\hotel\service\AuthServiceTest.java | Select-String "@Test").Count

# Expected output: 16
```

### Count Lines of Code

```bash
# PowerShell
(Get-Content src\test\java\com\luxestay\hotel\service\AuthServiceTest.java).Count

# Expected output: ~370+
```

### Check File Sizes

```bash
Get-ChildItem -Recurse -File | Select-Object Name, Length | Sort-Object Length -Descending | Select-Object -First 10
```

---

## 🎨 PRESENTATION COMMANDS

### PowerPoint

```
F5                  Start presentation
Shift+F5            Start from current slide
B                   Black screen (during presentation)
W                   White screen
Esc                 End presentation
```

### Gamma AI

```
1. Go to: https://gamma.app
2. Login with Google
3. "Create new" → "Paste in text"
4. Paste from: docs/GAMMA_AI_PROMPT.md
5. Click "Generate"
```

---

## 🔍 VERIFICATION COMMANDS

### Verify All Tests Pass

```bash
# IntelliJ: Run with Coverage
Expected output:
- 16/16 tests passed ✅
- Time: ~2.5 seconds
- Coverage: 87.5-100%
```

### Verify Files Exist

```powershell
# PowerShell
Test-Path prompts\log.md
Test-Path src\test\java\com\luxestay\hotel\service\AuthServiceTest.java
Test-Path htmlReport\index.html
Test-Path README.md

# All should return: True
```

### Quick Health Check

```powershell
# PowerShell - Run all checks
$checks = @(
    "prompts\log.md",
    "src\test\java\com\luxestay\hotel\service\AuthServiceTest.java",
    "htmlReport\index.html",
    "README.md"
)

foreach ($file in $checks) {
    if (Test-Path $file) {
        Write-Host "✅ $file"
    } else {
        Write-Host "❌ $file MISSING!"
    }
}
```

---

## 📞 QUICK ACTIONS

### Before Demo

```bash
# Open everything needed
start htmlReport\index.html
idea src\test\java\com\luxestay\hotel\service\AuthServiceTest.java
code prompts\log.md
code docs\DEMO_CHEAT_SHEET.md
```

### After Demo

```bash
# Backup files
Copy-Item -Recurse be_hotel "be_hotel_backup_$(Get-Date -Format 'yyyyMMdd_HHmmss')"

# Create submission ZIP
Compress-Archive -Path be_hotel\* -DestinationPath "LuxeStay_Submission_$(Get-Date -Format 'yyyyMMdd').zip"
```

---

## 🚨 TROUBLESHOOTING COMMANDS

### If Tests Won't Run

```bash
# Clean and rebuild
mvn clean compile
# Or in IntelliJ: Build → Rebuild Project
```

### If Coverage Not Showing

```bash
# Delete old coverage
Remove-Item htmlReport -Recurse -Force
Remove-Item .idea\coverage -Recurse -Force

# Re-run with coverage
# IntelliJ: Run → Run with Coverage
```

### If IntelliJ Slow

```
File → Invalidate Caches → Invalidate and Restart
```

---

## 📋 COPY-PASTE SCRIPTS

### Open All Demo Files (PowerShell)

```powershell
# Copy and paste this entire block
cd D:\hoc\FA25\SWP391\code-clone\be_hotel
start htmlReport\index.html
code prompts\log.md
code docs\DEMO_CHEAT_SHEET.md
idea .
```

### Quick Test & Coverage (IntelliJ Terminal)

```bash
# If Maven configured
mvn clean test jacoco:report
start target\site\jacoco\index.html
```

### Create Submission Package

```powershell
# Creates ZIP with timestamp
$date = Get-Date -Format "yyyyMMdd_HHmm"
$zipName = "LuxeStay_UnitTesting_$date.zip"
Compress-Archive -Path prompts,src\test,htmlReport,docs,README.md,pom.xml -DestinationPath $zipName
Write-Host "✅ Created: $zipName"
```

---

## 🎯 MOST USED COMMANDS

**Top 5 you'll use:**

```
1. Right-click AuthServiceTest.java → Run
2. Right-click AuthServiceTest.java → Run with Coverage
3. start htmlReport\index.html
4. code docs\DEMO_CHEAT_SHEET.md
5. Win + Shift + S (screenshot)
```

---

## 💡 PRO TIPS

### Speed Up Testing

```
- Use Ctrl+Shift+F10 instead of right-click → Run
- Use Shift+F10 to rerun last test
- Keep Coverage panel open (Ctrl+Alt+6)
```

### Quick Navigation

```
- Double Shift: Search anything
- Ctrl+E: Recent files
- Ctrl+B: Jump to code definition
```

### Efficient Demo

```
- Pre-open all files before demo
- Use Alt+Tab to switch between windows
- Practice keyboard shortcuts
```

---

## 📞 EMERGENCY COMMANDS

### If IntelliJ Crashes

```
1. Restart IntelliJ
2. File → Open Recent → be_hotel
3. Right-click AuthServiceTest → Run
```

### If Can't Find Coverage Report

```powershell
# Search for it
Get-ChildItem -Recurse -Filter "index.html" | Where-Object { $_.Directory.Name -like "*coverage*" -or $_.Directory.Name -like "*jacoco*" -or $_.Directory.Name -like "*htmlReport*" }
```

### If Need Screenshot NOW

```
Win + Shift + S
→ Crop area
→ Ctrl+V to paste
→ Save as PNG
```

---

## ✅ FINAL CHECKS

```bash
# Run this before submission
# PowerShell
Write-Host "🔍 Final Verification:"
Write-Host "1. Tests exist: $(Test-Path src\test\**\AuthServiceTest.java)"
Write-Host "2. Prompts exist: $(Test-Path prompts\log.md)"
Write-Host "3. Coverage exists: $(Test-Path htmlReport\index.html)"
Write-Host "4. README exists: $(Test-Path README.md)"
Write-Host "5. Docs exist: $(Test-Path docs\DEMO_SCRIPT.md)"
Write-Host "`n✅ All checks passed!" -ForegroundColor Green
```

---

**Status:** ✅ READY  
**Team:** LuxeStay  
**Next:** COPY → PASTE → WIN! 🏆

---

_Save this file for quick reference during competition!_
