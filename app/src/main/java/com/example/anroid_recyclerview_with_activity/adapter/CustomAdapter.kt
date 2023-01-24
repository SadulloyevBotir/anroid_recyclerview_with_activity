package com.example.anroid_recyclerview_with_activity.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.anroid_recyclerview_with_activity.R
import com.example.anroid_recyclerview_with_activity.activity.DetailActivity
import com.example.anroid_recyclerview_with_activity.model.User
import com.google.android.material.imageview.ShapeableImageView

class CustomAdapter(var activity: Activity, var items: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if (holder is UserViewHolder) {
            var ln_item = holder.ln_item
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            tv_fullname.text = item.fullname

            ln_item.setOnClickListener {
                var options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    ln_item,
                    "user_image"
                )
                var intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("user", item)
                activity.startActivity(intent, options.toBundle())
            }
        }
    }


    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ln_item: LinearLayout
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            ln_item = view.findViewById(R.id.ln_item)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}
