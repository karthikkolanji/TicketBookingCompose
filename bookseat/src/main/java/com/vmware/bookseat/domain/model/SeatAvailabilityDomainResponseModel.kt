package com.vmware.bookseat.domain.model

data class SeatAvailabilityDomainResponseModel(
    val availableSeats: Int,
    val eventId: String,
    val eventName: String,
    val showDate: String,
    val showTime: String,
    val totalSeats: Int,
    val venueName: String,
    val seats: List<SeatDomainModel>,
)

data class SeatDomainModel(
    val row: String,
    val hold: Boolean,
    val price: Int,
    val seatCategory: SeatCategory,
    val seatId: String,
    val seatNumber: String,
    val status: SeatStatus,
)

sealed interface SeatCategory {
    data object Normal : SeatCategory
    data object Executive : SeatCategory
    data object Premium : SeatCategory
}

sealed interface SeatStatus {
    data object Available : SeatStatus
    data object Booked : SeatStatus
}
