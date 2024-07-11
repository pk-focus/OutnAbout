package net.ezra.ui.teambuilding

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.ui.dinnerdates.DinnerdateScreen
import net.ezra.ui.home.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeambuildingScreen(navController:NavHostController){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "TEAM BUILDING DESTINATIONS", fontSize = 20.sp, color = Color.Black, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
                },
                navigationIcon = { IconButton(onClick = { navController.navigate(ROUTE_HOME)})
                {
                    Icon(Icons.Filled.Home, "Home" )


                }
                },



                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff95D9DF),
                    titleContentColor = Color.White,

                    )

            )
        },

        content =  {



            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xff34C9D8),
                                Color(0xff54F0DF),
                                Color(0xff34C9D8),
                                Color(0xff18A495),

                                )
                        )
                    ),
                verticalArrangement = Arrangement.Top ,
                horizontalAlignment = Alignment.Start
            ) {
item { Spacer(modifier = Modifier.height(80.dp)) }
                item {
                    Card {

                        Image(
                            painter = painterResource(id = R.drawable.langatabotanical),
                            contentDescription = "langata",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Transparent)

                        )
                        Text(
                            text = "Langata Botanical Garden",
                            fontSize = 20.sp
                        )


                    }
                }

                item { Spacer(modifier = Modifier.height(20.dp)) }
                item {
                    Card {

                        Image(
                            painter = painterResource(id = R.drawable.rcsagana),
                            contentDescription = "Rapids ",
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = "Rapids Camp Sagana",
                            fontSize = 20.sp
                        )


                    }
                }

                item { Spacer(modifier = Modifier.height(20.dp)) }

                item {
                    Card {

                        Image(
                            painter = painterResource(id = R.drawable.lnaivasha2),
                            contentDescription = "lakeNaivasha",
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = "Lake Naivasha Resort",
                            fontSize = 20.sp
                        )


                    }
                }

                item { Spacer(modifier = Modifier.height(20.dp)) }



                item {
                    Card {

                        Image(
                            painter = painterResource(id = R.drawable.tafaria3),
                            contentDescription = "Tafaria Castle",
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = "Tafaria Castle",
                            fontSize = 20.sp
                        )


                    }
                }

                item { Spacer(modifier = Modifier.height(20.dp)) }





            }



        },

        bottomBar = { BottomBar(navController = navController) }


    )
    

}

@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xff42C4B6)


    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
        },
            label = { Text(text = "Home",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"",tint = Color.White)
        },
            label = { Text(text = "Favorite",color =  Color.White) }, selected = (selectedIndex.value == 1), onClick = {

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.List, "",tint = Color.White)
        },
            label = { Text(
                text = "Calendrier",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_VIEW_PROD) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    TeambuildingScreen(rememberNavController())
}