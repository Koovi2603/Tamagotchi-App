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

class MainActivity2 : AppCompatActivity() {

    private lateinit var playroomButton: Button
    private lateinit var kitchenButton: Button
    private lateinit var bathroomButton: Button
    private lateinit var playActionButton: Button
    private lateinit var resetButton: Button
    private lateinit var imgResult: ImageView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //initialize
        playroomButton = findViewById(R.id.playroombutton)
        kitchenButton = findViewById(R.id.kitchenbutton)
        bathroomButton = findViewById(R.id.bathroombutton)
        playActionButton = findViewById(R.id.playActionButton)
        imgResult = findViewById(R.id.imgResult)
        resetButton = findViewById(R.id.resetButton)
        textResult = findViewById(R.id.textResult)

        playroomButton.setOnClickListener {
            // Start Playroom activity
            startActivity(Intent(this, MainActivity2::class.java))
        }

        kitchenButton.setOnClickListener {
            // Start Kitchen activity
            startActivity(Intent(this, MainActivity3::class.java))
        }

        bathroomButton.setOnClickListener {
            // Start Bathroom activity
            startActivity(Intent(this, MainActivity4::class.java))
        }

        // Initialize Excitement Level to 0 initially
        var excitementLevel = 0

        // Update UI with the initial excitement level
        textResult.text = "Excitement level: $excitementLevel"

        playActionButton.setOnClickListener {
            if (excitementLevel < 100) {
                excitementLevel += 10
                imgResult.setImageResource(R.drawable.playing)
                textResult.text = "Excitement level: $excitementLevel"
                // Check if excitement level exceeds 100 after adding 10
                if (excitementLevel >= 100) {
                    // Display message if excitement level is greater than or equal to 100
                    Toast.makeText(this, "I don't want to play anymore", Toast.LENGTH_SHORT).show()
                }
            }
        }
        resetButton.setOnClickListener {
            imgResult.setImageResource(R.drawable.sad)
            excitementLevel = 0
            textResult.text = "Excitement level: $excitementLevel"
        }
    }
}
