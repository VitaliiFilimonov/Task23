package ru.homework;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxTest {
    private static final ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SaxHandler handler = new SaxHandler();
        parser.parse(new File("/home/user/Task22/Test.xml"), handler);

        for (Employee employee : employees)
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", employee.getName(), employee.getJob()));
    }

    private static class SaxHandler extends DefaultHandler{
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String job = attributes.getValue("job");
                employees.add(new Employee(name, job));
            }
        }
    }
}

