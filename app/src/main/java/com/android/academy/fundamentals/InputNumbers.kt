package com.android.academy.fundamentals

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InputNumbers(val firstNum: Int, val secondNum: Int): Parcelable