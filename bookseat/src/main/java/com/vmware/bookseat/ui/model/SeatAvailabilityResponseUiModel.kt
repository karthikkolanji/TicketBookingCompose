package com.vmware.bookseat.ui.model

import androidx.compose.ui.graphics.Color
import com.vmware.bookseat.domain.model.SeatCategory
import com.vmware.bookseat.ui.theme.BookedSeat
import com.vmware.bookseat.ui.theme.SelectedSeat
import com.vmware.bookseat.ui.theme.UnselectedSeat

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
    val seats: MutableMap<String, List<SeatUiModel>>,
)

data class SeatUiModel(
    val row: String,
    val hold: Boolean,
    val price: Int,
    val seatCategory: SeatCategory,
    val seatId: String,
    val seatNumber: String,
    var status: SeatStatusUiModel,
)

sealed class SeatStatusUiModel(val color: Color) {
    data object Booked : SeatStatusUiModel(BookedSeat)
    sealed class Available(available: Color) : SeatStatusUiModel(available) {
        data object Unselected : Available(UnselectedSeat)
        data object Selected : Available(SelectedSeat)
    }
}
