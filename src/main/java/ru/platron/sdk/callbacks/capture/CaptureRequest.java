package ru.platron.sdk.callbacks.capture;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.callbacks.BaseRequest;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "request")
public class CaptureRequest extends BaseRequest {
	public CaptureRequest fromXml(String xml) {
		return (CaptureRequest) XmlUtils.fromXml(xml, BaseRequest.class, CaptureRequest.class);
	}
	
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_order_id")
	public String orderId;
}
