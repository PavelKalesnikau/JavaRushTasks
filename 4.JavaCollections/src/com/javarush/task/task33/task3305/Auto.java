package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonAutoDetect

/*
// моё первое решение, которое работает
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RaceBike.class, name = "com.javarush.task.task33.task3305.RaceBike"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "com.javarush.task.task33.task3305.Motorbike"),
        @JsonSubTypes.Type(value = Car.class, name = "com.javarush.task.task33.task3305.Car")

})
*/

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}