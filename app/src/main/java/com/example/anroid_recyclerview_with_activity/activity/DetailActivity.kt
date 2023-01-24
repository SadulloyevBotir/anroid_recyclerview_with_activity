package com.example.anroid_recyclerview_with_activity.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.anroid_recyclerview_with_activity.R
import com.example.anroid_recyclerview_with_activity.model.User

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    private fun initViews() {
        var tv_fullname = findViewById<TextView>(R.id.tv_fullname)

        var result = intent.getSerializableExtra("user") as User
        tv_fullname.text = result.fullname
    }
}