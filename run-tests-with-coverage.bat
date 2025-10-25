@echo off
echo ========================================
echo Running Tests with JaCoCo Coverage
echo ========================================

REM Check if Maven wrapper exists
if exist mvnw.cmd (
    echo Using Maven Wrapper...
    call mvnw.cmd clean test
) else (
    echo Using system Maven...
    call mvn clean test
)

echo.
echo ========================================
echo Coverage report generated at:
echo target\site\jacoco\index.html
echo ========================================
echo.
echo Opening coverage report...
start target\site\jacoco\index.html

pause

