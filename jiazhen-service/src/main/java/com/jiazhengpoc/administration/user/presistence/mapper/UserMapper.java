package com.jiazhengpoc.administration.user.presistence.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.user.dto.UserDto;


@Mapper
public interface UserMapper {

	List<LinkedHashMap<String, Object>> findUser01(Map<String, Object> param);
	 
	 
	 
	 List<UserDto> findUser02(String userId);

}
