package xml_parser;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class JaxXMLToObject {
    public static StudentServiceSystem jaxbXmlFileToObject(String fileName) throws FileNotFoundException {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(StudentServiceSystem.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<StudentServiceSystem> root =
                    jaxbUnmarshaller.unmarshal(new StreamSource(xmlFile), StudentServiceSystem.class);
            StudentServiceSystem mySystem = root.getValue();

            return mySystem;
        } catch (JAXBException e) {
            throw new FileNotFoundException();
        }
    }
}
