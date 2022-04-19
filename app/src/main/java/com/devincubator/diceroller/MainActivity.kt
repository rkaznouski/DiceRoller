package com.devincubator.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var diceImageFirst: ImageView
    private lateinit var diceImageSecond: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }

        diceImageFirst = findViewById(R.id.dice_image_first)
        diceImageSecond = findViewById(R.id.dice_image_second)
    }

    private fun rollDice() {
        diceImageFirst.setImageResource(getRandomDiceImage())
        diceImageSecond.setImageResource(getRandomDiceImage())

        Toast.makeText(this, "Rolled dice!", Toast.LENGTH_SHORT).show()
    }

    private fun getRandomDiceImage(): Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reset() {
        diceImageFirst.setImageResource(R.drawable.empty_dice)
        diceImageSecond.setImageResource(R.drawable.empty_dice)
    }
}