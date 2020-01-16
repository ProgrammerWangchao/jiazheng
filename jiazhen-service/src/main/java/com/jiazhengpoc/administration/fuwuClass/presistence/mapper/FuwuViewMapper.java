package com.jiazhengpoc.administration.fuwuClass.presistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.fuwuClass.dto.FuwuViewDto;

@Mapper
public interface FuwuViewMapper {

	List<FuwuViewDto> findfuwuall();

	FuwuViewDto findFuwuViewByName(int fuwuGroupName,String fuwuDetailName);

}
