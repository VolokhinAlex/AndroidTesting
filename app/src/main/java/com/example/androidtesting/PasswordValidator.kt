package com.example.androidtesting

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class PasswordValidator : TextWatcher {

    internal var isPasswordValid = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(pass: Editable?) {
        isPasswordValid = isValidEmail(pass)
        password = pass.toString()
    }

    companion object {
        private var password = ""

        fun getPassword(): String = password

        private val PASSWORD_PATTERN =
            Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{6,}\$")

        fun isValidEmail(password: CharSequence?): Boolean {
            return password != null && PASSWORD_PATTERN.matcher(password).matches()
        }
    }
}