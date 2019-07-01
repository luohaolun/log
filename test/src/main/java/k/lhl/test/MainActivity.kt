package k.lhl.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lhl.kotlinextends.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.click {
//            123456.e()
//            Thread {
//                "abcdef".v()
//            }.start()
//            textView.visible = !textView.visible


//            ToastUtils.setMsgColor(resources.getColor(R.color.colorAccent))
//            ToastUtils.setBgResource()
            "哈哈哈".e()


        }

        btnClick.longClick {
            "哈哈哈".e()
            true
        }

    }
}
