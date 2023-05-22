package com.example.swipeup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.swipeup.ui.theme.SwipeUpTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeUpTheme {
                val viewModel = viewModel<MainViewModel>()
                val isLoading by viewModel.isLoading.collectAsState()
                val swipeRefreshState= rememberSwipeRefreshState(isRefreshing=isLoading)
                SwipeRefresh(state = swipeRefreshState, onRefresh = viewModel::loadStuff,
                indicator = {
                    state, refreshTrigger ->
                    SwipeRefreshIndicator(state = state, refreshTriggerDistance = refreshTrigger,
                    backgroundColor = Color.Blue,
                    contentColor = Color.DarkGray)
                }
                ) {
                    
                }
                SwipeRefresh(state = swipeRefreshState, onRefresh = viewModel:: loadStuff) {
                    LazyColumn(modifier = Modifier.fillMaxSize())
                    {
                        items(count = 100){
                            Text(text = "test me", modifier = Modifier
                                .fillMaxSize()
                                .padding(32.dp))
                        }
                    }
                    
                }

            }
        }
    }
}

