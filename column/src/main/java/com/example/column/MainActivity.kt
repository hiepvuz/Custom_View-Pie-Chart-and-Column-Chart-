package com.example.column

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private val TAG: String = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val columnView = findViewById<Column>(R.id.columns)

        var value1 = columnView.value1
        var value2 = columnView.value2
        var value3 = columnView.value3
        var value4 = columnView.value4
        var value5 = columnView.value5


        val sb1 = findViewById<SeekBar>(R.id.sb1)
        val sb2 = findViewById<SeekBar>(R.id.sb2)
        val sb3 = findViewById<SeekBar>(R.id.sb3)
        val sb4 = findViewById<SeekBar>(R.id.sb4)
        val sb5 = findViewById<SeekBar>(R.id.sb5)

        val listSb: List<SeekBar> = arrayListOf(sb1, sb2, sb3, sb4, sb5)
        val listValue: MutableList<Float> = arrayListOf(value1, value2, value3, value4, value5)
        for (i in listSb.indices) {
            listSb[i].progress = listValue[i].toInt() / 10
        }



        for (index in listSb.indices) {
            listSb[index].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekbar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    seekbar!!.progress = progress
                    listValue[index] = (progress * 10).toFloat()
                    columnView.updateColumns(listValue)
                    Log.d(TAG, "onProgressChanged:  ${listValue[0]}")
                    columnView.invalidate()
                }

                override fun onStartTrackingTouch(seekbar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekbar: SeekBar?) {
                }
            })
        }
    }
}