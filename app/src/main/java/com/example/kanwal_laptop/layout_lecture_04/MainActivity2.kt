package com.example.kanwal_laptop.layout_lecture_04

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var leftBtn: Button
    private lateinit var rightBtn: Button
    private lateinit var pointsTextView: TextView
    private var num1: Int = 0
    private var num2: Int = 0
    private var points : Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftBtn = this.findViewById(R.id.left_click)
        rightBtn = this.findViewById(R.id.right_click)
        pointsTextView = this.findViewById(R.id.points)

        scoreUpdate()
    }

    fun leftBtnClickFun(view: View) {
        if(leftBtn.text.toString().toInt() > rightBtn.text.toString().toInt()){
            points++
        }else{
            points--
        }
        pointsTextView.text = "Points: $points"
        scoreUpdate()
    }

    fun rightBtnClickFun(view: View) {
        if(rightBtn.text.toString().toInt() > leftBtn.text.toString().toInt()){
            points++
        }else{
            points--
        }
        pointsTextView.text = "Points: $points"
        scoreUpdate()
    }

    private fun randomNumberGenerate() {
        val r = Random()
        num1 = r.nextInt(100)
        num2 = r.nextInt(100)

        if (num1 == num2) {
            num1 = r.nextInt(100)
        }
    }

    private fun scoreUpdate(){
        randomNumberGenerate()
        leftBtn.text = "$num1"
        rightBtn.text = "$num2"

    }
}