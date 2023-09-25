package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

const val MINIMUM_SEAT_SELECTION = 2

@Composable
fun PaymentButton(
    label: String,
    seatCount: Int,
    onClick: () -> Unit,
) {
    val enableButton = seatCount >= MINIMUM_SEAT_SELECTION
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        enabled = enableButton,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Magenta,
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(text = label)
    }
}
