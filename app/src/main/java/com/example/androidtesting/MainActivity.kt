package com.example.androidtesting

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val confirmPasswordValidator = ConfirmPasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.emailInput.addTextChangedListener(emailValidator)
        binding.password.addTextChangedListener(passwordValidator)
        binding.confirmPassword.addTextChangedListener(confirmPasswordValidator)
        binding.saveButton.setOnClickListener {
            if (emailValidator.isValid && passwordValidator.isPasswordValid && confirmPasswordValidator.isConfirmPasswordValid) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.valid_email), Toast.LENGTH_SHORT
                ).show()
            } else {
                val errorEmail = getString(R.string.invalid_email)
                binding.emailInput.error = errorEmail
                Toast.makeText(
                    this@MainActivity, errorEmail,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}