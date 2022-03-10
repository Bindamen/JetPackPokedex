package com.example.myapplication.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Utils.parseTypeToColor
import com.example.myapplication.View.AbilityDetails



@Composable
fun PokemonTech(

    type: List<String>,
    AbilityName: String,
    AbilityDesc: String

) {
    //AbilityDetails(viewModel = viewModel())


    Column(modifier = Modifier.padding(24.dp)) {
        Row(modifier = Modifier.align(Alignment.Start)) {
            Text(
                text = AbilityName,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                color = parseTypeToColor(type[0])

            )

        }
        Row(modifier = Modifier.padding(horizontal = 15.dp).align(Alignment.Start)) {
            Text(
                text = AbilityDesc,
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.padding(7.dp))
    }
}