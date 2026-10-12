package org.example;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {

    static void main() throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("autores.xml"));

        writer.writeStartDocument("1.0");
        writer.writeStartElement("Documents");
        writer.writeStartElement("document");
        writer.writeAttribute("Language", "spanish");
        writer.writeAttribute("Author", "Diego");
        writer.writeCharacters("Apuntes de AD");
        writer.writeEndElement();
        writer.writeStartElement("document");
        writer.writeAttribute("Language", "japanese");
        writer.writeAttribute("Author", "Hokazono");
        writer.writeCharacters("El arco del hotel es el mejor arco de Kagurabachi");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.close();
    }
}
