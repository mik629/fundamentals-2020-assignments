package com.android.academy.fundamentals.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransmittedParcelable(
    val transmittedString: String,
    val transmittedInt: Int,
    val transmittedBoolean: Boolean
): Parcelable