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
}
