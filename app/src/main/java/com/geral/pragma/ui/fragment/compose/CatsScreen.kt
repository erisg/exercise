package com.geral.pragma.ui.fragment.compose

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.geral.pragma.domain.Cat

@Composable
fun CatsScreen(cats: List<Cat>) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {
        items(cats) { cat ->
            CatItemScreen(cat = cat)
        }
    }
}
