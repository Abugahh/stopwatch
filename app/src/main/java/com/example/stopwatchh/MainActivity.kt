package com.example.stopwatchh

import android.nfc.Tag
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
//imported this by adding plugins in build gradle app to enable binding between the id(button_start) and the code
//plugin add in extra code the kotlin android extension
//In most cases, view binding replaces findViewById. val buttonReset : Button = findViewById(R.id.button_reset)
// buttonReset.setOnClickListener { showMyReset()}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stoptime:Long=0
        button_start.setOnClickListener {
            chronometer.base=SystemClock.elapsedRealtime()+stoptime
            chronometer.start()
            button_start.visibility=View.GONE
            button_pause.visibility=View.VISIBLE

        }
        button_pause.setOnClickListener {
            stoptime=chronometer.base-SystemClock.elapsedRealtime()
            chronometer.stop()
            button_pause.visibility=View.GONE
            button_start.visibility=View.VISIBLE

        }
        button_reset.setOnClickListener {
            chronometer.base=SystemClock.elapsedRealtime()+stoptime
            stoptime=0
            chronometer.stop()
            button_pause.visibility=View.GONE
            button_start.visibility=View.VISIBLE
        }



    }
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
           savedInstanceState.putLong("chronometer_time",chronometer.base)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null && savedInstanceState.containsKey("chronometer_time")){
            chronometer.base = savedInstanceState.getLong("chronometer_time")
        }

    }
//IMAGE ASSET IN NEW FILES THEN LOOK FOR IMAGES AND DELETE THE PREVIOS ONE AND HAVE 6,5,6 IN MIPMAP

}