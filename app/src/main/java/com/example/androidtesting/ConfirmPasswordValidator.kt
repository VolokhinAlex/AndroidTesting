package com.example.androidtesting

import android.text.Editable
import android.text.TextWatcher

class ConfirmPasswordValidator : TextWatcher {

    internal var isConfirmPasswordValid = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(password: Editable?) {
        isConfirmPasswordValid = PasswordValidator.isValidEmail(password)
        confirmPassword = password.toString()
    }

    companion object {

        private var confirmPassword = ""

        fun getConfirmPassword(): String = confirmPassword

    }
}