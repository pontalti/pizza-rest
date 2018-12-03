package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AuthException;
import com.exception.ContentNotAllowedException;

@RestController
@RequestMapping("admin")
public class AdminRestController {

	public AdminRestController() {
		super();
	}

	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getProtectedGreeting() throws AuthException, ContentNotAllowedException{
		return ResponseEntity.ok("Admin protected method!");
	}

}
