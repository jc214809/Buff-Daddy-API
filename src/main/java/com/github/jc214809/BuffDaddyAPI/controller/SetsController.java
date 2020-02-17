package com.github.jc214809.BuffDaddyAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.BuffDaddyAPI.model.Exercises;
import com.github.jc214809.BuffDaddyAPI.model.PreviousData;
import com.github.jc214809.BuffDaddyAPI.model.Set;
import com.github.jc214809.BuffDaddyAPI.service.SetsService;

@Controller
public class SetsController {

	@Autowired
	public SetsService setsService;
	
	@RequestMapping(value = "/addSet", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void addSet(@RequestBody final Set set) {
		setsService.addSet(set);
	}
	
	@RequestMapping(value = "/addWorkoutExercise", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void addWorkoutExercise(@RequestBody final Set set) {
		setsService.addWorkoutExercise(set);
	}
	
	@RequestMapping(value = "/deleteWorkoutExercise", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void deleteWorkoutExercise(@RequestBody final Set set) {
		setsService.deleteWorkoutExercise(set);
	}
	
	@RequestMapping(value = "/getSets", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<Set> getSets(@RequestParam(value = "id") int id) {
		return setsService.getSets(id);
	}
	
	@RequestMapping(value = "/getExercisesForWorkout", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<Exercises> getExercisesForWorkout(@RequestParam(value = "id") int id) {
		return setsService.getExercisesForWorkout(id);
	}
	
	@RequestMapping(value = "/saveSetDetails", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void saveSetDetails(@RequestBody final Set set) {
		setsService.saveSetDetails(set);
	}
	
	@RequestMapping(value = "/deleteSet", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void deleteSet(@RequestBody final Set set) {
		setsService.deleteSet(set.getSetId());
	}
	
	@RequestMapping(value = "/getPreviousExerciseData", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public PreviousData getPreviousExerciseData(@RequestParam(value = "exerciseId") int exerciseId,@RequestParam(value = "socialId") String socialId) {
		return setsService.getPreviousExerciseData(exerciseId, socialId);
	}
}
