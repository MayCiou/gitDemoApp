package com.example.gitdemoapp.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.inputmethod.InputMethodManager
import com.example.gitdemoapp.R
import org.jetbrains.anko.alert

object Utility {

    /**
     * Dialog
     */
    fun showLoadingProgressDialog(context: Context) : Dialog{

        val dialog = Dialog(context,R.style.customProgressDialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.view_progress)
        dialog.show()

        return dialog
    }

    fun dismissProgressDialog(dialog : Dialog?){

        if(dialog != null && dialog.isShowing)
        {
            dialog.dismiss()
            dialog.cancel()
        }
    }

    /**
     * Alert
     */
    fun showAlertWithPositiveButton(context : Context, title : String, message : String, positiveCb : (DialogInterface) ->Unit){

        context.alert(message,title){

            isCancelable = false
            positiveButton(R.string.ok,positiveCb)

        }.show()
    }
}