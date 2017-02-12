package com.github.jc214809.model;

import java.sql.Date;

public class Workout {

	private int workoutId;	
	private Date workoutDate;
	private String userId;
	private String workoutStatus;
	
	
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public Date getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(Date workoutDate) {
		this.workoutDate = workoutDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserID(String userId) {
		this.userId = userId;
	}
	public String getWorkoutStatus() {
		return workoutStatus;
	}
	public void setWorkoutStatus(String workoutStatus) {
		this.workoutStatus = workoutStatus;
	}


}
