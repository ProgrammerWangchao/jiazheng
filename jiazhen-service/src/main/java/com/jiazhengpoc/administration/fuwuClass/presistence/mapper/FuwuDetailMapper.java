package com.jiazhengpoc.administration.fuwuClass.presistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.fuwuClass.dto.FuwuDetailDto;

@Mapper
public interface FuwuDetailMapper {

	List<FuwuDetailDto> findFuwuDetailAll();

	FuwuDetailDto findFuwuDetailByName(int fuwuGroupId,String fuwuName);

	int insertFuwuDetail(FuwuDetailDto fuwuDetailDto);

}
