package com.student_grievance_portal.entity;

public class GrievanceWithUserDTO {
    private NewGrievance grievance;
    private NewUser user;
	public GrievanceWithUserDTO(NewGrievance grievance, NewUser user) {
		super();
		this.grievance = grievance;
		this.user = user;
	}
	public NewGrievance getGrievance() {
		return grievance;
	}
	public GrievanceWithUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setGrievance(NewGrievance grievance) {
		this.grievance = grievance;
	}
	public NewUser getUser() {
		return user;
	}
	public void setUser(NewUser user) {
		this.user = user;
	}

   
}
