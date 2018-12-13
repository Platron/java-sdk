package ru.platron.sdk.services.do_capture;

import javax.xml.bind.annotation.XmlElement;

import ru.platron.sdk.services.BaseRequest;

public class DoCaptureRequest extends BaseRequest {
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	// TODO add pg_long_record
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@Override
	public String getScriptName() {
		return "do_capture.php";
	}

	@Override
	public Class<DoCaptureResponse> getResponseClass() {
		return DoCaptureResponse.class;
	}
}
