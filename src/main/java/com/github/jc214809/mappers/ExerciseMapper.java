package com.github.jc214809.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.jc214809.model.Exercises;

public interface ExerciseMapper {

	@Insert("INSERT INTO Exercise(exerciseName, recommendation, exerciseDescription, image, weight, reps, time, distance, calories, heartRate, stairs, steps, level, incline, strokes, speed, socialId, arms, back, chest, core, legs, shoulders) VALUES (#{exerciseName},#{recommendation},#{exerciseDescription},#{image},#{weight},#{reps},#{time},#{distance},#{calories},#{heartRate},#{stairs},#{steps},#{level},#{incline},#{strokes},#{speed},#{socialId},#{arms},#{back},#{chest},#{core},#{legs},#{shoulders})")
	@Options(useGeneratedKeys = true, keyProperty="exerciseId")
	public void addExercise(Exercises exercises);	
	
	@Insert("INSERT INTO UserExercises(socialId, exerciseId) VALUES (#{socialId},#{exerciseId})")
	public void addExerciseToUser(Exercises exercises);

	@Update("UPDATE Exercise SET exerciseName= #{exerciseName}, recommendation= #{recommendation}, exerciseDescription = #{exerciseDescription},image = #{image},weight = #{weight}, reps = #{reps},time = #{time},distance = #{distance},calories = #{calories},heartRate = #{heartRate},stairs = #{stairs},steps = #{steps},level = #{level},incline = #{incline},strokes = #{strokes},speed = #{speed},arms = #{arms},back = #{back},chest = #{chest},core = #{core},legs = #{legs},shoulders = #{shoulders} WHERE exerciseId = #{exerciseId}")
	public void editExercise(Exercises exercises);

	@Delete("Delete FROM Exercise WHERE exerciseId = #{exerciseId}")
	public void deleteExercise(String exerciseId);
	
	@Delete("Delete FROM UserExercises WHERE userExercisesId = #{id}")
	public void deleteUsersExercise(int id);
			 
	@Select("Select userExercisesId FROM UserExercises WHERE exerciseId = #{exerciseId} AND socialId = #{socialId} limit 1")
	public int getId(Exercises exercise);
	
	@Select("SELECT Count(*) From Sets WHERE exerciseId = #{exerciseId}")
	public int checkExercise(String exerciseId);
	
	@Select("SELECT Count(*) From UserExercises WHERE exerciseId = #{exerciseId}")
	public int checkIfDeletable(String exerciseId);
	
	@Select("SELECT * From Exercise")
	public List<Exercises> getAllExercises();
	
	@Select("SELECT exercise.exerciseId, exercise.exerciseName, exercise.recommendation, exercise.exerciseDescription, exercise.weight, exercise.reps, exercise.time, exercise.distance, exercise.calories, exercise.heartRate, exercise.stairs, exercise.steps, exercise.level, exercise.incline, exercise.strokes, exercise.speed, exercise.socialId, arms, back, chest, core, legs, shoulders FROM UserExercises ue, Exercise exercise WHERE ue.exerciseId = exercise.exerciseId AND ue.socialId = #{socialId}")
	public List<Exercises> getUsersExercises(String socialId);

}
