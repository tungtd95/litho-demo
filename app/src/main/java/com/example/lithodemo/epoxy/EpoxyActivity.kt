package com.example.lithodemo.epoxy

import android.os.*
import androidx.appcompat.app.*
import androidx.lifecycle.Observer
import com.example.lithodemo.*
import com.example.lithodemo.epoxy.view.*
import kotlinx.android.synthetic.main.activity_epoxy.*

class EpoxyActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)
        title = "Epoxy"
        val controller = SkuEpoxyController()
        rvCategory.setController(controller)

        myViewModel = MyViewModel(this)
        myViewModel.categories.observe(this, Observer {
            controller.categories = it
        })
    }
}
