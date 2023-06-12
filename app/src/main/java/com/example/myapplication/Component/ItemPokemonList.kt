package com.example.myapplication.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.myapplication.Navigation.MainActions
import com.example.myapplication.R
import com.example.myapplication.Utils.parseStatToColor
import com.example.myapplication.Utils.parseTypeToColor
import com.example.myapplication.ui.theme.*
import java.util.*


@Composable
fun ItemPokemonList(name: String, imageURL: String, type: List<String>, onItemClick : () -> Unit) {


    Card(modifier = Modifier
        .clickable(onClick = onItemClick)
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colors.background)
        .padding(8.dp),
    )

    {

        Row(modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    listOf(
                        Color.Transparent,
                        parseTypeToColor(type[0])
                    )
                )
            ),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {

            Image(
                    painter = rememberImagePainter(
                    data = imageURL,
                    builder = {

                        transformations()
                    }
                ),

                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(12.dp)

            )

            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start
            ) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                style = typography.h6,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Start

            )
            Spacer(modifier = Modifier.size(12.dp))

                Spacer(modifier = Modifier.size(10.dp))
                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.Start
                ) {

                    type.forEach {

                        ChipView(types = it)
                        Spacer(modifier = Modifier.padding(top = 7.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ChipView(types: String) {
    Box(
        modifier = Modifier

            .clip(shape = Shapes.large)
            .background(parseTypeToColor(types))
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    
    ) {

        Text(
            text = types.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
            style = typography.caption,
            fontWeight = FontWeight.Bold,
            color = Color.White,

            )
    }
    Spacer(modifier = Modifier.padding(horizontal = 7.dp))
}

@Composable
fun TopBar(name:String, action: MainActions){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.text_back_button),
            modifier = Modifier.clickable(onClick = action.upPress))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = name, style = typography.h5, color = MaterialTheme.colors.onSurface)
    }

}
@Composable
fun LabelView(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.caption,
        textAlign = TextAlign.Start,
        color = MaterialTheme.colors.primary
    )
}

@ExperimentalComposeUiApi
@Composable
fun TextInputField(label: String, value: String, onValueChanged: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Box {
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
            value = value,
            onValueChange = {
                onValueChanged(it)
            },
            label = { LabelView(title = label) },
            textStyle = MaterialTheme.typography.body1,
            colors = textFieldColors(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ))

    }

}
@Composable
fun TypeFilterChip(
    typeP:String,

    onValueChanged: (String) -> Unit

){
    Surface(
        modifier = Modifier
            .padding(end = 8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,

    ){
        Row(modifier = Modifier
            .clickable(onClick = {
                onValueChanged(typeP)
            })
        ) {
            Text(
                text = typeP.capitalize(),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun textFieldColors() = TextFieldDefaults.textFieldColors(
    textColor = MaterialTheme.colors.primary,
    focusedLabelColor = MaterialTheme.colors.primary,
    focusedIndicatorColor = MaterialTheme.colors.primary,
    unfocusedIndicatorColor = MaterialTheme.colors.primary,
    cursorColor = MaterialTheme.colors.primary,
    placeholderColor = MaterialTheme.colors.primary,
    disabledPlaceholderColor = MaterialTheme.colors.primary
)

