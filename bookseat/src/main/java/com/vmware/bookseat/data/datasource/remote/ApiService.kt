package com.vmware.bookseat.data.datasource.remote

import com.vmware.bookseat.data.datasource.remote.model.SeatAvailabilityApiResponseModel
import retrofit2.http.GET

interface ApiService {
    @GET("9f64fa41-737d-43be-8f83-df6445a099f9")
    suspend fun getSeatAvailability(): SeatAvailabilityApiResponseModel
}
