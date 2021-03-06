package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/*
// моё первое решение, которое работает
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
@JsonSubTypes(@JsonSubTypes.Type(value=Parking.class,  name=".Parking"))
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")

public class Parking {
    public String name;
    public String city;
    public List<Auto> autos;

    public Parking(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", autos=" + autos +
                '}';
    }
}