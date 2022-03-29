package com.example.gitdemoapp

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.gitdemoapp.pageInterface.MainActivityView
import com.example.gitdemoapp.pagePresenter.MainActivityPresenter
import com.example.gitdemoapp.utils.Utility

class MainActivity : AppCompatActivity() , View.OnClickListener, MainActivityView {

    private lateinit var etEmail : EditText
    private lateinit var etCurrentPassword : EditText
    private lateinit var btnLogin : Button

    private var dialogProgress : Dialog? = null

    private val mainActivityPresenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etCurrentPassword = findViewById(R.id.etCurrentPassword)
        btnLogin = findViewById(R.id.btnLogin)

        clearEmailViewText()
        clearPasswordViewText()
        btnLogin.setOnClickListener(this)
        mainActivityPresenter.setView(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        dialogProgress = null
    }

    override fun onClick(view: View) {

        when(view.id) {

            R.id.btnLogin->
            {
                val mail = etEmail.text.toString()
                val password = etCurrentPassword.text.toString()
                mainActivityPresenter.loginViewOnClick(this, mail, password)
            }
        }
    }

    override fun dismissProgressDialog() {
        Utility.dismissProgressDialog(dialogProgress)
    }

    override fun showLoadingProgressDialog() {
        dialogProgress = Utility.showLoadingProgressDialog(this)
    }

    override fun showAlertWithPositiveButton(
        context: Context,
        title: String,
        message: String,
        positiveCb: (DialogInterface) -> Unit
    ) {
        Utility.showAlertWithPositiveButton(
            context,
            title,
            message,
            positiveCb)
    }

    override fun clearEmailViewText() {
        etEmail.setText("")
    }

    override fun clearPasswordViewText() {
        etCurrentPassword.setText("")
    }
}