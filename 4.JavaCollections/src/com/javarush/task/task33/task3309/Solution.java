package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String tag = "<" + tagName + ">";
        marshaller.marshal(obj, writer);

        String xml = writer.toString();
        if (xml.indexOf(tagName) > -1) {
            return xml.replace(tag, "<!--" + comment + "-->" + "\n" + tag);
        }
        else
            return xml;
    }

    public static void main(String[] args) throws JAXBException {
        TestComment test = new TestComment();
        test.first = 5;
        test.second = 12.5;
        test.users[0] = "first";
        test.users[1] = "second";

        System.out.println(toXmlWithComment(test, "second", "my comment"));
    }
}
