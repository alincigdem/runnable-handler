package com.example.runnablehandleruygulamas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.runnablehandleruygulamas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var numara =0
    var runnable : Runnable = Runnable{}
    var handler = Handler()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun baslat(view: View)
    {
        numara=0

        runnable= object : Runnable{
            override fun run() {
                numara=numara+1
                binding.textview.text="Sayaç: ${numara}"
                handler.postDelayed(runnable,1000)

            }

        }

        handler.post(runnable)
    }

    fun durdur(view:View)
    {
        handler.removeCallbacks(runnable)
        numara=0
        binding.textview.text="Sayaç: ${numara}"
    }
}


