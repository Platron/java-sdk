package ru.platron.sdk.callbacks;

import java.util.TreeMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import ru.platron.sdk.Signer;
import ru.platron.sdk.XmlObject;

@XmlRootElement(name = "request")
public class BaseRequest extends XmlObject {
	/*
	public static BaseRequest fromXml(String xml) {
		return (BaseRequest) XmlUtils.fromXml(xml, BaseRequest.class);
	}*/
	public boolean checkSignature(String scriptName, Signer signer) {
		String signature = signer.make(scriptName, (TreeMap<String, String>) this.getParamsMap());
		
		return signature.equals(this.signature);
	}

	@XmlElement(name = "cms_payment_module")
	public String cmsPaymentModule = "platron-java-sdk";
}
