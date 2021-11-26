package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var submitButton: Button
    lateinit var etEnterMessage: EditText

    private var items = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEnterMessage = findViewById(R.id.etEnterMessage)

        submitButton = findViewById(R.id.btnSubmit)

        submitButton.setOnClickListener{ addItems() }
    }

    private fun addItems() {
        if (etEnterMessage.text.isEmpty() || etEnterMessage.text.toString() == " ") {
            Snackbar.make(clMain, "You did not enter anything!", Snackbar.LENGTH_SHORT).show();
            return;
        } else {
            items.add(etEnterMessage.text.toString())

            val myRV = findViewById<RecyclerView>(R.id.rvMain)
            myRV.adapter = RecyclerViewAdapter(items)
            myRV.layoutManager = LinearLayoutManager(this)

            etEnterMessage.text.clear()

            Log.d("MainActivity", items.toString())
        }
    }
}