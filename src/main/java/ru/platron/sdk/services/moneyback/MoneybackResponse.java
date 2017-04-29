package ru.platron.sdk.services.moneyback;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class MoneybackResponse extends BaseResponse {
	@XmlElement(name = "pg_moneyback_id")
	public String moneybackId;
}
