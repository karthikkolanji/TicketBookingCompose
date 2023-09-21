package com.vmware.bookseat.domain.mapper

import com.plume.common.data.contract.mapper.DataToDomainMapper
import com.vmware.bookseat.data.repository.model.SeatAvailabilityDataResponseModel
import com.vmware.bookseat.domain.model.SeatAvailabilityDomainResponseModel
import javax.inject.Inject

class SeatAvailabilityResponseDataToDomainMapper @Inject constructor(
    private val seatDataToDomainMapper: SeatDataToDomainMapper,
) :
    DataToDomainMapper<SeatAvailabilityDataResponseModel, SeatAvailabilityDomainResponseModel>() {
    override fun map(input: SeatAvailabilityDataResponseModel) =
        SeatAvailabilityDomainResponseModel(
            availableSeats = input.availableSeats,
            eventId = input.eventId,
            eventName = input.eventName,
            showDate = input.showDate,
            showTime = input.showTime,
            totalSeats = input.totalSeats,
            venueName = input.venueName,
            seats = input.seats.map { seatDataModel ->
                seatDataToDomainMapper.toDomain(seatDataModel)
            },
        )
}
