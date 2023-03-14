package com.example.androidtesting

import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun `email check correct email simple return true`() {
        assertTrue(EmailValidator.isValidEmail(email = "test@gmail.com"))
    }

    @Test
    fun `email check correct email sub domain return true`() {
        assertTrue(EmailValidator.isValidEmail(email = "test@gmail.com.za"))
    }

    @Test
    fun `checking whether an email contain a domain return false`() {
        assertFalse(EmailValidator.isValidEmail(email = "test@gmail"))
    }

    @Test
    fun `checking email invalid email double dots return false`() {
        assertFalse(EmailValidator.isValidEmail(email = "test@gmail..ru"))
    }

    @Test
    fun `checking email for username content return false`() {
        assertFalse(EmailValidator.isValidEmail(email = "@gmail.ru"))
    }

    @Test
    fun `checking email for empty string return false`() {
        assertFalse(EmailValidator.isValidEmail(email = ""))
    }

    @Test
    fun `checking email for null passed parameter return false`() {
        assertFalse(EmailValidator.isValidEmail(email = null))
    }

    @Test
    fun `checking email for null email domain return false`() {
        assertFalse(EmailValidator.isValidEmail("test"))
    }

    @Test
    fun `checking for the presence of a postal address return false`() {
        assertFalse(EmailValidator.isValidEmail("test.com"))
    }

    @Test
    fun `checking the correctness of the entered domain after dot return false`() {
        assertFalse(EmailValidator.isValidEmail("test@gmail.c"))
    }
}