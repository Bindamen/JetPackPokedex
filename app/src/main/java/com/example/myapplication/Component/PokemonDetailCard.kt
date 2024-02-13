package com.example.myapplication.Component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication.Model.Abilities
import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.R
import com.example.myapplication.Utils.parseGenToId
import com.example.myapplication.Utils.parseStatToAbbr
import com.example.myapplication.Utils.parseTypeToColor
import java.util.*


@Composable
fun PokemonDetailCard(
    name: String,
    type: List<String>,
    imageURL: String,
    weight: Double,
    height: Double,
    id: Int,
    hp: Int,
    attack: Int,
    BaseTotal: Int,
    Defense: Int,
    SpDefense: Int,
    Speed: Int,
    SpAttack: Int,
    against_acier: Double,
    against_combat: Double,
    against_eau: Double,
    against_dragon: Double,
    against_fée: Double,
    against_electric: Double,
    against_feu: Double,
    against_glace: Double,
    against_insecte: Double,
    against_normal: Double,
    against_plante: Double,
    against_poison: Double,
    against_psy: Double,
    against_roche: Double,
    against_sol: Double,
    against_spectre: Double,
    against_ténèbres: Double,
    against_vol: Double,
    Gen: Int,
    Male: Double,
    Female: Double,
    Game: String,
    Region: String,




) {

// Transparent white bg
    Box(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        parseTypeToColor(type[0]),
                        parseTypeToColor(type[0]),
                        parseTypeToColor(type[0]),
                        parseTypeToColor(type[0])

                    )
                )
            )
            .padding(start = 20.dp, end = 16.dp, top = 40.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {

 //white box layout
        Box(
            Modifier

                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .padding(bottom = 50.dp),
        ) {
            PokemonImageContentView(
                name,
                imageURL,
                id,
                type,
                height,
                weight,
                hp,
                attack,
                Defense,
                SpAttack,
                SpDefense,
                Speed,
                BaseTotal,
                against_acier,
                against_combat,
                against_dragon,
                against_eau,
                against_fée,
                against_electric,
                against_feu,
                against_glace,
                against_insecte,
                against_normal,
                against_plante,
                against_poison,
                against_psy,
                against_roche,
                against_sol,
                against_spectre,
                against_ténèbres,
                against_vol,
                Gen,
                Male,
                Female,
                Game,
                Region,

            )
      }
    }
}



@Composable
fun   PokemonImageContentView(
    name: String,
    imageURL: String,
    id: Int,
    type: List<String>,
    height: Double,
    weight: Double,
    hp: Int,
    attack: Int,
    Defense: Int,
    SpDefense: Int,
    Speed: Int,
    SpAttack: Int,
    BaseTotal: Int,
    against_acier: Double,
    against_eau: Double,
    against_dragon: Double,
    against_combat: Double,
    against_fée: Double,
    against_electric: Double,
    against_feu: Double,
    against_glace: Double,
    against_insecte: Double,
    against_normal: Double,
    against_plante: Double,
    against_poison: Double,
    against_psy: Double,
    against_roche: Double,
    against_sol: Double,
    against_spectre: Double,
    against_ténèbres: Double,
    against_vol: Double,
    Gen: Int,
    Male: Double,
    Female: Double,
    Game: String,
    Region: String,


) {
// content
    Column(
        modifier = Modifier
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
//image
        Image(
            painter = rememberImagePainter(
                data = imageURL
            ),

            contentDescription = name,
            modifier = Modifier
                .size(250.dp)
                .padding(start = 2.dp, end = 2.dp, bottom = 2.dp),
            alignment = Alignment.TopCenter
        )

        Spacer(modifier = Modifier.height(2.dp))
        Column(
            modifier = Modifier
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#${id} ${
                    name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                }",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 10.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
            ) {

                for (type in type) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                            .clip(CircleShape)
                            .background(parseTypeToColor(type))
                            .height(35.dp)
                    ) {
                        Text(
                            text = type.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            PokemonDetailDataSection(weight, height)
            PokemonBaseStats(hp, attack, SpDefense, SpAttack, Speed, Defense, BaseTotal, type)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Description",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            PokemonDescription(Gen)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Faiblesses",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.padding(2.dp))
            PokemonWeaknesses(against_acier,against_combat, against_dragon, against_eau, against_electric, against_fée,
                against_feu, against_glace, against_insecte, against_normal, against_plante, against_poison, against_psy,
                against_roche, against_sol, against_spectre, against_ténèbres, against_vol,

                )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Techniques",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

           PokemonTech(viewModel = viewModel(), type = type,id)
            //AbilityView(viewModel = viewModel(), type = type,id)




            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Caractéristiques",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.padding(2.dp))
            PokemonCarac(type, Male, Female, Game, Region)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Shiny",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.padding(2.dp))
            ShinyPokemonPic(id)
        }
    }
}




