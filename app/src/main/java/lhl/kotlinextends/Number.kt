package lhl.kotlinextends

import com.blankj.utilcode.util.ConvertUtils

private var defaultNumber = 2
fun setDefaultNumber(num: Int) {
    defaultNumber = num
}

/**
 * 保留defaultNumber位小数
 */
fun Double.kp(num: Int = defaultNumber): String {
    return String.format("%.${num}f", this)
}

fun Float.kp(num: Int = defaultNumber): String {
    return String.format("%.${num}f", this)
}

fun Int.dp(): Int = this.toFloat().dp()
fun Double.dp(): Int = this.toFloat().dp()
fun Float.dp(): Int = ConvertUtils.px2dp(this)