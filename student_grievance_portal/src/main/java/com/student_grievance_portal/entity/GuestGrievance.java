package com.student_grievance_portal.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest-grievances")
public class GuestGrievance {
	
	@Id
    @GeneratedValue
   
	private UUID Id;
	
	 public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	@Column(name = "type", nullable = false)
	    private String type;
	 
	@Column(name="title", nullable = false)
 private String title;

 @Column(name="description", columnDefinition = "TEXT",nullable = false)
 private String description;
 @Column(name="remarks", columnDefinition = "TEXT",nullable = true)
 private String remarks;
 
 public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}

@Column(name = "status",nullable = false)
 private String status = "Submitted";
 
 public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Column(name = "submission_date", nullable = false)
 private LocalDateTime submission_date;
 
 @Column(name = "attachments", columnDefinition = "MEDIUMBLOB")
 @Lob
 private byte[] attachments;

//public Long getId() {
//	return id;
//}
//
//public void setId(Long id) {
//	this.id = id;
//}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDateTime getSubmission_date() {
	return submission_date;
}

public void setSubmission_date(LocalDateTime submission_date) {
	this.submission_date = submission_date;
}

public byte[] getAttachments() {
	return attachments;
}

public void setAttachments(byte[] attachments) {
	this.attachments = attachments;
}

public GuestGrievance(String type, String title, String description, LocalDateTime submission_date,
		byte[] attachments,String status, String remarks) {
	super();
	this.type = type;
	this.title = title;
	this.description = description;
	this.submission_date = submission_date;
	this.attachments = attachments;
	this.status=status;
	this.remarks=remarks;
}

public GuestGrievance() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
