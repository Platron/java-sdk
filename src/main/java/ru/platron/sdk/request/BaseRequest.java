package ru.platron.sdk.request;

import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.Signer;
import ru.platron.sdk.XmlObject;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "request")
public abstract class BaseRequest extends XmlObject {
	@XmlElement(name = "pg_merchant_id", required = true)
	public int merchantId;
	
	public abstract String getScriptName();
	public abstract Class<?> getResponseClass();
	
	public String toXml() {
		return XmlUtils.toXml(this);
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
