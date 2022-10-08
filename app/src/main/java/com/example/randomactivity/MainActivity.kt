package com.example.randomactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.retrofit.RandomApi
import com.example.retrofit.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get urlimage from Glide
        Glide.with(this).load("https://hammer-shop.ru/800/600/https/funart.pro/uploads/posts/2020-05/1588673015_1-p-foni-v-stile-flat-1.jpg").into(glideimage)
        //create first onItemClickListener
        recreationalbutton?.setOnClickListener {
            //use coroutines "GlobalScope"
            GlobalScope.launch(Dispatchers.Main) {
                val randomApi = RetrofitHelper.getInstance().create(RandomApi::class.java)
                val resultRecreation = randomApi.getRecreational()
                textviewActivity?.text = resultRecreation.body()?.activity
            }
        }
        educationbutton?.setOnClickListener {
            //use coroutines "GlobalScope"
            GlobalScope.launch(Dispatchers.Main) {
                val randomApi = RetrofitHelper.getInstance().create(RandomApi::class.java)
                val resultRecreation = randomApi.getEducation()
                textviewActivity?.text = resultRecreation.body()?.activity
            }
        }
    }
}