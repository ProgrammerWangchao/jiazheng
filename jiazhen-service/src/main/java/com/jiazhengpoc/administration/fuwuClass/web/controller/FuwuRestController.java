package com.jiazhengpoc.administration.fuwuClass.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiazhengpoc.administration.fuwuClass.dto.FuwuDetailDto;
import com.jiazhengpoc.administration.fuwuClass.dto.FuwuViewDto;
import com.jiazhengpoc.administration.fuwuClass.service.FuwuService;

@RestController
@RequestMapping(value = "/administration/fuwu")
public class FuwuRestController {

	@Autowired
	private FuwuService fuwuService;

	@RequestMapping(value = "/findfuwudetailall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FuwuDetailDto> findFuwuDetailAll() {
		List<FuwuDetailDto> ret = fuwuService.findFuwuDetailAll();
		return ret;
	}

	@RequestMapping(value = "/findfuwuall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FuwuViewDto>> findfuwuall() {
		List<FuwuViewDto> ret = fuwuService.findfuwuall();
		return ResponseEntity.ok(ret);
	}
	
	@RequestMapping(value = "/savefuwu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public long saveFuwu(@RequestBody final Map<String, Object> map) {
		long ret = fuwuService.saveFuwu(map);
		return ret;
	}
}
