package ru.platron.sdk.services.moneyback_status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class MoneybackStatusRequest extends BaseRequest {
	@XmlElement(name = "pg_moneyback_id")
	public String moneybackId;
	
	@XmlElement(name = "reference_id")
	public String referenceId;
	
	@Override
	public String getScriptName() {
		return "get_moneyback_status.php";
	}

	@Override
	public Class<MoneybackStatusResponse> getResponseClass() {
		return MoneybackStatusResponse.class;
	}

}
