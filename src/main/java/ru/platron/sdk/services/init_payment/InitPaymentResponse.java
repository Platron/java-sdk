package ru.platron.sdk.services.init_payment;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class InitPaymentResponse extends BaseResponse {
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
}
