package com.android.academy.fundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.ActivityFirstNumberBinding

class FirstNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            next.setOnClickListener {
                moveToNextScreen(firstNumber.text.toString().toInt())
            }
        }
    }

    private fun moveToNextScreen(firstNum: Int) {
        startActivity(
            Intent(this, SecondNumberActivity::class.java)
                .putExtra(FIRST_NUM, firstNum)
        )
    }

    companion object {
        const val FIRST_NUM = "firstNum"
    }
}
