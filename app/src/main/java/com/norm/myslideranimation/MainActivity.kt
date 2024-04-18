package com.norm.myslideranimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.norm.myslideranimation.ui.theme.MySliderAnimationTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySliderAnimationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var value by remember {
                        mutableFloatStateOf(0f)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Slider(
                            value = value,
                            onValueChange = {
                                value = it
                            },
                            track = { sliderPositions ->
                                SliderDefaults.Track(
                                    sliderPositions = sliderPositions,
                                    modifier = Modifier.pulsatingEffect(
                                        currentValue = value,
                                        isVisible = true,
                                        color = Color.Gray,
                                    )
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                        )
                    }
                }
            }
        }
    }
}