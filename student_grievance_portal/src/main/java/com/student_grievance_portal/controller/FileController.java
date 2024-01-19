package com.student_grievance_portal.controller;

import com.student_grievance_portal.entity.Admin;
import com.student_grievance_portal.entity.GuestGrievance;
import com.student_grievance_portal.entity.NewGrievance;
import com.student_grievance_portal.entity.NewUser;
import com.student_grievance_portal.service.GrievanceService;
import com.student_grievance_portal.service.GuestService;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileController {

    @Autowired
    private GrievanceService grievanceService;
    @Autowired
    private GuestService guestService;
    

    @GetMapping("/download-attachment/{id}")
    public ResponseEntity<byte[]> downloadAttachment(@PathVariable Long id,HttpSession session) {
    	Admin admin = (Admin) session.getAttribute("admin");
    	NewUser user = (NewUser) session.getAttribute("user");
    	
    	if (admin != null || user !=null) {
        NewGrievance grievance = grievanceService.getGrievanceById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);  
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("attachment.pdf").build());  // Set filename
    	
        return new ResponseEntity<>(grievance.getAttachments(), headers, HttpStatus.OK);
        
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    	
    
    
    @GetMapping("/download-guest-attachment/{id}")
    public ResponseEntity<byte[]> downloadGuestAttachment(@PathVariable UUID id, HttpSession session) {
    	Admin admin = (Admin) session.getAttribute("admin");
    	NewUser user = (NewUser) session.getAttribute("user");
    	
    	if (admin != null || user !=null) {
        Optional<GuestGrievance> guestGrievanceOptional = guestService.getGuestGrievancesById(id);

        if (guestGrievanceOptional.isPresent()) {
            GuestGrievance guestGrievance = guestGrievanceOptional.get();
            byte[] attachmentData = guestGrievance.getAttachments();  // Assuming getAttachments() returns byte[]

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("attachment.pdf").build());

            return new ResponseEntity<>(attachmentData, headers, HttpStatus.OK);
        } else {
            // Handle the case when GuestGrievance with the given ID is not found
            // You can redirect to an error page or handle it based on your requirements
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    
}
