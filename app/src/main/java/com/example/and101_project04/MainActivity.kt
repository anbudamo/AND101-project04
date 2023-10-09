package com.example.and101_project04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.and101_project04.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var numOfKg: Double = 0.0
    var numOfPounds: Double = 0.0
    val kgToPoundsConversionConstant: Double = 2.20462
    val poundsToKgConversionConstant: Double = 0.453592

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.DOWN

        var status: Boolean = true

        binding.convertButton.setOnClickListener() {
            if (status) {
                numOfKg = binding.editText1.text.toString().toDouble()
                numOfPounds = numOfKg * kgToPoundsConversionConstant
                binding.editText2.setText(numOfPounds.toString())
            }

            else {
                numOfPounds = binding.editText1.text.toString().toDouble()
                numOfKg = numOfPounds * poundsToKgConversionConstant
                binding.editText2.setText(numOfKg.toString())
            }

        }

        binding.convertImage.setOnClickListener() {
            binding.editText1.setText("")
            binding.editText2.setText("")

            if (status) {
                binding.editText1.setHint("pounds")
                binding.editText2.setHint("kg")
                status = false
            }

            else {
                binding.editText1.hint = "kg"
                binding.editText2.hint = "pounds"
                status = true
            }
        }

        binding.resetButton.setOnClickListener() {
            binding.editText1.setText("")
            binding.editText2.setText("")

            binding.editText1.hint = "kg"
            binding.editText2.hint = "pounds"
            status = true
        }
    }
}