package com.example.project1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.project1.data.Exercise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseDetailScreen(
    exercise: Exercise,
    durationInput: String,
    showSuccessDialog: Boolean,
    onDurationChange: (String) -> Unit,
    onLogWorkout: () -> Unit,
    onDismissDialog: () -> Unit,
    onBackClick: () -> Unit
) {
    val durationValue = durationInput.toIntOrNull()

    val isDurationValid =
        durationValue != null && durationValue > 0

    val errorMessage = when {
        durationInput.isEmpty() ->
            "Duration is required."

        durationValue == null ->
            "Enter a valid number."

        durationValue <= 0 ->
            "Duration must be greater than 0."

        else ->
            ""
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = exercise.name)
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Surface(
                shape = MaterialTheme.shapes.small,
                color = when (exercise.difficulty) {
                    "Beginner" ->
                        MaterialTheme.colorScheme.secondaryContainer

                    "Intermediate" ->
                        MaterialTheme.colorScheme.tertiaryContainer

                    else ->
                        MaterialTheme.colorScheme.errorContainer
                }
            ) {
                Text(
                    text = exercise.difficulty,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    ),
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = exercise.preview,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Recommended Duration",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${exercise.recommendedDuration} minutes",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Instructions",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                exercise.instructions.forEachIndexed { index, instruction ->

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "${index + 1}. $instruction",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Log Your Workout",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = durationInput,
                onValueChange = onDurationChange,
                label = {
                    Text(text = "Duration (Minutes)")
                },
                singleLine = true,
                isError = !isDurationValid,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                supportingText = {
                    if (!isDurationValid) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onLogWorkout,
                enabled = isDurationValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log Completed Workout")
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    if (showSuccessDialog) {

        AlertDialog(
            onDismissRequest = onDismissDialog,
            title = {
                Text(text = "Workout Logged!")
            },
            text = {
                Text(
                    text = "${exercise.name} was successfully added to your workout history."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = onDismissDialog
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}