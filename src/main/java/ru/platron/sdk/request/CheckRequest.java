package ru.platron.sdk.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "request")
public class CheckRequest extends XmlObject {
	@XmlElement(name = "pg_order_id")
	public String orderId;

	@XmlElement(name = "pg_payment_id")
	public String paymentId;

	@XmlElement(name = "pg_amount")
	public String amount;

	@XmlElement(name = "pg_currency")
	public String currency;

	@XmlElement(name = "pg_net_amount")
	public String netAmount;

	@XmlElement(name = "pg_ps_amount")
	public String psAmount;

	@XmlElement(name = "pg_ps_full_amount")
	public String psFullAmount;

	@XmlElement(name = "pg_ps_currency")
	public String psCurrency;

	@XmlElement(name = "pg_overpayment")
	public String overpayment;

	@XmlElement(name = "pg_payment_system")
	public String paymentSystem;

	@XmlElement(name = "pg_result")
	public String result;

	@XmlElement(name = "pg_payment_date")
	public String paymentDate;

	@XmlElement(name = "pg_can_reject")
	public String canReject;

	@XmlElement(name = "pg_card_brand")
	public String cardBrand;

	@XmlElement(name = "pg_card_pan")
	public String cardPan;

	@XmlElement(name = "pg_card_hash")
	public String cardHash;

	@XmlElement(name = "pg_auth_code")
	public String authCode;

	@XmlElement(name = "pg_captured")
	public String captured;

	@XmlElement(name = "pg_user_phone")
	public String userPhone;

	@XmlElement(name = "pg_need_phone_notification")
	public String needPhoneNotification;

	@XmlElement(name = "pg_user_contact_email")
	public String userContactEmail;

	@XmlElement(name = "pg_need_email_notification")
	public String needEmailNotification;

	@XmlElement(name = "pg_failure_code")
	public String failureCode;

	@XmlElement(name = "pg_failure_description")
	public String failureDescription;

	@XmlElement(name = "pg_recurring_profile_id")
	public String recurringProfileId;

	@XmlElement(name = "pg_recurring_profile_expiry_date")
	public String recurringProfileExpiryDate;

}
