package com.android.academy.fundamentals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.ResultScreenBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ResultScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleResult()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleResult()
    }

    private fun handleResult() {
        val result = intent.getFloatExtra(RESULT, Float.NEGATIVE_INFINITY)
        binding.result.text = if (result == Float.NEGATIVE_INFINITY) "" else result.toString()
        binding.goHomeBtn.setOnClickListener {
            redirectToFirstActivity()
        }
    }

    private fun redirectToFirstActivity() {
        startActivity(
            Intent(this, FirstNumberActivity::class.java)
        )
    }

    companion object {
        private const val RESULT = "result"

        fun createIntent(context: Context, res: Float) =
            Intent(context, ResultActivity::class.java)
                .putExtra(RESULT, res)
    }
}
