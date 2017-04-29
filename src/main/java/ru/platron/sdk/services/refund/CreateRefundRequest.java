package ru.platron.sdk.services.refund;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseRequest;

@XmlRootElement(name = "request")
public class CreateRefundRequest extends BaseRequest {
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_comment")
	public String comment;
	
	@XmlElement(name = "pg_refund_amount")
	public String refundAmount;
	
	@Override
	public String getScriptName() {
		return "create_refund_request.php";
	}

	@Override
	public Class<CreateRefundResponse> getResponseClass() {
		return CreateRefundResponse.class;
	}

}
