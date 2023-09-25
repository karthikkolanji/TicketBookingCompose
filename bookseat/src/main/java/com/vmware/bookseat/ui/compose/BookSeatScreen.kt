package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vmware.bookseat.ui.BookSeatViewModel
import com.vmware.bookseat.ui.model.SeatAvailabilityResponseUiModel
import com.vmware.bookseat.ui.theme.BookedSeat
import com.vmware.bookseat.ui.theme.SelectedSeat
import com.vmware.bookseat.ui.theme.UnselectedSeat
import com.vmware.bookseat.ui.theme.availableSeats
import com.vmware.bookseat.ui.theme.bookedSeats
import com.vmware.bookseat.ui.theme.pay
import com.vmware.bookseat.ui.theme.selectedSeats

@Composable
fun BookSeatScreen(
    seatsList: SeatAvailabilityResponseUiModel,
    viewModel: BookSeatViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 12.dp),
        ) {
            VenueDetailsView(seatsList.venueDetails)
            Spacer(modifier = Modifier.height(4.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                SeatTipView(color = BookedSeat, label = bookedSeats)
                Spacer(modifier = Modifier.height(4.dp))
                SeatTipView(color = UnselectedSeat, label = availableSeats)
                Spacer(modifier = Modifier.height(4.dp))
                SelectedSeatsCount(
                    color = SelectedSeat,
                    label = "$selectedSeats ${seatsList.selectedSeats.count()}",
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 24.dp),
        ) {
            seatsList.categoriesSeats.forEach {
                MovieTicketView(seat = it, viewModel)
            }
        }

        PaymentButton(
            label = "$pay ${seatsList.selectedSeats.map { it.price }.sum()}",
            seatCount = seatsList.selectedSeats.count(),
            onClick = {
            },
        )
    }
}
























