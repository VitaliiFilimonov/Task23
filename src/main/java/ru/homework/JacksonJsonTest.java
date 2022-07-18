package ru.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JacksonJsonTest {
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        student.setId(1);
        student.setAge(18);
        student.setName("John");
        student.setLanguage("Java");

        ObjectMapper ow = new ObjectMapper();
        ow.enable(SerializationFeature.INDENT_OUTPUT);
        String json = ow.writeValueAsString(student);
        ow.writeValue(new File("JsonTest.json"), json);

        System.out.println(json);//чтение из файла


    }

}
