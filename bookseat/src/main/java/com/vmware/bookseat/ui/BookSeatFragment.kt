package com.vmware.bookseat.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateError
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateLoading
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateSuccess

@Composable
fun BookSeatFragment(
    viewModel: BookSeatViewModel = hiltViewModel(),
) {
    val seatAvailabilityState = viewModel.seatAvailabilityState.observeAsState()
    viewModel.fetchSeatAvailability()

    when (seatAvailabilityState.value) {
        is StateLoading -> {
        }

        is StateSuccess -> {
            val seatAvailabilityData = (seatAvailabilityState.value as StateSuccess).data
            BookSeatScreen(categoriesSeatList = seatAvailabilityData.categoriesSeats)
        }

        is StateError -> {
            val error = (seatAvailabilityState.value as StateError).error
        }

        else -> {}
    }
}
