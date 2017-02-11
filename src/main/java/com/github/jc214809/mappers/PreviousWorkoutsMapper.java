package com.github.jc214809.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.jc214809.model.CompleteWorkoutData;

public interface PreviousWorkoutsMapper { 
	@Select("Select setId, Sets.workoutId, Workouts.workoutDate, Sets.exerciseId, Exercise.exerciseName, Sets.weight, Sets.reps, Sets.time, Sets.distance, Sets.calories, Sets.heartRate, Sets.stairs, Sets.steps, Sets.level, Sets.incline, Sets.strokes, Sets.speed, workoutsExerciseId as sortId  FROM Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutID INNER JOIN WorkoutsExercise ON Workouts.workoutId=WorkoutsExercise.workoutId AND Sets.exerciseId = WorkoutsExercise.exerciseId INNER JOIN Exercise ON Exercise.exerciseID=Sets.exerciseId Where Workouts.userID = #{socialId} AND Workouts.workoutStatus = 'Complete'")
	public List<CompleteWorkoutData> getPreviousWorkouts(@Param("socialId") String socialId);
}
