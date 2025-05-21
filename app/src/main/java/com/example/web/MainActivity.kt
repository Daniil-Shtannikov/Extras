package com.example.web

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity(), OnClickListener {
    lateinit var etFName: TextView
    lateinit var etLName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener(this)
    }


  override fun onClick(v: View) {
      intent = Intent(this, ViewActivity::class.java)
      intent.putExtra("fname", etFName.text.toString())
      intent.putExtra("lname", etLName.text.toString())
      startActivity(intent)
      }
  }
