package com.github.jc214809.model;

import java.util.Date;

public class CompleteWorkoutData {
	private int setId;
	private int workoutId;
	private Date workoutDate;
	private int exerciseId;
	private int sortId;
	private String exerciseName;
	private String weight;
	private String reps;
	private String time;
	private String distance;
	private String calories;
	private String heartRate;
	private String stairs;
	private String steps;
	private String level;
	private String incline;
	private String strokes;
	private String speed;
	
	public int getSetId() {
		return setId;
	}
	public void setSetId(int setId) {
		this.setId = setId;
	}
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getReps() {
		return reps;
	}
	public void setReps(String reps) {
		this.reps = reps;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getStairs() {
		return stairs;
	}
	public void setStairs(String stairs) {
		this.stairs = stairs;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getIncline() {
		return incline;
	}
	public void setIncline(String incline) {
		this.incline = incline;
	}
	public String getStrokes() {
		return strokes;
	}
	public void setStrokes(String strokes) {
		this.strokes = strokes;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public Date getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(Date workoutDate) {
		this.workoutDate = workoutDate;
	}
}
