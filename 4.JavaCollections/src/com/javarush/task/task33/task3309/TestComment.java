package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "testComment")
@XmlRootElement
public class TestComment {
    public String[] users = new String [2];
    public int first;
    public double second;
}
