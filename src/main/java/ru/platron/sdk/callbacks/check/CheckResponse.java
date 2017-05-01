package ru.platron.sdk.callbacks.check;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.callbacks.BaseResponse;

@XmlRootElement(name = "response")
public class CheckResponse extends BaseResponse {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_timeout")
	public String timeout;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@XmlElement(name = "pg_error_code")
	public String errorCode;
	
	@XmlElement(name = "pg_error_description")
	public String errorDescription;
}
