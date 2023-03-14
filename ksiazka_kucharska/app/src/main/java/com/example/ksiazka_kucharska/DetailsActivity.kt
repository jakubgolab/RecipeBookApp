package com.example.ksiazka_kucharska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val pos = intent.getIntExtra("position", 0)
        val recipeNames = resources.getStringArray(R.array.recipe_name)
        val recipeIngredients = resources.getStringArray(R.array.recipe_ingredients)
        val recipePrep = resources.getStringArray(R.array.recipe_preparation)

        val title = findViewById<TextView>(R.id.recipeTitle)
        val ingredients = findViewById<TextView>(R.id.recipeIngText)
        val preparation = findViewById<TextView>(R.id.recipePrepText)

        title.text = recipeNames[pos]
        ingredients.text = recipeIngredients[pos]
        preparation.text = recipePrep[pos]

        val goBackButton = findViewById<Button>(R.id.goBackButton)
        goBackButton.setOnClickListener {
            this.finish()
        }
    }
}