package com.jiazhengpoc.administration.product.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class ProductDto {
	/**
	 * 产品id
	 */
	private int p_id;
	/**
	 * 产品图片url
	 */
	private String p_icon;
	/**
	 * 产品名称
	 */
	private String p_title;
	/**
	 * 产品详情
	 */
	private String p_summary;
	/**
	 * 产品价格-线下价格
	 */
	private double p_priceA;
	
	/**
	 * 产品价格-线上价格
	 */
	private double p_priceB;
	
	/**
	 * 服务时间（分钟）
	 */
	private double p_duration;
	
	
	/**
	 * 项目介绍
	 */
	private String p_introduce;
	
	/**
	 * 服务人群
	 */
	private String p_fit_people;
	
	

}
