package ru.platron.sdk.request;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.Signer;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "request")
public abstract class BaseRequest {
	@XmlElement(name = "pg_merchant_id")
	public int merchantId;
	
	@XmlElement(name = "pg_salt")
	public String salt;
	
	@XmlElement(name = "pg_sig")
	public String signature;
	
	public abstract String getScriptName();
	public abstract Class<?> getResponseClass();
	
	public String toXml() {
		return XmlUtils.toXml(this);
	}
	
	public Map<String, String> getParamsMap() {
		Map<String, String> result = new TreeMap<String, String>();
		
		for (Field field : this.getClass().getFields()) {
			Object value = null;
			try {
				value = field.get(this);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (value == null) {
				continue;
			}
			
			XmlElement annotation = field.getAnnotation(XmlElement.class);
			if (annotation == null) {
				continue;
			}
			
			result.put(annotation.name(), value.toString());
		}
		
		return result;
	}
	
	public void sign(Signer signer) {
		if (salt == null) {
			salt = generateSalt();
		}
		
		signature = signer.make(getScriptName(), (TreeMap<String, String>) getParamsMap());
	}
	
	private String generateSalt() {
		return "generated salt";
	}
}
