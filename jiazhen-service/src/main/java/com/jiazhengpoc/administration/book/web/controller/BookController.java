package com.jiazhengpoc.administration.book.web.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jiazhengpoc.administration.book.dto.BookDto;
import com.jiazhengpoc.administration.book.service.BookService;

@RestController
@RequestMapping(value = "/administration/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/**
	 *创建个人订单
	 * @return
	 */
	@RequestMapping(value = "/post_one", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> newOneBook(@RequestBody final Map<String, Object> map) {
		LinkedHashMap<String, Object> reMap = bookService.newOneBook(map);
		return ResponseEntity.ok(reMap);
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> all(String userId) {
		LinkedHashMap<String, Object> imgsurlmap = new LinkedHashMap<>();
		imgsurlmap = bookService.getAllBook(userId);
		return ResponseEntity.ok(imgsurlmap);
	}
	
	/**
	 * 删除订单
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LinkedHashMap<String, Object>> cancel(@RequestBody final Map<String, Object> map) {
		LinkedHashMap<String, Object> reMap = bookService.deleteOneBook(map);
		return ResponseEntity.ok(reMap);
	}
}
