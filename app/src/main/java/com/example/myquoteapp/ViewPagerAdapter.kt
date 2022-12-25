package com.example.myquoteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerAdapter
    (private val images: ArrayList<Int>,
     private val viewPager2: ViewPager2): RecyclerView.Adapter<ViewPagerAdapter.ViewpagerViewHolder>() {


    inner class ViewpagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewpagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewpagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewpagerViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
        if (position == images.size-1){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
       return images.size
    }
    val runnable = Runnable {
        images.addAll(images)
        notifyDataSetChanged()
    }
}


