package lhl.kotlinextends

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog

typealias DialogListener = () -> Unit

const val CANCEL_ALL = 0
const val CANCEL_BACK = 1
const val CANCEL_NO = 2

var TDIALOG_TITLE = "提示"
var TDIALOG_POSITIVE = "确定"
var TDIALOG_NEGATIVE = "取消"

class TDialog(activity: Activity, message: String = "", private val cancel: Int = CANCEL_ALL, positive: DialogListener? = null) {

    private var builder: AlertDialog.Builder = AlertDialog.Builder(activity)
    private var dialog: Dialog? = null

    init {
        builder.setTitle(TDIALOG_TITLE)
        builder.setMessage(message)
        builder.setPositiveButton(TDIALOG_POSITIVE, null)
        if (cancel == CANCEL_NO)
            builder.setCancelable(false)
        positive?.let { setPositiveButton(listener = it) }
    }

    fun show() {
        dialog = builder.create()
        if (cancel != CANCEL_ALL)
            dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }

    fun setPositiveButton(text: String = TDIALOG_POSITIVE, listener: DialogListener? = null) {
        builder.setPositiveButton(text) { _, _ -> listener?.invoke() }
        show()
    }

    fun setNegativeButton(text: String = TDIALOG_NEGATIVE, listener: DialogListener? = null) {
        builder.setNegativeButton(text) { _, _ -> listener?.invoke() }
        show()
    }

    fun setButtons(textPositive: String = TDIALOG_POSITIVE, textNegative: String = TDIALOG_NEGATIVE, positive: DialogListener? = null, negative: DialogListener? = null) {
        builder.setPositiveButton(textPositive) { _, _ -> positive?.invoke() }
        builder.setNegativeButton(textNegative) { _, _ -> negative?.invoke() }
        show()
    }

    fun setButtons(positive: DialogListener? = null, negative: DialogListener? = null) {
        builder.setPositiveButton(TDIALOG_POSITIVE) { _, _ -> positive?.invoke() }
        builder.setNegativeButton(TDIALOG_NEGATIVE) { _, _ -> negative?.invoke() }
        show()
    }

    fun setNeutralButton(text: String, listener: DialogListener? = null) {
        builder.setNeutralButton(text) { _, _ -> listener?.invoke() }
    }

    fun setTitle(text: String) {
        builder.setTitle(text)
    }

    fun setMessage(text: String) {
        builder.setMessage(text)
    }
}