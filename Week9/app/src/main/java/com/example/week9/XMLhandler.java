package com.example.week9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLhandler {
    private static XMLhandler xmlHandler = new XMLhandler();

    private XMLhandler() {
    }

    public static XMLhandler getInstance() {
        return  xmlHandler;
    }

    public ArrayList<SmartPost> getXML (String url) {
        ArrayList<SmartPost> smartPostLocations = new ArrayList<SmartPost>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getDocumentElement().getElementsByTagName("item");


            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;
                smartPostLocations.add(new SmartPost(
                        element.getElementsByTagName("place_id").item(0).getTextContent(),
                        element.getElementsByTagName("name").item(0).getTextContent(),
                        element.getElementsByTagName("city").item(0).getTextContent(),
                        element.getElementsByTagName("address").item(0).getTextContent(),
                        element.getElementsByTagName("country").item(0).getTextContent(),
                        element.getElementsByTagName("postalcode").item(0).getTextContent(),
                        element.getElementsByTagName("routingcode").item(0).getTextContent(),
                        element.getElementsByTagName("availability").item(0).getTextContent(),
                        element.getElementsByTagName("description").item(0).getTextContent(),
                        element.getElementsByTagName("lat").item(0).getTextContent(),
                        element.getElementsByTagName("lng").item(0).getTextContent()
                ));
/*                System.out.println(element.getElementsByTagName("place_id").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("city").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("address").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("country").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("postalcode").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("routingcode").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("availability").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("description").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("lat").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("lng").item(0).getTextContent());*/
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            System.out.println("JOB'S DONE!");

        }
        return smartPostLocations;
    }

}
