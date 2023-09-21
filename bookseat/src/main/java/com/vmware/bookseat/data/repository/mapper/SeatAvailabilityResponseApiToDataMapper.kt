package com.vmware.bookseat.data.repository.mapper

import com.plume.common.data.contract.mapper.ApiToDataMapper
import com.vmware.bookseat.data.datasource.remote.model.SeatApiResponseModel
import com.vmware.bookseat.data.repository.model.SeatDataResponseModel
import javax.inject.Inject

class SeatAvailabilityResponseApiToDataMapper @Inject constructor(
    private val seatApiToDataMapper: SeatApiToDataMapper,
) :
    ApiToDataMapper<SeatApiResponseModel, SeatDataResponseModel>() {
    override fun map(input: SeatApiResponseModel) = SeatDataResponseModel(
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
