package com.github.jc214809.model;

import java.sql.Date;

public class Workout {

	private int workoutID;	
	private Date workoutDate;
	private String userId;
	private String workoutStatus;
	
	
	public int getWorkoutID() {
		return workoutID;
	}
	public void setWorkoutID(int workoutID) {
		this.workoutID = workoutID;
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
