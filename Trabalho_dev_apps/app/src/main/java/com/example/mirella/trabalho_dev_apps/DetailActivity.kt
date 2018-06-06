package com.example.mirella.trabalho_dev_apps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var image = intent.getIntExtra("EXTRA_PEOPLE_IMAGE", 0)
        var title = intent.getStringExtra("EXTRA_PEOPLE_TITLE")
        var description = intent.getStringExtra("EXTRA_PEOPLE_DESCRIPTION")

        imageDetail.setImageResource(image)
        titleBook.text = title
        descriptionBook.text = description
    }
}
