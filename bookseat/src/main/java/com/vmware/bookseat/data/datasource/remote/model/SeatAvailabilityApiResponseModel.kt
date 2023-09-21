package com.vmware.bookseat.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatAvailabilityApiResponseModel(
    @SerialName("available_seats")
    val availableSeats: Int,
    @SerialName("booked_seats")
    val bookedSeats: Int,
    @SerialName("event_id")
    val eventId: String,
    @SerialName("event_name")
    val eventName: String,
    @SerialName("seats")
    val seats: List<SeatApiModel>,
    @SerialName("show_date")
    val showDate: String,
    @SerialName("show_time")
    val showTime: String,
    @SerialName("total_seats")
    val totalSeats: Int,
    @SerialName("venue_name")
    val venueName: String,
)
