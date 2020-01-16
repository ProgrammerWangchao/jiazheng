package com.jiazhengpoc.administration.book.presistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.book.dto.BookDto;

@Mapper
public interface BookMapper {

	List<BookDto> getAllBook(String userId);

	int deleteOneBook(int b_id);

	int newOneBook(BookDto bookDto);

}
