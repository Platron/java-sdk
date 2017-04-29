package ru.platron.sdk.response.data_objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pg_sub_payment_system")
public class SubPaymentSystem {
	@XmlElement(name = "pg_sub_name")
	public String name;
	
	@XmlElement(name = "pg_sub_description")
	public String description;
}
