package com.vmware.bookseat.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatAvailabilityApiResponseModel(
    @SerializedName("available_seats")
    val availableSeats: Int,
    @SerializedName("booked_seats")
    val bookedSeats: Int,
    @SerializedName("event_id")
    val eventId: String,
    @SerializedName("event_name")
    val eventName: String,
    @SerializedName("seats")
    val seats: List<SeatApiModel>,
    @SerializedName("show_date")
    val showDate: String,
    @SerializedName("show_time")
    val showTime: String,
    @SerializedName("total_seats")
    val totalSeats: Int,
    @SerializedName("venue_name")
    val venueName: String,
)
