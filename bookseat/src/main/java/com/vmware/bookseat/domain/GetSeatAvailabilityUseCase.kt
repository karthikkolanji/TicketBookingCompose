package com.vmware.bookseat.domain

import com.vmware.bookseat.data.repository.SeatAvailabilityRepository
import com.vmware.bookseat.domain.mapper.SeatAvailabilityResponseDataToDomainMapper
import javax.inject.Inject

class GetSeatAvailabilityUseCase @Inject constructor(
    private val seatAvailabilityRepository: SeatAvailabilityRepository,
    private val seatAvailabilityResponseDataToDomainMapper: SeatAvailabilityResponseDataToDomainMapper,
) {

    suspend fun get() =
        seatAvailabilityResponseDataToDomainMapper.toDomain(seatAvailabilityRepository.get())
}
