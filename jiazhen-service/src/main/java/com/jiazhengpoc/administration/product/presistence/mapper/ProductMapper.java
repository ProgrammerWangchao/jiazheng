package com.jiazhengpoc.administration.product.presistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jiazhengpoc.administration.product.dto.ProductDto;

@Mapper
public interface ProductMapper {

	List<ProductDto> findProductAll();

	ProductDto findProductById(int p_id);

}
