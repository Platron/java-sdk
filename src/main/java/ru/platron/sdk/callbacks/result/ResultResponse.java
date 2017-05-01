package ru.platron.sdk.callbacks.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.callbacks.BaseResponse;

@XmlRootElement(name = "response")
public class ResultResponse extends BaseResponse {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@XmlElement(name = "pg_error_description")
	public String errorDescription;
}
