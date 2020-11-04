package com.android.academy.fundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.databinding.ActivityMainBinding
import com.android.academy.fundamentals.models.TransmittedParcelable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.greetingsText.setOnClickListener {
            moveToNextScreen()
        }
    }

    private fun moveToNextScreen() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(
            TRANSMITTED_PARCELABLE,
            TransmittedParcelable(
                "string to transmit",
                100500,
                true
            )
        )
        startActivity(
            intent
        )
    }

    companion object {
        const val TRANSMITTED_PARCELABLE = "transmittedParcelable"
    }
}
