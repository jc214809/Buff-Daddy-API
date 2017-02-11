package com.github.jc214809.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.model.Exercises;
import com.github.jc214809.service.ExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "/addExercise", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void addExercise(@RequestBody final Exercises exercises) {
		exerciseService.addExercise(exercises);
	}
	
	@RequestMapping(value = "/addExerciseToUser", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void addExerciseToUser(@RequestBody final Exercises exercises) {
		exerciseService.addExerciseToUser(exercises);
	}
	
	@RequestMapping(value = "/editExercise", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void editExercise(@RequestBody final Exercises exercises) {
		exerciseService.editExercise(exercises);
	}
	
	@RequestMapping(value = "/deleteExercise", method = RequestMethod.POST)
	@ResponseBody
	public void deleteExercise(@RequestParam(value = "exerciseId") String exerciseId) {
		exerciseService.deleteExercise(exerciseId);
	}
	
	@RequestMapping(value = "/checkIfDeletable", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkIfDeletable(@RequestParam(value = "exerciseId") String exerciseId) {
		return exerciseService.checkIfDeletable(exerciseId);
	}
	
	@RequestMapping(value = "/deleteUsersExercise", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void deleteUsersExercise(@RequestBody final Exercises exercise) {
		exerciseService.deleteUsersExercise(exercise);
	}
	
	@RequestMapping(value = "/modifiable", method = RequestMethod.GET)
	@ResponseBody
	public Boolean isExerciseModifable(@RequestParam(value = "exerciseId") String exerciseId) {
		return exerciseService.isExerciseModifable(exerciseId);
	}
	
	@RequestMapping(value = "/getAllExercises", method = RequestMethod.GET)
	@ResponseBody
	public List<Exercises> getAllExercises() {
		return exerciseService.getAllExercises();
	}
	
	@RequestMapping(value = "/getUsersExercises", method = RequestMethod.GET)
	@ResponseBody
	public List<Exercises> getUsersExercises(@RequestParam(value = "id") String socialId) {
		return exerciseService.getUsersExercises(socialId);
	}
}
