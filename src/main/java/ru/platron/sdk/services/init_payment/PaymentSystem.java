package ru.platron.sdk.services.init_payment;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ru.platron.sdk.MapAdapter;

@XmlRootElement(name = "pg_payment_system")
public class PaymentSystem {
	@XmlElement(name = "pg_name")
	public String name;
	
	@XmlElement(name = "pg_ps_data")
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, String> psData = new HashMap<String, String>();
}
