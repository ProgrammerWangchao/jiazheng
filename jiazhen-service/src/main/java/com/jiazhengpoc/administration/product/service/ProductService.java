package com.jiazhengpoc.administration.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazhengpoc.administration.product.dto.ProductDto;
import com.jiazhengpoc.administration.product.presistence.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public LinkedHashMap<String, Object> all() {
		List<ProductDto> productList = productMapper.findProductAll();
		LinkedHashMap<String, Object> product = new LinkedHashMap<>();
		product.put("products", productList);
		return product;
	}

	public LinkedHashMap<String, Object> hot() {
		List<ProductDto> productList = new ArrayList<ProductDto>();
		for (ProductDto productDto : productMapper.findProductAll()) {
			Map<Integer, String> hotId = new HashMap<>();
			hotId.put(210, "210");
			hotId.put(211, "211");
			hotId.put(212, "212");
			hotId.put(525, "525");
			hotId.put(526, "526");
			if (hotId.get(productDto.getP_id()) != null) {
				productList.add(productDto);
			}
		}
		LinkedHashMap<String, Object> product = new LinkedHashMap<>();
		product.put("products", productList);
		return product;
	}

	public LinkedHashMap<String, Object> mode() {
		List<ProductDto> productList = new ArrayList<ProductDto>();
		for (ProductDto productDto : productMapper.findProductAll()) {
			Map<Integer, String> hotId = new HashMap<>();
			hotId.put(210, "210");
			hotId.put(211, "211");
			hotId.put(212, "212");
			hotId.put(525, "525");
			hotId.put(526, "526");
			if (hotId.get(productDto.getP_id()) != null) {
				productList.add(productDto);
			}
		}
		LinkedHashMap<String, Object> product = new LinkedHashMap<>();
		product.put("products", productList);
		return product;
	}

	public LinkedHashMap<String, Object> one(String pid) {
		int p_id = Integer.valueOf(pid);
		ProductDto productDto = productMapper.findProductById(p_id);
		LinkedHashMap<String, Object> product = new LinkedHashMap<>();
		product.put("product", productDto);
		return product;
	}
}
