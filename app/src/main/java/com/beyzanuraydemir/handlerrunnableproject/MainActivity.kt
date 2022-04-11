package com.beyzanuraydemir.handlerrunnableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var numara=0
    var runnable : Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun baslat(view: View){
        numara=0
        runnable = object: Runnable{
            override fun run() {
                numara=numara+1
                textView.text="Sayaç: ${numara}"
                handler.postDelayed(runnable,1000)  //handlerı çalıştırır
            }
        }
        handler.post(runnable)    //Runable çalıştırır

    }

    fun durdur(view: View){
        handler.removeCallbacks(runnable)  //runnable kaldır
        numara=0
        textView.text="Sayaç: 0"

    }
}