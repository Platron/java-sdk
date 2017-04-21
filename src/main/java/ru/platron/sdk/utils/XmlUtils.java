package ru.platron.sdk.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import ru.platron.sdk.XmlObject;

public class XmlUtils {
	public static Object fromXml(String xml, Class<?> cls) {
		Object response = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(cls);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			response = jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static String toXml(XmlObject request) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(request.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			StringWriter writer = new StringWriter();
			jaxbMarshaller.marshal(request, writer);
			
			return writer.toString();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
