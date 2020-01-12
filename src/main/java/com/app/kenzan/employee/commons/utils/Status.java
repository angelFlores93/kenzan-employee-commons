package com.app.kenzan.employee.commons.utils;

/**
 * 
 * @author aaflo
 *
 */
public enum Status {
	ACTIVE("ACTIVE"),
	INATIVE("INACTIVE");
	
	private String value; 
	
	Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status of(String value) {
        return Status.valueOf(value);
    }
}
