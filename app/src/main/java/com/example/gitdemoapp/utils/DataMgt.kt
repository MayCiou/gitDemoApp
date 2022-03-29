package com.example.gitdemoapp.utils

import android.content.Context
import com.example.gitdemoapp.R
import java.util.regex.Pattern

object DataMgt {

    private const val ACCOUNT_EMAIL_MAX_LENGTH = 32
    private const val ACCOUNT_PASSWORD_MIN_LENGTH = 6
    private const val ACCOUNT_PASSWORD_MAX_LENGTH = 32

    private val patternPassword: Pattern = Pattern.compile("[^a-zA-Z0-9@.#%^&*$!_-]")

    fun checkLoginFormat(context: Context, email: String, password: String) : String{

        if(email.isEmpty())
        {
            return context.getString(R.string.email_too_short_msg)
        }

        if (!isEmailValid(email))
        {
            return context.getString(R.string.email_contains_illegal_msg)
        }

        if (email.length > ACCOUNT_EMAIL_MAX_LENGTH)
        {
            return String.format(context.getString(R.string.email_too_long_msg),(ACCOUNT_EMAIL_MAX_LENGTH + 1))
        }

        if (password.length < ACCOUNT_PASSWORD_MIN_LENGTH ||
            password.length > ACCOUNT_PASSWORD_MAX_LENGTH)
        {
            return String.format(context.getString(R.string.password_range_msg),
                ACCOUNT_PASSWORD_MIN_LENGTH,
                ACCOUNT_PASSWORD_MAX_LENGTH)
        }

        if(patternPassword.matcher(password).find())
        {
            return context.getString(R.string.check_email_and_password_error_msg)
        }

        return context.getString(R.string.success_mag)
    }

    private fun isEmailValid(email : String) : Boolean {

        var isValid = false
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr : CharSequence = email

        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)

        if(matcher.matches())
        {
            isValid = true
        }

        return isValid

    }
}