package com.vmware.bookseat.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatApiModel(
    @SerialName("hold")
    val hold: Boolean,
    @SerialName("price")
    val price: Int,
    @SerialName("seat_category")
    val seatCategory: CategoryApiModel,
    @SerialName("seat_id")
    val seatId: String,
    @SerialName("seat_number")
    val seatNumber: String,
    @SerialName("status")
    val status: StatusApiModel,
)

enum class CategoryApiModel(val category: String) {
    NORMAL("normal"),
    EXECUTIVE("executive"),
    PREMIUM("premium"),
}

enum class StatusApiModel(val availability: String) {
    AVAILABLE("available"),
    BOOKED("booked"),
}

// https://run.mocky.io/v3/b6468260-dc25-4e95-9829-805f35ff2584
