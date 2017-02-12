package com.github.jc214809.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.jc214809.model.Workout;

public interface WorkoutsMapper { 
	
	@Select("SELECT * FROM Workouts")
	public List<Workout> getCount();
	
	@Select("SELECT workoutId, Workouts.userId, workoutDate, workoutStatus FROM Workouts INNER JOIN ( SELECT userId, MAX(workoutDate) AS maxsign FROM Workouts GROUP BY userId ) ms ON Workouts.userId = ms.userId AND workoutDate = maxsign WHERE ms.userId = #{userId} and workoutStatus = 'In Progress'") 
	public Workout workoutInProgress(@Param("userId") String userId);
	
	@Insert("INSERT INTO `Workouts`(`userId`) VALUES (#{userId})")
	public void newWorkout(@Param("userId") String userId);
	
	@Update("UPDATE `Workouts` SET `workoutStatus`='Complete' WHERE userId = #{userId}")
	public void endWorkout(@Param("userId") String userId);
	
	@Select("SELECT * FROM SETS WHERE workoutId = #{workoutId}")
	public Workout getWorkoutDetails(@Param("workoutId") String workoutId);
	
}
