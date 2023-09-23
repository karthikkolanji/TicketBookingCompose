package com.vmware.bookseat.ui.model

import com.vmware.bookseat.domain.model.SeatCategory
import com.vmware.bookseat.domain.model.SeatStatus

data class SeatAvailabilityResponseUiModel(
    val venueDetails: VenueDetailsUiModel,
    val categoriesSeats: List<CategoriesSeatsUiModel>,
)

data class VenueDetailsUiModel(
    val availableSeats: Int,
    val eventId: String,
    val eventName: String,
    val showDate: String,
    val showTime: String,
    val totalSeats: Int,
    val venueName: String,
)

data class CategoriesSeatsUiModel(
    val row: List<String>,
    val category: String,
    val price: Int,
    val seats: List<SeatUiModel>,
)

data class SeatUiModel(
    val row: String,
    val hold: Boolean,
    val price: Int,
    val seatCategory: SeatCategory,
    val seatId: String,
    val seatNumber: String,
    val status: SeatStatus,

)
