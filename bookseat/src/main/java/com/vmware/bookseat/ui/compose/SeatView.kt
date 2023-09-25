package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.vmware.bookseat.ui.model.SeatUiModel

@Composable
fun SeatView(
    seats: MutableMap<String, List<SeatUiModel>>,
    onSeatClicked: (SeatUiModel) -> Unit,
) {
    for ((row, list) in seats) {
        LazyRow(
            userScrollEnabled = true,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp),
        ) {
            items(items = list, key = {
                it.seatId
            }) {
                SeatItem(seat = it, onSeatClicked = onSeatClicked)
            }
        }
    }
}
