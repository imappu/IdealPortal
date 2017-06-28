package com.application.enums;

/**
 * Enum of value ranges for diagnostic status using BMI The min and max values
 * define the ranges of BMI that will return a specific BMIRange. The formula
 * for range is min < BMI <= max
 * 
 *
 */
public enum SuccessEnum
{
    success(1);


    private final int key;

   
    SuccessEnum(int key)
    {
        this.key = key;
      
    }

   
    public int key()
    {
        return key;
    }
}
