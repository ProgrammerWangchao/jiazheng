package com.jiazhengpoc.common.config;


import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Help {

	
	
	/**
     * mapToDto
     *
     * @param map map
     * @param dtoClass Class<T>
     * @param <T> T
     * @return obj Dto
     */
    public static <T> T mapToDto(Map<String, Object> map, Class<T> dtoClass) {
        if (map == null) {
            return null;
        }
        T obj = null;
        ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SmartDateFormat());
        try {
            String json = mapper.writeValueAsString(map);
            obj = mapper.readValue(json, dtoClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
