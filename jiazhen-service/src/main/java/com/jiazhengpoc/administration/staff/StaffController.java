package com.jiazhengpoc.administration.staff;

import java.util.LinkedHashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/administration/staff")
public class StaffController {

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> all() {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		return ResponseEntity.ok(imgsurlmap);
	}
	
	@RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> one() {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		return ResponseEntity.ok(imgsurlmap);
	}
}
