package com.fertilagro.fertilagroapp.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class uteis {

    public static boolean ContemSomenteNumero(String string) {
        return string.chars().allMatch(Character::isDigit);
    }
    
	public static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    return mapper;
	}
    
}
