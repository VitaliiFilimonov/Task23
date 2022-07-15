package ru.homework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DomTest {

    private static final Logger LOGGER = LogManager.getLogger(DomTest.class);

    public static void main(String[] args) {
        String filepath = "/home/user/Task22/TestDom.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            LOGGER.info("Корневой элемент: " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("employee");
            List<Employee> employeeList = new ArrayList<Employee>();
            for(int i = 0; i < nodeList.getLength(); i++){
                employeeList.add(getEmployee(nodeList.item(i)));
            }

            for(Employee emp: employeeList){
                LOGGER.info(emp.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Employee getEmployee(Node node){
        Employee employee = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            employee.setName(getTagValue("name", element));
            employee.setJob(getTagValue("job", element));
        }
        return employee;
    }

    private static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
