package com.github.jc214809.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.model.CompleteWorkoutData;
import com.github.jc214809.model.Workout;
import com.github.jc214809.service.PreviousWorkoutsService;

@Controller
public class PreviousWorkoutsController {
	
	@Autowired
	private PreviousWorkoutsService previousWorkoutsService;

	@RequestMapping(value = "/getPreviousWorkouts", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<CompleteWorkoutData> getPreviousWorkouts(@RequestParam(value = "socialId") String socialId) {
		return previousWorkoutsService.getPreviousWorkouts(socialId);
	}
	
	@RequestMapping(value = "/repeatPreviousWorkouts", method = { RequestMethod.POST })
	@ResponseBody
	public void repeatPreviousWorkouts(@RequestBody final Workout workout) {
		previousWorkoutsService.repeatPreviousWorkouts(workout.getWorkoutId(), workout.getUserId());
	}
}
