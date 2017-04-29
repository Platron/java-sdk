package ru.platron.sdk.services.get_status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class GetStatusRequest extends BaseRequest {
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_order_id")
	public String orderId;
	
	@Override
	public String getScriptName() {
		return "get_status.php";
	}

	@Override
	public Class<?> getResponseClass() {
		return GetStatusResponse.class;
	}

}
