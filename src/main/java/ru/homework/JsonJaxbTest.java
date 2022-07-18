package ru.homework;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

public class JsonJaxbTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setAge(18);
        student.setName("John");
        student.setLanguage("Java");

        try{
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("eclipselink.media-type", "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(student, System.out);


        } catch(JAXBException e){
            e.printStackTrace();
        }
    }
}
