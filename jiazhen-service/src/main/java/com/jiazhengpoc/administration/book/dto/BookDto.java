package com.jiazhengpoc.administration.book.dto;

import java.sql.Date;
import java.sql.Time;

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
public class BookDto {
	
	/**
	 * 预约号
	 */
	private int b_id;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 预约号
	 */
	private int p_id;
	 
	/**
	 * 预约项目名称
	 */
	private String p_title;
	
	/**
	 * 价格
	 */
	private double b_price;
	
	/**
	 * 图片地址
	 */
	private  String  p_icon;
	
	/**
	 * 预约状态 0 预约成功，1商家接单
	 */
	private int b_state;
	
	/**
	 * 预约日期
	 */
	private Date b_date;
	
	/**
	 * 预约时间
	 */
	private Time  b_time;

	/**
	 * mid 
	 */
	private String mid;
	
	/**
	 * 预约人姓名
	 */
	private String b_name;
	
	/**
	 * 预约人电话
	 */
	private String b_phone;
	
	/**
	 * sId
	 */
	private String s_id;
	
	
}
