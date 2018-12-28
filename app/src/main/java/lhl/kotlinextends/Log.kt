package lhl.kotlinextends

import android.util.Log
import java.lang.Exception

const val ClassName = "lhl.kotlinextends.LogKt"
private var MaxLength = 3900

fun setLogMaxLength(int: Int) {
    MaxLength = int
}

fun Any.e(maxLen: Int = MaxLength) {
    print("e", this, maxLen)
}

fun Any.d(maxLen: Int = MaxLength) {
    print("d", this, maxLen)
}

fun Any.i(maxLen: Int = MaxLength) {
    print("i", this, maxLen)
}

fun Any.v(maxLen: Int = MaxLength) {
    print("v", this, maxLen)
}

fun Any.w(maxLen: Int = MaxLength) {
    print("w", this, maxLen)
}

fun Any.wtf(maxLen: Int = MaxLength) {
    print("wtf", this, maxLen)
}


private fun print(logLevel: String, log: Any, maxLen: Int) {
    var tag = Thread.currentThread().name + try {
        val traces = Thread.currentThread().stackTrace
        val stackElement = traces[traces.indexOfFirst { it.className == ClassName } + 2]
        "(${stackElement.fileName}:${stackElement.lineNumber})"
    } catch (e: Exception) {
        "TAG"
    }
    val str = log.toString()

    val sliceCount = str.length / maxLen + if ((str.length % maxLen) > 0) 1 else 0
    when (logLevel) {
        "e" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.e(tag, str.substring(i * maxLen, space))
            }
        }
        "v" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.v(tag, str.substring(i * maxLen, space))
            }
        }
        "d" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.d(tag, str.substring(i * maxLen, space))
            }
        }
        "i" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.i(tag, str.substring(i * maxLen, space))
            }
        }
        "w" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.w(tag, str.substring(i * maxLen, space))
            }
        }
        "wtf" -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.wtf(tag, str.substring(i * maxLen, space))
            }
        }
        else -> {
            for (i in 0 until sliceCount) {
                val space = if (i == sliceCount - 1) str.length else (i * maxLen + maxLen)
                Log.e(tag, str.substring(i * maxLen, space))
            }
        }
    }
}