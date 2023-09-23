package com.vmware.bookseat.data.datasource.remote

import com.vmware.bookseat.data.datasource.remote.model.SeatAvailabilityApiResponseModel
import retrofit2.http.GET

interface ApiService {
    @GET("e73f750e-60ab-40b4-bed4-a75761861f77")
    suspend fun getSeatAvailability(): SeatAvailabilityApiResponseModel
}
