package ru.platron.sdk.services.revoke;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class RevokeResponse extends BaseResponse {
	@XmlElement(name = "pg_error_code")
	public String errorCode;
}
