package com.github.jc214809.BuffDaddyAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.BuffDaddyAPI.model.RegistrationDetails;
import com.github.jc214809.BuffDaddyAPI.model.Workout;
import com.github.jc214809.BuffDaddyAPI.service.WorkoutsService;

@Controller
public class WorkoutsController {

	@Autowired
	public WorkoutsService workoutsService;

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Workout> WorkoutCounter() {
		List<Workout> workouts = workoutsService.getCount();
		return workouts;
	}
	
	@RequestMapping(value = "/newWorkout", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public void newWorkout(@RequestBody final RegistrationDetails  userDetails) {
		workoutsService.newWorkout(userDetails.getSocialId());
	}
	
	@RequestMapping(value = "/workoutInProgress", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public Workout workoutInProgress(@RequestParam(value = "id") String id){
		return workoutsService.workoutInProgress(id);
	}
	@RequestMapping(value = "/endWorkout", method = { RequestMethod.POST })
	@ResponseBody
	public void endWorkout(@RequestBody final  Workout workout){
		workoutsService.endWorkout(workout);
	}
	@RequestMapping(value = "/workoutDetails", method = { RequestMethod.GET })
	@ResponseBody
	public void workoutDetails(@RequestParam(value = "workoutId") String workoutId){
		workoutsService.getWorkoutDetails(workoutId);
	}
}
