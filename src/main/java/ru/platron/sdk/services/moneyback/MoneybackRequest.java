package ru.platron.sdk.services.moneyback;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class MoneybackRequest extends BaseRequest {
	@XmlElement(name = "pg_contract_id")
	public String contracrId;
	
	@XmlElement(name = "pg_moneyback_system")
	public String moneybackSystem;
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	// TODO add additional ps fields
	
	@Override
	public String getScriptName() {
		return "create_moneyback.php";
	}

	@Override
	public Class<MoneybackResponse> getResponseClass() {
		return MoneybackResponse.class;
	}

}
