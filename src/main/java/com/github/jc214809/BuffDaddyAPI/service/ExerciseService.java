package com.github.jc214809.BuffDaddyAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.BuffDaddyAPI.mappers.ExerciseMapper;
import com.github.jc214809.BuffDaddyAPI.model.Exercises;

@Service
public class ExerciseService {

	@Autowired
	public ExerciseMapper exerciseMapper;
	
	public void addExercise(Exercises exercises) {
		exerciseMapper.addExercise(exercises);
		int id = exercises.getExerciseId();
		exercises.setExerciseId(id);
		exerciseMapper.addExerciseToUser(exercises);
	}
	
	public void addExerciseToUser(Exercises exercises) {
		exerciseMapper.addExerciseToUser(exercises);
	}
	
	public void editExercise(Exercises exercises) {
		exerciseMapper.editExercise(exercises);
	}
	
	public List<Exercises> getUsersExercises(String socialId) {
		 List<Exercises> exercises = exerciseMapper.getUsersExercises(socialId);
//		 for (Exercises exercise : exercises) {
//			 String mg = null;
//				if(exercise.getArms().booleanValue()){
//					mg = "Arms,";
//				}
//				if(exercise.getBack().booleanValue()){
//					mg = "Back,";
//				}
//				if(exercise.getChest().booleanValue()){
//					mg = "Chest,";
//				}
//				if(exercise.getCardio().booleanValue()){
//					mg = "Cardio,";
//				}
//				if(exercise.getShoulders().booleanValue()){
//					mg = "Shoulders,";
//				}
//				if(exercise.getCore().booleanValue()){
//					mg = "Core,";
//				}
//				if(exercise.getLegs().booleanValue()){
//					mg = "Legs,";
//				}
//				mg.substring(0, mg.length() - 1);
//				exercise.setMuscleGroup(mg);
//		}
		return exercises;
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
		 List<Exercises> exercises = exerciseMapper.getAllExercises();
//		 for (Exercises exercise : exercises) {
//			 String mg = null;
//				if(exercise.getArms().booleanValue()){
//					mg = "Arms,";
//				}
//				if(exercise.getBack().booleanValue()){
//					mg = "Back,";
//				}
//				if(exercise.getChest().booleanValue()){
//					mg = "Chest,";
//				}
//				if(exercise.getCardio().booleanValue()){
//					mg = "Cardio,";
//				}
//				if(exercise.getShoulders().booleanValue()){
//					mg = "Shoulders,";
//				}
//				if(exercise.getCore().booleanValue()){
//					mg = "Core,";
//				}
//				if(exercise.getLegs().booleanValue()){
//					mg = "Legs,";
//				}
//				mg.substring(0, mg.length() - 1);
//				exercise.setMuscleGroup(mg);
//		}
		return exercises;
	}
	
	public static String replaceCharAt(String s, int pos, char c) {
		   return s.substring(0,pos) + c + s.substring(pos+1);
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
