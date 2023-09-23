package com.vmware.bookseat.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatApiModel(
    @SerializedName("row")
    val row: String,
    @SerializedName("hold")
    val hold: Boolean,
    @SerializedName("price")
    val price: Int,
    @SerializedName("seat_category")
    val seatCategory: CategoryApiModel,
    @SerializedName("seat_id")
    val seatId: String,
    @SerializedName("seat_number")
    val seatNumber: String,
    @SerializedName("status")
    val status: StatusApiModel,
)

enum class CategoryApiModel {
    @SerializedName("normal")
    NORMAL,

    @SerializedName("executive")
    EXECUTIVE,

    @SerializedName("premium")
    PREMIUM,
}

enum class StatusApiModel {
    @SerializedName("available")
    AVAILABLE,

    @SerializedName("booked")
    BOOKED,
}

// https://run.mocky.io/v3/b6468260-dc25-4e95-9829-805f35ff2584
