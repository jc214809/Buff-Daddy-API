package com.github.jc214809.model;

import java.util.List;

public class PreviousWorkoutData {
	
	private int exerciseId;
	private String socialId;
	private String workoutIds;
	
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getSocialId() {
		return socialId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public String getWorkoutIds() {
		return workoutIds;
	}
	public void setWorkoutIds(List<String> workoutIds) {
		String Ids = "";
		for (String id : workoutIds) {
			Ids += id;
			if(workoutIds.lastIndexOf(workoutIds) != workoutIds.size()){
				Ids += ",";
			}
		}
		this.workoutIds = Ids;
	}
}
