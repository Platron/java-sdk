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
	
	@XmlElement(name = "pg_amount", required = true)
	public double amount;
	
	@XmlElement(name = "pg_currency")
	public String currency;
	
	@XmlElement(name = "pg_description", required = true)
	public String description;

	@XmlElement(name = "pg_order_id")
	public String orderId;
	
	@XmlElement(name = "pg_check_url")
	public String checkUrl;

	@XmlElement(name = "pg_result_url")
	public String resultUrl;

	@XmlElement(name = "pg_refund_url")
	public String refundUrl;

	@XmlElement(name = "pg_capture_url")
	public String captureUrl;

	@XmlElement(name = "pg_request_method")
	public String requestMethod;

	@XmlElement(name = "pg_success_url")
	public String successUrl;

	@XmlElement(name = "pg_failure_url")
	public String failureUrl;

	@XmlElement(name = "pg_success_url_method")
	public String successUrlMethod;

	@XmlElement(name = "pg_failure_url_method")
	public String failureUrlMethod;

	@XmlElement(name = "pg_state_url")
	public String stateUrl;

	@XmlElement(name = "pg_state_url_method")
	public String stateUrlMethod;

	@XmlElement(name = "pg_site_url")
	public String siteUrl;

	@XmlElement(name = "pg_payment_system")
	public String paymentSystem;

	@XmlElement(name = "pg_lifetime")
	public String lifeTime;

	@XmlElement(name = "pg_encoding")
	public String encoding;

	@XmlElement(name = "pg_user_phone")
	public String userPhone;

	@XmlElement(name = "pg_need_phone_notification")
	public String needPhoneNotification;

	@XmlElement(name = "pg_user_contact_email")
	public String userContactEmail;

	@XmlElement(name = "pg_need_email_notification")
	public String needEmailNotification;

	@XmlElement(name = "pg_user_ip")
	public String userIp;

	@XmlElement(name = "pg_postpone_payment")
	public String postponePayment;

	@XmlElement(name = "pg_language")
	public String language;

	@XmlElement(name = "pg_testing_mode")
	public String testingMode;

	@XmlElement(name = "pg_recurring_start")
	public String recurringStart;

	@XmlElement(name = "pg_recurring_lifetime")
	public String recurringLifetime;
	
	public String getScriptName() {
		return "init_payment.php";
	}
	public Class<InitPaymentResponse> getResponseClass() {
		return InitPaymentResponse.class;
	}
}
