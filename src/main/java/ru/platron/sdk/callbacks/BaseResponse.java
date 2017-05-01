package ru.platron.sdk.callbacks;

import java.util.TreeMap;

import javax.xml.bind.annotation.XmlRootElement;

import ru.platron.sdk.Signer;
import ru.platron.sdk.XmlObject;
import ru.platron.sdk.utils.XmlUtils;

@XmlRootElement(name = "response")
public class BaseResponse extends XmlObject {
	public void sign(String scriptName, Signer signer) {
		if (salt == null) {
			salt = generateSalt();
		}
		
		signature = signer.make(scriptName, (TreeMap<String, String>) getParamsMap());
	}
	
	private String generateSalt() {
		return "generated salt";
	}
	
	public String toXml() {
		return XmlUtils.toXml(this);
	}
}
