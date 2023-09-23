package com.vmware.bookseat.data.datasource.remote

import com.vmware.bookseat.data.datasource.remote.model.SeatAvailabilityApiResponseModel
import retrofit2.http.GET

interface ApiService {
    @GET("8bae0967-51d5-4e36-aff5-7f42af6670a7")
    suspend fun getSeatAvailability(): SeatAvailabilityApiResponseModel
}