@Composable
fun PokemonCarac(
    type: List<String>,
    Male: Double,
    Female: Double,
    Game: String,
    Region: String
) {
    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.Start


        ) {

        Spacer(modifier = Modifier.padding(7.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(

                painter = painterResource(id = R.drawable.ic_baseline_videogame_asset_24),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(24.dp),
                alignment = Alignment.TopStart,
                
            )

            Spacer(modifier = Modifier.padding(7.dp))
            Column{
                
                Text(
                    text = "Jeux:",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = parseTypeToColor(type[0]),
                    modifier = Modifier.padding(horizontal = 10.dp))
                Row {
                    Text(
                        text = Game.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                }
                Spacer(modifier = Modifier.fillMaxWidth())
            }
        }
        Spacer(modifier = Modifier.padding(7.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_public_24),

                contentDescription = "",
                modifier = Modifier

                    .align(Alignment.CenterVertically)
                    .size(24.dp)
                   ,
                alignment = Alignment.CenterStart,)
            Spacer(modifier = Modifier.padding(7.dp))
            Column{
                Text(
                    text = "Région d'origine:",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = parseTypeToColor(type[0]),
                    modifier = Modifier.padding(horizontal = 10.dp))
                Row {
                    Text(
                        text = Region.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.padding(7.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_catching_pokemon_24),

                contentDescription = "",
                modifier = Modifier

                    .align(Alignment.CenterVertically)
                    .size(24.dp),
                alignment = Alignment.CenterStart,


                )
            Spacer(modifier = Modifier.padding(7.dp))
            Column{
                Text(
                    text = "Genre:",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = parseTypeToColor(type[0]),
                    modifier = Modifier.padding(horizontal = 10.dp))
                Row {
                    Text(
                        text = "$Male%",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.male),
                        contentDescription = "",

                        Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Text(
                        text = "$Female%",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.female),
                        contentDescription = "",
                        Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun PokemonDetailDataSection(
    weight: Double,
    height: Double,
    sectionHeight: Dp = 80.dp
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PokemonDetailDataItem(
            dataValue = weight,
            dataUnit = " kg",
            dataIcon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray)
        )

        PokemonDetailDataItem(
            dataValue = height,
            dataUnit = " m",
            dataIcon = painterResource(id = R.drawable.ic_height),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PokemonDetailDataItem(
    dataValue: Double,
    dataUnit: String,
    dataIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            painter = dataIcon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$dataValue$dataUnit",
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 25.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

// Text(text = statName)

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF505050)
                } else {
                    Color.LightGray
                }
            ),

        ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                textAlign = TextAlign.Right,
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)

            )

            Text(
                text = statName,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)

            )

        }

    }


}

