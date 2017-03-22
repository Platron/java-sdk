package ru.platron.sdk;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

@XmlRootElement(name = "response")
public class Response {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_error_code")
	public String errorCode;
	
	@XmlElement(name = "pg_error_description")
	public String errorDescription;

	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_redirect_url")
	public String redirectUrl;
	
	@XmlElement(name = "pg_redirect_url_type")
	public String redirectUrlType;
	
	public static Response fromXml(String xml) {
		Response response;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			response = (Response) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			response = new Response();
		}
		
		return response;
	}
}
