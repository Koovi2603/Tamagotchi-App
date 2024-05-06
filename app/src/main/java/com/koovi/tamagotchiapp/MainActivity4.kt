package com.koovi.tamagotchiapp

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
private lateinit var cleanActionButton: Button
private lateinit var resetButton: Button
private lateinit var imgResult: ImageView
private lateinit var textResult: TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        //initiliase
        playroomButton = findViewById(R.id.playroombutton)
        kitchenButton = findViewById(R.id.kitchenbutton)
        bathroomButton = findViewById(R.id.bathroombutton)
        cleanActionButton = findViewById(R.id.cleanActionButton)
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

        // Initialize cleanlinessLevel to 0 initially
        var cleanlinessLevel = 0

        // Update UI with the initial cleanliness level
        textResult.text = "Cleanliness level: $cleanlinessLevel"

        cleanActionButton.setOnClickListener {
            if (cleanlinessLevel < 100) {
                cleanlinessLevel += 10
                imgResult.setImageResource(R.drawable.bath)
                textResult.text = "Cleanliness level: $cleanlinessLevel"

                if (cleanlinessLevel >= 100) {
                    Toast.makeText(this, "Im clean, lets go play now!!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        resetButton.setOnClickListener {
            imgResult.setImageResource(R.drawable.dirty)
            cleanlinessLevel = 0
            textResult.text = "Cleanliness levels: $cleanlinessLevel"
        }
    }
}