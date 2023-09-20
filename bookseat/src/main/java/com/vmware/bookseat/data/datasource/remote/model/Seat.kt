package com.vmware.bookseat.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Seat(
    @SerialName("hold")
    val hold: Boolean,
    @SerialName("price")
    val price: Int,
    @SerialName("seat_category")
    val seatCategory: Category,
    @SerialName("seat_id")
    val seatId: String,
    @SerialName("seat_number")
    val seatNumber: String,
    @SerialName("status")
    val status: Status,
)

enum class Category(val category: String) {
    NORMAL("normal"),
    EXECUTIVE("executive"),
    PREMIUM("premium"),
}

enum class Status(val availability: String) {
    AVAILABLE("available"),
    BOOKED("booked"),
}

// https://run.mocky.io/v3/b6468260-dc25-4e95-9829-805f35ff2584
