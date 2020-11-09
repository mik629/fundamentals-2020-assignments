package com.android.academy.fundamentals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                    intent.getParcelableExtra(INPUT_NUMS)!!,
                    operation
                )
            )
        )
    }

    private fun calculateResult(inputNumbers: InputNumbers, operation: Operation): Float =
        with(inputNumbers) {
            when (operation) {
                Operation.PLUS -> firstNum + secondNum.toFloat()
                Operation.MINUS -> firstNum - secondNum.toFloat()
                Operation.MULTIPLY -> firstNum * secondNum.toFloat()
                Operation.DIVIDE -> firstNum / secondNum.toFloat()
            }
        }

    companion object {
        private const val INPUT_NUMS = "inputNumbers"

        fun createIntent(context: Context, firstNum: Int, secondNum: Int) =
            Intent(context, OperationActivity::class.java)
                .putExtra(INPUT_NUMS, InputNumbers(firstNum, secondNum))
    }
}

