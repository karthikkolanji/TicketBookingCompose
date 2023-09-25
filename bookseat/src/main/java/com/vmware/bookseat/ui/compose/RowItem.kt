package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
