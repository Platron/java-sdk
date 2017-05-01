package ru.platron.sdk.services;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "response")
public class BaseResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_error_code")
	public String errorCode;
	
	@XmlElement(name = "pg_error_description")
	public String errorDescription;
}
