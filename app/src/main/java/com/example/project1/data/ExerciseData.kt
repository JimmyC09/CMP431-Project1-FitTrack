package com.example.project1.data

object ExerciseData {

    val categories = listOf(
        "Strength",
        "Cardio",
        "Flexibility",
        "HIIT"
    )

    val exercises = listOf(

        // Strength
        Exercise(
            id = "classic_pushups",
            name = "Classic Push-ups",
            category = "Strength",
            difficulty = "Beginner",
            preview = "Build chest, shoulder, and arm strength using your body weight.",
            instructions = listOf(
                "Place your hands slightly wider than shoulder-width apart.",
                "Keep your body in a straight line from head to heels.",
                "Lower your chest toward the floor.",
                "Push through your palms to return to the starting position."
            ),
            recommendedDuration = 10
        ),

        Exercise(
            id = "bodyweight_squats",
            name = "Bodyweight Squats",
            category = "Strength",
            difficulty = "Beginner",
            preview = "Strengthen your legs and glutes with a controlled squat movement.",
            instructions = listOf(
                "Stand with your feet about shoulder-width apart.",
                "Keep your chest upright and core engaged.",
                "Lower your hips as if sitting into a chair.",
                "Push through your feet to return to standing."
            ),
            recommendedDuration = 12
        ),

        Exercise(
            id = "forearm_plank",
            name = "Forearm Plank",
            category = "Strength",
            difficulty = "Intermediate",
            preview = "Strengthen your core by holding a stable plank position.",
            instructions = listOf(
                "Place your forearms on the floor with elbows below your shoulders.",
                "Extend your legs behind you.",
                "Keep your body in a straight line.",
                "Brace your core and hold the position."
            ),
            recommendedDuration = 5
        ),

        // Cardio
        Exercise(
            id = "jumping_jacks",
            name = "Jumping Jacks",
            category = "Cardio",
            difficulty = "Beginner",
            preview = "Raise your heart rate with a simple full-body cardio movement.",
            instructions = listOf(
                "Stand upright with your feet together.",
                "Jump your feet outward while raising your arms overhead.",
                "Jump your feet back together while lowering your arms.",
                "Repeat at a steady pace."
            ),
            recommendedDuration = 10
        ),

        Exercise(
            id = "high_knees",
            name = "High Knees",
            category = "Cardio",
            difficulty = "Intermediate",
            preview = "Increase your heart rate by running in place with high knee lifts.",
            instructions = listOf(
                "Stand upright with your feet hip-width apart.",
                "Drive one knee toward your chest.",
                "Quickly switch legs.",
                "Continue alternating knees while maintaining a quick pace."
            ),
            recommendedDuration = 8
        ),

        Exercise(
            id = "mountain_climbers",
            name = "Mountain Climbers",
            category = "Cardio",
            difficulty = "Intermediate",
            preview = "Combine core stability with fast-paced cardiovascular movement.",
            instructions = listOf(
                "Begin in a high plank position.",
                "Drive one knee toward your chest.",
                "Return that leg while bringing the opposite knee forward.",
                "Continue alternating legs at a controlled pace."
            ),
            recommendedDuration = 8
        ),

        // Flexibility
        Exercise(
            id = "hamstring_stretch",
            name = "Hamstring Stretch",
            category = "Flexibility",
            difficulty = "Beginner",
            preview = "Gently stretch the muscles along the back of your legs.",
            instructions = listOf(
                "Sit with one leg extended in front of you.",
                "Bend the opposite leg comfortably.",
                "Reach toward the toes of your extended leg.",
                "Hold the stretch without bouncing and switch sides."
            ),
            recommendedDuration = 5
        ),

        Exercise(
            id = "childs_pose",
            name = "Child's Pose",
            category = "Flexibility",
            difficulty = "Beginner",
            preview = "Relax your back, hips, and shoulders with a gentle resting stretch.",
            instructions = listOf(
                "Begin on your hands and knees.",
                "Move your hips backward toward your heels.",
                "Extend your arms forward along the floor.",
                "Relax your head and hold the position."
            ),
            recommendedDuration = 5
        ),

        Exercise(
            id = "shoulder_stretch",
            name = "Shoulder Stretch",
            category = "Flexibility",
            difficulty = "Beginner",
            preview = "Improve shoulder mobility with a simple cross-body stretch.",
            instructions = listOf(
                "Stand or sit upright.",
                "Bring one arm across your chest.",
                "Use your opposite arm to gently pull it closer.",
                "Hold the stretch and repeat on the other side."
            ),
            recommendedDuration = 5
        ),

        // HIIT
        Exercise(
            id = "burpees",
            name = "Burpees",
            category = "HIIT",
            difficulty = "Advanced",
            preview = "Challenge your entire body with an explosive high-intensity movement.",
            instructions = listOf(
                "Begin standing with your feet shoulder-width apart.",
                "Lower into a squat and place your hands on the floor.",
                "Jump your feet backward into a plank.",
                "Return your feet forward and jump upward."
            ),
            recommendedDuration = 10
        ),

        Exercise(
            id = "jump_squats",
            name = "Jump Squats",
            category = "HIIT",
            difficulty = "Intermediate",
            preview = "Add explosive power to a traditional squat.",
            instructions = listOf(
                "Stand with your feet shoulder-width apart.",
                "Lower into a controlled squat.",
                "Explode upward into a jump.",
                "Land softly and immediately begin the next repetition."
            ),
            recommendedDuration = 8
        ),

        Exercise(
            id = "skater_jumps",
            name = "Skater Jumps",
            category = "HIIT",
            difficulty = "Intermediate",
            preview = "Build lateral power and endurance with side-to-side jumps.",
            instructions = listOf(
                "Begin standing with your knees slightly bent.",
                "Jump sideways onto one foot.",
                "Bring the opposite leg behind your body.",
                "Jump toward the other side and continue alternating."
            ),
            recommendedDuration = 8
        )
    )

    fun getExercisesByCategory(category: String): List<Exercise> {
        return exercises.filter {
            it.category.equals(category, ignoreCase = true)
        }
    }

    fun getExerciseById(id: String): Exercise? {
        return exercises.find {
            it.id == id
        }
    }
}