package com.example.day2demo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat


class PieChart : View {
    private val TAG: String = this.javaClass.name
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var listPiece: MutableList<PieSeries> = mutableListOf()
    private var sum: Float = 0f
    private val left = 50f
    private val top = 50f
    private val right = 1000f
    private val bottom = 1000f

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    init {
        listPiece.add(
            PieSeries(
                ContextCompat.getColor(context, R.color.teal_700), 40f
            )
        )

        listPiece.add(
            PieSeries(
                ContextCompat.getColor(context, R.color.purple_700), 35f
            )
        )

        listPiece.add(
            PieSeries(
                ContextCompat.getColor(context, R.color.black), 90f
            )
        )

        listPiece.add(
            PieSeries(
                ContextCompat.getColor(context, R.color.purple_200), 70f
            )
        )
        for (s in listPiece) {
            sum += s.value
        }
    }

    private fun calSum(list: MutableList<PieSeries>) {
        for (s in list) {
            sum += s.value
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var startAngle = 0f
        var sweepAngle = 0f

        sum = 0f
        calSum(listPiece)

        for (s in listPiece) {
            paint.color = s.color
            startAngle += sweepAngle
            sweepAngle = s.value / sum * 360
            val bound = RectF(left, top, right, bottom)
            canvas?.drawArc(bound, startAngle, sweepAngle, true, paint)
        }

        paint.color = Color.WHITE
        canvas?.drawCircle((right - left) / 2 + left, (bottom - top) / 2 + left, 200f, paint)
    }


}


