package net.ezra.ui


import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME



@Composable
fun SplashScreen(navController: NavHostController) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }

    // Image

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
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
            )

    ){

       Box (modifier = Modifier
           .height(200.dp)){
           Text("OUT ",

               fontFamily = FontFamily.Cursive,
               fontSize = 50.sp,

               modifier = Modifier
                   .border(
                       5.dp, color = Color.White,
                       shape = RoundedCornerShape(1000.dp),

                       )
                   .padding(40.dp)

           )

       }

        Box(modifier = Modifier
            .height(200.dp),

            ) {
            Text("'N' ",

                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp,

                modifier = Modifier
                    .border(
                        5.dp, color = Color.White,
                        shape = RoundedCornerShape(1000.dp),

                        )
                    .padding(40.dp)




            )
        }
        Box(modifier = Modifier
            .height(200.dp)

        ) {
            Text("ABOUT ",

                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp,

                modifier = Modifier
                    .border(
                        5.dp, color = Color.White,
                        shape = RoundedCornerShape(1000.dp),

                        )
                    .padding(40.dp)



            )
        }



    }




}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    SplashScreen(rememberNavController())
}

