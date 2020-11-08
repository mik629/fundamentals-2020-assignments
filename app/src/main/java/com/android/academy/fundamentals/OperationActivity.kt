package com.android.academy.fundamentals

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.ActivityOperationBinding

class OperationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOperationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            plus.setOnClickListener {
                moveToResult(Operation.PLUS)
            }
            minus.setOnClickListener {
                moveToResult(Operation.MINUS)
            }
            multiply.setOnClickListener {
                moveToResult(Operation.MULTIPLY)
            }
            divide.setOnClickListener {
                moveToResult(Operation.DIVIDE)
            }
        }
    }

    private fun moveToResult(operation: Operation) {
        startActivity(
            Intent(this, ResultActivity::class.java)
                .putExtras(intent)
                .putExtra(OPERATION, operation as Parcelable)
        )
    }

    companion object {
        const val OPERATION = "operation"
    }
}