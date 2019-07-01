package lhl.kotlinextends

import com.blankj.utilcode.util.ToastUtils

fun String.toast() {
    ToastUtils.showShort(this)
}

fun String.longToast() {
    ToastUtils.showLong(this)
}