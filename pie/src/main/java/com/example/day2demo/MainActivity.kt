package com.example.day2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {
    private val TAG: String = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pieChart = findViewById<View>(R.id.pc) as PieChart
        val sb1 = findViewById<SeekBar>(R.id.sb1)
        val sb2 = findViewById<SeekBar>(R.id.sb2)
        val sb3 = findViewById<SeekBar>(R.id.sb3)
        val sb4 = findViewById<SeekBar>(R.id.sb4)

        sb1.progress = pieChart.listPiece[0].value.toInt()

        sb2.progress = pieChart.listPiece[1].value.toInt()

        sb3.progress = pieChart.listPiece[2].value.toInt()

        sb4.progress = pieChart.listPiece[3].value.toInt()

        val ls: List<SeekBar> = arrayListOf(sb1, sb2, sb3, sb4)
        for (index in ls.indices) {
            ls[index].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekbar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    seekbar!!.progress = progress
                    pieChart.listPiece[index].value = seekbar.progress.toFloat()
                    pieChart.invalidate()
                }

                override fun onStartTrackingTouch(seekbar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekbar: SeekBar?) {
                }
            })
        }

    }
}