package com.example.column

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class Coordinate : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initPaint()
    }

    private fun initPaint() {
        paint.strokeWidth = 10f
        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.textSize = 40f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText("100", 10f, 200f, paint)
        canvas?.drawText("75", 10f, 450f, paint)
        canvas?.drawText("50", 10f, 700f, paint)
        canvas?.drawText("25", 10f, 950f, paint)
        canvas?.drawText("0", 10f, 1200f, paint)

        canvas?.drawText("Item1", 125f, 1250f, paint)
        canvas?.drawText("Item2", 275f, 1250f, paint)
        canvas?.drawText("Item3", 425f, 1250f, paint)
        canvas?.drawText("Item4", 575f, 1250f, paint)
        canvas?.drawText("Item5", 725f, 1250f, paint)


        canvas?.drawLine(100f, 1200f, 900f, 1200f, paint)
        canvas?.drawLine(100f, 50f, 100f, 1200f, paint)

    }


}