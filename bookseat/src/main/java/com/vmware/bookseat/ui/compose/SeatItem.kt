package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vmware.bookseat.ui.model.SeatStatusUiModel
import com.vmware.bookseat.ui.model.SeatStatusUiModel.Available.Selected
import com.vmware.bookseat.ui.model.SeatStatusUiModel.Available.Unselected
import com.vmware.bookseat.ui.model.SeatUiModel

@Composable
fun SeatItem(
    seat: SeatUiModel,
    onSeatClicked: (SeatUiModel) -> Unit,
) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .toggleable(
                value = true,
                onValueChange = {
                    if (seat.status !is SeatStatusUiModel.Booked) {
                        val updatedSeat = seat.copy(status = seat.status.toggleStatus())
                        onSeatClicked(updatedSeat)
                    }
                },
            )
            .background(seat.status.color),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = seat.seatNumber,
            style = TextStyle(fontSize = 10.sp),
        )
    }
}

fun SeatStatusUiModel.toggleStatus() = if (this is Selected) {
    Unselected
} else {
    Selected
}
