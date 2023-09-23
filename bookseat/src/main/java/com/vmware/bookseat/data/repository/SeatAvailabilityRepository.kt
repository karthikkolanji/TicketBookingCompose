package com.vmware.bookseat.data.repository

import com.vmware.bookseat.data.datasource.remote.ApiService
import com.vmware.bookseat.data.repository.mapper.SeatAvailabilityResponseApiToDataMapper
import com.vmware.core.di.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SeatAvailabilityRepository @Inject constructor(
    private val apiService: ApiService,
    private val dispatcherProvider: DispatcherProvider,
    private val seatAvailabilityResponseApiToDataMapper: SeatAvailabilityResponseApiToDataMapper,
) {

    suspend fun get() = withContext(dispatcherProvider.io()) {
        val temp = apiService.getSeatAvailability()
        seatAvailabilityResponseApiToDataMapper.toData(temp)
    }
}
