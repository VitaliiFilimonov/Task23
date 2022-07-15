package ru.homework;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DomTestEdit {
    private static final Logger LOGGER = LogManager.getLogger(DomTestEdit.class);

    public static void main(String[] args) {
        String filepath = "/home/user/Task22/TestDom.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            addElement(document);

            document.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("TestDomUpdated.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            LOGGER.info("XML успешно изменен!");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void addElement(Document document){
        NodeList employees = document.getElementsByTagName("employee");
        Element element = null;

        for (int i = 0; i < employees.getLength(); i++){
            element = (Element) employees.item(i);
            Element officeElement = document.createElement("office");
            officeElement.appendChild(document.createTextNode("1"));
            element.appendChild(officeElement);
        }
    }

}
