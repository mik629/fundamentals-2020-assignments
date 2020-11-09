package com.android.academy.fundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.FirstNumberScreenBinding

class FirstNumberActivity : AppCompatActivity() {
    private lateinit var binding: FirstNumberScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FirstNumberScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            moveToNextScreen(binding.firstNumber.text.toString().toInt())
        }
    }

    private fun moveToNextScreen(firstNum: Int) {
        startActivity(
            SecondNumberActivity.createIntent(this, firstNum)
        )
    }
}
