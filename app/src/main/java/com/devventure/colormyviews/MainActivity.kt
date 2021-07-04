package com.devventure.colormyviews

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var boxOne : TextView
    lateinit var boxTwo : TextView
    lateinit var boxThree : TextView
    lateinit var boxFour : TextView
    lateinit var boxFive : TextView

    val sharedPreferences: SharedPreferences
        get() {
           return this.getSharedPreferences("colors", Context.MODE_PRIVATE)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)

        var paintBucket = R.color.grey

        boxOne = findViewById(R.id.box_one_text)
        boxTwo = findViewById(R.id.box_two_text)
        boxThree = findViewById(R.id.box_three_text)
        boxFour = findViewById(R.id.box_four_text)
        boxFive = findViewById(R.id.box_five_text)

        val colorBoxOne = sharedPreferences.getInt(boxOne.toString(), paintBucket)
        val colorBoxTwo = sharedPreferences.getInt(boxTwo.toString(), paintBucket)
        val colorBoxThree = sharedPreferences.getInt(boxThree.toString(), paintBucket)
        val colorBoxFour = sharedPreferences.getInt(boxFour.toString(), paintBucket)
        val colorBoxFive = sharedPreferences.getInt(boxFive.toString(), paintBucket)

        boxOne.setBackgroundResource(colorBoxOne)
        boxTwo.setBackgroundResource(colorBoxTwo)
        boxThree.setBackgroundResource(colorBoxThree)
        boxFour.setBackgroundResource(colorBoxFour)
        boxFive.setBackgroundResource(colorBoxFive)

        redButton.setOnClickListener {
            paintBucket = R.color.red
        }

        yellowButton.setOnClickListener {
            paintBucket = R.color.yellow
        }

        greenButton.setOnClickListener {
            paintBucket = R.color.green
        }

        boxOne.setOnClickListener{
            boxOne.setBackgroundResource(paintBucket)
        }

        boxTwo.setOnClickListener{
            boxTwo.setBackgroundResource(paintBucket)
        }

        boxThree.setOnClickListener{
            boxThree.setBackgroundResource(paintBucket)
        }

        boxFour.setOnClickListener{
            boxFour.setBackgroundResource(paintBucket)
        }

        boxFive.setOnClickListener{
            boxFive.setBackgroundResource(paintBucket)
        }
    }

    override fun onStop() {
        super.onStop()

        val editor = sharedPreferences.edit()

        var viewColor: ColorDrawable = boxOne.background as ColorDrawable
        var colorId: Int = viewColor.color
        editor.putInt(boxOne.toString(), colorId)

        viewColor = boxTwo.background as ColorDrawable
        colorId = viewColor.color
        editor.putInt(boxTwo.toString(), colorId)

        viewColor = boxThree.background as ColorDrawable
        colorId = viewColor.color
        editor.putInt(boxThree.toString(), colorId)

        viewColor = boxFour.background as ColorDrawable
        colorId = viewColor.color
        editor.putInt(boxFour.toString(), colorId)

        viewColor = boxFive.background as ColorDrawable
        colorId = viewColor.color
        editor.putInt(boxFive.toString(), colorId)

        editor.commit()
    }
}