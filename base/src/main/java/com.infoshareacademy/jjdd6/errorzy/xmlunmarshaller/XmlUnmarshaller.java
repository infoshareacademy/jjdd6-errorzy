package com.infoshareacademy.jjdd6.errorzy.xmlunmarshaller;

import com.infoshareacademy.jjdd6.errorzy.Markers;
import com.infoshareacademy.jjdd6.menu.InsideMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Stateless
public class XmlUnmarshaller {

    private static final Logger LOGGER = LogManager.getLogger(InsideMenu.class.getName());

    public Markers getMarkersList() {

        File file = new File("nextbike-live.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Markers.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Markers) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            LOGGER.error("JAXB Exception: " + e);
            return new Markers();
        }
    }
}