@Composable
fun PokemonBaseStats(
    hp: Int,
    Speed: Int,
    SpAttack: Int,
    SpDefense: Int,
    Attack: Int,
    Defense: Int,
    BaseTotal: Int,
    type: List<String>,
    animDelayPerItem: Int = 1
) {


    Column(
        modifier = Modifier.padding(start = 7.dp, end = 7.dp)
    ) {
        Text(
            text = "Base Stat:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(7.dp))


        PokemonStat(

            statName = parseStatToAbbr("HP"),
            statValue = hp,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = hp * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = parseStatToAbbr("Attack"),
            statValue = Attack,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = Attack * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = parseStatToAbbr("Defense"),
            statValue = Defense,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = Defense * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = parseStatToAbbr("SpAttack"),
            statValue = SpAttack,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = SpAttack * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = parseStatToAbbr("SpDefense"),
            statValue = SpDefense,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = SpDefense * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = parseStatToAbbr("Speed"),
            statValue = Speed,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = Speed * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
        PokemonStat(
            statName = "BaseTotal",
            statValue = BaseTotal,
            statMaxValue = BaseTotal/3,
            statColor = parseTypeToColor(type[0]),
            animDelay = 200 * animDelayPerItem
        )
        Spacer(modifier = Modifier.height(7.dp))
    }
}

@Composable
fun ShinyPokemonPic(
    id: Int
) {
    Column(
    )
    {
        Image(
            painter = rememberImagePainter(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/shiny/$id.png"
            ),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .fillMaxSize(),
            alignment = Alignment.TopCenter
        )
        Spacer(modifier = Modifier.fillMaxHeight())
    }
}

@Composable
fun PokemonWeaknesses(
    against_acier: Double,
    against_combat: Double,
    against_dragon: Double,
    against_eau: Double,
    against_electric: Double,
    against_fée: Double,
    against_feu: Double,
    against_glace: Double,
    against_insecte: Double,
    against_normal: Double,
    against_plante: Double,
    against_poison: Double,
    against_psy: Double,
    against_roche: Double,
    against_sol: Double,
    against_spectre: Double,
    against_ténèbres: Double,
    against_vol: Double

) {

    Row {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_steel_icon),
                    contentDescription = "Acier",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                when {
                    against_acier > 1.0 -> {
                        Text(
                            text = "X $against_acier",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Red
                        )
                    }
                    against_acier < 1.0 -> {
                        Text(
                            text = "X $against_acier",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Green
                        )
                    }
                    else -> {
                        Text(
                            text = "X $against_acier",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fighting_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                when {
                    against_combat > 1.0 -> {
                        Text(
                            text = "X $against_combat",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Red
                        )
                    }
                    against_combat < 1.0 -> {
                        Text(
                            text = "X $against_combat",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Green
                        )
                    }
                    else -> {
                        Text(
                            text = "X $against_combat",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_water_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_eau > 1.0) {
                    Text(
                        text = "X $against_eau",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_eau < 1.0) {
                    Text(
                        text = "X $against_eau",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_eau",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dragon_icon),
                    contentDescription = "Dragon",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_dragon > 1.0) {
                    Text(
                        text = "X $against_dragon",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_dragon < 1.0) {
                    Text(
                        text = "X $against_dragon",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_dragon",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }


            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_electric_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_electric > 1.0) {
                    Text(
                        text = "X $against_electric",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_electric < 1.0) {
                    Text(
                        text = "X $against_electric",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_electric",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fairy_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_fée > 1.0) {
                    Text(
                        text = "X $against_fée",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_fée < 1.0) {
                    Text(
                        text = "X $against_fée",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_fée",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fire_icon),
                    contentDescription = "Fire",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_feu > 1.0) {
                    Text(
                        text = "X $against_feu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_feu < 1.0) {
                    Text(
                        text = "X $against_feu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_feu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ice_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_glace > 1.0) {
                    Text(
                        text = "X $against_glace",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_glace < 1.0) {
                    Text(
                        text = "X $against_glace",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_glace",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bug_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_insecte > 1.0) {
                    Text(
                        text = "X $against_insecte",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_insecte < 1.0) {
                    Text(
                        text = "X $against_insecte",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_insecte",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_normal_icon),
                    contentDescription = "Acier",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_normal > 1.0) {
                    Text(
                        text = "X $against_normal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_normal < 1.0) {
                    Text(
                        text = "X $against_normal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_normal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_grass_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_plante > 1.0) {
                    Text(
                        text = "X $against_plante",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_plante < 1.0) {
                    Text(
                        text = "X $against_plante",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_plante",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_poison_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_poison > 1.0) {
                    Text(
                        text = "X $against_poison",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_poison < 1.0) {
                    Text(
                        text = "X $against_poison",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_poison",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_psychic_icon),
                    contentDescription = "Acier",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_psy > 1.0) {
                    Text(
                        text = "X $against_psy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_psy < 1.0) {
                    Text(
                        text = "X $against_psy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_psy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_rock_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_roche > 1.0) {
                    Text(
                        text = "X $against_roche",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_roche < 1.0) {
                    Text(
                        text = "X $against_roche",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_roche",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ghost_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_spectre > 1.0) {
                    Text(
                        text = "X $against_spectre",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_spectre < 1.0) {
                    Text(
                        text = "X $against_spectre",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_spectre",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ground_icon),
                    contentDescription = "Acier",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_sol > 1.0) {
                    Text(
                        text = "X $against_sol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_sol < 1.0) {
                    Text(
                        text = "X $against_sol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_sol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_dark_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()

                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_ténèbres > 1.0) {
                    Text(
                        text = "X $against_ténèbres",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_ténèbres < 1.0) {
                    Text(
                        text = "X $against_ténèbres",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_ténèbres",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
            Row(modifier = Modifier.padding(4.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_flying_icon),
                    contentDescription = "Fighting",
                    modifier = Modifier
                        .size(40.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                if (against_vol > 1.0) {
                    Text(
                        text = "X $against_vol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Red
                    )
                } else if (against_vol < 1.0) {
                    Text(
                        text = "X $against_vol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Color.Green
                    )
                } else {
                    Text(
                        text = "X $against_vol",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonDescription(
    Gen: Int,

) {


    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Génération #$Gen")
        }
        Spacer(modifier = Modifier.padding(7.dp))
        Image(
            painter = painterResource(parseGenToId(Gen)),
            contentDescription = "",
            alignment = Alignment.Center,


        )



        }


    }


