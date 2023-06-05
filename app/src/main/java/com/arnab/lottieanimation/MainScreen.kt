package com.arnab.lottieanimation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.arnab.lottieanimation.ui.theme.Green
import com.arnab.lottieanimation.ui.theme.Yellow

@Composable
fun MainScreen() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background))
    val progress by animateLottieCompositionAsState(
        composition = composition, iterations = LottieConstants.IterateForever
    )

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Yellow,
        targetValue = Green,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(390.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.background, MaterialTheme.colors.onSurface, MaterialTheme.colors.onBackground
                    )
                )
            ), contentAlignment = Alignment.TopCenter
    ) {
        // Add your content here
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Add your content here
        }


        // Bottom overlay
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(390.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.onBackground,
                            MaterialTheme.colors.onSurface,
                            MaterialTheme.colors.background,
                        )
                    )
                ), contentAlignment = Alignment.BottomCenter
        ) {
            // Add your content here

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp)
                    .padding(horizontal = 40.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.title),
                    color = Color.White,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.description),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    modifier = Modifier
                        .height(54.dp)
                        .fillMaxWidth(),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = color),
                    shape = CircleShape
                ) {
                    Text(
                        text = "Recipes, Now!",
                        color = Color.Black
                    )
                }

            }
        }
    }
}