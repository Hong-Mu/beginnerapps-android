package com.hongmu.mangoplate

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RestaurantModel(
    val imageUrl: String = "",
    val name: String = "",
    val url: String = "",
): Parcelable