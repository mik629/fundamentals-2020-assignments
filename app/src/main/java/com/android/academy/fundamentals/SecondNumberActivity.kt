package com.android.academy.fundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.ActivitySecondNumberBinding

class SecondNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            next.setOnClickListener {
                moveToNextScreen(secondNumber.text.toString().toInt())
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    private fun moveToNextScreen(secondNum: Int) {
        startActivity(
            Intent(this, OperationActivity::class.java)
                .putExtras(intent)
                .putExtra(SECOND_NUM, secondNum)
        )
    }

    companion object {
        const val SECOND_NUM = "secondNum"
    }
}