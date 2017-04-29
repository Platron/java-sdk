package ru.platron.sdk.services.moneyback_status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class MoneybackStatusResponse extends BaseResponse {
	@XmlElement(name = "pg_moneyback_status")
	public String moneybackStatus;
	
	@XmlElement(name = "pg_reference_id")
	public String referenceId;
}
