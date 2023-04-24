package com.geral.pragma.ui.fragment.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geral.pragma.domain.Cat

@Composable
fun CatItemScreen(cat: Cat) {
    Column {
        Text(
            text = cat.breedName,
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 18.sp,
            color = black
        )
        Text(
            text = cat.origin,
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 18.sp,
            color = black
        )

        Text(
            text = cat.intelligence,
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 18.sp,
            color = black
        )
    }
}

@Composable
@Preview
fun InstallBeforeTripPreview() {
    PragmaTheme() {
    }
}
