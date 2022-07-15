package ru.homework;

import ru.homework.xjc.Employees;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class JaxbTest {
    public static void main(String[] args) {
        JAXBContext jaxbContext;
        File xmlFile = new File("/home/user/Task22/JaxbTest.xml");
        try{
            jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employees employees = (Employees) jaxbUnmarshaller.unmarshal(xmlFile);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employees, new File("/home/user/Task22/JaxbTest1.xml"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
