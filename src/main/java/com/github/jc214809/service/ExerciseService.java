package com.github.jc214809.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.mappers.ExerciseMapper;
import com.github.jc214809.model.Exercises;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseMapper exerciseMapper;
	
	public void addExercise(Exercises exercises) {
		exerciseMapper.addExercise(exercises);
		int id = exercises.getExerciseID();
		exercises.setExerciseID(id);
		exerciseMapper.addExerciseToUser(exercises);
	}
	
	public void addExerciseToUser(Exercises exercises) {
		exerciseMapper.addExerciseToUser(exercises);
	}
	
	public void editExercise(Exercises exercises) {
		exerciseMapper.editExercise(exercises);
	}
	
	public List<Exercises> getUsersExercises(String socialId) {
		return exerciseMapper.getUsersExercises(socialId);
	}

	public void deleteExercise(String exerciseId) {
		exerciseMapper.deleteExercise(exerciseId);
	}
	
	public Boolean checkIfDeletable(String exerciseId) {
		int count = exerciseMapper.checkIfDeletable(exerciseId);
		if(count > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public void deleteUsersExercise(Exercises exercise) {
		exerciseMapper.deleteUsersExercise(exerciseMapper.getId(exercise));
	}
	
	public List<Exercises> getAllExercises() {
		return exerciseMapper.getAllExercises();
	}

	public Boolean isExerciseModifable(String exerciseId) {
		int count = exerciseMapper.checkExercise(exerciseId);
		if(count > 0){
			return false;
		}else{
			return true;
		}
		
	}
}
