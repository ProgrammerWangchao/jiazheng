package com.jiazhengpoc.administration.index;

import java.util.LinkedHashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/administration/index")
public class IndexController {
	
	@RequestMapping(value = "/getswiper", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> getswiper() {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		imgsurlmap.put("titleImg01", "titleImg01.jpg");
		imgsurlmap.put("titleImg02", "titleImg02.jpg");
		imgsurlmap.put("titleImg03", "titleImg03.jpg");
		return ResponseEntity.ok(imgsurlmap);
	}

}
