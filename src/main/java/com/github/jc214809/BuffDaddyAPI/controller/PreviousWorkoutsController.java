package com.github.jc214809.BuffDaddyAPI.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.BuffDaddyAPI.model.CompleteWorkoutData;
import com.github.jc214809.BuffDaddyAPI.model.Workout;
import com.github.jc214809.BuffDaddyAPI.service.PreviousWorkoutsService;

@Controller
public class PreviousWorkoutsController {

	@Autowired
	public PreviousWorkoutsService previousWorkoutsService;

	@RequestMapping(value = "/getPreviousWorkouts", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<Workout> getPreviousWorkouts(@RequestParam(value = "socialId") String socialId) {
		return previousWorkoutsService.getPreviousWorkouts(socialId);
	}

	@RequestMapping(value = "/getAllPreviousWorkoutSets", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<CompleteWorkoutData> getAllPreviousWorkoutSets(@RequestParam(value = "socialId") String socialId) {
		return previousWorkoutsService.getAllPreviousWorkoutSets(socialId);
	}


	@RequestMapping(value = "/getFirstWorkoutDate", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public Date getFirstWorkoutDate(@RequestParam(value = "socialId") String socialId) {
		return previousWorkoutsService.getFirstWorkoutDate(socialId);
	}
	
	@RequestMapping(value = "/getPreviousWorkoutDetails", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<CompleteWorkoutData> getPreviousWorkoutsDetails(@RequestParam(value = "workoutId") String workoutId) {
		return previousWorkoutsService.getPreviousWorkoutsDetails(workoutId);
	}
	
	@RequestMapping(value = "/repeatPreviousWorkouts", method = { RequestMethod.POST })
	@ResponseBody
	public void repeatPreviousWorkouts(@RequestBody final Workout workout) {
		previousWorkoutsService.repeatPreviousWorkouts(workout.getWorkoutId(), workout.getUserId());
	}
}
