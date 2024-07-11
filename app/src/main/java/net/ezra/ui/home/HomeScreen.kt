package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_DINNERS
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_PICNICS
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_TEAMBUILDING
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.navigation.ROUTE_VIEW_STUDENTS
import net.ezra.ui.dashboard.DashboardScreen


data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Out 'n' About", fontSize = 50.sp, color = Color.Black, fontFamily = FontFamily.Cursive)
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
//                            Icon(
//                                Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.Black
//                                )
                        }
                    }
                },

                actions = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff95D9DF),
                    titleContentColor = Color.White,

                )

            )
        },

        content = @Composable {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }
            ) {}


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



//                    item {  Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_PICNICS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "PICNICS",
//                        textAlign = TextAlign.Center,
//                        fontSize = 50.sp,
//                        color = Color.Black,
//                        textDecoration = TextDecoration.Underline,
//                        style = TextStyle(shadow = Shadow(color = Color.Gray, offset = Offset(5f,5f), blurRadius = 5f) )
//                    )}
// item { Spacer(modifier = Modifier.height(30.dp))}

                    item {  Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_DINNERS) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                        text = "DINNER DATES",
                        textAlign = TextAlign.Center,
                        fontSize = 50.sp,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        style = TextStyle(shadow = Shadow(color = Color.Gray, offset = Offset(5f,5f), blurRadius = 5f) )
                    )}
                    item { Spacer(modifier = Modifier.height(30.dp))}


                    item {  Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_TEAMBUILDING) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                        text = "TEAM BUILDING",
                        textAlign = TextAlign.Center,
                        fontSize = 50.sp,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        style = TextStyle(shadow = Shadow(color = Color.Gray, offset = Offset(5f,5f), blurRadius = 5f) )
                    )}
                    item { Spacer(modifier = Modifier.height(30.dp))}
//
//                   item {   Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_VIEW_PROD) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "View Event",
//                        textAlign = TextAlign.Center,
//                        fontSize = 10.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )}






                }



        },

        bottomBar = { BottomBar(navController = navController) }







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp)
            ,
        color = Color.LightGray,
//        elevation = 16.dp
    ) {
        Column {
            Text(
                text = "Drawer Item 1"

            )
            Text(
                text = "Drawer Item 2"
            )

        }
    }
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
   HomeScreen(rememberNavController())
}