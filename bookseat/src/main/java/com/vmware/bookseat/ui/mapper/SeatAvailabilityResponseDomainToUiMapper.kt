package com.vmware.bookseat.ui.mapper

import com.vmware.bookseat.domain.model.SeatAvailabilityDomainResponseModel
import com.vmware.bookseat.domain.model.SeatCategory
import com.vmware.bookseat.domain.model.SeatDomainModel
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

    val rowList = map { it.row }.distinct()

    val categorizedLists = mutableMapOf<SeatCategory, List<SeatDomainModel>>()

    for (category in categoryList) {
        val filteredList = filter { it.seatCategory == category }
        categorizedLists[category] = filteredList
    }

    val categorizesSeatList = mutableListOf<CategoriesSeatsUiModel>()
    for ((category, list) in categorizedLists) {
        val temp = CategoriesSeatsUiModel(
            row = list.map { it.row }.distinct(),
            seats = list.categorizeSeatsByRow(),
            category = category.mapCategory(),
            price = list.map { it.price }.distinct().first(),

        )
        categorizesSeatList.add(temp)
    }
    return categorizesSeatList
}

fun List<SeatDomainModel>.categorizeSeatsByRow(): MutableMap<String, List<SeatUiModel>> {
    val mappedUiList = map { it.mapCategorizedSeat() }
    val rowList = mappedUiList.map { it.row }.distinct()
    val rowedSeatLists = mutableMapOf<String, List<SeatUiModel>>()
    for (row in rowList) {
        val filteredList = mappedUiList.filter { it.row == row }
        rowedSeatLists[row] = filteredList
    }
    return rowedSeatLists
}

fun SeatCategory.mapCategory() = when (this) {
    SeatCategory.Normal -> "Normal"
    SeatCategory.Executive -> "Executive"
    SeatCategory.Premium -> "Premium"
}

fun SeatDomainModel.mapCategorizedSeat() = SeatUiModel(
    row = this.row,
    hold = this.hold,
    price = this.price,
    seatCategory = this.seatCategory,
    seatId = this.seatId,
    seatNumber = this.seatNumber,
    status = this.status,
)
