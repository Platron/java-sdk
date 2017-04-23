package ru.platron.sdk.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "response")
public class CheckResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@XmlElement(name = "pg_timeout")
	public String timeout;
	
	@XmlElement(name = "pg_errorDescription")
	public String errorDescription;
}
