package com.example.praktik13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    lateinit var pilihan: Spinner
    lateinit var tPesanan: TextView
    lateinit var tPembayaran: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val KUNCI = "KunciOrder"
        var pesan = "Anda memesan "
        pesan += intent.getStringExtra(KUNCI)

        val teksPesanan = findViewById<TextView>(R.id.tPesanan)
        teksPesanan.text = pesan

        tPesanan = findViewById<TextView>(R.id.tPesanan)
        tPesanan.text = pesan
        pilihan = findViewById<Spinner>(R.id.sPilihan)
        ArrayAdapter.createFromResource(
            this,
            R.array.jenis,
            android.R.layout.simple_spinner_item
        ).also {
                listPilihan -> listPilihan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pilihan.adapter = listPilihan
        }
        tPembayaran = findViewById<TextView>(R.id.tPembayaran)
    }
    fun fRadioButton(view: View){
        if(view is RadioButton){
            val terpilih = view.isChecked
            if(view.getId() == R.id.rbTransfer && terpilih){
                tPembayaran.text = "Memilih Transfer"
            }
            else if(view.getId() == R.id.rbCod && terpilih){
                tPembayaran.text = "Memilih COD"
            }
        }
    }
}