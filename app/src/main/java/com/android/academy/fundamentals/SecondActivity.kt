package com.android.academy.fundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.academy.fundamentals.MainActivity.Companion.TRANSMITTED_PARCELABLE
import com.android.academy.fundamentals.databinding.ActivitySecondBinding
import com.android.academy.fundamentals.models.TransmittedParcelable

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transmittedParcelable =
            intent.getParcelableExtra<TransmittedParcelable>(TRANSMITTED_PARCELABLE)
        binding.secondActivityTextView.text =
        with(transmittedParcelable!!) {
            "These values were passed from previous screen: $transmittedString, $transmittedInt, $transmittedBoolean"
        }
    }
}