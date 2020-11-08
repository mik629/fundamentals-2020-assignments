package com.android.academy.fundamentals

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class Operation: Parcelable {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE
}