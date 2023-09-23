package com.vmware.bookseat.data.repository.mapper

import com.vmware.bookseat.data.datasource.remote.model.SeatAvailabilityApiResponseModel
import com.vmware.bookseat.data.repository.model.SeatAvailabilityDataResponseModel
import com.vmware.core.mapper.ApiToDataMapper
import javax.inject.Inject

class SeatAvailabilityResponseApiToDataMapper @Inject constructor(
    private val seatApiToDataMapper: SeatApiToDataMapper,
) :
    ApiToDataMapper<SeatAvailabilityApiResponseModel, SeatAvailabilityDataResponseModel>() {
    override fun map(input: SeatAvailabilityApiResponseModel) = SeatAvailabilityDataResponseModel(
        availableSeats = input.availableSeats,
        bookedSeats = input.bookedSeats,
        eventId = input.eventId,
        eventName = input.eventName,
        seats = input.seats.map { apiModel ->
            seatApiToDataMapper.toData(apiModel)
        },
        showDate = input.showDate,
        showTime = input.showTime,
        totalSeats = input.totalSeats,
        venueName = input.venueName,
    )
}
