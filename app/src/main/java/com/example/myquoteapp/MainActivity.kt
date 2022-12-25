package com.example.myquoteapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val layout : ConstraintLayout
    get() = findViewById(R.id.layout)

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

//    lateinit var viewPager2: ViewPager2
//    lateinit var handler: Handler
//    lateinit var imageList : ArrayList<Int>
//    lateinit var adapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

//        init()
//        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                handler.removeCallbacks(runnable)
//                handler.postDelayed(runnable, 3000)
//            }
//        })

    }
//    private val runnable = Runnable {
//        viewPager2.currentItem = viewPager2.currentItem + 1
//    }
//    private fun init(){
//        viewPager2 = findViewById(R.id.view_pager)
//        handler = Handler(Looper.myLooper()!!)
//        imageList = ArrayList()
//         imageList.add(R.drawable.blue_background)
//         imageList.add(R.drawable.white_background)
//         imageList.add(R.drawable.nebula_background)
//
//        adapter = ViewPagerAdapter(imageList, viewPager2)
//        viewPager2.adapter = adapter
//        viewPager2.offscreenPageLimit = 3
//        viewPager2.clipToPadding = false
//        viewPager2.clipChildren = false
//        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//    }

    fun setQuote(quote: Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }
    fun onNext(view: View){
        setQuote(mainViewModel.nextQuote())
        getColor()


    }
    fun onPrevious(view: View){
        setQuote(mainViewModel.previousQuote())
        getColor()

    }
    fun onShare(view: View){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)

    }

    fun getColor(){
        val randomInt = Random().nextInt(9) +1
        val drawableResources = when (randomInt){
            1->layout.setBackgroundResource(R.drawable.img_1)
            2->layout.setBackgroundResource(R.drawable.img_2)
            3->layout.setBackgroundResource(R.drawable.nebula_background)
            4->layout.setBackgroundResource(R.drawable.img_3)
            5->layout.setBackgroundResource(R.drawable.img_4)
            6->layout.setBackgroundResource(R.drawable.img_5)
            7->layout.setBackgroundResource(R.drawable.img_6)
            8->layout.setBackgroundResource(R.drawable.img_7)
            9->layout.setBackgroundResource(R.drawable.img)
            else->layout.setBackgroundResource(R.drawable.bg_gradient)

                    }
    }

}