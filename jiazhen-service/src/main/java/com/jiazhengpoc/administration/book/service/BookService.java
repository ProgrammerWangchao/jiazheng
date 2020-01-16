package com.jiazhengpoc.administration.book.service;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazhengpoc.administration.book.dto.BookDto;
import com.jiazhengpoc.administration.book.presistence.mapper.BookMapper;

@Service
public class BookService {

	@Autowired
    private BookMapper bookMapper;

	//@Transactional("dataSourceStr")
	public String saveByCondition01(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return "Success";
	}


	public LinkedHashMap<String, Object> getAllBook(String userId) {
		List<BookDto> books = bookMapper.getAllBook(userId);
		LinkedHashMap<String, Object> list = new LinkedHashMap<>();
		list.put("books", books);
        return list;
	}

	/**
	 * 删除订单
	 * @return
	 */
	public LinkedHashMap<String, Object> deleteOneBook(Map<String, Object> map) {
		int code = bookMapper.deleteOneBook(Integer.valueOf(map.get("bid").toString()));
		LinkedHashMap<String, Object> list = new LinkedHashMap<>();
		list.put("code", code);
        return list;
	}


	/**
	 *创建个人订单
	 * @return
	 */
	public LinkedHashMap<String, Object> newOneBook(final Map<String, Object> map) {
		//BookDto requestDto = Help.mapToDto(map, BookDto.class);
		BookDto bookDto = new BookDto();
		bookDto.setUserId((String) map.get("uuid"));
		bookDto.setP_id(Integer.valueOf(map.get("pid").toString()));
		bookDto.setP_title((String) map.get("ptitle"));
		bookDto.setP_icon((String) map.get("picon"));
		bookDto.setB_price( Double.valueOf(map.get("price").toString()));
		bookDto.setB_state(0);
		bookDto.setB_date(Date.valueOf(map.get("date").toString()));
		bookDto.setB_time(Time.valueOf(map.get("time").toString()+":00"));
		bookDto.setMid((String) map.get("mid"));
		bookDto.setB_name((String) map.get("name"));
		bookDto.setB_phone((String) map.get("phone"));
		//options.id
		bookDto.setS_id((String) map.get("sid"));
		
		int code = bookMapper.newOneBook(bookDto);
		LinkedHashMap<String, Object> list = new LinkedHashMap<>();
		list.put("code", code);
        return list;
	}
}
