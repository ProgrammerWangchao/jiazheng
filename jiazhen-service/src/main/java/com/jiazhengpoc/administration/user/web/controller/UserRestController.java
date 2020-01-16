package com.jiazhengpoc.administration.user.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiazhengpoc.administration.user.dto.UserDto;
import com.jiazhengpoc.administration.user.service.UserService;

@RestController
@RequestMapping(value = "/administration/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/finduserall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findUserAll(@RequestBody final Map<String, Object> map) {
	        String ret = userService.saveByCondition01(map);
	        return ResponseEntity.ok(ret);
	}
	
	@RequestMapping(value = "/finduser01", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedHashMap<String, Object>>> findUser01(@RequestBody final Map<String, Object> map) {
		List<LinkedHashMap<String, Object>> ret = userService.findUser01(map);
		return ResponseEntity.ok(ret);
	}
	
	@RequestMapping(value = "/finduser02", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> findUser02() {
		String userId = "";
		List<UserDto> ret = userService.findUser02(userId);
		return ret;
	}
}
