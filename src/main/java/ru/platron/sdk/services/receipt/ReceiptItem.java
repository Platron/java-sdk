package ru.platron.sdk.services.receipt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pg_items")
public class ReceiptItem {
	@XmlElement(name = "pg_label")
	public String label;
	
	@XmlElement(name = "pg_price")
	public String price;
	
	@XmlElement(name = "pg_quantity")
	public String quantity;
	
	@XmlElement(name = "pg_amount")
	public String amount;
	
	@XmlElement(name = "pg_vat")
	public String vat;
	
	@XmlElement(name = "pg_type")
	public String type;

	@XmlElement(name = "pg_nomenclature_code")
	public String nomenclatureCode;
	
	@XmlElement(name = "pg_payment_type")
	public String paymentType;
	
	@XmlElement(name = "pg_agent_type")
	public String agentType;
	
	@XmlElement(name = "pg_agent_name")
	public String agentName;
	
	@XmlElement(name = "pg_agent_inn")
	public String agentInn;
	
	@XmlElement(name = "pg_agent_phone")
	public String agentPhone;
}
