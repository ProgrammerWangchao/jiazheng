package com.jiazhengpoc.administration.user.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazhengpoc.administration.user.dto.UserDto;
import com.jiazhengpoc.administration.user.presistence.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
    private UserMapper userMapper;

	//@Transactional("dataSourceStr")
	public String saveByCondition01(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return "Success";
	}

    public List<LinkedHashMap<String, Object>> findUser01(final Map<String, Object> param) {
        List<LinkedHashMap<String, Object>> list = userMapper.findUser01(param);
        return list;
    }
    
    public List<UserDto> findUser02(final String userId) {
        List<UserDto> list = userMapper.findUser02(userId);
        return list;
    }
}
