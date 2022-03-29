package com.example.gitdemoapp.pageInterface

import android.content.Context
import android.content.DialogInterface

interface MainActivityView {

    fun dismissProgressDialog()

    fun showLoadingProgressDialog()

    fun showAlertWithPositiveButton(context : Context, title : String, message : String, positiveCb : (DialogInterface) ->Unit)

    fun clearEmailViewText()

    fun clearPasswordViewText()
}