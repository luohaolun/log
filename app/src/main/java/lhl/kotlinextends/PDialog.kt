package lhl.kotlinextends

import android.app.Activity
import android.app.ProgressDialog

class PDialog(activity: Activity, message: String, cancel: Int, dismissListener: DialogListener? = null) {

    constructor(activity: Activity, message: String) : this(activity, message, CANCEL_NO)

    constructor(activity: Activity, message: String, dismissListener: DialogListener) : this(activity, message, CANCEL_BACK, dismissListener)

    private var progressDialog = ProgressDialog(activity)

    init {
        progressDialog.setMessage(message)
        when (cancel) {
            CANCEL_ALL -> {
                progressDialog.setCancelable(true)
                progressDialog.setCanceledOnTouchOutside(true)
            }
            CANCEL_BACK -> {
                progressDialog.setCancelable(true)
                progressDialog.setCanceledOnTouchOutside(false)
            }
            CANCEL_NO -> {
                progressDialog.setCancelable(false)
                progressDialog.setCanceledOnTouchOutside(false)
            }
        }
        progressDialog.setOnDismissListener { dismissListener?.invoke() }
    }


    fun setMessage(text: String) {
        progressDialog.setMessage(text)
    }

    fun show() {
        progressDialog.show()
    }

    fun dismiss() {
        progressDialog.dismiss()
    }

}