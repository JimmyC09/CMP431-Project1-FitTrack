package com.example.project1

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project1.data.ExerciseData
import com.example.project1.ui.FitTrackViewModel
import com.example.project1.ui.screens.DashboardScreen
import com.example.project1.ui.screens.ExerciseDetailScreen
import com.example.project1.ui.screens.ExerciseListScreen

@Composable
fun FitTrackApp(
    fitTrackViewModel: FitTrackViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState = fitTrackViewModel.uiState

    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {

        composable(route = "dashboard") {
            DashboardScreen(
                uiState = uiState,
                categories = ExerciseData.categories,
                onCategoryClick = { category ->
                    navController.navigate(
                        "exercise_list/$category"
                    )
                },
                onClearLogs = {
                    fitTrackViewModel.clearWorkoutLogs()
                }
            )
        }

        composable(
            route = "exercise_list/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val category =
                backStackEntry.arguments?.getString("category") ?: ""

            ExerciseListScreen(
                category = category,
                onExerciseClick = { exerciseId ->
                    navController.navigate(
                        "exercise_detail/$exerciseId"
                    )
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "exercise_detail/{exerciseId}",
            arguments = listOf(
                navArgument("exerciseId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val exerciseId =
                backStackEntry.arguments?.getString("exerciseId") ?: ""

            ExerciseDetailScreen(
                exerciseId = exerciseId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}