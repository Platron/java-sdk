package ru.platron.sdk.services.make_recurring;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class MakeRecurringRequest extends BaseRequest {
	@XmlElement(name = "pg_order_id")
	public String orderId;
	
	@XmlElement(name = "pg_recurring_profile")
	public String recurringProfile;
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_result_url")
	public String resultUrl;
	
	@XmlElement(name = "pg_refund_url")
	public String refundUrl;
	
	@XmlElement(name = "pg_request_method")
	public String requestMethod;
	
	@XmlElement(name = "pg_encoding")
	public String encoding;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@Override
	public String getScriptName() {
		return "make_recurring_payment.php";
	}

	@XmlElement(name = "cms_payment_module")
	public String cmsPaymentModule = "platron-java-sdk";

	@Override
	public Class<MakeRecurringResponse> getResponseClass() {
		return MakeRecurringResponse.class;
	}

}
