package com.example.column

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat


class Column : View {

    private val TAG: String = this.javaClass.name
    private val paint = Paint()

    var value1 = 400f
    var value2 = 700f
    var value3 = 200f
    var value4 = 850f
    var value5 = 300f
    var listValue: MutableList<Float> = arrayListOf()
    var updateListValue: MutableList<Float> = arrayListOf()

    init {
        listValue.add(value1)
        listValue.add(value2)
        listValue.add(value3)
        listValue.add(value4)
        listValue.add(value5)
        for (index in listValue.indices) {
            updateListValue.add(listValue[index])
        }
    }

    fun updateColumns(
        updateListValue: List<Float>
    ) {
        value1 = updateListValue[0]
        value2 = updateListValue[1]
        value3 = updateListValue[2]
        value4 = updateListValue[3]
        value5 = updateListValue[4]

    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initPaint(context)
    }

    private fun initPaint(context: Context) {
        paint.strokeWidth = 50f
        paint.color = ContextCompat.getColor(context, R.color.teal_700)
        paint.textSize = 40f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        updateColumns(updateListValue)
        Log.d(TAG, "onDraw: $value1")
        Log.d(TAG, "onDraw: ${updateListValue[0]}")

        canvas?.drawText("${(value1 / 10).toInt()}", 150f - 25f, 1200f - value1 - 10f, paint)
        canvas?.drawText("${(value2 / 10).toInt()}", 300f - 25f, 1200f - value2 - 10f, paint)
        canvas?.drawText("${(value3 / 10).toInt()}", 450f - 25f, 1200f - value3 - 10f, paint)
        canvas?.drawText("${(value4 / 10).toInt()}", 600f - 25f, 1200f - value4 - 10f, paint)
        canvas?.drawText("${(value5 / 10).toInt()}", 750f - 25f, 1200f - value5 - 10f, paint)


        canvas?.drawLine(150f, 1200f - value1, 150f, 1200f, paint)
        canvas?.drawLine(300f, 1200f - value2, 300f, 1200f, paint)
        canvas?.drawLine(450f, 1200f - value3, 450f, 1200f, paint)
        canvas?.drawLine(600f, 1200f - value4, 600f, 1200f, paint)
        canvas?.drawLine(750f, 1200f - value5, 750f, 1200f, paint)

    }
}