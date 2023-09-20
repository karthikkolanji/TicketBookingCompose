package com.vmware.bookseat.data.datasource.remote

import com.vmware.bookseat.data.datasource.remote.model.SeatApiModel
import retrofit2.http.GET

interface ApiService {
    @GET("/b6468260-dc25-4e95-9829-805f35ff2584")
    suspend fun getSeatAvailability(): SeatApiModel
}
