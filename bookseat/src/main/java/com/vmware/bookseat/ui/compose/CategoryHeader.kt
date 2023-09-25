package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
