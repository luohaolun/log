package k.lhl.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lhl.kotlinextends.e
import lhl.kotlinextends.v

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.setOnClickListener {
            123456.e()
            Thread {
                "abcdef".v()
            }.start()
        }

    }
}
