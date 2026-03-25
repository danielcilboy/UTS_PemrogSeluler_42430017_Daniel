package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etUsername = findViewById<EditText>(R.id.etUsername)
        val btnLogin = findViewById<Button>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()

            if (username.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Halo, $username! Anda berhasil login.",
                    Toast.LENGTH_SHORT
                ).show()


                val intent = Intent(this, PanelActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", username)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Silakan isi username",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}