package com.valentin.reservacion_citas.web.controller;

import com.valentin.reservacion_citas.domain.service.NotificationService;
import com.valentin.reservacion_citas.web.dto.request.EmailReqDto;
import com.valentin.reservacion_citas.web.dto.response.MessageResDto;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {
	private final NotificationService contactService;

	@Autowired
	public EmailController(NotificationService contactService) {
		this.contactService = contactService;
	}


	@PostMapping("/send")
	public ResponseEntity<MessageResDto> sendEmail(@Valid @RequestBody EmailReqDto emailReqDto) throws MessagingException {
		return new ResponseEntity<>(contactService.sendContactEmailToOwner(emailReqDto), HttpStatus.OK);
	}
}
