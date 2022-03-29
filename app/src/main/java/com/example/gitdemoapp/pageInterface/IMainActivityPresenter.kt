package com.example.gitdemoapp.pageInterface

import android.content.Context

interface IMainActivityPresenter {

    fun setView(mainActivityView: MainActivityView)

    fun loginViewOnClick(context: Context, email: String, password: String)
}