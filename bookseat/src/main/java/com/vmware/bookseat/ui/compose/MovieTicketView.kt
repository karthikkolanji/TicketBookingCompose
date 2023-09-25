package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vmware.bookseat.ui.BookSeatViewModel
import com.vmware.bookseat.ui.model.CategoriesSeatsUiModel
import com.vmware.bookseat.ui.theme.seatRow

@Composable
fun MovieTicketView(
    seat: CategoriesSeatsUiModel,
    viewModel: BookSeatViewModel,
) {
    Row() {
        Column {
            CategoryHeader(seatRow)
            RowView(seat.row)
        }

        Spacer(modifier = Modifier.width(34.dp))
        Column {
            CategoryHeader("${seat.category} - ₹${seat.price}")
            SeatView(seat.seats) { seat ->
                viewModel.updateSelectedSeats(seat)
            }
        }
    }
}
