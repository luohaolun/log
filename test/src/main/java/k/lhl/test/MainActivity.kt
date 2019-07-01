package k.lhl.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import lhl.kotlinextends.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.click {
            //            123456.e()

            textView.visible = !textView.visible


//            ToastUtils.setMsgColor(resources.getColor(R.color.colorAccent))
//            ToastUtils.setBgResource()
//            "是是是".toastLong()

//            Observable.fromCallable {
////                Thread {
////                    "abcdef".v()
////                    TDialog(this, "是是是").setPositiveButton {
////                        "是是是休息休息".toast()
////                    }
////                }.start()
//                var s :String? = null
//                s!!.substring(20,1)
//            }.subscribe({
//                it.e()
//            }){
//                it.log()
//            }


//            try {
//                var s :String? = null
//                s!!.substring(20,1)
//            }catch (e:Exception){
//                e.e()
//            }

//            TDialog(this, "测试", CANCEL_NO).setButtons(positive = {
//                "点击确定".toast()
//            }) {
//                "点击取消".toast()
//            }

            val pDialog = PDialog(this, "正在上传..") { "取消上传".toast() }
            pDialog.show()
        }

        btnClick.longClick {
            "哈哈哈".e()
            true
        }

    }
}
