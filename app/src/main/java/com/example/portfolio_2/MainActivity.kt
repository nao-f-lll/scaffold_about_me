package com.example.portfolio_2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio_2.ui.theme.Portfolio_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Portfolio_2Theme {
                Scaffold()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val itemsList = listOf(
        "Education" to "Software Engineering",
        "Sport" to "Something",
        "Favourite Food" to "I don't know",
        "Hobby" to "Some random data"
    )

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray
                ),
                title = { Text(text = "Sobre me", color = Color.White) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Share, contentDescription = "compartir")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Gray,
            ) {
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(id = R.drawable.github),
                        contentDescription = "Favorite",
                    )
                }
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(id = R.drawable.reddit), contentDescription = "Reddit")
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Rounded.Favorite, contentDescription = "email")
            }
        }
    ) { innerPadding: PaddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "me",
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        text = "Naoufal Lyamani"
                    )
                    Text(
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        text = "I'm someone who lives somewhere in the planet earth"
                    )
                }

                items(itemsList.size) { index ->
                    val (title, description) = itemsList[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = title,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = description,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun Scaffold_preview() {
    Portfolio_2Theme {
        Scaffold()
    }
}
