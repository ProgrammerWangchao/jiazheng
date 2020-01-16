package com.jiazhengpoc.administration.fuwuClass.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazhengpoc.administration.fuwuClass.dto.FuwuDetailDto;
import com.jiazhengpoc.administration.fuwuClass.dto.FuwuGroupDto;
import com.jiazhengpoc.administration.fuwuClass.dto.FuwuViewDto;
import com.jiazhengpoc.administration.fuwuClass.presistence.mapper.FuwuDetailMapper;
import com.jiazhengpoc.administration.fuwuClass.presistence.mapper.FuwuGroupMapper;
import com.jiazhengpoc.administration.fuwuClass.presistence.mapper.FuwuViewMapper;

@Service
public class FuwuService {

	@Autowired
	private FuwuGroupMapper fuwuGroupMapper;
	@Autowired
	private FuwuDetailMapper fuwuDetailMapper;
	@Autowired
	private FuwuViewMapper fuwuViewMapper;
	

	public List<FuwuGroupDto> findFuwuGroupAll() {
		List<FuwuGroupDto> list = fuwuGroupMapper.findFuwuGroupAll();
		return list;
	}

	public List<FuwuDetailDto> findFuwuDetailAll() {
		List<FuwuDetailDto> list = fuwuDetailMapper.findFuwuDetailAll();
		return list;
	}

	public List<FuwuViewDto> findfuwuall() {
		
		List<FuwuViewDto> FuwuViewDtoList =  fuwuViewMapper.findfuwuall();
		
		return FuwuViewDtoList;
	}

	public long saveFuwu(Map<String, Object> map) {
		String fuwuName = "";
		FuwuGroupDto fuwuGroupDto= fuwuGroupMapper.findFuwuGroupByName(fuwuName);
		if (fuwuGroupDto == null) {
			fuwuGroupDto.setFuwuGroupName(fuwuName);
			fuwuGroupDto.setBeizhu(null);
			int f = fuwuGroupMapper.insertFuwuGroup(fuwuGroupDto);
			if ( f<= 0) return 0;
		}
		
		FuwuDetailDto fuwuDetailDto= fuwuDetailMapper.findFuwuDetailByName(fuwuGroupDto.getFuwuGroupId(),fuwuName);
		if (fuwuDetailDto == null) {
			fuwuDetailDto.setFuwuGroupId(fuwuGroupDto.getFuwuGroupId());
			fuwuDetailDto.setFuwuDetailName(null);
			fuwuDetailDto.setFuwuDetailMiaoshu(null);
			fuwuDetailDto.setCrateTime(new java.sql.Date(new Date().getTime()));
			fuwuDetailDto.setUpdateTime(new java.sql.Date(new Date().getTime()));
			fuwuDetailDto.setBeizhu(null);
			int f = fuwuDetailMapper.insertFuwuDetail(fuwuDetailDto);
			if (f <= 0) return 0;
		}
		return 0;
	}

}
