package com.example.depozit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var statusText: TextView
    private lateinit var bottomTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        statusText = findViewById(R.id.statusText)
        bottomTV = findViewById(R.id.bottomTV)

        statusText.text = "${seekBar.progress}"


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateStatus(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Здесь можно оставить пустым, если не нужно обрабатывать событие
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Здесь можно оставить пустым, если не нужно обрабатывать событие
            }
        })
        val madeIn = getString(R.string.made_in)
        val byKaterin = getString(R.string.BY_Katerin)
        bottomTV.text = "$madeIn $byKaterin"

    }

    private fun updateStatus(progress: Int) {
        val status: String = when (progress) {
            in 0..9 -> "Пенсионный"
            in 10..14 -> "Оптимальный"
            in 15..19 -> "Комфорт"
            in 20..24 -> "Бизнесмен"
            else -> "Максимум"
        }

        val color: Int = when (status) {
            "Пенсионный" -> getColor(R.color.fuxi)
            "Оптимальный" -> getColor(R.color.light_green)
            "Комфорт" -> getColor(R.color.perple)
            "Бизнесмен" -> getColor(R.color.orange)
            else -> getColor(R.color.red)
        }
        statusText.text = "$status"
        statusText.setTextColor(color)
    }


}

