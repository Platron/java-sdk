package ru.platron.sdk.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.responses.InitPaymentResponse;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitPaymentRequest extends BaseRequest {
	public static final String SCRIPT_NAME = "init_payment.php";
	
	@XmlElement(name = "pg_amount")
	public double amount;
	
	@XmlElement(name = "pg_description")
	public String description;

	@XmlElement(name = "pg_testing_mode")
	public String testingMode;
	
	public String getScriptName() {
		return "init_payment.php";
	}
	public Class<InitPaymentResponse> getResponseClass() {
		return InitPaymentResponse.class;
	}
}
