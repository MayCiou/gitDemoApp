package com.example.gitdemoapp.pagePresenter

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.gitdemoapp.R
import com.example.gitdemoapp.pageInterface.IMainActivityPresenter
import com.example.gitdemoapp.pageInterface.MainActivityView
import com.example.gitdemoapp.utils.DataMgt

class MainActivityPresenter(private val context : Context) : IMainActivityPresenter {

    private lateinit var mainActivityView: MainActivityView
    private val tag = javaClass.simpleName

    override fun setView(mainActivityView: MainActivityView) {

        this.mainActivityView = mainActivityView
    }

    override fun loginViewOnClick(context: Context, email: String, password: String) {

        mainActivityView.showLoadingProgressDialog()
        Handler(Looper.getMainLooper()).postDelayed({

            val checkFormat = DataMgt.checkLoginFormat(context, email, password)

            mainActivityView.dismissProgressDialog()
            mainActivityView.showAlertWithPositiveButton(
                context,
                context.getString(R.string.message_title),
                checkFormat) {}

        }, 2000)

    }

}