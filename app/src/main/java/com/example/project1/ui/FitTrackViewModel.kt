package com.example.project1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.project1.data.Exercise
import com.example.project1.data.WorkoutLog
import com.example.project1.data.WorkoutUiState

class FitTrackViewModel : ViewModel() {

    var uiState by mutableStateOf(WorkoutUiState())
        private set

    private var nextWorkoutId = 1L

    fun onDurationChange(newDuration: String) {
        uiState = uiState.copy(
            durationInput = newDuration
        )
    }

    fun logWorkout(exercise: Exercise) {
        val duration = uiState.durationInput.toIntOrNull()

        if (duration == null || duration <= 0) {
            return
        }

        val newWorkout = WorkoutLog(
            id = nextWorkoutId++,
            exerciseName = exercise.name,
            category = exercise.category,
            durationMinutes = duration
        )

        uiState = uiState.copy(
            totalWorkouts = uiState.totalWorkouts + 1,
            totalMinutes = uiState.totalMinutes + duration,
            workoutHistory = listOf(newWorkout) + uiState.workoutHistory,
            durationInput = "",
            showSuccessDialog = true
        )
    }

    fun clearWorkoutLogs() {
        uiState = uiState.copy(
            totalWorkouts = 0,
            totalMinutes = 0,
            workoutHistory = emptyList()
        )
    }

    fun dismissSuccessDialog() {
        uiState = uiState.copy(
            showSuccessDialog = false
        )
    }

    fun resetLogger() {
        uiState = uiState.copy(
            durationInput = "",
            showSuccessDialog = false
        )
    }
}