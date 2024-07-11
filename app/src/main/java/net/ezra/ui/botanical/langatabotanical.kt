package net.ezra.ui.botanical






import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_DINNERS
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_TEAMBUILDING
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.ui.home.BottomBar
import net.ezra.ui.home.HomeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LangatabotanicalScreen(navController:NavHostController){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Out 'n' About", fontSize = 50.sp, color = Color.Black, fontFamily = FontFamily.Cursive)
                },


                navigationIcon = { IconButton(onClick = { navController.navigate(ROUTE_HOME)})
                {
                    Icon(Icons.Filled.Home, "Home" )


                }},


                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff95D9DF),
                    titleContentColor = Color.White,

                    )

            )
        },

        content ={


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
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.Start
            ) {

                item { Card {
                    Text(text = " This beautiful piece of land is found in Karen -Hardy Road. The manicured lawns are ideal for outdoor activities." +
                            "With a minimum charge of 500pp, the large area can be yours to create memories in. The management allows the visitors to bring in their food of choice or they can also order from the Restaurant within." +
                            "You can also be treated with a guided tour of the botanical life within the gardens as the Cherry on top. " )



                } }








            }



        },

        bottomBar = { BottomBar(navController = navController) }


    )}

@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xff42C4B6)


    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Add,"", tint = Color.White)
        },
            label = { Text(text = "Home",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {navController.navigate(
                ROUTE_ADD_PRODUCT)

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


















