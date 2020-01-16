package com.jiazhengpoc.administration.fuwuClass.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class FuwuViewDto {

	private int fuwuGroupId;
	
	private String fuwuGroupName;

	private int fuwuDetailId;
	
	private String fuwuDetailName;
	
	private String fuwuDetailMiaoshu;
	
	private String beizhu;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date crateTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
}
