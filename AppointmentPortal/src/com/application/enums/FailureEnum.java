package com.application.enums;

public enum FailureEnum {
	
	 failure(0);


    private final int key;

   
    FailureEnum(int key)
    {
    	this.key = key;
    }
   
    public int key()
    {
        return key;
    }
	
	
}

