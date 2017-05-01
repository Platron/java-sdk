package ru.platron.sdk.services.make_recurring;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.services.BaseResponse;

@XmlRootElement(name = "response")
public class MakeRecurringResponse extends BaseResponse {
	@XmlElement(name = "pg_payment_id")
	public String paymentId;
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_currency")
	public String currency;
	
	@XmlElement(name = "pg_recurring_profile_id")
	public String recurringProfileId;
	
	@XmlElement(name = "pg_recurring_profile_expiry_date")
	public String recurringProfileExpiryDate;
}
