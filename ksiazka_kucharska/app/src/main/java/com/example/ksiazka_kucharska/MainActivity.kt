package com.example.ksiazka_kucharska

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isTablet = resources.getBoolean(R.bool.isTablet)

        val recipeList: ListView = findViewById(R.id.recipesList)
        val recipesName = resources.getStringArray(R.array.recipe_name)
        val adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, recipesName)
        recipeList.adapter = adapter

        val recipeIng = resources.getStringArray(R.array.recipe_ingredients)
        val recipePrep = resources.getStringArray(R.array.recipe_preparation)

        val manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        var fragment = detailsFragment.newInstance(recipesName[0], recipeIng[0], recipePrep[0])


        recipeList.setOnItemClickListener { adapterView, view, position, l ->
            if (isTablet) {
                transaction = manager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView2, detailsFragment.newInstance(recipesName[position], recipeIng[position], recipePrep[position])).commit()
            } else {
                val nextPage = Intent(this, DetailsActivity::class.java)
                nextPage.putExtra("position", position)
                startActivity(nextPage)
            }
        }

    }
}