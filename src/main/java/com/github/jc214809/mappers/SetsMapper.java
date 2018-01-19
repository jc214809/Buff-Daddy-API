package com.github.jc214809.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.jc214809.model.CompleteWorkoutData;
import com.github.jc214809.model.Exercises;
import com.github.jc214809.model.PreviousWorkoutData;
import com.github.jc214809.model.Set;



public interface SetsMapper { 
	
	@Insert("INSERT INTO `Sets`(`workoutId`, `exerciseId`, `weight`, `reps`, `time`, `distance`, `calories`, `heartRate`, `stairs`, `steps`, `level`, `incline`, `strokes`, `speed`) VALUES (#{workoutId},#{exerciseId},#{weight},#{reps},#{time},#{distance},#{calories},#{heartRate},#{stairs},#{steps},#{level},#{incline},#{strokes},#{speed})")
	public void addSet(Set set);
	
	@Select("SELECT Count(*) FROM `WorkoutsExercise` WHERE exerciseId = #{exerciseId} AND workoutId = #{workoutId}")
	public int checkForExerciseToWorkout(Set set);
	
	@Insert("INSERT INTO `WorkoutsExercise`(`workoutId`, `exerciseId`) VALUES (#{workoutId},#{exerciseId})")
	public void addExerciseToWorkout(Set set);
	
	@Delete("DELETE FROM `WorkoutsExercise` WHERE exerciseId = #{exerciseId} AND workoutId = #{workoutId}")
	public void deleteExerciseToWorkout(Set set);
	
	@Select("SELECT sets.setId, sets.workoutId, sets.exerciseId, exercise.exerciseName, sets.weight, sets.reps, sets.time, sets.distance, sets.calories, sets.heartRate, sets.stairs, sets.steps, sets.level, sets.incline, sets.strokes, sets.speed FROM Sets sets, Exercise exercise WHERE sets.exerciseId =exercise.exerciseId AND sets.workoutId = #{workoutId}")
	public List<Set> getSets(int workoutId);
	
	@Select("SELECT DISTINCT(sets.exerciseId), exercise.exerciseName, exercise.weight, exercise.reps, exercise.time, exercise.distance, exercise.calories, exercise.heartRate, exercise.stairs, exercise.steps, exercise.level, exercise.incline, exercise.strokes, exercise.speed, (SELECT workoutsExerciseId From WorkoutsExercise we WHERE sets.exerciseId = we.exerciseId AND workoutId = #{workoutId}) as sortId, exercise.arms, exercise.back, exercise.chest, exercise.core, exercise.legs, exercise.shoulders, exercise.cardio FROM Sets sets, Exercise exercise WHERE sets.exerciseId =exercise.exerciseId AND sets.workoutId = #{workoutId}")
	public List<Exercises> getExercisesForWorkout(int workoutId);
	
	@Update("UPDATE Sets SET weight = #{weight}, reps = #{reps},time = #{time}, distance = #{distance}, calories = #{calories}, heartRate = #{heartRate},stairs = #{stairs},steps = #{steps},level = #{level},incline = #{incline},strokes = #{strokes},speed = #{speed} WHERE setId = #{setId}")
	public void saveSetDetails(Set set);
	
	@Delete("DELETE FROM `Sets` WHERE setId = #{setId}")
	public void deleteSet(int setId);
	
	@Select("SELECT DISTINCT(Workouts.workoutId) from Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId WHERE exerciseId = #{exerciseId} AND userId = #{socialId} AND workoutStatus = 'Complete' ORDER BY Workouts.workoutId DESC LIMIT 3")
	public List<String> getLastThreeWorkoutsWithExercise(PreviousWorkoutData previousWorkoutData);
	
	@Select("SELECT setId, Sets.workoutId, Workouts.workoutDate, Sets.exerciseId, Sets.weight, Sets.reps, Sets.time, Sets.distance, Sets.calories, Sets.heartRate, Sets.stairs, Sets.steps, Sets.level, Sets.incline, Sets.strokes, Sets.speed from Sets INNER JOIN Workouts ON Sets.workoutId=Workouts.workoutId WHERE exerciseId = #{exerciseId} AND userId = #{socialId} AND workoutStatus = 'Complete' AND Workouts.workoutId = #{workoutId}")
	public List<CompleteWorkoutData> getSetDataForWorkout(@Param("exerciseId") int exerciseId,@Param("socialId") String socialId,@Param("workoutId") String workoutId);
	
	@Select("SELECT MIN(s.setId) From Sets s, Workouts w Where w.workoutStatus = 'In Progress' and s.workoutId = #{workoutId} and s.workoutId = w.workoutId and s.exerciseId = #{exerciseId}")
	public int getMinSetId(@Param("exerciseId") int exerciseId,@Param("workoutId") int workoutId);

}
