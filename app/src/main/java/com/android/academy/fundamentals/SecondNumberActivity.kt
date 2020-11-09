package com.android.academy.fundamentals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.SecondNumberScreenBinding

class SecondNumberActivity : AppCompatActivity() {
    private lateinit var binding: SecondNumberScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondNumberScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            moveToNextScreen(binding.secondNumber.text.toString().toInt())
        }
    }

    private fun moveToNextScreen(secondNum: Int) {
        startActivity(
            OperationActivity.createIntent(this, intent.getIntExtra(FIRST_NUM, 0), secondNum)
        )
    }

    companion object {
        const val FIRST_NUM = "firstNum"

        fun createIntent(context: Context, firstNum: Int) =
            Intent(context, SecondNumberActivity::class.java)
                .putExtra(FIRST_NUM, firstNum)
    }
}