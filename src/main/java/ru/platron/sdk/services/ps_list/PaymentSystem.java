package ru.platron.sdk.services.ps_list;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pg_payment_system")
public class PaymentSystem {
	@XmlElement(name = "pg_name")
	public String name;
	
	@XmlElement(name = "pg_description")
	public String description;
	
	@XmlElement(name = "pg_payment_scenario")
	public String paymentScenario;
	
	@XmlElement(name = "pg_amount_to_pay")
	public String amountToPay;
	
	@XmlElement(name = "pg_amount_to_pay_currency")
	public String amountToPayCurrency;
	
	@XmlElement(name = "pg_category")
	public String category;
	
	@XmlElementWrapper(name = "pg_sub_payment_systems")
	@XmlElementRef
	public List<SubPaymentSystem> subPaymentSystems;
}
