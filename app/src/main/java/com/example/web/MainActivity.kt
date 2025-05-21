package com.example.web

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity(), OnClickListener {
    lateinit var tvText: TextView
    lateinit var btnColor: Button
    lateinit var btnAlign: Button

    val REQUEST_CODE_COLOR: Int = 1
    val REQUEST_CODE_ALIGN: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)

        btnColor = findViewById(R.id.btnColor);
        btnAlign =  findViewById(R.id.btnAlign);

        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);

        btnColor.setOnClickListener(this)
        btnAlign.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.btnColor -> {
                intent = Intent(this, Colors::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }

            R.id.btnAlign -> {
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_COLOR -> {
                    val color = data?.getIntExtra("color", Color.WHITE)
                    if (color != null) {
                        tvText.setTextColor(color)
                    }
                }

                REQUEST_CODE_ALIGN -> {
                    val align = data?.getIntExtra("alignment", Gravity.LEFT)
                    if (align != null) {
                        tvText.gravity = align
                    }
                }
            }
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }
    }
}
