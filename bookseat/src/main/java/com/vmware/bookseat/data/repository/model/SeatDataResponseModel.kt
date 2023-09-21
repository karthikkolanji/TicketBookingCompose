package com.vmware.bookseat.data.repository.model

data class SeatDataResponseModel(
    val availableSeats: Int,
    val bookedSeats: Int,
    val eventId: String,
    val eventName: String,
    val seats: List<SeatDataModel>,
    val showDate: String,
    val showTime: String,
    val totalSeats: Int,
    val venueName: String,
)
