package com.android.academy.fundamentals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.SecondNumberActivity.Companion.FIRST_NUM
import com.android.academy.fundamentals.databinding.OperationScreenBinding

class OperationActivity : AppCompatActivity() {
    private lateinit var binding: OperationScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OperationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plus.setOnClickListener {
            moveToResult(Operation.PLUS)
        }
        binding.minus.setOnClickListener {
            moveToResult(Operation.MINUS)
        }
        binding.multiply.setOnClickListener {
            moveToResult(Operation.MULTIPLY)
        }
        binding.divide.setOnClickListener {
            moveToResult(Operation.DIVIDE)
        }

    }

    private fun moveToResult(operation: Operation) {
        startActivity(
            ResultActivity.createIntent(
                this,
                calculateResult(
                    intent.getIntExtra(FIRST_NUM, Int.MIN_VALUE),
                    intent.getIntExtra(SECOND_NUM, Int.MIN_VALUE),
                    operation
                )
            )
        )
    }

    private fun calculateResult(firstNum: Int, secondNum: Int, operation: Operation): Float =
        when (operation) {
            Operation.PLUS -> firstNum + secondNum.toFloat()
            Operation.MINUS -> firstNum - secondNum.toFloat()
            Operation.MULTIPLY -> firstNum * secondNum.toFloat()
            Operation.DIVIDE -> firstNum / secondNum.toFloat()
            else -> 0f
        }

    companion object {
        private const val SECOND_NUM = "secondNum"

        fun createIntent(context: Context, firstNum: Int, secondNum: Int) =
            Intent(context, OperationActivity::class.java)
                .putExtra(FIRST_NUM, firstNum)
                .putExtra(SECOND_NUM, secondNum)
    }
}