package com.android.academy.fundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.FirstNumberActivity.Companion.FIRST_NUM
import com.android.academy.fundamentals.OperationActivity.Companion.OPERATION
import com.android.academy.fundamentals.SecondNumberActivity.Companion.SECOND_NUM
import com.android.academy.fundamentals.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstNum = intent.getIntExtra(FIRST_NUM, 0)
        val secondNum = intent.getIntExtra(SECOND_NUM, 0)
        val res = when(intent.getParcelableExtra<Operation>(OPERATION)) {
            Operation.PLUS -> firstNum + secondNum
            Operation.MINUS -> firstNum - secondNum
            Operation.MULTIPLY -> firstNum * secondNum
            Operation.DIVIDE -> firstNum / secondNum.toFloat()
            else -> 0
        }
        with(binding) {
            result.text = res.toString()
            goHomeBtn.setOnClickListener {
                goHome()
            }
        }
    }

    private fun goHome() {
        startActivity(
            Intent(this@ResultActivity, FirstNumberActivity::class.java)
        )
    }
}