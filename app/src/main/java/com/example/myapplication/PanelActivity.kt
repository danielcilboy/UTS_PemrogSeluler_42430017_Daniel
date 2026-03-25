package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val etMatkul = findViewById<EditText>(R.id.etMatkul)
        val etJumlahMhs = findViewById<EditText>(R.id.etJumlahMhs)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        val username = intent.getStringExtra("EXTRA_USERNAME") ?: "Admin"
        tvWelcome.text = getString(R.string.welcome_user, username)

        btnGenerate.setOnClickListener {
            val namaDosen = etNamaDosen.text.toString()
            val matkul = etMatkul.text.toString()
            val jumlahMhsStr = etJumlahMhs.text.toString()

            if (namaDosen.isNotEmpty() && matkul.isNotEmpty() && jumlahMhsStr.isNotEmpty()) {
                val jumlahMhs = jumlahMhsStr.toInt()
                

                val statusKelas = if (jumlahMhs > 30) {
                    getString(R.string.status_besar)
                } else {
                    getString(R.string.status_reguler)
                }

                val resultBuilder = StringBuilder()
                resultBuilder.append(getString(R.string.report_header)).append("\n")
                resultBuilder.append(getString(R.string.report_dosen, namaDosen)).append("\n")
                resultBuilder.append(getString(R.string.report_matkul, matkul)).append("\n")
                resultBuilder.append(getString(R.string.report_status, statusKelas)).append("\n")
                resultBuilder.append(getString(R.string.report_divider)).append("\n")
                resultBuilder.append(getString(R.string.report_absensi_header)).append("\n")

                for (i in 1..jumlahMhs) {
                    resultBuilder.append(getString(R.string.report_absensi_item, i)).append("\n")
                }

                tvResult.text = resultBuilder.toString()
            } else {
                tvResult.text = getString(R.string.error_empty_fields)
            }
        }
    }
}