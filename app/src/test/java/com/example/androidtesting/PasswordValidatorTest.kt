package com.example.androidtesting

import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun `checking password for correct simple return true`() {
        assertTrue(PasswordValidator.isValidEmail(password = "Correct65#"))
    }

    @Test
    fun `checking the password for the presence of digits return false`() {
        assertFalse(PasswordValidator.isValidEmail(password = "Correct#"))
    }

    @Test
    fun `checking the password for the presence of a capital letter return false`() {
        assertFalse(PasswordValidator.isValidEmail(password = "correct56#"))
    }

    @Test
    fun `checking the password for the presence of a lowercase letter return false`() {
        assertFalse(PasswordValidator.isValidEmail(password = "CORRECT56#"))
    }

    @Test
    fun `checking the password for the presence of a special character return false`() {
        assertFalse(PasswordValidator.isValidEmail(password = "Correct65"))
    }

    @Test
    fun `checking the password for the presence of the minimum length return false`() {
        assertFalse(PasswordValidator.isValidEmail(password = "s1n#"))
    }

    @Test
    fun `checking the password for null return false`() {
        assertFalse(PasswordValidator.isValidEmail(null))
    }

    @Test
    fun `checking the password for empty return false`() {
        assertFalse(PasswordValidator.isValidEmail(""))
    }

    @Test
    fun `password verification and password confirmation for identity return true`() {
        assertSame(PasswordValidator.getPassword(), ConfirmPasswordValidator.getConfirmPassword())
    }


}