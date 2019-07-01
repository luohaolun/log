package lhl.kotlinextends

import android.view.View


private var lastClickTime: Long = 0
fun isFastDoubleClick(): Boolean {
    val time = System.currentTimeMillis()
    if (time - lastClickTime < 500) {
        return true
    }
    lastClickTime = time
    return false
}

open class SingleClick(private val listener: (View?) -> Unit) : View.OnClickListener {
    override fun onClick(v: View?) {
        if (!isFastDoubleClick())
            listener.invoke(v)
    }
}

fun View.click(listener: (View?) -> Unit) {
    setOnClickListener(SingleClick(listener))
}

fun View.longClick(listener: (View?) -> Boolean) {
    isLongClickable = true
    setOnLongClickListener(listener)
}

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
    }
