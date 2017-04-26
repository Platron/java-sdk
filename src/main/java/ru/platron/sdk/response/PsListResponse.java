package ru.platron.sdk.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "response")
public class PsListResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;
	
	
}
