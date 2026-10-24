package com.example.project1.data

data class Exercise(
    val id: String,
    val name: String,
    val category: String,
    val difficulty: String,
    val preview: String,
    val instructions: List<String>,
    val recommendedDuration: Int
)

data class WorkoutLog(
    val id: Long,
    val exerciseName: String,
    val category: String,
    val durationMinutes: Int
)

data class WorkoutUiState(
    val totalWorkouts: Int = 0,
    val totalMinutes: Int = 0,
    val workoutHistory: List<WorkoutLog> = emptyList(),
    val durationInput: String = "",
    val showSuccessDialog: Boolean = false
)