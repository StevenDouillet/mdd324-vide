package com.ipiecoles.java.mdd324.homepage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActuService {

    private final Logger logger = LoggerFactory.getLogger(ActuService.class);

    public List<Item> getActus() {

        List<Item> items = new ArrayList<>();

        try {
            String URL = "https://www.lemonde.fr/rss/une.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // Normalize XML response
            doc.getDocumentElement().normalize();

            // Read details first
            Rss rss = new Rss(new Channel(
                    doc.getElementsByTagName("title").item(0).getTextContent(),
                    doc.getElementsByTagName("description").item(0).getTextContent(),
                    doc.getElementsByTagName("copyright").item(0).getTextContent(),
                    doc.getElementsByTagName("link").item(0).getTextContent(),
                    doc.getElementsByTagName("pubDate").item(0).getTextContent(),
                    doc.getElementsByTagName("language").item(0).getTextContent())
            );

            // Read items list
            NodeList nodeList = doc.getElementsByTagName("item");

            // Loop 10 last item nodes
            for (int i = 0; i < 10; i++) {

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

        return items;
    }
}
