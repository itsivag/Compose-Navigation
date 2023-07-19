package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "nav_route") {
                    navigation(
                        startDestination = "page_1",
                        route = "nav_route"
                    ) {

                        composable(route = "page_1") {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Button(
                                    onClick = { navController.navigate("page_2") },
                                    modifier = Modifier.align(CenterHorizontally)
                                ) {
                                    Text(text = "Click To Navigate")
                                }
                            }

                        }

                        composable(route = "page_2") {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.Cyan)
                            ) {

                                Text(
                                    text = "Success", modifier = Modifier.align(CenterHorizontally)
                                )

                                Button(
                                    onClick = { navController.navigate("page_1") },
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(text = "Go Back")
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
