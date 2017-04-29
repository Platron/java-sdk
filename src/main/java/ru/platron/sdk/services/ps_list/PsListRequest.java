package ru.platron.sdk.services.ps_list;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class PsListRequest extends BaseRequest {
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_currency")
	public String currency;
	
	@XmlElement(name = "pg_testing_mode")
	public String testingMode;
	
	@Override
	public String getScriptName() {
		return "ps_list.php";
	}

	@Override
	public Class<PsListResponse> getResponseClass() {
		return PsListResponse.class;
	}

}
