package xml_parser_utils;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.InvalidFileOrFilePathException;

import java.io.File;

import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class JaxObjectToXML {
    public static void jaxbObjectToXML(StudentServiceSystem studentServiceSystem, String fileName) throws InvalidFileOrFilePathException {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(StudentServiceSystem.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            JAXBElement<StudentServiceSystem> jaxbElement =
                    new JAXBElement<>(new QName("", "studentServiceSystem"),
                            StudentServiceSystem.class,
                            studentServiceSystem);

            //Store XML to File
            File file = new File(fileName);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(jaxbElement, file);
        } catch (Exception e) {
            throw new InvalidFileOrFilePathException();
        }
    }
}
