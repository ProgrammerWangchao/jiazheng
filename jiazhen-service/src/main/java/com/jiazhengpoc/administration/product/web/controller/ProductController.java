package com.jiazhengpoc.administration.product.web.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiazhengpoc.administration.product.service.ProductService;

@RestController
@RequestMapping(value = "/administration/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> all() {
		LinkedHashMap<String, Object> res = productService.all();
		return ResponseEntity.ok(res);
	}

	@RequestMapping(value = "/hot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> hot() {
		LinkedHashMap<String, Object> res = productService.hot();
		return ResponseEntity.ok(res);
	}

	@RequestMapping(value = "/mode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> mode() {
		LinkedHashMap<String, Object> res = productService.mode();
		return ResponseEntity.ok(res);
	}
	
	@RequestMapping(value = "/recent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> recent() {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		return ResponseEntity.ok(imgsurlmap);
	}

	@RequestMapping(value = "/one", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> one(String pid) {
		LinkedHashMap<String, Object> res = productService.one(pid);
		return ResponseEntity.ok(res);
	}

}
