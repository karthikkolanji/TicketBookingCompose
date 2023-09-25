package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vmware.bookseat.ui.model.VenueDetailsUiModel

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
