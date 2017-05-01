package ru.platron.sdk.callbacks.refund;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.callbacks.BaseRequest;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "request")
public class RefundRequest extends BaseRequest {
	
	public RefundRequest fromXml(String xml) {
		return (RefundRequest) XmlUtils.fromXml(xml, BaseRequest.class, RefundRequest.class);
	}
	
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

	@XmlElement(name = "pg_ps_full_amount")
	public String psFullAmount;

	@XmlElement(name = "pg_ps_currency")
	public String psCurrency;

	@XmlElement(name = "pg_payment_system")
	public String paymentSystem;

	@XmlElement(name = "pg_refund_date")
	public String refundDate;
	
	@XmlElement(name = "pg_refund_type")
	public String refundType;
	
	@XmlElement(name = "pg_refund_system")
	public String refundSystem;
	
	@XmlElement(name = "pg_refund_id")
	public String refundId;
}
