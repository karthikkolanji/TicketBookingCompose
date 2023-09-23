package com.vmware.bookseat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vmware.bookseat.ui.model.CategoriesSeatsUiModel
import com.vmware.bookseat.ui.model.SeatUiModel

@Composable
fun BookSeatScreen(
    modifier: Modifier = Modifier,
    categoriesSeatList: List<CategoriesSeatsUiModel>,
) {
    Column(
        modifier = Modifier.padding(horizontal = 0.dp, vertical = 154.dp).fillMaxSize(),
    ) {
        categoriesSeatList.forEach {
            MovieTicketView(seat = it)
        }
    }
}

@Composable
fun MovieTicketView(seat: CategoriesSeatsUiModel) {
    Row {
        Column {
            CategoryHeader("")
            RowView(seat.row)
        }

        Spacer(modifier = Modifier.width(60.dp))
        Column {
            CategoryHeader("${seat.category} - ${seat.price}")
            SeatView(seat.seats)
        }
    }
}

@Composable
fun SeatView(seats: List<SeatUiModel>) {
    LazyVerticalGrid(
        userScrollEnabled = false,
        columns = GridCells.Fixed(10),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
    ) {
        items(items = seats) {
            SeatItem(seat = it)
        }
    }
}

@Composable
fun SeatItem(seat: SeatUiModel) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = seat.seatNumber,
            style = TextStyle(fontSize = 10.sp),
        )
    }
}

@Composable
fun RowView(row: List<String>) {
    LazyColumn(
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp),
    ) {
        items(items = row) {
            RowItem(it)
        }
    }
}

@Composable
fun RowItem(row: String) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color.Gray),
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

// @Preview
// @Composable
// fun PreviewSeatTempItem() {
//    MovieTicketView(seatList)
// }
