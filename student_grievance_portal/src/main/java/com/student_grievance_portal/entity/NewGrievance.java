package com.student_grievance_portal.entity;

import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "grievance")
public class NewGrievance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column(name = "type")
	    private String type;
	 
	@Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "status")
    private String status = "Submitted";

    @Column(name = "submission_date")
    private LocalDateTime submission_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private NewUser submittedBy;
    
    @Column(name = "remarks",columnDefinition = "TEXT", nullable=true)
    private String remarks;
    
    @Column(name = "attachments", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte[] attachments;

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public LocalDateTime getSubmissionDate() {
		return submission_date;
	}



	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submission_date = submissionDate;
	}


	

	public NewUser getSubmittedBy() {
		return submittedBy;
	}



	public void setSubmittedBy(NewUser submittedBy) {
		this.submittedBy = submittedBy;
	}



	public NewGrievance() {
		super();
		// TODO Auto-generated constructor stub
	}



	public NewGrievance(String type, String title, String description, String status, LocalDateTime submissionDate,
			NewUser submittedBy, byte[] attachments, String remarks) {
		super();
		this.type = type;
		this.title = title;
		this.description = description;
		this.status = "Submitted";
		this.submission_date = submissionDate;
		this.submittedBy=submittedBy;
		this.attachments = attachments;
		this.remarks=remarks;
	}

	public LocalDateTime getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(LocalDateTime submission_date) {
		this.submission_date = submission_date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
}
