package com.vmware.bookseat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vmware.bookseat.ui.model.CategoriesSeatsUiModel
import com.vmware.bookseat.ui.model.SeatAvailabilityResponseUiModel
import com.vmware.bookseat.ui.model.SeatStatusUiModel
import com.vmware.bookseat.ui.model.SeatUiModel
import com.vmware.bookseat.ui.model.VenueDetailsUiModel
import com.vmware.bookseat.ui.theme.BookedSeat
import com.vmware.bookseat.ui.theme.SelectedSeat
import com.vmware.bookseat.ui.theme.UnselectedSeat
import timber.log.Timber

@Composable
fun BookSeatScreen(
    seatsList: SeatAvailabilityResponseUiModel,
    viewModel: BookSeatViewModel = hiltViewModel(),
) {
    seatsList.categoriesSeats.forEach { model ->
        for ((row, list) in model.seats) {
            val temp = list.find { it.seatId == "A1" }
            if (temp != null) {
                Timber.d("Changed data BookSeatScreen $temp")
            }
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 12.dp),
        ) {
            VenueDetailsView(seatsList.venueDetails)
            Spacer(modifier = Modifier.height(4.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                SeatTipView(color = BookedSeat, label = "Booked seats")
                Spacer(modifier = Modifier.height(4.dp))
                SeatTipView(color = UnselectedSeat, label = "Available seats")
                Spacer(modifier = Modifier.height(4.dp))
                SelectedSeatsCount(
                    color = SelectedSeat,
                    label = "Selected seats: ",
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
    }
}

@Composable
fun MovieTicketView(
    seat: CategoriesSeatsUiModel,
    viewModel: BookSeatViewModel,
) {
    Row {
        Column {
            CategoryHeader("Seat Row")
            RowView(seat.row)
        }

        Spacer(modifier = Modifier.width(60.dp))
        Column {
            CategoryHeader("${seat.category} - ₹${seat.price}")
            SeatView(seat.seats) { seat ->
                Timber.d("toggleable @@@ 1")
                viewModel.updateSelectedSeats(seat)
            }
        }
    }
}

@Composable
fun SeatView(
    seats: MutableMap<String, List<SeatUiModel>>,
    onSeatClicked: (SeatUiModel) -> Unit,
) {
    for ((row, list) in seats) {
        Timber.d("toggleable @@@ 2")

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

@Composable
fun RowView(row: List<String>) {
    LazyColumn(
        modifier = Modifier.nestedScroll(rememberNestedScrollInteropConnection()),
        userScrollEnabled = true,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 2.dp, vertical = 4.dp),
    ) {
        items(items = row) {
            RowItem(it)
        }
    }
}

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
                    Timber.d("toggleable 1 ###${seat.status}")
                    if (seat.status !is SeatStatusUiModel.Booked) {
                        val changedStatus = SeatStatusUiModel.Available.Selected
//                            if (seat.status is SeatStatusUiModel.Available.Selected) {
//                                SeatStatusUiModel.Available.Unselected
//                            } else {
//                                SeatStatusUiModel.Available.Selected
//                            }
                        Timber.d("toggleable changedStatus $changedStatus")

                        val updatedSeat = seat.copy(status = changedStatus)
                        Timber.d("toggleable updatedSeat $updatedSeat")

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

@Composable
fun RowItem(row: String) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = row,
            style = TextStyle(fontSize = 10.sp),
        )
    }
}

@Composable
fun CategoryHeader(headerLabel: String) {
    Text(
        text = headerLabel,
        style = TextStyle(
            color = Color.Black,
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Start,
        ),
        modifier = Modifier
            .padding(end = 12.dp, top = 20.dp),
    )
}

@Composable
fun VenueDetailsView(venueDetails: VenueDetailsUiModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Location : ${venueDetails.venueName}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Movie Name: ${venueDetails.eventName}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "Show Date : ${venueDetails.showDate}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Show Time : ${venueDetails.showTime}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Total seats : ${venueDetails.totalSeats}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Available seats : ${venueDetails.availableSeats}",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
    }
}

@Composable
fun SelectedSeatsCount(color: Color, label: String) {
    SeatTipItem(color, label)
}

@Composable
fun SeatTipView(color: Color, label: String) {
    SeatTipItem(color, label)
}

@Composable
fun SeatTipItem(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(color),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
    }
}

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(54.dp),
            color = Color.DarkGray,
            strokeWidth = 4.dp,
        )
    }
}

@Composable
fun ErrorView(label: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
        )
    }
}
