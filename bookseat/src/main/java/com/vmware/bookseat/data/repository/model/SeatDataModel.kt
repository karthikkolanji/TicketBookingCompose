package com.vmware.bookseat.data.repository.model

data class SeatDataModel(
    val hold: Boolean,
    val price: Int,
    val seatCategory: CategoryDataModel,
    val seatId: String,
    val seatNumber: String,
    val status: StatusDataModel,
)

enum class CategoryDataModel(val category: String) {
    NORMAL("normal"),
    EXECUTIVE("executive"),
    PREMIUM("premium"),
}

enum class StatusDataModel(val availability: String) {
    AVAILABLE("available"),
    BOOKED("booked"),
}
