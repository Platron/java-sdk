package ru.platron.sdk.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "response")
public class InitPaymentResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;
	
	@XmlElement(name = "pg_error_code")
	public String errorCode;
	
	@XmlElement(name = "pg_error_description")
	public String errorDescription;

	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_redirect_url")
	public String redirectUrl;
	
	@XmlElement(name = "pg_redirect_url_type")
	public String redirectUrlType;
	
	@XmlElement(name = "pg_accepted_payment_systems")
	public String acceptedPaymentSystems;
	
	@XmlElementWrapper(name = "pg_ps_additional_data")
	@XmlElementRef()
	public List<PaymentSystem> psAdditionalData = null;
	
	public static InitPaymentResponse fromXml(String xml) {
		return (InitPaymentResponse) XmlUtils.fromXml(xml, InitPaymentResponse.class);
	}
}
