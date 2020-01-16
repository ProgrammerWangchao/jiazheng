package com.jiazhengpoc.administration.fuwuClass.presistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.fuwuClass.dto.FuwuGroupDto;

@Mapper
public interface FuwuGroupMapper {

	List<FuwuGroupDto> findFuwuGroupAll();

	int insertFuwuGroup(FuwuGroupDto fuwugroupDto);

	FuwuGroupDto findFuwuGroupByName(String fuwuName);

}
