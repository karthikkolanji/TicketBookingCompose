package com.vmware.bookseat.ui.mapper

import com.vmware.bookseat.domain.model.SeatAvailabilityDomainResponseModel
import com.vmware.bookseat.domain.model.SeatCategory
import com.vmware.bookseat.domain.model.SeatDomainModel
import com.vmware.bookseat.domain.model.SeatStatus
import com.vmware.bookseat.ui.model.CategoriesSeatsUiModel
import com.vmware.bookseat.ui.model.SeatAvailabilityResponseUiModel
import com.vmware.bookseat.ui.model.SeatUiModel
import com.vmware.bookseat.ui.model.VenueDetailsUiModel
import com.vmware.core.mapper.DomainToUiMapper
import javax.inject.Inject

class SeatAvailabilityResponseDomainToUiMapper @Inject constructor() :
    DomainToUiMapper<SeatAvailabilityDomainResponseModel, SeatAvailabilityResponseUiModel>() {
    override fun map(input: SeatAvailabilityDomainResponseModel) = SeatAvailabilityResponseUiModel(
        venueDetails = VenueDetailsUiModel(
            availableSeats = input.availableSeats,
            eventId = input.eventId,
            eventName = input.eventName,
            showDate = input.showDate,
            showTime = input.showTime,
            totalSeats = input.totalSeats,
            venueName = input.venueName,
        ),
        categoriesSeats = input.seats.categorize(),
    )
}

fun List<SeatDomainModel>.categorize(): List<CategoriesSeatsUiModel> {
    val categoryList = map { seat ->
        seat.seatCategory
    }.distinct()

    val price = map { seat ->
        seat.price
    }.distinct()

    val categorizedLists = mutableMapOf<SeatCategory, List<SeatDomainModel>>()
    for (category in categoryList) {
        val filteredList = filter { it.seatCategory == category }
        categorizedLists[category] = filteredList
    }

    val finalList = mutableListOf<CategoriesSeatsUiModel>()
    for ((category, list) in categorizedLists) {
        val temp = CategoriesSeatsUiModel(
            row = list.map {
                it.seatNumber.extractRows()
            }.distinct(),
            seats = list.map { it.mapCategorizedSeat() },
            category = category.mapCategory(),
            price = list.map { it.price }.distinct().first(),

        )
        finalList.add(temp)
    }

    return finalList
}

data class CategoriesSeatsUiModel(
    val row: List<String>,
    val seats: List<SeatUiModel>,
    val category: String,
    val price: Int,
)

data class SeatUiModel(
    val hold: Boolean,
    val price: Int,
    val seatCategory: SeatCategory,
    val seatId: String,
    val seatNumber: String,
    val status: SeatStatus,

)

fun SeatCategory.mapCategory() = when (this) {
    SeatCategory.Normal -> "Normal"
    SeatCategory.Executive -> "Executive"
    SeatCategory.Premium -> "Premium"
}

fun SeatDomainModel.mapCategorizedSeat() = SeatUiModel(
    hold = this.hold,
    price = this.price,
    seatCategory = this.seatCategory,
    seatId = this.seatId,
    seatNumber = this.seatNumber,
    status = this.status,
)

fun String.extractRows() = filter { it.isLetter() }
