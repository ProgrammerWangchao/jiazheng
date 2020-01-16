package com.jiazhengpoc.administration.pv;

import java.util.LinkedHashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/administration/pv")
public class PvController {

	@RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> one() {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		return ResponseEntity.ok(imgsurlmap);
	}
}
