package com.example.myapplication.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.myapplication.Navigation.MainActions
import com.example.myapplication.R
import com.example.myapplication.Utils.parseTypeToColor
import com.example.myapplication.ui.theme.*
import java.lang.reflect.Type
import java.util.*


@Composable
fun ItemPokemonList(name: String, imageURL: String, type: List<String>, onItemClick : () -> Unit) {


    Card(modifier = Modifier
        .clickable(onClick = onItemClick)
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.background)
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
                style = typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
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
            style = typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,

            )
    }
    Spacer(modifier = Modifier.padding(horizontal = 7.dp))
}

@Composable
fun TopBar(name: String, action: MainActions){

    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.text_back_button),
                modifier = Modifier.clickable(onClick = action.upPress))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = name, style = typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}
@Composable
fun LabelView(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
        textAlign = TextAlign.Start,
        color = MaterialTheme.colorScheme.primary
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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
            textStyle = MaterialTheme.typography.labelSmall,
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

        shape = MaterialTheme.shapes.medium,

    ){
        Row(modifier = Modifier
            .clickable(onClick = {
                onValueChanged(typeP)
            })
        ) {
            Text(
                text = typeP.capitalize(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textFieldColors() = TextFieldDefaults.textFieldColors(
    textColor = MaterialTheme.colorScheme.primary,
    focusedLabelColor = MaterialTheme.colorScheme.primary,
    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
    cursorColor = MaterialTheme.colorScheme.primary,
    placeholderColor = MaterialTheme.colorScheme.primary,
    disabledPlaceholderColor = MaterialTheme.colorScheme.primary
)

