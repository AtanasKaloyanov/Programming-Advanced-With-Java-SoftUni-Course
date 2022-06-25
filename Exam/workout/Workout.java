package Exam.workout;


import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise bestExercise = null;
        int max = -1;
        for (Exercise exercise : exercises) {
            if (exercise.getBurnedCalories() > max) {
                max = exercise.getBurnedCalories();
                bestExercise = exercise;
            }
        }
        return bestExercise;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", type)).append("\n");
        for (Exercise exercise : exercises) {
            sb.append(exercise).append("\n");
        }
        return sb.toString().trim();
    }
}




