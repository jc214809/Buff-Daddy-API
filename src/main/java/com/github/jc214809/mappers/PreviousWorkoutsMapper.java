package com.github.jc214809.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.jc214809.model.CompleteWorkoutData;

public interface PreviousWorkoutsMapper { 
	@Select("Select setId, Sets.workoutId, Workouts.workoutDate, Workouts.workoutTitle, Sets.exerciseId, Exercise.exerciseName, Sets.weight, Sets.reps, Sets.time, Sets.distance, Sets.calories, Sets.heartRate, Sets.stairs, Sets.steps, Sets.level, Sets.incline, Sets.strokes, Sets.speed, workoutsExerciseId as sortId  FROM Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId INNER JOIN WorkoutsExercise ON Workouts.workoutId=WorkoutsExercise.workoutId AND Sets.exerciseId = WorkoutsExercise.exerciseId INNER JOIN Exercise ON Exercise.exerciseId=Sets.exerciseId Where Workouts.userId = #{socialId} AND Workouts.workoutStatus = 'Complete'")
	public List<CompleteWorkoutData> getPreviousWorkouts(@Param("socialId") String socialId);

	@Select("Select Sets.exerciseId, workoutsExerciseId as sortId  FROM Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId INNER JOIN WorkoutsExercise ON Workouts.workoutId=WorkoutsExercise.workoutId AND Sets.exerciseId = WorkoutsExercise.exerciseId INNER JOIN Exercise ON Exercise.exerciseId=Sets.exerciseId Where Workouts.workoutStatus = 'Complete' AND Sets.workoutId = #{workoutId}")
	public List<CompleteWorkoutData> getPreviousWorkoutByWorkoutId(int workoutId);
}
