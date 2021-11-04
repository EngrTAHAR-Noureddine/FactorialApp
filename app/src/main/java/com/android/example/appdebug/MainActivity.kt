package com.android.example.appdebug

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val util = Util()
        val fbButton = findViewById<Button>(R.id.fbButton)
        val factButton = findViewById<Button>(R.id.factButton)
        val avgButton = findViewById<Button>(R.id.avgButton)
        val factEditText = findViewById<EditText>(R.id.factEditText)
        val sizeEditText = findViewById<EditText>(R.id.sizeEditText)
        // The facebook page URL
        val url  = "fb://page/218641444910278"
        // Onclick of the first button
        fbButton.setOnClickListener {
            util.openPage(this, url)
        }
        // Onclick of the second button

        factButton.setOnClickListener {
            when {
                factEditText.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Le champ est vide !!", Toast.LENGTH_SHORT).show()
                }
                factEditText.text.toString().toInt() == 0 -> {
                    Toast.makeText(this, "Entres le numero >= 1", Toast.LENGTH_SHORT).show()
                }
                factEditText.text.toString().length >=3 -> {
                    Toast.makeText(this, "Le nemuro est grand", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val number =factEditText.text.toString().toInt()
                    val i = util.factorial(number)
                    Toast.makeText(this, "Le factoriel est: $i", Toast.LENGTH_SHORT).show()
                }
            }


        }
        // Onclick of the third button
        avgButton.setOnClickListener {
            when {
                sizeEditText.text.toString().isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Le champs est vide !!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                sizeEditText.text.toString().toInt() <1 -> {
                    Toast.makeText(
                        this,
                        "entrez numero > 1",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                sizeEditText.text.toString().length >=3 -> {
                    Toast.makeText(
                        this,
                        "Le nemuro est grand",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val number = sizeEditText.text.toString().toInt()
                    val list = util.randomList(number)
                    var sum = 0
                    for (item in list) {
                        sum += item
                    }
                    Toast.makeText(
                        this,
                        "La moyenne de la liste est: ${sum / list.size}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

    }
}
