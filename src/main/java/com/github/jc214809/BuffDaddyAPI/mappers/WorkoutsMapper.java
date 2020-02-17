package com.github.jc214809.BuffDaddyAPI.mappers;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.github.jc214809.BuffDaddyAPI.model.Workout;

@Mapper
public interface WorkoutsMapper { 
	
	@Select("SELECT * FROM Workouts")
	List<Workout> getCount();
	
	@Select("SELECT workoutId, Workouts.userId, workoutDate, workoutStatus FROM Workouts INNER JOIN ( SELECT userId, MAX(workoutDate) AS maxsign FROM Workouts GROUP BY userId ) ms ON Workouts.userId = ms.userId AND workoutDate = maxsign WHERE ms.userId = #{userId} and workoutStatus = 'In Progress'") 
	Workout workoutInProgress(@Param("userId") String userId);
	
	@Insert("INSERT INTO `Workouts`(`userId`) VALUES (#{userId})")
	void newWorkout(@Param("userId") String userId);
	
	@Update("UPDATE `Workouts` SET `workoutStatus`='Complete', workoutTitle = #{workoutTitle} WHERE userId = #{userId} AND workoutId = #{workoutId}")
	void endWorkout(Workout workout);
	
	@Select("SELECT * FROM SETS WHERE workoutId = #{workoutId}")
	Workout getWorkoutDetails(@Param("workoutId") String workoutId);
	
}
