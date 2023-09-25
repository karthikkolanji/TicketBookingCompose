package com.vmware.bookseat.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateError
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateLoading
import com.vmware.bookseat.ui.state.SeatAvailabilityState.StateSuccess
import timber.log.Timber

@Composable
fun BookSeatFragment(
    viewModel: BookSeatViewModel = hiltViewModel(),
) {
    val seatAvailabilityState = viewModel.seatAvailabilityState.observeAsState()
    viewModel.fetchSeatAvailability()

    when (seatAvailabilityState.value) {
        is StateLoading -> {
            LoadingView()
        }

        is StateSuccess -> {
            val seatAvailabilityData = (seatAvailabilityState.value as StateSuccess).data

            seatAvailabilityData.categoriesSeats.forEach { model ->
                for ((row, list) in model.seats) {
                    val temp = list.find { it.seatId == "A1" }
                    if (temp != null) {
                        Timber.d("Changed data BookSeatFragment $temp")
                    }
                }
            }

            BookSeatScreen(seatsList = seatAvailabilityData)
        }

        is StateError -> {
            val error = (seatAvailabilityState.value as StateError).error
            ErrorView(error)
        }

        else -> {}
    }
}
