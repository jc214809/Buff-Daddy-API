package com.github.jc214809.BuffDaddyAPI.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.jc214809.BuffDaddyAPI.model.CompleteWorkoutData;
import com.github.jc214809.BuffDaddyAPI.model.Workout;

@Mapper
public interface PreviousWorkoutsMapper { 
	@Select("Select * From Workouts Where userId = #{socialId} AND workoutStatus = 'Complete'")
	List<Workout> getPreviousWorkouts(@Param("socialId") String socialId);
	
	@Select("Select Sets.setId, Sets.exerciseId, Exercise.exerciseName, Sets.weight, Sets.reps, Sets.time, Sets.distance, Sets.calories, Sets.heartRate, Sets.stairs, Sets.steps, Sets.level, Sets.incline, Sets.strokes, Sets.speed, WorkoutsExercise.workoutsExerciseId as sortId From Sets INNER JOIN WorkoutsExercise ON Sets.workoutId=WorkoutsExercise.workoutId INNER JOIN Exercise ON Sets.exerciseId=Exercise.exerciseId AND Sets.exerciseId = WorkoutsExercise.exerciseId Where Sets.workoutId=#{workoutId}")
	List<CompleteWorkoutData> getPreviousWorkoutsDetails(@Param("workoutId") String workoutId);
	
	@Select("SELECT workoutDate FROM Workouts Where userId = #{socialId} AND workoutStatus = 'Complete' AND workoutTitle IS NOT NULL ORDER BY workoutDate ASC LIMIT 1")
	Date getFirstWorkoutDate(@Param("socialId") String socialId);

	@Select("Select Sets.exerciseId, workoutsExerciseId as sortId  FROM Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId INNER JOIN WorkoutsExercise ON Workouts.workoutId=WorkoutsExercise.workoutId AND Sets.exerciseId = WorkoutsExercise.exerciseId INNER JOIN Exercise ON Exercise.exerciseId=Sets.exerciseId Where Workouts.workoutStatus = 'Complete' AND Sets.workoutId = #{workoutId} ORDER BY sortId")
	List<CompleteWorkoutData> getPreviousWorkoutByWorkoutId(int workoutId);

	@Select("Select setId, Sets.workoutId, Workouts.workoutDate, Workouts.workoutTitle, Sets.exerciseId, Exercise.exerciseName, Sets.weight, Sets.reps, Sets.time, Sets.distance, Sets.calories, Sets.heartRate, Sets.stairs, Sets.steps, Sets.level, Sets.incline, Sets.strokes, Sets.speed, workoutsExerciseId as sortId  FROM Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId INNER JOIN WorkoutsExercise ON Workouts.workoutId=WorkoutsExercise.workoutId AND Sets.exerciseId = WorkoutsExercise.exerciseId INNER JOIN Exercise ON Exercise.exerciseId=Sets.exerciseId Where Workouts.userId = #{socialId} AND Workouts.workoutStatus = 'Complete'")
	public List<CompleteWorkoutData> getAllPreviousWorkoutSets(@Param("socialId") String socialId);
}
