package com.koovi.tamagotchiapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//declare
private lateinit var playroomButton: Button
private lateinit var kitchenButton: Button
private lateinit var bathroomButton: Button
private lateinit var eatActionButton: Button
private lateinit var resetButton: Button
private lateinit var imgResult: ImageView
private lateinit var textResult: TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        //initiliase
        playroomButton = findViewById(R.id.playroombutton)
        kitchenButton = findViewById(R.id.kitchenbutton)
        bathroomButton = findViewById(R.id.bathroombutton)
        eatActionButton = findViewById(R.id.eatActionButton)
        resetButton = findViewById(R.id.resetButton)
        imgResult = findViewById(R.id.imgResult)
        textResult = findViewById(R.id.textResult)


        playroomButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        kitchenButton.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

        bathroomButton.setOnClickListener {
            startActivity(Intent(this, MainActivity4::class.java))
        }

        // Initialize hungerLevel to 100 initially
        var hungerLevel = 100

        // Update UI with the initial hunger level
        textResult.text = "Hunger level: $hungerLevel"

        eatActionButton.setOnClickListener {
            if (hungerLevel >= 10) { // Check if hunger level is greater than or equal to 10
                hungerLevel -= 10 // Decrease hunger level by 10
                imgResult.setImageResource(R.drawable.eat)
                textResult.text = "Hunger level: $hungerLevel"

                if (hungerLevel <= 0) {
                    Toast.makeText(this, "I don't want to eat anymore", Toast.LENGTH_SHORT).show()
                }
            }
        }

        resetButton.setOnClickListener {
            imgResult.setImageResource(R.drawable.hungry)
            hungerLevel = 100
            textResult.text = "Hunger level: $hungerLevel"
        }
    }
}