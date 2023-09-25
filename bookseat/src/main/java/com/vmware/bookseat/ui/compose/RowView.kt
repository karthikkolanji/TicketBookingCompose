package com.vmware.bookseat.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RowView(row: List<String>) {
    LazyColumn(
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 2.dp, vertical = 4.dp),
    ) {
        items(items = row) {
            RowItem(it)
        }
    }
}
