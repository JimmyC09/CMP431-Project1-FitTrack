package com.example.project1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project1.data.WorkoutUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    uiState: WorkoutUiState,
    categories: List<String>,
    onCategoryClick: (String) -> Unit,
    onClearLogs: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "FitTrack")
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(
                text = "Workout Summary",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column {
                        Text(
                            text = "Workouts",
                            style = MaterialTheme.typography.labelLarge
                        )

                        Text(
                            text = uiState.totalWorkouts.toString(),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    Column {
                        Text(
                            text = "Total Minutes",
                            style = MaterialTheme.typography.labelLarge
                        )

                        Text(
                            text = uiState.totalMinutes.toString(),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Choose a Category",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            categories.chunked(2).forEach { rowCategories ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    rowCategories.forEach { category ->

                        Button(
                            onClick = {
                                onCategoryClick(category)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = category)
                        }
                    }

                    if (rowCategories.size == 1) {
                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Recent Activity",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (uiState.workoutHistory.isEmpty()) {

                Text(
                    text = "No workouts logged yet. Select a category above to get started!",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

            } else {

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(
                        items = uiState.workoutHistory,
                        key = { it.id }
                    ) { workout ->

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = workout.exerciseName,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = workout.category,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = "${workout.durationMinutes} minutes",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onClearLogs,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Clear Workout Logs")
            }
        }
    }
}