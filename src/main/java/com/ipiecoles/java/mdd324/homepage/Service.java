package com.ipiecoles.java.mdd324.homepage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final Logger logger = LoggerFactory.getLogger(Service.class);


    public Rss getActus() {

        Rss rss = null;

        try {
            String URL = "https://www.lemonde.fr/rss/une.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // normalize XML response
            doc.getDocumentElement().normalize();

            //read details first
            rss = new Rss(new Channel(
                    doc.getElementsByTagName("title").item(0).getTextContent(),
                    doc.getElementsByTagName("description").item(0).getTextContent(),
                    doc.getElementsByTagName("copyright").item(0).getTextContent(),
                    doc.getElementsByTagName("link").item(0).getTextContent(),
                    doc.getElementsByTagName("pubDate").item(0).getTextContent(),
                    doc.getElementsByTagName("langage").item(0).getTextContent())
            );

            //read students list
            NodeList nodeList = doc.getElementsByTagName("item");

            //create an empty list for students
            List<Item> items = new ArrayList<>();

            //loop all available student nodes
            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Item item = new Item(
                            elem.getElementsByTagName("title").item(0).getTextContent(),
                            elem.getElementsByTagName("pubDate").item(0).getTextContent(),
                            elem.getElementsByTagName("description").item(0).getTextContent(),
                            elem.getElementsByTagName("link").item(0).getTextContent()
                    );
                    items.add(item);
                }
            }


        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return rss;
    }
}
