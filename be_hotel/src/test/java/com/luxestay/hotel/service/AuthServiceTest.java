package com.luxestay.hotel.service;

import com.luxestay.hotel.dto.auth.AuthResponse;
import com.luxestay.hotel.dto.auth.LoginRequest;
import com.luxestay.hotel.dto.auth.RegisterRequest;
import com.luxestay.hotel.model.Account;
import com.luxestay.hotel.model.Role;
import com.luxestay.hotel.repository.AccountRepository;
import com.luxestay.hotel.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for AuthService
 * Testing Framework: JUnit 5 + Mockito
 * Coverage Target: ≥80%
 */
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    private RegisterRequest validRegisterRequest;
    private LoginRequest validLoginRequest;
    private Role customerRole;
    private Account testAccount;

    @BeforeEach
    void setUp() {
        // Setup common test data
        validRegisterRequest = new RegisterRequest();
        validRegisterRequest.setFullName("Test User");
        validRegisterRequest.setEmail("test@example.com");
        validRegisterRequest.setPassword("password123");
        validRegisterRequest.setPhoneNumber("0123456789");

        validLoginRequest = new LoginRequest();
        validLoginRequest.setEmail("test@example.com");
        validLoginRequest.setPassword("password123");

        customerRole = Role.builder()
                .id(1)
                .name("customer")
                .description("Customer role")
                .build();

        testAccount = Account.builder()
                .id(1)
                .fullName("Test User")
                .email("test@example.com")
                .passwordHash("$2a$10$hashedPassword")
                .phoneNumber("0123456789")
                .role(customerRole)
                .isActive(true)
                .build();
    }

    // ============================================
    // REGISTER TESTS (5 tests)
    // ============================================

    @Test
    void register_WhenEmailNotExists_ShouldSaveAndReturnToken() {
        // Given
        when(accountRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByName("customer")).thenReturn(Optional.of(customerRole));
        when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        // When
        AuthResponse response = authService.register(validRegisterRequest);

        // Then
        assertThat(response).isNotNull();
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getAccountId()).isEqualTo(1);
        assertThat(response.getFullName()).isEqualTo("Test User");
        assertThat(response.getRole()).isEqualTo("customer");

        // Verify interactions
        verify(accountRepository).existsByEmail("test@example.com");
        verify(roleRepository).findByName("customer");
        verify(passwordEncoder).encode("password123");
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    void register_WhenEmailAlreadyExists_ShouldThrowIllegalArgumentException() {
        // Given
        when(accountRepository.existsByEmail(anyString())).thenReturn(true);

        // When & Then
        assertThatThrownBy(() -> authService.register(validRegisterRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Email đã tồn tại");

        // Verify no save occurred
        verify(accountRepository).existsByEmail("test@example.com");
        verify(accountRepository, never()).save(any());
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    void register_WhenRoleNotFound_ShouldThrowIllegalStateException() {
        // Given
        when(accountRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByName("customer")).thenReturn(Optional.empty());

        // When & Then
        assertThatThrownBy(() -> authService.register(validRegisterRequest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Không tìm thấy role");

        // Verify no save occurred
        verify(accountRepository, never()).save(any());
    }

    @Test
    void register_ShouldEncryptPasswordWithBCrypt() {
        // Given
        when(accountRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByName("customer")).thenReturn(Optional.of(customerRole));
        when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        // When
        authService.register(validRegisterRequest);

        // Then - Capture the account being saved
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountCaptor.capture());

        Account savedAccount = accountCaptor.getValue();
        assertThat(savedAccount.getPasswordHash()).isEqualTo("$2a$10$hashedPassword");
        assertThat(savedAccount.getPasswordHash()).isNotEqualTo("password123"); // Not plain text

        // Verify encoder was called with plain password
        verify(passwordEncoder).encode("password123");
    }

    @Test
    void register_ShouldAssignCustomerRoleToNewAccount() {
        // Given
        when(accountRepository.existsByEmail(anyString())).thenReturn(false);
        when(roleRepository.findByName("customer")).thenReturn(Optional.of(customerRole));
        when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");
        when(accountRepository.save(any(Account.class))).thenReturn(testAccount);

        // When
        AuthResponse response = authService.register(validRegisterRequest);

        // Then
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountCaptor.capture());

        Account savedAccount = accountCaptor.getValue();
        assertThat(savedAccount.getRole()).isNotNull();
        assertThat(savedAccount.getRole().getName()).isEqualTo("customer");
        assertThat(response.getRole()).isEqualTo("customer");
    }

    // ============================================
    // LOGIN TESTS (5 tests)
    // ============================================

    @Test
    void login_WhenCredentialsValid_ShouldReturnToken() {
        // Given
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        // When
        AuthResponse response = authService.login(validLoginRequest);

        // Then
        assertThat(response).isNotNull();
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getAccountId()).isEqualTo(1);
        assertThat(response.getFullName()).isEqualTo("Test User");
        assertThat(response.getRole()).isEqualTo("customer");

        verify(accountRepository).findByEmail("test@example.com");
        verify(passwordEncoder).matches("password123", "$2a$10$hashedPassword");
    }

    @Test
    void login_WhenEmailNotFound_ShouldThrowIllegalArgumentException() {
        // Given
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        // When & Then
        assertThatThrownBy(() -> authService.login(validLoginRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Tài khoản không tồn tại");

        verify(accountRepository).findByEmail("test@example.com");
        verify(passwordEncoder, never()).matches(anyString(), anyString());
    }

    @Test
    void login_WhenAccountInactive_ShouldThrowIllegalStateException() {
        // Given
        testAccount.setIsActive(false);
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));

        // When & Then
        assertThatThrownBy(() -> authService.login(validLoginRequest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Tài khoản đã bị khóa");

        verify(accountRepository).findByEmail("test@example.com");
        verify(passwordEncoder, never()).matches(anyString(), anyString());
    }

    @Test
    void login_WhenPasswordMismatch_ShouldThrowIllegalArgumentException() {
        // Given
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

        // When & Then
        assertThatThrownBy(() -> authService.login(validLoginRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Mật khẩu không đúng");

        verify(accountRepository).findByEmail("test@example.com");
        verify(passwordEncoder).matches("password123", "$2a$10$hashedPassword");
    }

    @Test
    void login_ShouldStoreTokenInSessionsMap() {
        // Given
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        // When
        AuthResponse response = authService.login(validLoginRequest);

        // Then - Verify token works with verify()
        String token = response.getToken();
        Optional<Integer> accountId = authService.verify(token);

        assertThat(accountId).isPresent();
        assertThat(accountId.get()).isEqualTo(1);
    }

    // ============================================
    // VERIFY TESTS (2 tests)
    // ============================================

    @Test
    void verify_WhenValidToken_ShouldReturnAccountId() {
        // Given - Create a session by logging in
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        AuthResponse loginResponse = authService.login(validLoginRequest);
        String validToken = loginResponse.getToken();

        // When
        Optional<Integer> result = authService.verify(validToken);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(1);
    }

    @Test
    void verify_WhenTokenInvalid_ShouldReturnEmpty() {
        // Given
        String invalidToken = "invalid-token-12345";

        // When
        Optional<Integer> result = authService.verify(invalidToken);

        // Then
        assertThat(result).isEmpty();
    }

    // ============================================
    // LOGOUT TESTS (2 tests)
    // ============================================

    @Test
    void logout_WhenValidToken_ShouldRemoveFromSessions() {
        // Given - Create a session first
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        AuthResponse loginResponse = authService.login(validLoginRequest);
        String token = loginResponse.getToken();

        // Verify token is valid before logout
        assertThat(authService.verify(token)).isPresent();

        // When
        authService.logout(token);

        // Then
        Optional<Integer> result = authService.verify(token);
        assertThat(result).isEmpty();
    }

    @Test
    void logout_WhenTokenNotExists_ShouldNotThrowException() {
        // Given
        String nonExistentToken = "non-existent-token";

        // When & Then - Should not throw any exception
        assertThatCode(() -> authService.logout(nonExistentToken))
                .doesNotThrowAnyException();
    }

    // ============================================
    // REQUIRE_ACCOUNT TESTS (1 test)
    // ============================================

    @Test
    void requireAccount_WhenTokenInvalid_ShouldThrowIllegalArgumentException() {
        // Given
        String invalidToken = "invalid-token";

        // When & Then
        assertThatThrownBy(() -> authService.requireAccount(invalidToken))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Bạn cần đăng nhập");
    }

    @Test
    void requireAccount_WhenValidToken_ShouldReturnAccount() {
        // Given - Create valid session
        when(accountRepository.findByEmail(anyString())).thenReturn(Optional.of(testAccount));
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        AuthResponse loginResponse = authService.login(validLoginRequest);
        String validToken = loginResponse.getToken();

        // Mock findById for requireAccount
        when(accountRepository.findById(1)).thenReturn(Optional.of(testAccount));

        // When
        Account result = authService.requireAccount(validToken);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getEmail()).isEqualTo("test@example.com");

        verify(accountRepository).findById(1);
    }
}
