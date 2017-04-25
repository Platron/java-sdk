package ru.platron.sdk.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "response")
public class GetStatusResponse extends XmlObject {
	@XmlElement(name = "pg_status")
	public String status;

	@XmlElement(name = "pg_payment_id")
	public String paymentId;

	@XmlElement(name = "pg_transaction_status")
	public String transactionStatus;

	@XmlElement(name = "pg_can_reject")
	public String canReject;

	@XmlElement(name = "pg_create_date")
	public String createDate;

	@XmlElement(name = "pg_result_date")
	public String resultDate;

	@XmlElement(name = "pg_revoke_date")
	public String revokeDate;

	@XmlElement(name = "pg_payment_system")
	public String paymentSystem;

	@XmlElement(name = "pg_accepted_payment_systems")
	public String acceptedPaymentSystems;

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

	@XmlElement(name = "pg_overpayment")
	public String overpayment;

	@XmlElement(name = "pg_failure_code")
	public String failuteCode;

	@XmlElement(name = "pg_failure_description")
	public String failuteDescription;

	@XmlElement(name = "pg_error_description")
	public String errorDescription;

}
