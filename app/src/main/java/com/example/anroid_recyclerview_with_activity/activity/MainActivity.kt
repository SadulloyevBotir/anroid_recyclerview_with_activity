package com.example.anroid_recyclerview_with_activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anroid_recyclerview_with_activity.R
import com.example.anroid_recyclerview_with_activity.adapter.CustomAdapter
import com.example.anroid_recyclerview_with_activity.model.User

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(loadUser())
    }

    private fun refreshAdapter(items: ArrayList<User>) {
        val adapter = CustomAdapter(this, items)
        recyclerView.adapter = adapter
    }

    private fun loadUser(): ArrayList<User> {
        var items = ArrayList<User>()
        items.add(User("Botir"))
        items.add(User("Aziz"))
        items.add(User("Sherzod"))
        items.add(User("Behzod"))
        items.add(User("Botir"))
        items.add(User("Aziz"))
        items.add(User("Sherzod"))
        items.add(User("Behzod"))
        items.add(User("Botir"))
        items.add(User("Aziz"))
        items.add(User("Sherzod"))
        items.add(User("Behzod"))

        return items
    }
}