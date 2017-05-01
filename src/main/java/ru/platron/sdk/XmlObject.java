package ru.platron.sdk;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlObject {
	@XmlElement(name = "pg_salt", required = true)
	public String salt;
	
	@XmlElement(name = "pg_sig", required = true)
	public String signature;
	
	public Map<String, String> getParamsMap() {
		Map<String, String> result = new TreeMap<String, String>();
		
		for (Field field : this.getClass().getFields()) {
			Object value = null;
			try {
				value = field.get(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.exit(1);
			}
			if (value == null) {
				continue;
			}
			
			XmlElement annotation = field.getAnnotation(XmlElement.class);
			if (annotation == null || annotation.name().equals("pg_sig")) {
				continue;
			}
			
			result.put(annotation.name(), value.toString());
		}
		
		return result;
	}
}
