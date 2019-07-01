package lhl.kotlinextends

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog

typealias DialogListener = () -> Unit

const val CANCEL_ALL = 0
const val CANCEL_BACK = 1
const val CANCEL_NO = 2

class TDialog(activity: Activity, message: String = "", private val cancel: Int = CANCEL_ALL, positive: DialogListener? = null) {

    private var builder: AlertDialog.Builder = AlertDialog.Builder(activity)
    private var dialog: Dialog? = null

    init {
        builder.setTitle("提示")
        builder.setMessage(message)
        builder.setPositiveButton("确定", null)
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

    fun setPositiveButton(text: String = "确定", listener: DialogListener? = null) {
        builder.setPositiveButton(text) { _, _ -> listener?.invoke() }
        show()
    }

    fun setNegativeButton(text: String = "取消", listener: DialogListener? = null) {
        builder.setNegativeButton(text) { _, _ -> listener?.invoke() }
        show()
    }

    fun setButtons(textPositive: String = "确定", textNegative: String = "取消", positive: DialogListener? = null, negative: DialogListener? = null) {
        builder.setPositiveButton(textPositive) { _, _ -> positive?.invoke() }
        builder.setNegativeButton(textNegative) { _, _ -> negative?.invoke() }
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