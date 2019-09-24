package com.example.lithodemo

import android.content.*
import android.os.*
import androidx.appcompat.app.*
import com.example.lithodemo.epoxy.*
import com.example.lithodemo.litho.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.app_name)
        btnEpoxy.setOnClickListener {
            startActivity(Intent(this, EpoxyActivity::class.java))
        }
        btnLitho.setOnClickListener {
            startActivity(Intent(this, LithoActivity::class.java))
        }
    }
}
